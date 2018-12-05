package Emprestimo;

import Exemplares.Emprestado;
import Exemplares.Exemplar;
import Livros.Emprestimo;
import Livros.Livro;
import Livros.Reserva;
import Usuarios.Usuario;

public class EmprestimoGraduacao implements EmprestimoBehavior {
	// verificar disponibilidade do livro
	// verificar se o aluno está devendo algum livro
	// verificar se o aluno atingiu o limite de empréstimos
	// verificar se o aluno fez reserva do livro
	// verificar a quantidade de reservas e exemplares disponíveis
	// remover a reserva
	// alterar o estado do exemplar

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		boolean livroDisponivel = livro.verificaEstado(); // se falso, não tem livros disponíveis
		if (!livroDisponivel) {
			System.out.println("Não foi possível efetuar o empréstimo - Não existem exemplares disponíveis");
			return;
		}

		int numEmprestimos = usuario.getNumEmprestimos();
		if (numEmprestimos == 3) {
			System.out.println("Não foi possível efetuar o empréstimo - Limite de empréstimos atingido");
			return;
		}

		boolean usuarioemDebito = usuario.verificaDebito();
		if (usuarioemDebito) {
			System.out.println("Não foi possível efetuar o empréstimo - Usuário está devendo um livro");
			return;
		}

		// verifica se o usuário já tem reserva do livro
		boolean usuarioFezReserva = usuario.verificaReserva(livro.getCodigo());

	}
}