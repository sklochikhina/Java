package main.java.ru.nsu.klochikhina.lab1904;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java HttpClient <host> <resource>");
            return;
        }

        String host = args[0];
        String resource = args[1];
        String request = "GET " + resource + " HTTP/1.0\r\n\r\n";
        int port = 80;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            out.println(request);

            String line;
            boolean isHeadersCompleted = false;

            while ((line = in.readLine()) != null) {
                if (!isHeadersCompleted) {
                    if (line.isEmpty())
                        isHeadersCompleted = true;
                    continue;
                }
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            System.err.println("GET" + resource + "HTTP/1.0\r\n" + "HTTP/1.0 404 Not Found\n\r\n" + "Unknown host: " + host + "\r\n" + "Connection: close\r\n\r\n");
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}