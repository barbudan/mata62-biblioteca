package emprestar;


import exemplar.Exemplar;
import livro.Emprestimo;
import livro.Livro;
import usuario.Usuario;

public class EmprestarProfessor implements EmprestarBehavior {

	public void emprestar(Usuario usuario, Livro livro) {
		String nomeUsuario = usuario.getNome();
		String tituloLivro = livro.getTitulo();

		// Verifica se há livros disponíveis
		
		if(!livro.existeExemplar()) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao ha exemplares para este livro na Biblioteca");
		}
		
		if (!livro.estaDisponivel() && !livro.estaReservado()) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis para este Usuario");
			return;
		}

		// Verifica se Usuário está em débito
		boolean usuarioemDebito = usuario.verificarDebito();
		if (usuarioemDebito) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Usuario esta devendo um livro");
			return;
		}
		
		Exemplar exemplar = null;
		
		if(livro.estaDisponivel())
			exemplar = livro.getExemplarDisponivel();
		else if(livro.estaReservado())
			exemplar = livro.getExemplarReservado();
		
		String codigoDoExemplar = exemplar.getCodigoExemplar();
		int totalDiasEmprestimo = usuario.getMaximoDiasEmprestimo();
		
		// Adiciona o empréstimo
		exemplar.emprestarExemplar();
		Emprestimo e = new Emprestimo(usuario, livro, exemplar, totalDiasEmprestimo , codigoDoExemplar);
		usuario.addEmprestimo(e);
		livro.addEmprestimo(e);
		usuario.addNumEmprestimos();
		System.out.println("Livro " + tituloLivro + " emprestado para o usuario " + nomeUsuario);

	}

}