package network;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",5000);
            Scanner scanner = new Scanner(System.in);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Ingrese la posición del objeto en la lista que quiere ver");
            int position = scanner.nextInt();
            dataOutputStream.writeInt(position);
            String result = dataInputStream.readUTF();
            System.out.println(result);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
