package botellero;

public class BotellaRunnable extends Thread{
	private String nombre;
	private int capacidadMaxima;
	private int capacidadContenida;
	private static char caracterLlenar = '※';
	private static char caracterVaciar = '-';
	private static long milis = 300;

	public BotellaRunnable(String nombre, int capacidadMaxima, int capacidadContenida) {
		this.nombre = nombre;
		this.capacidadMaxima = capacidadMaxima;
		this.capacidadContenida = capacidadContenida > capacidadMaxima ? capacidadMaxima
				: capacidadContenida < 0 ? 0 : capacidadContenida;
	}

	private boolean vaciar() {
		if (capacidadContenida <= 0) {
			System.out.printf("%nLa botella está vacía, no se puede vaciar.%n");
			return false;
		}
		while (capacidadContenida > 0) {
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(caracterVaciar);
			capacidadContenida--;
		}
		System.out.println();
		return true;
	}
	
	public boolean llenar() {
		if(capacidadContenida >= capacidadMaxima) {
			System.out.printf("%nLa botella está llena, no se puede llenar más.%n");
			return false;
		}
		while(capacidadContenida < capacidadMaxima){
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(caracterLlenar);
			capacidadContenida++;
			
		}
		System.out.println();
		return true;
	}
	
	@Override
	public void run() {
		System.out.printf("[%s] Iniciando vaciado...%n", nombre);
		vaciar();
		System.out.printf("[%s] ¡Vaciado completado!%n", nombre);
		
		System.out.printf("[%s] Iniciando llenado...%n", nombre);
		llenar();
		System.out.printf("[%s] ¡Llenado completado!%n", nombre);
	}

	@Override
	public String toString() {
		return "Botella [nombre=" + nombre + ", capacidadMaxima=" + capacidadMaxima + ", capacidadContenida="
				+ capacidadContenida + "]";
	}

	public static void main(String[] args) {
		BotellaRunnable b1 = new BotellaRunnable("B-1", 15, 6);
		System.out.println(b1.toString());
		//System.out.printf("%nLa botella se vacía: %s%n", b1.vaciar() ? "Sí": "No");
		//System.out.printf("%nLa botella se vacía: %s%n", b1.vaciar() ? "Sí": "No");
		System.out.printf("%nVaciar y llenar una botella.%n");
		b1.vaciar();
		b1.llenar();
		
		System.out.printf("%nMultihilo 3 botellas y .start()%n");
		
		BotellaRunnable b2 = new BotellaRunnable("B-2", 6, 4);
		BotellaRunnable b3 = new BotellaRunnable("B-3", 8, 4);
		BotellaRunnable b4 = new BotellaRunnable("B-4", 10, 5);
		
		//System.out.printf("%nBotella b2%n");
		b2.start();
		//System.out.printf("%nBotella b3%n");
		b3.start();
		//System.out.printf("%nBotella b4%n");
		b4.start();
		
		
		
		
	}

}
