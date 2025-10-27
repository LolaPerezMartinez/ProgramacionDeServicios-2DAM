package botellero;

public class BotellaJavi extends Thread {
	private int capacidadMax;
	private int capacidadOcupada;
	private char caracter;
	private static long milis;

	// Esto es un bloque estatico y se crea justo despues de crearse la clase
	// Es lo mismo que asignarle el valor en private static long milis = 300;
	static {
		milis = 300;
	}

	public BotellaJavi(int capacidadMax, char caracter) {
		this.capacidadMax = capacidadMax <= 0 ? 1 : capacidadMax;
		// Si no ponemos this.capacidadMax la capacidad ocupada puede ser mayor que la
		// maxima
		this.capacidadOcupada = this.capacidadMax;
		this.caracter = caracter;
	}

	public void vaciar() {
		while (capacidadOcupada > 0) {
			capacidadOcupada--;
			System.out.print(caracter);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	

	@Override
	public String toString() {
		return String.format("Botella de %c con conenido %s de %d%n", caracter, capacidadOcupada, capacidadMax);
	}

	public static void main(String[] args) {
		BotellaJavi b1 = new BotellaJavi(5, '⁓');
		BotellaJavi b2 = new BotellaJavi(10, '※');
		System.out.printf("%nBotella b1%n");
		System.out.printf("-----------%n");
		System.out.println(b1);
		// b1.vaciar();

		System.out.printf("%nBotella b2%n");
		System.out.printf("-----------%n");
		System.out.println(b2);
		// b2.vaciar();

		System.out.printf("%nVaciado de botellas%n");
		System.out.printf("---------------------%n");
		b1.vaciar();
		b2.vaciar();

		System.out.printf("%nVaciado de botellas con Thread%n");
		System.out.printf("---------------------------------%n");
		b1.vaciar();
		b2.vaciar();
	}
}
