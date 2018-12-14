package sistema;

import usuario.Usuario;
import usuario.Professor;

public class ConsultarNotificacoes implements Comando {
	@Override
	public void executar(Parametros p) {

		ConsultarNotificacoes.consultar(p);

	}

	public static void consultar(Parametros p) {

		int codigoUsuario = p.getP1();
		Biblioteca b = Biblioteca.getInstancia();
		b.consultarNotificacoes(codigoUsuario);

	}
}
