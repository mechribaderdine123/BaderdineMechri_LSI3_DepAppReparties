package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ServeurUDP {

    private static List<InetSocketAddress> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(null);
            InetSocketAddress address = new InetSocketAddress("localhost", 1234);
            socket.bind(address);

            System.out.println("Serveur en attente sur le port 1234...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message reçu de " + packet.getAddress() + ": " + message);

                // Ajouter l'expéditeur à la liste des clients si ce n'est pas déjà fait
                InetSocketAddress clientAddress = new InetSocketAddress(packet.getAddress(), packet.getPort());
                if (!clients.contains(clientAddress)) {
                    clients.add(clientAddress);
                }

                // Diffuser le message à tous les clients connectés sauf à l'expéditeur
                broadcastMessage(message, clientAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void broadcastMessage(String message, InetSocketAddress sender) {
        for (InetSocketAddress client : clients) {
            if (!client.equals(sender)) {
                try {
                    DatagramSocket broadcastSocket = new DatagramSocket();
                    byte[] buffer = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, client);
                    broadcastSocket.send(packet);
                    broadcastSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

