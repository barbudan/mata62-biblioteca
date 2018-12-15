package sistema;

public class Parametro {
	private int p1;
	private int p2;

	// construtor para o caso de nenhum parametro
	public Parametro() {
	}

	// construtor para o caso de 1 parametro
	public Parametro(int p1) {
		this.p1 = p1;
	}

	// construtor para o caso de 2 parametros
	public Parametro(int p1, int p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public int getP1() {
		return p1;
	}

	public int getP2() {
		return p2;
	}
}
