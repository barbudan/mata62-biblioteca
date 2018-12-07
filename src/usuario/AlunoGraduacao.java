package usuario;

import emprestar.EmprestarGraduacao;

public class AlunoGraduacao extends Usuario {

	public AlunoGraduacao(int codigo, String nome) {
		super(codigo, nome);
		emprestimoBehavior = new EmprestarGraduacao();
	}
}
