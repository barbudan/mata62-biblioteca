package emprestar;

import exemplar.Emprestado;
import exemplar.Exemplar;
import livro.Emprestimo;
import livro.Livro;
import livro.Reserva;
import usuario.Usuario;

public class EmprestarPosGraduacao implements EmprestarBehavior {

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		// Verifica se há livros disponíveis
		boolean livroDisponivel = livro.estaDisponivel();
		if (!livroDisponivel) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}

		// Verifica se Usuário está em débito
		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario esta devendo um livro");
			return;
		}

		// Verifica se o Usuário atingiu o Limite de Empréstimos
		int numEmprestimos = usuario.getNumEmprestimos();
		if (numEmprestimos == 4) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Limite de emprestimos atingido");
			return;
		}

		// Verifica se o Usuário já reservou o Livro Solicitado
		int codigoLivro = livro.getCodigo();
		boolean usuarioFezReserva = usuario.verificarReserva(codigoLivro);
		boolean maisExemplaresQueReservas = livro.maisExemplaresQueReservas();
		if (!(maisExemplaresQueReservas) && !(usuarioFezReserva)) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis");
			return;
		}

		// Verifica se o Usuário já está com o Livro Solicitado
		boolean jaFezEmprestimo = usuario.livroEstaComUsuario(codigoLivro);
		if (jaFezEmprestimo) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario ja pegou este livro");
			return;
		}

		Exemplar exemp = livro.getExemplarDisponivel();
		String codigoDoExemplar = exemp.getCodigoExemplar();

		if (maisExemplaresQueReservas && usuarioFezReserva) {
			// Remover a reserva realizada
			Reserva r = usuario.getReserva(livro.getCodigo());
			usuario.removerReserva(r);
			r = livro.getReserva(usuario.getCodigo());
			livro.removerReserva(r);
			// Adicionar o empréstimo
			Emprestimo e = new Emprestimo(usuario, livro, 4, codigoDoExemplar);
			usuario.addEmprestimo(e);
			livro.addEmprestimo(e);
			// Alterar o estado do exemplar
			e.setEstadoLivro("Emprestado");
			exemp.setEstado(new Emprestado());
			usuario.addNumEmprestimos();
			System.out.println("Livro " + tituloLivro + "emprestado para o usuario " + nomeUsuario);

		} else if (maisExemplaresQueReservas && !(usuarioFezReserva)) {
			// Adicionar o empréstimo
			Emprestimo e = new Emprestimo(usuario, livro, 4, codigoDoExemplar);
			usuario.addEmprestimo(e);
			livro.addEmprestimo(e);
			// Alterar o estado do exemplar
			e.setEstadoLivro("Emprestado");
			exemp.setEstado(new Emprestado());
			usuario.addEmprestimo(e);
			System.out.println("Livro " + tituloLivro + "emprestado para o usuario " + nomeUsuario);

		} else if (!(maisExemplaresQueReservas) && usuarioFezReserva) {
			// Remover a reserva realizada
			Reserva r = usuario.getReserva(livro.getCodigo());
			usuario.removerReserva(r);
			r = livro.getReserva(usuario.getCodigo());
			livro.removerReserva(r);
			// Adicionar o empréstimo
			Emprestimo e = new Emprestimo(usuario, livro, 4, codigoDoExemplar);
			usuario.addEmprestimo(e);
			livro.addEmprestimo(e);
			// Alterar o estado
			e.setEstadoLivro("Emprestado");
			exemp.setEstado(new Emprestado());
			usuario.addEmprestimo(e);
			System.out.println("Livro " + tituloLivro + "emprestado para o usuario " + nomeUsuario);

		}
	}

}
