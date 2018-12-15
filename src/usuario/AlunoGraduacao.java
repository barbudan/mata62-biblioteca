package usuario;

import emprestar.EmprestarAluno;

public class AlunoGraduacao extends Usuario {

	public AlunoGraduacao(int codigo, String nome) {
		super(codigo, nome);
		setMaximoDiasEmprestimo(3);
		emprestimoBehavior = new EmprestarAluno();
	}
}
