package sistema;

public class Sair implements Comando {

	@Override
	public void executar(Parametros p) {
		Sair.finalizarPrograma();
	}
	
	public static void finalizarPrograma() {
		
		Biblioteca.sair();
		
	}

}
