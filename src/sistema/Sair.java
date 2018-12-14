package sistema;

public class Sair implements Comando {

	@Override
	public void executar(Parametros p) {
		Sair.finalizarPrograma();
	}
	
	public static void finalizarPrograma() {
		
		System.out.println("Encerrando o Sistema de Biblioteca...");
		
		System.exit(0);
		
	}

}
