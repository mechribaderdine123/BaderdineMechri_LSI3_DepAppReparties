package client_processus;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

import calcul.Calculatice;

public class ClientProcessus_thread  extends Thread{
	
	private Socket s ;
	private int nombre_client;
	
	public ClientProcessus_thread(Socket s,int nb) {
		this.s=s;
		this.nombre_client=nb;
	}
	
	public void run () {
		 
		try {
			
			System.out.println("vous avez le clienrt numero : "+nombre_client);
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Calculatice c = (Calculatice) ois.readObject();
			
			int a = c.getNb1();
			int b = c.getNb2();
			String op = c.getOp();
			int res = 0;
			
			switch(op) {
			case "+": res = a+b;
				break;
			case "-": res = a-b;
				break;
			case "*": res = a*b;
				break;
			case "/": res = a/b;
				break;
			}
			
			System.out.println("le client a envoye l'operation suivant "+a+" "+op+" "+b+" = "+res);
			
			OutputStream out = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
		    dos.writeInt(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}

