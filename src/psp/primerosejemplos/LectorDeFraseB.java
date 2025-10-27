package psp.primerosejemplos;

public class LectorDeFraseB extends Thread{
	private String frase;
	private static int milli = 300;
	
	public LectorDeFraseB(String frase) {
		this.frase = frase;
	}

	@Override
	public void run() {
		String fraseSinEspacios = frase.replace("  ", " ");
		String [] palabras = fraseSinEspacios.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			System.out.printf("[%s]", palabras[i]);
			try {
				Thread.sleep(milli);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
	}
	
}
