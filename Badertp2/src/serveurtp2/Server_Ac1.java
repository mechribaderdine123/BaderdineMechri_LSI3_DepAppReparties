package serveurtp2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ac1 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss =new ServerSocket(1234);
		System.out.println("server connecté");
		Socket s=ss.accept();
		System.out.println("un client connecté");
		InputStream in = s.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		int a = dis.readInt();
		int op = dis.readInt();
		int b = dis.readInt();
		
		
		System.out.println(" a "+a+" b "+b+" op "+op );
		
		
		int res=0;
		switch (op) {
		case 1: res = a+b;
			break;
		case 2 : res =a-b;
		    break;
		case 3 : res = a*b;
		    break;
		case 4 : res = a/b;
		    break;
		}
		System.out.println("le resultat retourné au server est :"+res);
		OutputStream out = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeInt(res);
		s.close();
		ss.close();
		
	}

}