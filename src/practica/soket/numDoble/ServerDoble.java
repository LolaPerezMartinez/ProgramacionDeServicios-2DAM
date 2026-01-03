package practica.soket.numDoble;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDoble {
	private int port;
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	
	public ServerDoble(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}
	
	public void start() throws IOException {
		System.out.printf("[Servidor: %d] Estableciendo conexión...%n", port);
		socket = serverSocket.accept();
		
		System.out.printf("[Servidor: %d] Conexión establecida.%n", port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}
	
	public void stop() throws IOException {
		System.out.printf("[Servidor: %d] Cerrando conexión...%n", port);
		is.close();
		os.close();
		socket.close();
		
		System.out.printf("[Servidor: %d] Conexión cerrada.%n", port);
	}
	
	public static void main(String[] args) {
		try {
			ServerDoble s1 = new ServerDoble(5000);
			s1.start();
			while(true) {
				int datoRecibido = s1.is.read();
				
				if(datoRecibido == -1) break;
				
				System.out.printf("[Servidor: %d] Dato recibido (%d).%n", s1.port, datoRecibido);
				
				int datoEnviado  = datoRecibido * 2;
				System.out.printf("[Servidor: %d] Dato enviado (%d).%n", s1.port, datoEnviado);
				s1.os.write(datoEnviado);
			}
			s1.stop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
