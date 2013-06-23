package controle;

import controle.analisador.LexicalError;
import controle.analisador.Lexico;
import controle.analisador.SemanticError;
import controle.analisador.Semantico;
import controle.analisador.Sintatico;
import controle.analisador.SyntaticError;
import controle.analisador.Token;

public class Analisador {
	public static void lexico(String input) throws LexicalError {
		Lexico lexico = new Lexico(input);

		Token token;
		do {
			token = lexico.nextToken();
			System.out.println(token);
		} while (token != null);
	}

	public static void sintatico(String input) throws LexicalError, SyntaticError, SemanticError {
		// TODO
		System.out.println("Não implementado");

		Lexico lexico = new Lexico(input);
		Sintatico sintatico = new Sintatico();
		Semantico semantico = new Semantico();

		sintatico.parse(lexico, semantico);
	}

	public static void semantico(String input) throws LexicalError, SyntaticError, SemanticError {
		// TODO
		System.out.println("Não implementado");
	}

}
