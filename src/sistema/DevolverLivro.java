package sistema;

import exemplar.Exemplar;
import livro.Livro;
import usuario.Usuario;

public class DevolverLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		DevolverLivro.devolver(p);
	}

	public static void devolver(Parametros p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
	
		Biblioteca b = Biblioteca.getInstancia();
		
		Usuario usu = b.getUsuario(codigoUsuario);
		Livro livro = b.getLivro(codigoLivro);
		
		if(usu.livroEstaComUsuario(codigoLivro))
		{
			Exemplar e = usu.getExemplar(codigoLivro);
			System.out.println("Livro " + livro.getTitulo() + " devolvido pelo Usuario " + usu.getNome());
			System.out.println(livro.getNumReservas());
			System.out.println(livro.getNumExemplaresDisponiveis());
			e.disponibilizarExemplar();
			if(livro.getNumReservas()!=livro.getNumExemplaresReservados())
				e.reservarExemplar();
			
			livro.removerEmprestimo(livro.getEmprestimo(codigoLivro));
		}	
		else
			System.out.println("Devolução não concluida. Livro " + livro.getTitulo() + " não está em posse do Usuario " + usu.getNome());
	}
}
