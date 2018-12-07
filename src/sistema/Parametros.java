package sistema;

public class Parametros {
	private int p1;
	private int p2;

	// construtor para o caso de nenhum parametro
	public Parametros() {
	}

	// construtor para o caso de 1 parametro
	public Parametros(int p1) {
		this.p1 = p1;
	}

	// construtor para o caso de 2 parametros
	public Parametros(int p1, int p2) {
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
