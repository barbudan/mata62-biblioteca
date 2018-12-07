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
	private boolean flagReserva = false; // Flag que detecta a necessidade de notificar Observadores

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
	private ArrayList<Observer> observadores = new ArrayList<Observer>();

	// GETTERS //
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
	
	
	// MÉTODOS AUXILIARES //
	
	public boolean estaDisponivel() {
		for (Exemplar e : exemplares) {
			if (e.getNomeEstadoExemplar() == "Disponivel") {
				return true;
			}
		}
		return false;
	}
	
	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
		if (emprestimos.size() >= 2) {
			notificarObservadores();
		}
	}

	public void adicionarReserva(Reserva r) {
		reservas.add(r);
		if (reservas.size() > 2 && flagReserva==false) {
			flagReserva=true;
			notificarObservadores();
		}
	}
	
	public void removerReserva(Reserva r) {
		int n = reservas.indexOf(r);
		if (n >= 0) {
			reservas.remove(r);
			if(reservas.size()<=2)
				flagReserva=false;
		}
	}

	public void adicionarExemplar(Exemplar e) {
		exemplares.add(e);
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
	
	
	// PADRÃO OBSERVER //
	
	@Override
	// Registra Observador
	public void registraObservador(Observer o) {
		observadores.add(o);
	}

	@Override
	// Remove Observador
	public void removerObservador(Observer o) {
		int n = observadores.indexOf(o);
		if (n >= 0) {
			observadores.remove(n);
		}
	}

	@Override
	// Notifica Observador
	public void notificarObservadores() {
		for(int i=0;i<observadores.size();i++)
		{
			Observer o = observadores.get(i);
			o.update(this);
		}
	}

}
