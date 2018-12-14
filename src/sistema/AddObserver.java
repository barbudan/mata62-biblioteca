package sistema;

import livro.Livro;
import usuario.Observer;
import usuario.Usuario;


public class AddObserver implements Comando{

	@Override
	public void executar(Parametros p) {
		AddObserver.observar(p);		
	}

	public static void observar(Parametros p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		
		Biblioteca b = Biblioteca.getInstancia();
		b.addObserver(codigoUsuario, codigoLivro);		
	}
	
}
