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

	public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	public ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	public ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
	public ArrayList<Observer> observadores = new ArrayList<Observer>();

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
	
	
	// MÉTODOS EM RESERVA //
	
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

	public Reserva getReserva(int codigoLivro) {
		for(Reserva r : reservas) {
			if(r.getCodigoLivro() == codigoLivro) {
				return r;
			}
		}
		return null;
	}
	
	public int getNumReservas() {
		int numReservas = reservas.size();
		return numReservas;
	}
	
	// MÉTODOS EM EMPRESTIMO //
	
	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
		if (emprestimos.size() >= 2) {
			notificarObservadores();
		}
	}
	
	// MÉTODOS EM EXEMPLAR //
	
	public boolean estaDisponivel() {
		for (Exemplar e : exemplares) {
			if (e.getNomeEstadoExemplar() == "Disponivel") {
				return true;
			}
		}
		return false;
	}
	
	public boolean estaReservado() {
		for (Exemplar e : exemplares) {
			if (e.getNomeEstadoExemplar() == "Reservado") {
				return true;
			}
		}
		return false;
	}
	
	public void adicionarExemplar(Exemplar e) {
		exemplares.add(e);
	}
	
	public void removerExemplar(Exemplar e) {
		if(exemplares.size()>0)
		{
			int i = exemplares.indexOf(e);
			exemplares.remove(i);
		}
	}
	
	public boolean existeExemplar() {
		if(exemplares.size()>0)
			return true;
		return false;
	}

	public Exemplar getExemplarDisponivel() {
		for(Exemplar e : exemplares) {
			if(e.getNomeEstadoExemplar() == "Disponivel") {
				return e;
			}
		}
		return null;
	}
	
	public Exemplar getExemplarReservado() {
		for(Exemplar e : exemplares) {
			if(e.getNomeEstadoExemplar() == "Reservado") {
				return e;
			}
		}
		return null;
	}
	
	public int getNumExemplaresDisponiveis() {
		int exemplaresDisponiveis = 0;
		for (Exemplar e : exemplares) {
			if (e.getNomeEstadoExemplar() == "Disponivel") {
				exemplaresDisponiveis++;
			}
		}
		return exemplaresDisponiveis;
	}
	
	public int getNumExemplaresReservados() {
		int exemplaresReservados = 0;
		for (Exemplar e : exemplares) {
			if (e.getNomeEstadoExemplar() == "Reservado") {
				exemplaresReservados++;
			}
		}
		return exemplaresReservados;
	}

	// Verifica se tem menos reservas que exemplares disponiveis
	// Se sim, retorna true
	public boolean maisExemplaresDisponiveisQueReservados() {
		if (this.getNumExemplaresDisponiveis() > reservas.size()) {
			return true;
		}
		return false;
	}
	
	public void listarUsuariosComReservas() {
		// implementar
	}
	
	public void listarExemplares() {
		
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
