package client;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Remplacez par l'adresse IP du serveur
        int serverPort = 1234;

        try {
            InetAddress serverIP = InetAddress.getByName(serverAddress);
            InetSocketAddress serverSocketAddr = new InetSocketAddress(serverIP, serverPort);

            Socket clientSocket = new Socket();
            clientSocket.connect(serverSocketAddr);

            // Gérez la communication avec le serveur ici, utilisez clientSocket.getInputStream() et clientSocket.getOutputStream().

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
			
		}

	}


