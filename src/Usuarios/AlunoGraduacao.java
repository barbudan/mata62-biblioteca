package Usuarios;

import Emprestimo.EmprestimoGraduacao;

public class AlunoGraduacao extends Usuario {

	public AlunoGraduacao(int codigo, String nome) {
		super(codigo, nome);
		emprestimoBehavior = new EmprestimoGraduacao();
	}
}
