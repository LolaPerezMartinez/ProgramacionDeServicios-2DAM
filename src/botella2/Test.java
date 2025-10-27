package botella2;

public class Test {
public static void main(String[] args) {
	Botella b1 = new Botella("B1",'⁜', 6);
	Botella b2 = new Botella("B1",'⁂', 3);
	Botella b3 = new Botella("B1",'♪', 8);
	LanzadorVaciadoBotella lb1 = new LanzadorVaciadoBotella(b1);
	LanzadorVaciadoBotella lb2 = new LanzadorVaciadoBotella(b2);
	LanzadorVaciadoBotella lb3 = new LanzadorVaciadoBotella(b3);

	System.out.println("Estado inicial: ");

	System.out.println(b1);
	System.out.println(b2);
	System.out.println(b3);
	System.out.println();

	lb1.start();
	lb2.start();
	lb3.start();

	try {
		lb1.join();
		lb2.join();
		lb3.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("\n\nEstado final: ");
	System.out.println(b1);
	System.out.println(b2);
	System.out.println(b3);
	
	System.out.println("\n\nOtra manera: ");
	new LanzadorVaciadoBotella(new Botella("A", '$', 5)).start();
	new LanzadorVaciadoBotella(new Botella("B",'*', 4)).start();
	new LanzadorVaciadoBotella(new Botella("C",'-', 3)).start();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	LanzadorVaciadoBotella lb1 = new LanzadorVaciadoBotella(new Botella("B-1", '※', 5));
//	LanzadorVaciadoBotella lb2 = new LanzadorVaciadoBotella(new Botella("B-2", '⁂', 5));
//	LanzadorVaciadoBotella lb3 = new LanzadorVaciadoBotella(new Botella("B-3", '⁘', 5));
//	
//	System.out.printf("%nHilos%n");
//	lb1.start();
//	lb2.start();
//	lb3.start();
//	
//	try {
//		lb1.join();
//		lb2.join();
//		lb3.join();
//	}catch(InterruptedException e) {
//		System.out.println("Hilo interrumpido");
//	}
//	
//	System.out.printf("%nDespués de .join()%n");
//	
}
}
