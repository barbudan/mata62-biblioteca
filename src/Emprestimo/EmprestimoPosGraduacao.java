package Emprestimo;

import Exemplares.Emprestado;
import Exemplares.Exemplar;
import Livros.Emprestimo;
import Livros.Livro;
import Livros.Reserva;
import Usuarios.Usuario;

public class EmprestimoPosGraduacao implements EmprestimoBehavior {

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario esta devendo um livro");
			return;
		}

		int numEmprestimos = usuario.getNumEmprestimos();
		if (numEmprestimos == 4) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Limite de emprestimos atingido");
			return;
		}

		boolean livroDisponivel = livro.verificarEstado(); // se falso, n�o tem livros dispon�veis
		if (!livroDisponivel) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}

		// verifica se o usu�rio j� tem reserva do livro
		boolean usuarioFezReserva = usuario.verificarReserva(livro.getCodigo());
		boolean comparaReservasExemplares = livro.comparaReservasExemplares();
		if (!(comparaReservasExemplares) && !(usuarioFezReserva)) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
		}

		// Verifica se o usu�rio j� est� com o livro
		boolean jaFezEmprestimo = usuario.livroJaComoUsuario(livro.getCodigo());
		if (jaFezEmprestimo) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario ja pegou este livro");
		}

		// Implementar o emprestimo se
		// 1- Usu�rio tem reserva e n�o tem menos reservas que exemplares
		// 2- Tem menos reservas que exemplares e o usu�rio n�o tem reserva
		// 3- Tem menos reservas que exemplares e o usu�rio tem reserva
	}

}
