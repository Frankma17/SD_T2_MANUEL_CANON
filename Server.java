package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Server {

    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(5000);
        Logger.getGlobal().info("Servidor creado en el puerto 5000...");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!serverSocket.isClosed()) {
                    try {
                        Socket connection = serverSocket.accept();
                        Logger.getGlobal().info("Nueva conexion aceptada :)");
                        String[] list = {"Pedro","Juan","Marcos","Lucas"};
                        DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
                        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                        int position = dataInputStream.readInt();
                        dataOutputStream.writeUTF(list[position]);
                    }catch (IOException exception){
                        exception.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}