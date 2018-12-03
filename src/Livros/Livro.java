package Livros;

public class Livro {
	private String titulo;
	private int codigo;
	private int ano;
	private String edicao;
	private String editora;

	public Livro(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAno() {
		return ano;
	}

	public String getEdicao() {
		return edicao;
	}

	public String getEditora() {
		return editora;
	}

}
