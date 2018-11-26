package Emprestimo;

import Livros.Livro;
import Usuarios.Usuario;

public interface EmprestimoBehavior {
	public void emprestar(Usuario usuario, Livro livro);
}
