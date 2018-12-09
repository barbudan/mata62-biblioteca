package sistema;

import sistema.Biblioteca;
import sistema.Parametros;
import usuario.Usuario;
//import sistema.realizarConsultaLivro;
import livro.Livro;

public class ConsultarLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		ConsultarLivro.consultar(p);

	}

	public static void consultar(Parametros parametros) {

		int codigoLivro = parametros.getP1();

		Biblioteca b = Biblioteca.getInstancia();

		Livro livro = b.getLivro(codigoLivro);

		if (livro == null) {
			System.out.println("Livro nao encontrado");
			return;
		} else {
			System.out.println(livro.getTitulo() + "\n");
			System.out.println("Quantidade de reservas: " + livro.getQuantidadeReservas() + "\n");
			if (livro.getQuantidadeReservas() > 0) {
				livro.listarUsuariosComReservas();
			}
			System.out.println("EXEMPLARES \n");
			livro.listarExemplares();
		}
	}
}
