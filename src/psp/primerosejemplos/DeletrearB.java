package psp.primerosejemplos;

public class DeletrearB extends Thread{
	private String palabra;
	private static int millis = 300;
	
	
	public DeletrearB(String palabra) {
		this.palabra = palabra;
	}


	@Override
	public void run() {
		String palabraSinEspacios = palabra.replace(" ", "");
		char [] palabraChar = palabraSinEspacios.toCharArray();
		for (int i = 0; i < palabraChar.length; i++) {
			System.out.printf("[%s]", palabraChar[i]);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
