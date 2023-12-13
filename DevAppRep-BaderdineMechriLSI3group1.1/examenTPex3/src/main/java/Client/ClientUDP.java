package Client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1234;

            // Demander le nom d'utilisateur
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();

            while (true) {
                System.out.print("Message : ");
                String message = scanner.nextLine();

                // Construire le paquet à envoyer au serveur
                String fullMessage = "[" + username + "]: " + message;
                byte[] buffer = fullMessage.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);

                // Envoyer le paquet
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
