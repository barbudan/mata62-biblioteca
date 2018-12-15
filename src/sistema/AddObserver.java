package sistema;


public class AddObserver implements Comando{

	@Override
	public void executar(Parametro p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		
		Biblioteca b = Biblioteca.getInstancia();
		b.addObserver(codigoUsuario, codigoLivro);		
	}
	
}
