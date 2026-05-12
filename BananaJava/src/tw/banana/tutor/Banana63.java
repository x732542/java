package tw.banana.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Banana63 {

	public static void main(String[] args) {
		while (true) {
			try(ServerSocket server = new ServerSocket(9999);
				Socket socket = server.accept();
				BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
				//--------------------------------------------------
					){
				
				String urIp = socket.getInetAddress().getHostAddress();
				
				BufferedOutputStream bout = new BufferedOutputStream(
						new FileOutputStream(String.format("dir2/%s.jpg", urIp)));
				
				byte[] buf = bin.readAllBytes();
				System.out.println(buf.length + " bytes");
				
				bout.write(buf);
				bout.flush();
				bout.close();
				//System.out.println("TCP Receive OK");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}