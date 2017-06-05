package main;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
    
    public static void main(String[] args) throws SQLException, IOException {

        try (ServerSocket ss = new ServerSocket(65535);) {
            while (true) {
                Socket cSocket = ss.accept();
                System.out.println("connected to client");
                new ServerHandler(cSocket).start();
            }
        }
               
    }
}
