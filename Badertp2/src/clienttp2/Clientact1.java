package clienttp2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Clientact1 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//la premier etape 
			try {
				//creation du serveur socket
				System.out.println("je suis un clinet pas encore connecté ");
				Socket s =new Socket("localhost", 1234);
				//accepter le requete venant du client
				System.out.println("un client est connecté");
			    // recuperer de clavier
				Scanner sc = new Scanner(System.in);
				System.out.println("entrer le premier entier : ");
				int a = sc.nextInt();
				System.out.println("entrer le 2eme entier : ");
				int b = sc.nextInt();
				System.out.println("entrer un operateur : \n 1) + \n 2) - \n 3) * \n 4) / ");
				int op = sc.nextInt();
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeInt(a);
				dos.writeInt(op);
				dos.writeInt(b);
				InputStream in = s.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				int res = dis.readInt();
				System.out.println("le resultat est : "+res);
				s.close();
			}
			catch(IOException e) {
			e.printStackTrace();
			}
			
		
		
}
}

