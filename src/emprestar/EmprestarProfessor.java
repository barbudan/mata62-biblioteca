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
		
		if(!livro.existeExemplar()) {
			System.out.println("N�o foi possivel efetuar o emprestimo - Nao ha exemplares para este livro na Biblioteca");
		}
		
		if (!livro.estaDisponivel() && !livro.estaReservado()) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis para este Usuario");
			return;
		}

		// Verifica se Usu�rio est� em d�bito
		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Usuario esta devendo um livro");
			return;
		}
		
		Exemplar exemplar = livro.getExemplarDisponivel();
		String codigoDoExemplar = exemplar.getCodigoExemplar();
		
		// Adiciona o empr�stimo
		exemplar.emprestarExemplar();
		Emprestimo e = new Emprestimo(usuario, livro, exemplar, 7, codigoDoExemplar);
		usuario.addEmprestimo(e);
		livro.addEmprestimo(e);
		usuario.addNumEmprestimos();
		System.out.println("Livro " + tituloLivro + "emprestado para o usuario " + nomeUsuario);

	}

}