package serveur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import client.Client;
public class Serveurmultithread {
		public static void main(String[] args) {
			
			try {
					ServerSocket  ss = new ServerSocket(1234);
					System.out.println("Server en attend de connexions  ");
					int clientnumber = 0;
					while(true) {
						Socket s = ss.accept();
						clientnumber++;
						System.out.println(" Noueau client connecte - clkient  "+ clientnumber);
						Client client = new Client(s,clientnumber);
						new Thread(client).start();	
					}
			}catch(IOException e) {
				e.printStackTrace();
			}

		}

	} 

