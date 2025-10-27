package psp.primerosejemplos;

import java.util.Arrays;

public class LectorDeFraseA {
	private String frase;
	
	
	
	public LectorDeFraseA(String frase) {
		this.frase = frase;
	}



	public void sacarPalabras() { 
		String fraseSinEspacios = frase.replace("  ", " ");
		String [] palabras = fraseSinEspacios.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			System.out.printf("[%s]",palabras[i]);
	}

}
	
	
	
	@Override
	public String toString() {
		return "LectorDeFraseA [frase=" + frase + "]";
	}

	
}
