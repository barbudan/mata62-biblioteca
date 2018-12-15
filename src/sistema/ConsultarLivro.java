package sistema;


public class ConsultarLivro implements Comando {
	
	@Override
	public void executar(Parametro p) {
		int codigoLivro = p.getP1();
		Biblioteca b = Biblioteca.getInstancia();
		b.consultarLivro(codigoLivro);
	}

}
