package usuario;

import java.time.LocalDate;
import java.util.ArrayList;

import emprestar.EmprestarBehavior;
import emprestar.EmprestarProfessor;
import livro.Emprestimo;
import livro.Livro;
import livro.Reserva;
import exemplar.Exemplar;

public abstract class Usuario implements Observer{

	private String nomeUsuario;
	private int codigoUsuario;
	private int numReservas = 0;
	private int numEmprestimos = 0;
	EmprestarBehavior emprestimoBehavior;

	public ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	public Usuario(int codigo, String nome) {
		this.codigoUsuario = codigo;
		this.nomeUsuario = nome;
	}

	// GETTERS //
	public int getCodigo() {
		return codigoUsuario;
	}

	public String getNome() {
		return this.nomeUsuario;
	}

	public int getNumEmprestimos() {
		return numEmprestimos;
	}

	public int getNumReservas() {
		return numReservas;
	}
	
	public Exemplar getExemplar(int codigoLivro) {
		for(Emprestimo e : emprestimos)
			if(e.getCodigoLivro() == codigoLivro)
				return e.getExemplar();
		return null;
	}
	
	public Emprestimo getEmprestimo(int codigo) {
		for (Emprestimo e : emprestimos) {
			if (e.getCodigoLivro() == codigo) {
				return e;
			}
		}
		return null;
	}

	public Reserva getReserva(int codigoLivro) {
		for (Reserva r : reservas) {
			if (r.getCodigoLivro() == codigoLivro) {
				return r;
			}
		}
		return null;
	}

	// MÉTODOS AUXILIARES //
	public void addNumReservas() {
		this.numReservas++;
	}

	public void addNumEmprestimos() {
		this.numEmprestimos++;
	}

	public void subNumEmprestimos() {
		this.numEmprestimos--;
	}

	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
	}

	public void removerEmprestimo(Emprestimo e) {
		int index = emprestimos.indexOf(e);
		if (index >= 0) {
			emprestimos.remove(index);
		}
	}

	public boolean livroEstaComUsuario(int codigo) {
		for (Emprestimo e : emprestimos) {
			if (e.getCodigoLivro() == codigo) {
				return true;
			}
		}
		return false;
	}

	public boolean adicionarReserva(Reserva r) {
		if(numReservas<3)
		{
			reservas.add(r);
			return true;
		}
		return false;	
	}
	// verifica, através do código do livro, se o usuário já tem reserva do livro
	public boolean verificarReserva(int codigo) {
		for (Reserva r : reservas) {
			if (r.getCodigoLivro() == codigo) {
				return true;
			}
		}
		return false;
	}

	public void removerReserva(Reserva r) {
		int index = reservas.indexOf(r);
		if (index >= 0) {
			reservas.remove(index);
		}
	}

	public void fazerEmprestimo(Usuario usuario, Livro livro) {
		emprestimoBehavior.emprestar(usuario, livro);
	}

	public boolean verificarDebito() {
		LocalDate dataAtual = LocalDate.now();
		for (Emprestimo e : emprestimos) {
			LocalDate dataPrevista = e.getDataPrevistaDevolucao();
			if (dataAtual.isAfter(dataPrevista)) {
				return true;
			}
		}
		return false;

	}

	// falta testar o nome do usuário
	public void listarEmprestimos() {

		System.out.println("Empréstimos em Curso");
		for(Emprestimo e : emprestimos)
		{
			if(e.getDataDevolucao()==null)
			{
				System.out.println("Titulo: " + e.getLivro().getTitulo());
				System.out.println("Data de inicio do emprestimo: " + e.getDataEmprestimo());
				System.out.println("Data de devolução prevista: " + e.getDataPrevistaDevolucao());
			}
		}
		
		System.out.println("Empréstimos Finalizados");
		for(Emprestimo e : emprestimos)
		{
			if(e.getDataDevolucao()!=null)
			{
				System.out.println("Titulo: " + e.getLivro().getTitulo());
				System.out.println("Data de inicio do emprestimo: " + e.getDataEmprestimo());
				System.out.println("Data de finalizacao do emprestimo: " + e.getDataDevolucao());			
			}
		}
		
	}

	public void listarReservas() {
		for (Reserva r : reservas) {
			System.out.println("Titulo: " + r.getTitulo());
			System.out.println("Data da reserva: " + r.getDataReserva());
		}
	}
	

	public void devolveReservaExemplar(int codigoLivro) {
		for (Emprestimo e : emprestimos)
		{
			if(e.getCodigoLivro() == codigoLivro)
			{
				if(e.getDataDevolucao()==null)
				{
					e.setDataDevolucao(LocalDate.now());
					e.getExemplar().reservarExemplar();			
				}
			}	
		}
	}
	
	public void devolveDisponibilizaExemplar(int codigoLivro) {
		for (Emprestimo e : emprestimos)
		{
			if(e.getCodigoLivro() == codigoLivro)
			{
				if(e.getDataDevolucao()==null)
				{
					e.setDataDevolucao(LocalDate.now());
					e.getExemplar().disponibilizarExemplar();			
				}
			}	
		}
	}
	
	public void update(Livro livro) {}
	
	public boolean temReserva() {
		if(reservas.size()>0)
			return true;
		else
			return false;
	}

}
