package psp.primerosejemplos;

public class DeletrearA {
	private String palabra;

	public DeletrearA(String palabra) {
		this.palabra = palabra;
	}
	
	public void deletrear() {
		String palabraSinEspacios = palabra.replace(" ", "");
		char [] letras = palabraSinEspacios.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			System.out.printf("[%s]", letras[i]);
		}
	}

}
