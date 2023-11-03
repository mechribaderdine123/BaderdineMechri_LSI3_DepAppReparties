package serveur;
   import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;

	import client_processus.ClientProcessus_thread;
	
	public class Serveuract2 {

		public static void main(String[] args) throws IOException {
			
			int nbclient =1;
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("je suis un server  attend la connexion d'un client  ! ");
			
			while(true) {
				Socket s = ss.accept();
				System.out.println("un client est connecte !!");
				ClientProcessus_thread client = new ClientProcessus_thread(s,nbclient);
				client.start();
				nbclient++;
				
			}
			
			
		}

	}
