package practica.soket.numsSuma;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerNumsSuma {
	private int port;
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	
	public ServerNumsSuma(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}
	
	private void start() throws IOException {
		System.out.printf("[Servidor: %d] Estableciendo conexión...%n", port);
		socket = serverSocket.accept();
		
		System.out.printf("[Servidor: %d] Conexión establecida.%n", port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}
	
	private void stop() throws IOException {
		System.out.printf("[Servidor: %d] Cerrando conexión...%n", port);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Servidor: %d] Conexión cerrada.%n", port);
		
	}
	public static void main(String[] args) {
		try {
			ServerNumsSuma s1 = new ServerNumsSuma(5001);
			s1.start();
			System.out.printf("[Servidor: %d] Datos recibidos: ", s1.port);
			int suma = 0;
			
			while(true) {
				int numero = s1.is.read();
				if (numero == -1) break;
				
				suma += numero;
				System.out.printf("| %d |", numero);
				
			}
			System.out.println();
			s1.os.write(suma);
			s1.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
