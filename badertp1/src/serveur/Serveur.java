package serveur;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.net.ServerSocket;
	import java.net.Socket;
public class Serveur {
	    	public static void main(String[] args) throws IOException {
			ServerSocket ss =new ServerSocket(1234);
			System.out.println("server connecté");
			Socket s=ss.accept();
			System.out.println("un client connecté");
			InputStream in = s.getInputStream();
			int a = in.read();
			int res=a*5;
			System.out.println("le resultat retourné au server est :"+res);
			OutputStream out = s.getOutputStream();
			out.write(res);
			s.close();
			ss.close();
			}
			
		}


