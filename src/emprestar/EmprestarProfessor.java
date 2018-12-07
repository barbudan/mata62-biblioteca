package emprestar;

import exemplar.Emprestado;
import exemplar.Exemplar;
import livro.Emprestimo;
import livro.Livro;
import livro.Reserva;
import usuario.Usuario;

public class EmprestarProfessor implements EmprestarBehavior {

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		// Verifica se h� livros dispon�veis
		boolean livroDisponivel = livro.estaDisponivel();
		if (!livroDisponivel) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}
		
		// Verifica se Usu�rio est� em d�bito
		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Usuario esta devendo um livro");
			return;
		}

		// Verifica se o Usu�rio Reservou o Livro Solicitado
		boolean usuarioFezReserva = usuario.verificarReserva(livro.getCodigo());

		// falta:
		// se o usuario tem reserva, remove a reserva
		// aumenta o contador de emprestimos
		// faz a reserva e muda o status
	}

}