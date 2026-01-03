package sockets.numericonociclico;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketNumericoC {
	private int port;
	//linea de comunicacion -> socket
	private Socket socket;
	//para escuchar conexiones (lo que tiene el socket) en un puerto
	//es muy importante que se ponga a escuchar en un puerto
	private ServerSocket serverSocket;
	private InputStream is;
	private OutputStream os;
	
	
	public ServerSocketNumericoC(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}
	
	public void start() throws IOException {
		System.out.printf("[Servidor: %d] Esperando conexión...%n", port);
		//accept() // Espera (bloquea) hasta que un cliente se conecta 
		//y crea el socket de comunicación
		//está escuchando dando vueltas hasta que encuentra un socket
		socket = serverSocket.accept();
		System.out.printf("[Servidor: %d] Conexión establecida.%n", port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	};
	
	public void stop() throws IOException {
		System.out.printf("[Servidor: %d] Cerrando conexiones.%n", port);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Servidor: %d] Conexión cerrada.%n", port);
	};
	
	public static void main(String[] args) {
		try {
			ServerSocketNumericoC s1 = new ServerSocketNumericoC(8081);
			s1.start();
			while(true) {
				int datoLeido = s1.is.read();
				
				if(datoLeido == -1) break;
				
				System.out.printf("[Servidor: %d] Dato recibido (%d).%n", s1.port, datoLeido);
				int datoADevolver = datoLeido + 1;
				s1.os.write(datoADevolver);
				System.out.printf("[Servidor: %d] Dato enviado (%d).%n", s1.port, datoADevolver);
			}
			s1.stop();
		} catch (IOException e) {
			System.out.printf("");
		}
	}
	
}
