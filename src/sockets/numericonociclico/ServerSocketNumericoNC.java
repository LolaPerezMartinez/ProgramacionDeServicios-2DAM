package sockets.numericonociclico;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketNumericoNC {
	private int port;
	//linea de comunicacion -> socket
	private Socket socket;
	private ServerSocket serverSocket;
	private InputStream is;
	private OutputStream os;
	
	
	public ServerSocketNumericoNC(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}
	
	public void start() throws IOException {
		System.out.printf("[Servidor: %d] Esperando conexión...%n", port);
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
			ServerSocketNumericoNC s1 = new ServerSocketNumericoNC(8081);
			s1.start();
			int datoLeido = s1.is.read();
			System.out.printf("[Servidor: %d] Dato recibido (%d).%n", s1.port, datoLeido);
			int datoADevolver = datoLeido + 1;
			s1.os.write(datoADevolver);
			System.out.printf("[Servidor: %d] Dato enviado (%d).%n", s1.port, datoADevolver);
			s1.stop();
		} catch (IOException e) {
			System.out.printf("");
		}
	}
	
}
