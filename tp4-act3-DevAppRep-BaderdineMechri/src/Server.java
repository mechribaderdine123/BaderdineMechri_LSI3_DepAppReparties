import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Server {
    private static final int PORT = 1234;
    private static final Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            // Crée un ServerSocket lié au port 1234
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(PORT));
            System.out.println("Serveur de chat démarré sur le port " + PORT);

            while (true) {
                // Accepte les connexions des clients
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);

                // Crée un thread pour gérer chaque client
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Obtient le flux d'entrée du client
            InputStream inputStream = clientSocket.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            // Le premier message envoyé par le client est son nom
            String clientName = scanner.nextLine();
            System.out.println("Nouveau client connecté : " + clientName);

            while (scanner.hasNextLine()) {
                // Lit le message du client
                String message = scanner.nextLine();

                // Diffuse le message à tous les clients connectés, à l'exception de l'expéditeur
                broadcast(clientName + ": " + message, clientSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Retire le client de la liste après qu'il se déconnecte
            clients.remove(clientSocket);
        }
    }

    private static void broadcast(String message, Socket sender) {
        try {
            for (Socket client : clients) {
                // Diffuse le message à tous les clients connectés, à l'exception de l'expéditeur
                if (client != sender) {
                    OutputStream outputStream = client.getOutputStream();
                    outputStream.write((message + "\n").getBytes());
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
