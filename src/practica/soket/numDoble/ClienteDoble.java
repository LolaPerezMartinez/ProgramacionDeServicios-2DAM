package practica.soket.numDoble;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.random.RandomGenerator;

public class ClienteDoble {
	private String address;
	private int port;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	private static RandomGenerator random = RandomGenerator.getDefault();
	
	
	public ClienteDoble(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	private void start() throws UnknownHostException, IOException {
		System.out.printf("[Cliente: %s:%d] Estableciendo conexión...%n", address, port);
		socket =  new Socket(address, port);
		
		System.out.printf("[Cliente: %s:%d] Conexión establecida.%n", address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}
	
	private void stop() throws IOException {
		System.out.printf("[Cliente: %s:%d] Finalizando conexión...%n", address, port);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Cliente: %s:%d] Conexión finalizada.%n", address, port);
	}
	
	public static void main(String[] args) {
		ClienteDoble c1 = new ClienteDoble("localhost", 5000);
		try {
			c1.start();
			int numeroRandom = random.nextInt(1, 101);
			c1.os.write(numeroRandom);
			System.out.printf("[Cliente: %s:%d] Dato enviado (%d).%n", c1.address, c1.port, numeroRandom);
			
			int datoRecibido = c1.is.read();
			System.out.printf("[Cliente: %s:%d] Dato recibido (%d).%n", c1.address, c1.port, datoRecibido);
			c1.stop();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
