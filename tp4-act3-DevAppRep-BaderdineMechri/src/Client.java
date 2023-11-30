import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try {
            // Crée un Socket et se connecte au serveur sur localhost:1234
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connecté au serveur de chat.");

            // Demande au client d'entrer son nom
            System.out.print("Entrez votre nom : ");
            Scanner nameScanner = new Scanner(System.in);
            String clientName = nameScanner.nextLine();

            // Envoie le nom au serveur
            OutputStream nameOutputStream = socket.getOutputStream();
            nameOutputStream.write((clientName + "\n").getBytes());
            nameOutputStream.flush();

            // Crée un thread pour lire les messages du serveur
            Thread readerThread = new Thread(() -> readMessages(socket));
            readerThread.start();

            // Envoie des messages au serveur depuis la console
            Scanner scanner = new Scanner(System.in);
            OutputStream outputStream = socket.getOutputStream();

            while (true) {
                // Lit le message de la console et l'envoie au serveur
                String message = scanner.nextLine();
                outputStream.write((message + "\n").getBytes());
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMessages(Socket socket) {
        try {
            // Obtient le flux d'entrée du serveur
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                // Lit et affiche les messages du serveur
                String message = scanner.nextLine();
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

