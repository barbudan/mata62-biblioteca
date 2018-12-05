package Emprestimo;

import Exemplares.Emprestado;
import Exemplares.Exemplar;
import Livros.Emprestimo;
import Livros.Livro;
import Livros.Reserva;
import Usuarios.Usuario;

public class EmprestimoProfessor implements EmprestimoBehavior {

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		boolean livroDisponivel = livro.verificaEstado(); // se falso, n�o tem livros dispon�veis
		if (!livroDisponivel) {
			System.out.println("N�o foi poss�vel efetuar o empr�stimo - N�o existem exemplares dispon�veis");
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