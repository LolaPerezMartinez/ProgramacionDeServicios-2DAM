package sockets.numericonociclico;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ClienteSocketNumericoC {
	private int port;
	private String address;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	private static RandomGenerator random = RandomGenerator.getDefault();
	
	public ClienteSocketNumericoC(String address, int port) {
		this.port = port;
		this.address = address;
	}
	
	private void start() throws UnknownHostException, IOException {
		System.out.printf("[Cliente: %s:%d] Solicitando conexión...%n", address, port);
		socket = new Socket(address, port);
		System.out.printf("[Cliente: %s:%d] Conexión establecida.%n", address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}
	
	private void stop() throws UnknownHostException, IOException {
		System.out.printf("[Cliente: %s:%d] Cerrando conexión...%n", address, port);
		//is.close();
		//os.close();
		socket.close();
		System.out.printf("[Cliente: %s:%d] Conexión cerrada.%n", address, port);
	}
	
	public static void main(String[] args) {
		ClienteSocketNumericoC client = new ClienteSocketNumericoC("localhost", 8081);
		try {
			client.start();
			//Meto en el bucle lo que envio y lo que recibo para que no se acoplen los datos
			for (int datoAEnviar = 0; datoAEnviar < 255; datoAEnviar++) {
				client.os.write(datoAEnviar);
				System.out.printf("[Cliente: %s:%d] Dato enviado (%d)...%n", client.address, client.port, datoAEnviar);
				int datoRecibido = client.is.read();
				System.out.printf("[Cliente: %s:%d] Dato recibido (%d)...%n", client.address, client.port, datoRecibido);
			}
			
			client.stop();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
