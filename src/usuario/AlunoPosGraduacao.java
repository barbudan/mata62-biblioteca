package usuario;

import emprestar.EmprestarPosGraduacao;

public class AlunoPosGraduacao extends Usuario {

	public AlunoPosGraduacao(int codigo, String nome) {
		super(codigo, nome);
		emprestimoBehavior = new EmprestarPosGraduacao();
	}

}
