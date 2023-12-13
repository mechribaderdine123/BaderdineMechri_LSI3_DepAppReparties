package serveur;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServeurUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Création du socket UDP
            socket = new DatagramSocket(1234);

            byte[] buffer = new byte[1024];

            System.out.println("Le serveur écoute sur le port 1234...");

            while (true) {
                // Attente de la demande du client
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                // Récupération de la date et heure actuelles
                String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                byte[] responseData = currentDateTime.getBytes();

                // Envoi de la date et heure au client
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, requestPacket.getAddress(), requestPacket.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
