package sistema;


public class ReservarLivro implements Comando {
	
	@Override
	public void executar(Parametro p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		Biblioteca b = Biblioteca.getInstancia();
		b.reservarLivro(codigoUsuario, codigoLivro);
	}

}
