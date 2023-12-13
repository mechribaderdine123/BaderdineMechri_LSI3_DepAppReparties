package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            // Créer un socket UDP sur le port 1234
            DatagramSocket serveurSocket = new DatagramSocket(1234);

            System.out.println("Le serveur écoute sur le port 1234...");

            while (true) {
                // Préparer le paquet pour recevoir les données du client
                byte[] buffer = new byte[1024];
                DatagramPacket receptionPacket = new DatagramPacket(buffer, buffer.length);

                // Recevoir les données du client
                serveurSocket.receive(receptionPacket);

                // Traiter les données reçues
                String message = new String(receptionPacket.getData(), 0, receptionPacket.getLength());
                InetAddress clientAddress = receptionPacket.getAddress();
                int clientPort = receptionPacket.getPort();

                // Construire la réponse
                String response = "Bienvenue " + message;
                byte[] envoiData = response.getBytes();

                // Envoyer la réponse au client
                DatagramPacket envoiPacket = new DatagramPacket(envoiData, envoiData.length, clientAddress, clientPort);
                serveurSocket.send(envoiPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
