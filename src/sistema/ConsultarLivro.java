package sistema;

import Aplicacao.Biblioteca;
import Aplicacao.Parametros;
import Aplicacao.realizarConsultaLivro;
import Livros.Livro;

public class ConsultarLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		ConsultarLivro.Consultar(p);

	}

	public static void Consultar(Parametros parametros) {

		int codigoLivro = parametros.getP1();

		Biblioteca b = Biblioteca.getInstancia();

		livro.Livro livro = b.getLivro(codigoLivro);

		if (livro == null) {
			System.out.println("Livro nao encontrado");
			return;
		} else {
			System.out.println(livro.getTitulo() + "\n");
			System.out.println("Quantidade de reservas: " + livro.reservas.size() + "\n");
			if (livro.reservas.size() > 0) {
				livro.listarUsuariosComReservas();
			}
			System.out.println("EXEMPLARES \n");
			livro.listarExemplares();
		}
	}
}
