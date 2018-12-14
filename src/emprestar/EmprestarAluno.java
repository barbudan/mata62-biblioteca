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
		
		int codigoLivro = livro.getCodigo();

		if(!livro.existeExemplar()){
			System.out.println("N�o foi possivel efetuar o emprestimo - N�o existem exemplares para este livro");
			return;
		}
		
		boolean usuarioFezReserva = usuario.verificarReserva(codigoLivro);
		
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
		
		// Verifica se n�o h� mais exemplar dispon�vel que reserva e o Usu�rio n�o tem Reservas
		boolean maisExemplaresDisponiveisQueReservados = livro.maisExemplaresDisponiveisQueReservados();
		if (!(maisExemplaresDisponiveisQueReservados) && !(usuarioFezReserva)) {
			System.out.println("Nao foi possivel efetuar o emprestimo - Nao existem exemplares disponiveis e o Usu�rio n�o possui Reserva");
			return;
		}

		// Verifica se o Usu�rio j� est� com o Livro Solicitado
		boolean jaFezEmprestimo = usuario.livroEstaComUsuario(codigoLivro);
		if (jaFezEmprestimo) {
			System.out.println("Nao foi possivel efetuar o emprestimo - O usuario ja pegou este livro");
			return;
		}

		if(!livro.estaReservado() && !livro.estaDisponivel())
		{
			System.out.println("N�o foi possivel efetuar o emprestimo - N�o h� Exemplares Dispon�veis");
			return;
		}
		
		Exemplar exemplar;
		String codigoDoExemplar;
		
		if(usuarioFezReserva && livro.estaReservado()) {
			
			exemplar = livro.getExemplarReservado();
			codigoDoExemplar = exemplar.getCodigoExemplar();
			Reserva r = usuario.getReserva(livro.getCodigo());
			usuario.removerReserva(r);
			r = livro.getReserva(livro.getCodigo(), usuario.getCodigo());
			livro.removerReserva(r);
			
			exemplar.emprestarExemplar();
			Emprestimo e = new Emprestimo(usuario, livro, exemplar, 3, codigoDoExemplar);
			usuario.addEmprestimo(e);
			livro.addEmprestimo(e);
			usuario.addNumEmprestimos();
			System.out.println("Livro " + tituloLivro + " emprestado para o usuario " + nomeUsuario);
			return;
			
		} else if(livro.estaDisponivel()) {
			
			exemplar = livro.getExemplarDisponivel();
			codigoDoExemplar = exemplar.getCodigoExemplar();
			
			exemplar.emprestarExemplar();
			Emprestimo e = new Emprestimo(usuario, livro, exemplar, 3, codigoDoExemplar);
			usuario.addEmprestimo(e);
			livro.addEmprestimo(e);
			usuario.addNumEmprestimos();
			System.out.println("Livro " + tituloLivro + " emprestado para o usuario " + nomeUsuario);
			return;
		}
		
		
		return;
		
	}

}