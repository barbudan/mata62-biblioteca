package sistema;

import exemplar.Exemplar;
import livro.Livro;
import usuario.Usuario;

public class DevolverLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		DevolverLivro.devolver(p);
	}

	public static void devolver(Parametros p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		Biblioteca b = Biblioteca.getInstancia();
		b.devolverLivro(codigoUsuario, codigoLivro);
	}
}
