package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            // Créer un socket UDP
            DatagramSocket clientSocket = new DatagramSocket();

            // Adresse du serveur
            InetAddress serveurAddress = InetAddress.getByName("localhost");
            int serveurPort = 1234;

            // Demander au client d'entrer son prénom et nom
            System.out.print("Entrez votre prénom et nom (séparés par un espace) : ");
            String prenomNom = System.console().readLine();

            // Envoyer le message au serveur
            byte[] envoiData = prenomNom.getBytes();
            DatagramPacket envoiPacket = new DatagramPacket(envoiData, envoiData.length, serveurAddress, serveurPort);
            clientSocket.send(envoiPacket);

            // Préparer le paquet pour recevoir la réponse du serveur
            byte[] receptionBuffer = new byte[1024];
            DatagramPacket receptionPacket = new DatagramPacket(receptionBuffer, receptionBuffer.length);

            // Recevoir la réponse du serveur
            clientSocket.receive(receptionPacket);

            // Traiter et afficher la réponse
            String reponse = new String(receptionPacket.getData(), 0, receptionPacket.getLength());
            System.out.println("Message reçu du serveur (" + receptionPacket.getAddress() + ":" + receptionPacket.getPort() + "): " + reponse);

            // Fermer le socket du client
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
