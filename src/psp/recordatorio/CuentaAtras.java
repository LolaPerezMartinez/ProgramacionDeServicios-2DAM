package psp.recordatorio;

//extends threads: permite que cada objeto pueda ejecutarse en un hilo independiente
public class CuentaAtras extends Thread{
	private String nombre;
	private int inicio;

	public CuentaAtras(String nombre, int incio) {
		this.nombre = nombre;
		this.inicio = incio;
	}

	@Override
	public void run() {
		for (int i = inicio; i >= 0; i--) {
			System.out.printf("%s: %d -> CuentaAtras%n", nombre, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
