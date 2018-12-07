package livro;

import java.util.ArrayList;

import exemplar.Exemplar;
import usuario.Observer;
import usuario.Subject;

public class Livro implements Subject {
	private String titulo;
	private int codigo;
	private int ano;
	private String edicao;
	private String editora;
	private String autor;

	public Livro(String titulo, int codigo, int ano, String edicao, String editora, String autor) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.ano = ano;
		this.edicao = edicao;
		this.editora = editora;
		this.autor = autor;
	}

	private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();

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

	public String getAutor() {
		return autor;
	}
	public boolean verificarEstado() {
		for (Exemplar e : exemplares) {
			if (e.getEstado().toString() == "Disponivel") {
				return true;
			}
		}
		return false;
	}

	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
		if (emprestimos.size() >= 2) {
			notificarObservers();
		}
	}

	public void addReserva(Reserva r) {
		reservas.add(r);
		if (reservas.size() >= 2) {
			notificarObservers();
		}
	}

	public void addExemplar(Exemplar e) {
		exemplares.add(e);
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removerObserver(Observer o) {
		int n = observers.indexOf(o);
		if (n >= 0) {
			observers.remove(n);
		}

	}

	@Override
	public void notificarObservers() {
		// TODO Auto-generated method stub

	}

	public int getNumExemplaresDisponiveis() {
		int exemplaresDisponiveis = 0;
		for (Exemplar e : exemplares) {
			if (e.getEstado().toString() == "Disponivel") {
				exemplaresDisponiveis++;
			}
		}
		return exemplaresDisponiveis;
	}

	// Verifica se tem menos reservas que exemplares disponiveis
	// Se sim, retorna true
	public boolean maisExemplaresQueReservas() {
		if (this.getNumExemplaresDisponiveis() > reservas.size()) {
			return true;
		}
		return false;
	}

	public int getNumReservas() {
		int numReservas = reservas.size();
		return numReservas;
	}

}
