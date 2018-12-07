package sistema;

import java.util.ArrayList;

import livro.Livro;
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
	public Livro getLivro(int codigo) {
		for (Livro l : listaDeLivros) {
			if (l.getCodigo() == codigo) {
				return l;
			}
		}
		return null;
	}

	// get usuario através do código
	public Usuario getUsuario(int codigo) {
		for (Usuario u : listaDeUsuarios) {
			if (u.getCodigo() == codigo) {
				return u;
			}
		}
		return null;
	}

}
