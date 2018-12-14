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

		Biblioteca.emprestarLivro(codigoUsuario, codigoLivro);	

	}
}
