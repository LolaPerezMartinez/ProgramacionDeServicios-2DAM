package practica.soket.numerosNC;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.random.RandomGenerator;

public class ClienteSocketNumNC {
	private int port;
	private String address;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	private static RandomGenerator random = RandomGenerator.getDefault();
	
	public ClienteSocketNumNC(int port, String address) {
		this.port = port;
		this.address = address;
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.printf("[Cliente: %s:%d] Solicitando conexión...%n", address, port);
		socket = new Socket(address, port);
		System.out.printf("[Cliente: %s:%d] Conexión establecida.%n", address, port);
		
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}
	
	public void stop() throws IOException {
		System.out.printf("[Cliente: %s:%d] Cerrando conexión...%n", address, port);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Cliente: %s:%d] Conexión cerrada.%n", address, port);
		
	}
	
	public static void main(String[] args) {
		ClienteSocketNumNC c1 = new ClienteSocketNumNC(9091, "localhost");
		
		try {
			c1.start();
			int datoEnviar = random.nextInt(0, 255);
			c1.os.write(datoEnviar);
			System.out.printf("[Cliente: %s:%d] Dato enviado (%d)...%n", c1.address, c1.port, datoEnviar);
			
			int datoRecibido = c1.is.read();
			
			System.out.printf("[Cliente: %s:%d] Dato recibido (%d).%n", c1.address, c1.port, datoRecibido);
			c1.stop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
