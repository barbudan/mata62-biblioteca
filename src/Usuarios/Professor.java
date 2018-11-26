package Usuarios;

public class Professor extends Usuario {

	private int notificacoes = 0;

	public Professor(int codigo, String nome) {
		super(codigo, nome);
	}

	public int getNotificacoes() {
		return notificacoes;
	}
}
