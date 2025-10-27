package psp.recordatorio;

//se recomienda implements Runnable para hacer multihilo porque asi puedo heredar
public class CuentaAtrasRunnable implements Runnable{
	private String nombre;
	private int inicio;

	public CuentaAtrasRunnable(String nombre, int incio) {
		this.nombre = nombre;
		this.inicio = incio;
	}

	@Override
	public void run() {
		for (int i = inicio; i >= 0; i--) {
			System.out.printf("%s: %d -> CuentaAtrasRunnable%n", nombre, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
