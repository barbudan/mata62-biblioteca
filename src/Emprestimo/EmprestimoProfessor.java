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

		boolean livroDisponivel = livro.verificaEstado(); // se falso, não tem livros disponíveis
		if (!livroDisponivel) {
			System.out.println("Não foi possível efetuar o empréstimo - Não existem exemplares disponíveis");
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