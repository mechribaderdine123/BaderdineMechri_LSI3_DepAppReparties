package clientpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Clientact3 {

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
			System.out.println("entrer un entier : ");
			int a = sc.nextInt();
			System.out.println("entrer un operateur + - * / ");
			String op = sc.next();
			OutputStream out = s.getOutputStream();
			out.write(a);
			PrintWriter pw = new PrintWriter(out);
			pw.print(op);
			InputStream in = s.getInputStream();
			int res = in.read();
			System.out.println("le resultat est : "+res);
			s.close();
		}
		catch(IOException e) {
		e.printStackTrace();
		}}}