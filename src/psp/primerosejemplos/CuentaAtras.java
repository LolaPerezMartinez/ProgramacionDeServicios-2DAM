package psp.primerosejemplos;

public class CuentaAtras extends Thread{
	private int valorInicial;
	private String nombre;
	private static int milis = 200;
	
	
	public CuentaAtras(int valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		//this.arranca();
		arranca();
	}

	public void arranca() {
		for (int i = valorInicial; i >= 0; i--) {
			//en este hilo que estoy me lo paras 300 milisegundos
			System.out.printf("%s: %d%n", nombre, i);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CuentaAtras ca1 = new CuentaAtras(10, "C-1");
		CuentaAtras ca2 = new CuentaAtras(5, "C-2");
		ca1.start();
		ca2.start();
	}
}
