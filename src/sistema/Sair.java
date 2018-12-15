package sistema;


public class Sair implements Comando {

	@Override
	public void executar(Parametro p) {
		Biblioteca b = Biblioteca.getInstancia();
		b.sair();
	}

}
