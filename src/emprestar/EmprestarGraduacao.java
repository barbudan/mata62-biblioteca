package emprestar;

import exemplar.Emprestado;
import exemplar.Exemplar;
import livro.Emprestimo;
import livro.Livro;
import livro.Reserva;
import usuario.Usuario;

public class EmprestarGraduacao implements EmprestarBehavior {

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		// Verifica se h� livros dispon�veis
		boolean livroDisponivel = livro.verificarEstado();
		if (!livroDisponivel) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem usuarios disponiveis");
			return;
		}
		
		// Verifica se Usu�rio est� em d�bito
		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O Usuario esta devendo um livro");
			return;
		}

		// Verifica se o Usu�rio atingiu o Limite de Empr�stimos
		int numEmprestimos = usuario.getNumEmprestimos();
		if (numEmprestimos == 3) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Limite de emprestimos atingido");
			return;
		}
		
		
		// Verifica se o Usu�rio j� reservou o Livro Solicitado
		int codigoLivro = livro.getCodigo();
		boolean usuarioFezReserva = usuario.verificarReserva(codigoLivro);
		boolean maisExemplaresQueReservas = livro.maisExemplaresQueReservas();
		if (!(maisExemplaresQueReservas) && !(usuarioFezReserva)) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}

		// Verifica se o Usu�rio j� est� com o Livro Solicitado
		boolean jaFezEmprestimo = usuario.livroEstaComUsuario(codigoLivro);
		if (jaFezEmprestimo) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario ja pegou este livro");
			return;
		}

		// Implementar o emprestimo se
		// 1- Usu�rio tem reserva e n�o tem menos reservas que exemplares
		// 2- Tem menos reservas que exemplares e o usu�rio n�o tem reserva
		// 3- Tem menos reservas que exemplares e o usu�rio tem reserva
	}

}