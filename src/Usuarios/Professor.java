package Usuarios;

import Emprestimo.EmprestimoProfessor;
import Livros.Livro;

public class Professor extends Usuario implements Observer {

	private int notificacoes = 0;

	public Professor(int codigo, String nome) {
		super(codigo, nome);
		emprestimoBehavior = new EmprestimoProfessor();
	}

	public int getNotificacoes() {
		return notificacoes;
	}

	@Override
	public void update(Livro livro) {
		notificacoes++;

	}
}
