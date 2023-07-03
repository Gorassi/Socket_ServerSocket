package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;

public class MyClient implements Runnable  {
    Socket socket;
    BufferedWriter bw;
    BufferedReader reader;

    @Override
    public void run()  {
        try {
            Thread.sleep(10);
            socket = new Socket("127.0.0.1", 6660);
//            System.out.println("socket on client constructed : " + socket);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw.write("Hello from myClient !!!");
            bw.write("Message TWO from myClient !!!\n");
            bw.write("Message THREE from myClient !!!");
 //           Thread.sleep(1000);
 //           String echo = reader.readLine();
//            System.out.println("client : server send : " + reader.readLine());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.close();
//                reader.close();
                socket.close();
                System.out.println("client socket and streams has closed");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Thread went to finish");
    }
}
