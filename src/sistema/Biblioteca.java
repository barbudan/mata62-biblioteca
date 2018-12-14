package sistema;

import java.util.ArrayList;

import exemplar.Exemplar;
import livro.Livro;
import livro.Reserva;
import usuario.Observer;
import usuario.Professor;
import usuario.Usuario;

public class Biblioteca {
	private Biblioteca() {
	};

	private static Biblioteca instancia;

	public ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
	public ArrayList<Livro> listaDeLivros = new ArrayList<Livro>();

	public static Biblioteca getInstancia() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}

	public void addUsuario(Usuario u) {
		listaDeUsuarios.add(u);
	}

	public void addLivro(Livro l) {
		listaDeLivros.add(l);
	}

	// get livro através do código
	private Livro getLivro(int codigo) {
		for (Livro l : listaDeLivros) {
			if (l.getCodigo() == codigo) {
				if (l.existeExemplar())
					return l;
			}
		}
		return null;
	}

	// get usuario através do código
	private Usuario getUsuario(int codigo) {
		for (Usuario u : listaDeUsuarios) {
			if (u.getCodigo() == codigo) {
				return u;
			}
		}
		return null;
	}

	public void addObserver(int codigoUsuario, int codigoLivro) {
		Biblioteca b = Biblioteca.getInstancia();
		
		Usuario usu = b.getUsuario(codigoUsuario);
		Livro livro = b.getLivro(codigoLivro);
		
		livro.registraObservador((Observer) usu);
		
		System.out.println("Professor " + usu.getNome() + " está agora observando o livro " + livro.getTitulo());
	}
	
	public void consultarLivro(int codigoLivro) {
		Biblioteca b = Biblioteca.getInstancia();
		Livro livro = b.getLivro(codigoLivro);

		if (livro == null) {
			System.out.println("Livro nao encontrado");
			return;
		} else {
			System.out.println("Nome do Livro: " + livro.getTitulo());
			System.out.println("Quantidade de reservas: " + livro.getQuantidadeReservas());
			if (livro.getQuantidadeReservas() > 0) {
				livro.listarUsuariosComReservas();
			}
			System.out.println("EXEMPLARES");
			livro.listarExemplares();
		}
	}

	public void consultarNotificacoes(int codigoUsuario) {
		Biblioteca b = Biblioteca.getInstancia();
		Usuario usu = b.getUsuario(codigoUsuario);

		System.out.println(
				"Professor " + usu.getNome() + " tem " + ((Professor) usu).getNotificacoes() + " notificacoes");

	}

	public void consultarUsuario(int codigoUsuario) {
		Biblioteca b = Biblioteca.getInstancia();
		Usuario usuario = b.getUsuario(codigoUsuario);

		System.out.println("Usuario: " + usuario.getNome());
		usuario.listarEmprestimos();
		System.out.println("Reservas:");
		usuario.listarReservas();
	}

	public void devolverLivro(int codigoUsuario, int codigoLivro) {
		Biblioteca b = Biblioteca.getInstancia();
		Usuario usu = b.getUsuario(codigoUsuario);
		Livro livro = b.getLivro(codigoLivro);

		if (usu.livroEstaComUsuario(codigoLivro)) {
			Exemplar e = usu.getExemplar(codigoLivro);
			System.out.println("Livro " + livro.getTitulo() + " devolvido pelo Usuario " + usu.getNome());
			e.disponibilizarExemplar();
			if (livro.getNumReservas() != livro.getNumExemplaresReservados())
				e.reservarExemplar();

			usu.devolveReservaExemplar(codigoLivro);
			usu.subNumEmprestimos();
			livro.removerEmprestimoPorExemplar(e.getCodigoExemplar());
		} else
			System.out.println("Devolução não concluida. Livro " + livro.getTitulo() + " não está em posse do Usuario "
					+ usu.getNome());
	}

	public void emprestarLivro(int codigoUsuario, int codigoLivro) {
		Biblioteca b = Biblioteca.getInstancia();
		Livro livro = b.getLivro(codigoLivro);
		Usuario usuario = b.getUsuario(codigoUsuario);

		if (livro == null) {
			System.out.println("Não há exemplar para este livro.");
			return;
		}

		usuario.fazerEmprestimo(usuario, livro);
	}
	
	public void reservarLivro(int codigoUsuario, int codigoLivro) {
		Biblioteca b = Biblioteca.getInstancia();
		Usuario usu = b.getUsuario(codigoUsuario);
		Livro livro = b.getLivro(codigoLivro);
		
		if(usu.getNumReservas()<3)
		{
			boolean achouReserva = false;
			for(Reserva r : usu.reservas)
			{
				if(r.getCodigoLivro() == codigoLivro)
				{
					achouReserva = true;
					break;
				}
			}
			if(!achouReserva)
			{	
				Reserva r = new Reserva(livro.getTitulo(), codigoLivro, usu.getNome(), codigoUsuario);
				livro.adicionarReserva(r);
				usu.adicionarReserva(r);
				System.out.println("Reserva do livro " + livro.getTitulo() + " efetuada para o Usuario " + usu.getNome());
				return;
			}
			else
			{
				System.out.println("Reserva não pôde ser efetivada. Usuário já reservou um Exemplar deste Livro");
			}
		}
		else
			System.out.println("Reserva não pôde ser efetivada. Usuário já atingiu o limite de reservas");		
	}
	
	public static void sair() {
		
		System.out.println("Encerrando o Sistema de Biblioteca...");
		
		System.exit(0);
		
	}
}
