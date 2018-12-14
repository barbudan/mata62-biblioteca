package sistema;

import sistema.Biblioteca;
import sistema.Parametros;
import usuario.Usuario;
//import sistema.realizarConsultaLivro;
import livro.Livro;

public class ConsultarLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		ConsultarLivro.consultar(p);

	}

	public static void consultar(Parametros parametros) {
		int codigoLivro = parametros.getP1();
		Biblioteca b = Biblioteca.getInstancia();
		b.consultarLivro(codigoLivro);
	}
}
