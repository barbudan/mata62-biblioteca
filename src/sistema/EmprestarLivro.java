package sistema;

import sistema.Biblioteca;
import sistema.Parametros;
//import sistema.realizarEmprestimo;
import livro.Livro;
import usuario.Usuario;

public class EmprestarLivro implements Comando {

	@Override
	public void executar(Parametros p) {
		EmprestarLivro.emprestar(p);
	}

	public static void emprestar(Parametros p) {

		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();

		Biblioteca b = Biblioteca.getInstancia();

		Livro livro = b.getLivro(codigoLivro);
		Usuario usuario = b.getUsuario(codigoUsuario);

		if (livro == null) {
			System.out.println("Não há exemplar para este livro.");
			return;
		}

		usuario.fazerEmprestimo(usuario, livro);		

	}
}
