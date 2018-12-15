package sistema;


public class ConsultarNotificacoes implements Comando {
	
	@Override
	public void executar(Parametro p) {
		int codigoUsuario = p.getP1();
		Biblioteca b = Biblioteca.getInstancia();
		b.consultarNotificacoes(codigoUsuario);
	}

}
