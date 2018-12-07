package emprestar;

import livro.Livro;
import usuario.Usuario;

public interface EmprestarBehavior {
	public void emprestar(Usuario usuario, Livro livro);
}
