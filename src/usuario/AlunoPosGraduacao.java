package usuario;

import emprestar.EmprestarAluno;

public class AlunoPosGraduacao extends Usuario {

	public AlunoPosGraduacao(int codigo, String nome) {
		super(codigo, nome);
		setMaximoDiasEmprestimo(4);
		emprestimoBehavior = new EmprestarAluno();
	}

}
