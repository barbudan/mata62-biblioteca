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

		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Usuario esta devendo um livro");
			return;
		}

		boolean livroDisponivel = livro.verificarEstado(); // se falso, não tem livros disponíveis
		if (!livroDisponivel) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}

		// verifica se o usuário já tem reserva do livro
		boolean usuarioFezReserva = usuario.verificarReserva(livro.getCodigo());

		// falta:
		// se o usuario tem reserva, remove a reserva
		// aumenta o contador de emprestimos
		// faz a reserva e muda o status
	}

}