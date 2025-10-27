package psp.recordatorio;

public class Test {
	public static void main(String[] args) {
		//son hilos porque extienden de thread
		CuentaAtras ca1 = new CuentaAtras("C-1", 10);
		CuentaAtras ca2 = new CuentaAtras("C-2", 5);
		
		//Son runnables no hilos por eso se envuelve en thread para multihilo
		CuentaAtrasRunnable car1 = new CuentaAtrasRunnable ("C-1", 10);
		CuentaAtrasRunnable car2 = new CuentaAtrasRunnable ("C-2", 5);
		
		System.out.printf("Mismo hilo%n");
		ca1.run();
		ca2.run();
		
		System.out.printf("%nDistinto hilo%n");
		ca1.start();
		ca2.start();
		
		System.out.printf("%nCon new Thread()%n");
		
		new Thread(car1).start();
		new Thread(car2).start();
		new Thread(() ->{
			System.out.printf("%nDentro de lambda%n");
			for (int i = 10; i >= 0; i--) {
				System.out.printf("%d ", i);
			}
			
		}).start();
		
		System.out.printf("%nCar1 en 2 hilos distintos%n");
		Thread t1 = new Thread(car1);
		Thread t2 = new Thread(car1);
		t1.start();
		t2.start();
		
		MismoObjetoRunnable mor1 = new MismoObjetoRunnable("C-1", 10);

		Thread tmo1 = new Thread(mor1);
		Thread tmo2 = new Thread(mor1);

		tmo1.start();
		tmo2.start();

	}
}
