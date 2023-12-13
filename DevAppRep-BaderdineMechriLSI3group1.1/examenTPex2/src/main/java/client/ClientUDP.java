package client;

import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Création du socket UDP
            socket = new DatagramSocket();

            // Paramètres du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1234;

            // Envoi de la demande au serveur
            byte[] requestData = "Demande d'heure".getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAddress, serverPort);
            socket.send(requestPacket);

            // Réception de la réponse du serveur
            byte[] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);

            // Affichage des informations de temps reçues
            String receivedDateTime = new String(responseData, 0, responsePacket.getLength());
            System.out.println("Heure actuelle reçue du serveur : " + receivedDateTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
