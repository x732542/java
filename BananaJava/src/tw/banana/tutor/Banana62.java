package tw.banana.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Banana62 {

	public static void main(String[] args) {
		File source = new File("dir1/06f5.gif");
		try(BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream(source));
			//------------------------------------------------------------
				Socket socket = new Socket(InetAddress.getByName("10.0.102.29"), 9999);
			BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream())	
				){
			
			byte[] buf = bin.readAllBytes();
			System.out.println(buf.length + " bytes");
			
			out.write(buf);
			out.flush();
			System.out.println("TCP Send OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}