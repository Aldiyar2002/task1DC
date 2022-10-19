package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Processor of HTTP request.
 */
public class Processor {
    private final Socket socket;
    private final HttpRequest request;

    public Processor(Socket socket, HttpRequest request) {
        this.socket = socket;
        this.request = request;
    }

    public void process() throws IOException {
        System.out.println("Got request:");
        String text = request.getRequestLine();
        System.out.println(request.toString());
        System.out.flush();

        PrintWriter output = new PrintWriter(socket.getOutputStream());

        if(text.equals("GET /create/something.txt HTTP/1.1")){
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        output.println("<html>");
        output.println("<head><title>Task 1</title></head>");
        output.println("<body><p>Congratulations, something.txt file in drive D has been created</p></body>");
        output.println("<body><p>now. write exec/params to check execution</p></body>");
        output.println("</html>");
        output.flush();
        socket.close();
        }
        else if(text.equals("GET /delete/something.txt HTTP/1.1")){
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>Task 1</title></head>");
            output.println("<body><p>Congratulations, something.txt file in drive D has been completely deleted</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        }
        else if(text.equals("GET /exec/params HTTP/1.1")){
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>Task 1</title></head>");
            output.println("<body><p>you can check something.txt file. In this file you will see the output</p></body>");
            output.println("<body><p>now enter delete/something.txt to delete this file</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        }
        else {
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>Task 1</title></head>");
            output.println("<body><p>Here you can create txt file, check execution and delete it</p></body>");
            output.println("<body><p>Let's start</p></body>");
            output.println("<body><p>write /create/something.txt to create txt file in your drive D</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        }
    }
}
