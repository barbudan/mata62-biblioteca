package sistema;

import livro.Livro;
import livro.Reserva;
import usuario.Usuario;

public class ReservarLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		ReservarLivro.reservar(p);
	}

	public static void reservar(Parametros p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		Biblioteca b = Biblioteca.getInstancia();
		b.reservarLivro(codigoUsuario, codigoLivro);
	}
}
