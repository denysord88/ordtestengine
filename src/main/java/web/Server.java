package web;

import conf.Properties;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Server {
    public static void main(String[] args) {
        Server s = new Server();
        s.start();
    }

    public static boolean alive = false;
    private static int currentLogsBufferSize = 0;
    private static String logFileName = "logs/user_logs_from_" + new SimpleDateFormat("dd.MM.yy_H_mm_ss_SSS").format(new Date()) + ".log";
    public static int connectedClients = 0;

    public void start() {
        if (alive) return;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(Properties.SERVER_PORT);
        } catch (IOException e) {
            throw new RuntimeException("Can't run server on port " + Properties.SERVER_PORT, e);
        }

        alive = true;
        while (alive) {
            Socket s = null;
            try {
                s = ss.accept();
                new Thread(new SocketProcessor(s)).start();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    private class SocketProcessor implements Runnable {
        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;

        private SocketProcessor(Socket socket) throws Throwable {
            this.socket = socket;
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
        }

        public void run() {
            if (connectedClients >= Properties.SERVER_MAX_CONNECTIONS) return;
            connectedClients++;
            LinkedHashMap<String, String> requestHeaders = new LinkedHashMap<>();
            List<Integer> postRequestData = new LinkedList<>();
            postRequestData.addAll(readRequestHeaders(requestHeaders));
            if(!postRequestData.isEmpty()) {
                StringBuilder postRequestDataStr = new StringBuilder();
                postRequestData.forEach(elem -> {
                    postRequestDataStr.append((char) elem.intValue());
                });
                System.out.println();
            }
            /*if (postRequestData != null && postRequestData.length > 0
                    && requestHeaders.containsKey("content-type")
                    && requestHeaders.get("content-type").equalsIgnoreCase("application/json")) {
                postRequestDataStr = normalizeText(new String(postRequestData, StandardCharsets.UTF_8))
                        .replaceAll("\t", " ")
                        .replaceAll("\r", " ")
                        .replaceAll("\n", " ")
                        .replaceAll("  ", " ");
            }*/

            LinkedHashMap<String, String> responseHTTPHeaders = new LinkedHashMap<>();
            responseHTTPHeaders.put("HTTP/1.1 2", "00 OK\r\n");
            responseHTTPHeaders.put("Server: ", "YarServer/2009-09-09\r\n");

            byte[] response = null;
            if (requestHeaders.keySet().contains("endpoint")) {
                response = findFile(requestHeaders.get("endpoint"));
            } else response = "Method not yet implemented".getBytes();

            responseHTTPHeaders.put("Content-Length: ", response.length + "\r\n");
            responseHTTPHeaders.put("Connection: ", "Close\r\n\r\n");
            writeResponse(getBytesFromStringMap(responseHTTPHeaders), response);
        }

        private byte[] getBytesFromStringMap(LinkedHashMap<String, String> map) {
            StringBuffer sb = new StringBuffer();
            for (String key : map.keySet()) sb.append(key + map.get(key));
            return sb.toString().getBytes();
        }

        private void writeResponse(byte[] headers, byte[] body) {
            byte[] response = new byte[headers.length + body.length];
            System.arraycopy(headers, 0, response, 0, headers.length);
            System.arraycopy(body, 0, response, headers.length, body.length);
            try {
                outputStream.write(response);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private List<Integer> readRequestHeaders(LinkedHashMap<String, String> headersMap) {
            ArrayList<Integer> inputData = new ArrayList<>();
            try {
                while(true) {
                    if(inputStream.available() <= 0) break;
                    int input = inputStream.read();
                    if(input < 0) break;
                    inputData.add(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
            StringBuilder headers = new StringBuilder();
            for(int i = 0; i < inputData.size(); i++) {
                headers.append((char) inputData.get(i).intValue());
                if(headers.toString().endsWith("\r\n\r\n")) {
                    break;
                }
            }
            String[] requestHeaders = headers.toString().split("\r\n");

            String method = requestHeaders[0].split("/", 2)[0].trim().toLowerCase();
            headersMap.put("method", method);
            String[] withMethod = requestHeaders[0].split("/", 2);
            if (withMethod.length != 2) return new ArrayList<>();
            String endpoint = withMethod[1].replaceAll("[Hh][Tt][Tt][Pp][Ss/ ]*[\\d]\\.[\\d]$", "").trim();
            headersMap.put("endpoint", "/"
                    + (endpoint.isEmpty() ? "index.html" : endpoint));
            for (int i = 1; i < requestHeaders.length; i++) {
                if (requestHeaders[i].trim().isEmpty()) {
                    break;
                }
                String[] header = requestHeaders[i].split(":", 2);
                if (header.length != 2 || header[0].trim().isEmpty() || header[1].trim().isEmpty()) {
                    break;
                }
                headersMap.put(normalizeText(header[0]).toLowerCase(), normalizeText(header[1]));
            }
            if(headers.length() >= inputData.size()) return new ArrayList<>();

            ByteBuffer postData = ByteBuffer.allocate(inputData.size() - headers.length());
            return inputData.subList(headers.length(), inputData.size());
        }

        private String normalizeText(String text) {
            return URLDecoder.decode(StringEscapeUtils.unescapeHtml4(text.trim()));
        }

        private byte[] findFile(String endpoint) {
            String fullPath = new File("").getAbsolutePath() + "/www" + (
                    endpoint.equals("/") ? "/index.html" : endpoint);
            if (!new File(fullPath).exists()) return "Method not yet implemented".getBytes();

            try {
                return Files.readAllBytes(Paths.get(fullPath));
            } catch (IOException e) {
                e.printStackTrace();
                return "Error reading requested file".getBytes();
            }
/*
            StringBuilder contentBuilder = new StringBuilder();
            try (Stream<String> stream = Files.lines(Paths.get(fullPath), StandardCharsets.UTF_8)) {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
            } catch (IOException e) {
                e.printStackTrace();
                return "Error reading requested file";
            }
            return contentBuilder.toString();*/
        }

        private byte[] readPostRequestData(int length) {
            byte[] data = new byte[length];
            try {
                inputStream.read(data);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return data;
        }
    }
}
