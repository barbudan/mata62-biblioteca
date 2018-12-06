package Usuarios;

import Emprestimo.EmprestimoPosGraduacao;

public class AlunoPosGraduacao extends Usuario {

	public AlunoPosGraduacao(int codigo, String nome) {
		super(codigo, nome);
		emprestimoBehavior = new EmprestimoPosGraduacao();
	}

}
