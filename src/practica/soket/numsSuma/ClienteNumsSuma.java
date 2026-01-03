package practica.soket.numsSuma;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class ClienteNumsSuma {
	private String address;
	private int port;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int numerosEnviados;
	private List<Integer> listaNumerosRandom;

	
	private static RandomGenerator random = RandomGenerator.getDefault();
	
	public ClienteNumsSuma(String address, int port, int numerosEnviados) {
		this.address = address;
		this.port = port;
		this.numerosEnviados = numerosEnviados <= 0 ? 1 : numerosEnviados > 10 ? 10 :  numerosEnviados;
		
		
		listaNumerosRandom = new ArrayList<>();
		for (int i = 0; i < numerosEnviados; i++) {
			listaNumerosRandom.add(random.nextInt(1, 101));
		}
			
	}
	
	private void start() throws UnknownHostException, IOException  {
		System.out.printf("[Cliente: %s:%d] Estableciendo conexión...%n", address, port);
		socket = new Socket(address, port);
		
		System.out.printf("[Cliente: %s:%d] Conexión establecida.%n", address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		
		
	}
	private void stop() throws IOException {
		System.out.printf("[Cliente: %s:%d] Cerrando conexión...%n", address, port);
		is.close();
		os.close();
		socket.close();
		System.out.printf("[Cliente: %s:%d] Conexión cerrada.%n", address, port);
	}
	
	public static void main(String[] args) {
		ClienteNumsSuma c1 = new ClienteNumsSuma("localhost", 5001, 3);
		try {
			c1.start();
			
			System.out.printf("[Cliente: %s:%d] El cliente ha enviado los siguientes numeros: ", c1.address, c1.port);
			System.out.print("[");
			
			for (int i = 0; i < c1.listaNumerosRandom.size(); i++) {
				c1.os.write(c1.listaNumerosRandom.get(i));
				if(i <= c1.listaNumerosRandom.size() -2) {
					System.out.printf("%d, ", c1.listaNumerosRandom.get(i));
				}else {
					System.out.printf("%d", c1.listaNumerosRandom.get(i));
				}
			}
			System.out.printf("]%n");
			c1.socket.shutdownOutput();
			
			int datoRecibido = c1.is.read();
			System.out.printf("[Cliente: %s:%d] La suma de los números enviados es: %d.%n", c1.address, c1.port, datoRecibido);
			c1.stop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
