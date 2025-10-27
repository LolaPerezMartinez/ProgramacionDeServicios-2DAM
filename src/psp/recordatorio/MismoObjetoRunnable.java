package psp.recordatorio;

public class MismoObjetoRunnable implements Runnable{
	// se recomienda implements Runnable para hacer multihilo porque asi puedo
	// heredar
	
		private String nombre;
		private int inicio;

		public MismoObjetoRunnable(String nombre, int incio) {
			this.nombre = nombre;
			this.inicio = incio;
		}

		@Override
		public void run() {
			for (int i = inicio; i >= 0; i--) {
				System.out.printf("%s [%s]: %d%n", nombre, Thread.currentThread().getName(), i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	

}
