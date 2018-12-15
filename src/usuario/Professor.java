package usuario;

import emprestar.EmprestarProfessor;
import livro.Livro;

public class Professor extends Usuario implements Observer {

	private int notificacoes = 0;

	public Professor(int codigo, String nome) {
		super(codigo, nome);
		setMaximoDiasEmprestimo(7);
		emprestimoBehavior = new EmprestarProfessor(); // PADRAO STRATEGY
	}

	// GETTERS && SETTERS //
	
	public int getNotificacoes() {
		return notificacoes;
	}

	// METODOS PADRAO OBSERVER //
	
	@Override
	public void update(Livro livro) {
		notificacoes++;
	}
}
