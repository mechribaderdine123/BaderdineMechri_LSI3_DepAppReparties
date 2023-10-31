package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveuract3 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss =new ServerSocket(1234);
		System.out.println("server connecté");
		Socket s=ss.accept();
		System.out.println("un client connecté");
		InputStream in = s.getInputStream();
		int a = in.read();
		InputStreamReader isr =new InputStreamReader(in);
		BufferedReader bf =new  BufferedReader(isr);
		String op = bf.readLine();
		int res=0;
		switch (op) {
		case "+": res = a+5;
			break;
		case "-" : res =a-5;
		    break;
		case "/" : res = a/5;
		    break;
		case "*" : res = a*5;
		    break;
		}
		System.out.println("le resultat retourné au server est :"+res);
		OutputStream out = s.getOutputStream();
		out.write(res);
		s.close();
		ss.close();
		
	}
}