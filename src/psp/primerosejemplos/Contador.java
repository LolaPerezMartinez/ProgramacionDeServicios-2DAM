package psp.primerosejemplos;

public class Contador extends Thread{
	private int valorFinal;
	private String nombre;
	private static int milis = 400;
	
	
	public Contador(int valorFinal, String nombre) {
		this.valorFinal = valorFinal;
		this.nombre = nombre;
	}
	
	
	@Override
	public void run() {
		for(int i = 0; i <= valorFinal; i++) {
			System.out.printf("%d %s%n", i, nombre);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		Contador c1 = new Contador(10, "C-1");
		Contador c2 = new Contador(5, "C-2");
		c1.start();
		c2.start();
	}
	
	

}
