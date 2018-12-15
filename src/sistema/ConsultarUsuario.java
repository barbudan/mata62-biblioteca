package sistema;


public class ConsultarUsuario implements Comando {
	
	@Override
	public void executar(Parametro p) {
		int codigoUsuario = p.getP1();
		Biblioteca b = Biblioteca.getInstancia();
		b.consultarUsuario(codigoUsuario);
	}

}
