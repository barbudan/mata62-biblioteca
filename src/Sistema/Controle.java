package Sistema;

import java.util.HashMap;
import java.util.Map;

public class Controle {
	public static Map<String, Comando> mapaComandos = new HashMap<String, Comando>();

	static {
		mapaComandos.put("emp", new EmprestarLivro());
		mapaComandos.put("dev", new DevolverLivro());
		mapaComandos.put("res", new ReservarLivro());
		mapaComandos.put("obs", new AddObserver());
		mapaComandos.put("liv", new ConsultarLivro());
		mapaComandos.put("usu", new ConsultarUsuario());
		mapaComandos.put("ntf", new ConsultarNotificacoes());
		mapaComandos.put("sai", new Sair());
	}

	public static void lerEntrada(String entrada) {
		Parametros argumentos;
		String[] argumentosDivididos;

		argumentosDivididos = entrada.split(" ");
		String command = argumentosDivididos[0];
		// não tem nenhum parametro
		if (argumentosDivididos.length == 1) {
			argumentos = new Parametros();
		} else if (argumentosDivididos.length == 2) {
			// tem um parametro
			int arg1 = Integer.parseInt(argumentosDivididos[1]);
			argumentos = new Parametros(arg1);
		} else {
			// tem dois parametros
			int arg1 = Integer.parseInt(argumentosDivididos[1]);
			int arg2 = Integer.parseInt(argumentosDivididos[2]);
			argumentos = new Parametros(arg1, arg2);
		}
		mapaComandos.get(command).executar(argumentos);
	}

	public static void main(String[] args) {
		// preencher com os dados de teste
		// criar um loop
	}
}
