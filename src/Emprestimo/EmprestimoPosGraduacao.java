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

		boolean livroDisponivel = livro.verificarEstado(); // se falso, não tem livros disponíveis
		if (!livroDisponivel) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}

		// verifica se o usuário já tem reserva do livro
		boolean usuarioFezReserva = usuario.verificarReserva(livro.getCodigo());
		boolean comparaReservasExemplares = livro.comparaReservasExemplares();
		if (!(comparaReservasExemplares) && !(usuarioFezReserva)) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
		}

		// Verifica se o usuário já está com o livro
		boolean jaFezEmprestimo = usuario.livroJaComoUsuario(livro.getCodigo());
		if (jaFezEmprestimo) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario ja pegou este livro");
		}

		// Implementar o emprestimo se
		// 1- Usuário tem reserva e não tem menos reservas que exemplares
		// 2- Tem menos reservas que exemplares e o usuário não tem reserva
		// 3- Tem menos reservas que exemplares e o usuário tem reserva
	}

}
