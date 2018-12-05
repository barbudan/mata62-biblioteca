package Emprestimo;

import Exemplares.Emprestado;
import Exemplares.Exemplar;
import Livros.Emprestimo;
import Livros.Livro;
import Livros.Reserva;
import Usuarios.Usuario;

public class EmprestimoGraduacao implements EmprestimoBehavior {
	// verificar disponibilidade do livro
	// verificar se o aluno est� devendo algum livro
	// verificar se o aluno atingiu o limite de empr�stimos
	// verificar se o aluno fez reserva do livro
	// verificar a quantidade de reservas e exemplares dispon�veis
	// remover a reserva
	// alterar o estado do exemplar

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		boolean livroDisponivel = livro.verificaEstado(); // se falso, n�o tem livros dispon�veis
		if (!livroDisponivel) {
			System.out.println("N�o foi poss�vel efetuar o empr�stimo - N�o existem exemplares dispon�veis");
			return;
		}

		int numEmprestimos = usuario.getNumEmprestimos();
		if (numEmprestimos == 3) {
			System.out.println("N�o foi poss�vel efetuar o empr�stimo - Limite de empr�stimos atingido");
			return;
		}

		boolean usuarioemDebito = usuario.verificaDebito();
		if (usuarioemDebito) {
			System.out.println("N�o foi poss�vel efetuar o empr�stimo - Usu�rio est� devendo um livro");
			return;
		}

		// verifica se o usu�rio j� tem reserva do livro
		boolean usuarioFezReserva = usuario.verificaReserva(livro.getCodigo());

	}
}