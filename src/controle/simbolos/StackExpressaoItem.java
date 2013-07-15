package controle.simbolos;

import controle.analisador.SemanticError;

public class StackExpressaoItem {

	protected ETipo tipo;

	protected IdMetodo metodo;
	protected int npa;

	public StackExpressaoItem() {
	}

	public ETipo getTipo() {
		return tipo;
	}

	public void adicionar(ETipo tipoSimbolo) throws SemanticError {
		if (metodo == null) {
			if (tipo == null) {
				tipo = tipoSimbolo;
			} else if (tipo == tipoSimbolo) {
				return;
			} else if ((tipoSimbolo == ETipo.REAL || tipoSimbolo == ETipo.INTEIRO) && (tipo == ETipo.REAL || tipo == ETipo.INTEIRO)) {
				tipo = ETipo.REAL;
			} else {
				throw new SemanticError("Tipo do item diferente do da expressão");
			}
		} else {
			try {
				ETipo tipoMetodo = metodo.getTipoParametro(npa);
				if (tipoSimbolo == tipoMetodo || (tipoSimbolo == ETipo.REAL && tipoMetodo == ETipo.INTEIRO)
						|| (tipoSimbolo == ETipo.CADEIA && tipoMetodo == ETipo.CADEIA)) {
					npa++;
				} else {
					throw new SemanticError("Tipo da expressão diferente do esperado");
				}
			} catch (IndexOutOfBoundsException e) {
				throw new SemanticError("Número de parametros acima do esperado");
			}
		}
	}

	public void checarOperacao(String lexeme) throws Exception {
		if (lexeme.equals("+") || lexeme.equals("-") || lexeme.equals("*")) {
			if (tipo == ETipo.INTEIRO || tipo == ETipo.REAL) {
				return;
			}
		} else if (lexeme.equals("\\")) {
			if (tipo == ETipo.INTEIRO) {
				tipo = ETipo.REAL;
				return;
			} else if (tipo == ETipo.REAL) {
				return;
			}
		} else if (lexeme.equals("div")) {
			if (tipo == ETipo.INTEIRO) {
				return;
			}
		} else if (lexeme.equals("ou") || lexeme.equals("e")) {
			if (tipo == ETipo.BOOLEANO) {
				return;
			}
		} else if (lexeme.equals("=") || lexeme.equals("<") || lexeme.equals(">") || lexeme.equals(">=") || lexeme.equals("<=") || lexeme.equals("<>")) {
		} else {
			throw new SemanticError("Erro ao identificar lexeme '" + lexeme + "'");
		}
		throw new SemanticError("Operador invalido para expressão");

	}

	public ETipo finalizar() throws SemanticError {
		if (metodo != null && npa != metodo.getNumParametros()) {
			throw new SemanticError("Número de parametros abaixo do esperado");
		}
		return tipo;
	}

	public boolean isMetodo() {
		return metodo != null;
	}
}
