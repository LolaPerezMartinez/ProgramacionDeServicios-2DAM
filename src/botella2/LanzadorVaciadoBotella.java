package botella2;

public class LanzadorVaciadoBotella extends Thread {
	private Botella botella;

	
public LanzadorVaciadoBotella(Botella botella) {
	this.botella = botella;
}
	@Override
	public void run() {
		botella.vaciar();
	}
	@Override
	public String toString() {
		return "LanzadorVaciadoBotella [botella=" + botella + "]";
	}
}
