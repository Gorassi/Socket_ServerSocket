package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyServer {
    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        MyServer myServer = new MyServer();
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try{
            myServer.serverSocket = new ServerSocket(6660);
//            System.out.println("serverSocket : " + myServer.serverSocket);
            MyClient myClient = new MyClient();
            Thread thread = new Thread(myClient);
            System.out.println("serverSocket start accept()");
            thread.start();
            Socket socket = myServer.serverSocket.accept();
//            System.out.println("socket on server : " + socket);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            writer.write("ku-ku from Server !!!\n");
//            writer.write("ku-ku 2 from Server !!!");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            System.out.println("server read message from client: " + msg);
            writer.write("server read msg from client: " + msg);

        } catch (IOException  e) {
            e.printStackTrace();
        }

        System.out.println("Main went to finish at " + new SimpleDateFormat("HH:MM:ss").format( new Date().getTime()));
//        reader.close();
//        writer.close();
//        socket.close();
    }
}
