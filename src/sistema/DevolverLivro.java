package sistema;


public class DevolverLivro implements Comando {
	
	@Override
	public void executar(Parametro p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		Biblioteca b = Biblioteca.getInstancia();
		b.devolverLivro(codigoUsuario, codigoLivro);
	}

}
