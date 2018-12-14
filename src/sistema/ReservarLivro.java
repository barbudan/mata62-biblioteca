package sistema;

import livro.Livro;
import livro.Reserva;
import usuario.Usuario;

public class ReservarLivro implements Comando {
	@Override
	public void executar(Parametros p) {
		ReservarLivro.reservar(p);
	}
	
	public static void reservar(Parametros p) {
		int codigoUsuario = p.getP1();
		int codigoLivro = p.getP2();
		
		Biblioteca b = Biblioteca.getInstancia();
		
		Usuario usu = b.getUsuario(codigoUsuario);
		Livro livro = b.getLivro(codigoLivro);
		
		if(usu.getNumReservas()<3)
		{
			boolean achouReserva = false;
			for(Reserva r : usu.reservas)
			{
				if(r.getCodigoLivro() == codigoLivro)
				{
					achouReserva = true;
					break;
				}
			}
			if(!achouReserva)
			{	
				Reserva r = new Reserva(livro.getTitulo(), codigoLivro, usu.getNome(), codigoUsuario);
				livro.adicionarReserva(r);
				usu.adicionarReserva(r);
				System.out.println("Reserva do livro " + livro.getTitulo() + " efetuada para o Usuario " + usu.getNome());
				return;
			}
			else
			{
				System.out.println("Reserva não pôde ser efetivada. Usuário já reservou um Exemplar deste Livro");
			}
		}
		else
			System.out.println("Reserva não pôde ser efetivada. Usuário já atingiu o limite de reservas");		
	}
}
