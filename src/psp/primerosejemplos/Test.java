package psp.primerosejemplos;

public class Test {
	public static void main(String[] args) {
		System.out.printf("Lector de frase sin multihilo%n");
		System.out.printf("------------------------------%n");
		LectorDeFraseA l1 = new LectorDeFraseA("El que ha desplazado la montaña es el que comenzó por quitar las pequeñas piedras");
		System.out.println(l1.toString());
		l1.sacarPalabras();
		
		System.out.println();
		System.out.printf("%nLector de frase con multihilo%n");
		System.out.printf("------------------------------%n");
		LectorDeFraseB l2 = new LectorDeFraseB("Hola Mundo");
		LectorDeFraseB l3 = new LectorDeFraseB("El compilador nunca miente");
		l2.start();
		l3.start();
		
		System.out.printf("%nDeletrear sin multihilo%n");
		System.out.printf("------------------------------%n");
		DeletrearA d1 = new DeletrearA("El esfuerzo compila existo");
		d1.deletrear();
		
		System.out.println();
		System.out.printf("%nDeletrear con multihilo%n");
		System.out.printf("------------------------------%n");
		DeletrearB d2 = new DeletrearB("Unas veces se gana y otras se aprende");
		DeletrearB d3 =  new DeletrearB("A programar se aprende programando");
		d2.start();
		d3.start();
	}

}
