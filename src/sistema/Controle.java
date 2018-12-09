package sistema;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import sistema.*;
import usuario.*;
import emprestar.*;
import exemplar.*;
import livro.*;

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
		Usuario user1 = new AlunoGraduacao(123, "Joao da Silva");
		Usuario user2 = new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues");
		Usuario user3 = new AlunoGraduacao(789, "Pedro Paulo");
		Usuario user4 = new Professor(100, "Carlos Lucena");
		
		Livro livro1 = new Livro("Engenharia de Software", 100, 2000, "6", "AddisonWesley", "Ian Sommervile");
		Livro livro2 = new Livro("UML - Guia do Usuario", 101, 2000, "7", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson");
		Livro livro3 = new Livro("Code Complete", 200, 2014, "2", "Microsoft Press", "Steve McConnell");
		Livro livro4 = new Livro("Agile Software Development, Principles, Patterns, and Practices", 201, 2002, "1", "Prentice Hall", "Robert Martin");
		Livro livro5 = new Livro("Refactoring: Improving the Design of Existing Code", 300, 1999, "1", "Addison-Wesley Professional", "Martin Fowler");
		Livro livro6 = new Livro("Software Metrics: A Rigorous and Practical Apporach", 301, 2014, "3", "CRC Press", "Norman Fenton, James Bieman");
		Livro livro7 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Sofware", 400, 1994, "1", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
		Livro livro8 = new Livro("UML Distilled: A Brief guide to the Standard Object Modeling Language", 401, 2003, "3", "Addison-Wesley Professional", "Martin Fowler");
		
		Exemplar exemplar1 = new Exemplar("01");
		Exemplar exemplar2 = new Exemplar("02");
		Exemplar exemplar3 = new Exemplar("03");
		Exemplar exemplar4 = new Exemplar("04");
		Exemplar exemplar5 = new Exemplar("05");
		Exemplar exemplar6 = new Exemplar("06");
		Exemplar exemplar7 = new Exemplar("07");
		Exemplar exemplar8 = new Exemplar("08");
		Exemplar exemplar9 = new Exemplar("09");
		
		livro1.adicionarExemplar(exemplar1);
		livro1.adicionarExemplar(exemplar2);
		livro2.adicionarExemplar(exemplar3);
		livro3.adicionarExemplar(exemplar4);
		livro4.adicionarExemplar(exemplar5);
		livro5.adicionarExemplar(exemplar6);
		livro5.adicionarExemplar(exemplar7);
		livro7.adicionarExemplar(exemplar8);
		livro7.adicionarExemplar(exemplar9);
		
		Biblioteca b = Biblioteca.getInstancia();
		
		b.addLivro(livro1);
		b.addLivro(livro2);
		b.addLivro(livro3);
		b.addLivro(livro4);
		b.addLivro(livro5);
		b.addLivro(livro6);
		b.addLivro(livro7);
		b.addLivro(livro8);
		
		b.addUsuario(user1);
		b.addUsuario(user2);
		b.addUsuario(user3);
		b.addUsuario(user4);
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Seja bem-vindo ao Sistema de Bibliotecas");
		while(true)
		{
			lerEntrada(input.nextLine());
		}
		
		
	}
}
