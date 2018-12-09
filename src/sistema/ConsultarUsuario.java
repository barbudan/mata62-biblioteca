package sistema;

import usuario.Usuario;

public class ConsultarUsuario implements Comando {
	@Override
	public void executar(Parametros p) {
		ConsultarUsuario.consultar(p);		
	}
	
	public static void consultar(Parametros p) {
		int codigoUsuario = p.getP1();
		
		Biblioteca b = Biblioteca.getInstancia();
		
		Usuario usuario = b.getUsuario(codigoUsuario);
		
		System.out.println("Usuario: " + usuario.getNome());
		usuario.listarEmprestimos();
		System.out.println("Reservas:");
		usuario.listarReservas();
		
		
	}

}
