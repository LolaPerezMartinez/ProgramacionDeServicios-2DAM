package practica.soket.numerosNC;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSocketNumNC {
	private int port;
	private Socket socket;
	private ServerSocket serverSocket;
	private InputStream is;
	private OutputStream os;
	
	
	public ServerSocketNumNC(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}
	
	public void start() throws IOException {
		System.out.printf("[Servidor: %d] Creando conexión...%n", port);
		socket = serverSocket.accept();
		System.out.printf("[Servidor: %d] Conexion establecida.%n", port);
		
		is = socket.getInputStream();
		os = socket.getOutputStream();
		
	}
	
	public void stop() throws IOException {
		System.out.printf("[Servidor: %d] Cerrando conexión...%n", port);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Servidor: %d] Conexion cerrada.%n", port);
	}
	
	public static void main(String[] args) {
		try {
			ServerSocketNumNC s1 = new ServerSocketNumNC(9091);
			s1.start();
			while(true) {
				int datoLeido = s1.is.read();
				
				if(datoLeido == -1) break;
				
				System.out.printf("[Servidor: %d] Dato recibido: %d%n", s1.port, datoLeido);
				
				int datoAdevolver = datoLeido + 1;
				s1.os.write(datoAdevolver);
				System.out.printf("[Servidor: %d] Dato enviado: %d%n", s1.port, datoAdevolver);
			}
			s1.stop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
