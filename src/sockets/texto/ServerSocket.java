package sockets.texto;

import java.io.InputStream;
import java.io.OutputStream;

public class ServerSocket {
	private int port;
	private ServerSocket socket;
	private InputStream is;
	private OutputStream os;
	
	public ServerSocket(int port) {
		this.port = port;
		socket = new ServerSocket(port);
	}
	
	public void start() {
		
	}

}
