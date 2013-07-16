package controle.simbolos;

import controle.analisador.SemanticError;

public class StackExpressaoItem {

	protected ETipo tipoOperandos;
	protected ETipo tipoExpressao;

	protected IdMetodo metodo;
	protected int npa;

	public StackExpressaoItem() {
	}

	public ETipo getTipo() {
		if (tipoExpressao != null) {
			return tipoExpressao;
		} else {
			return tipoExpressao;
		}
	}

	public void adicionar(ETipo tipoSimbolo) throws SemanticError {
		if (metodo == null) {
			if (tipoOperandos == null) {
				tipoOperandos = tipoSimbolo;
			} else if (tipoOperandos == tipoSimbolo) {
				return;
			} else if ((tipoSimbolo == ETipo.REAL || tipoSimbolo == ETipo.INTEIRO) && (tipoOperandos == ETipo.REAL || tipoOperandos == ETipo.INTEIRO)) {
				tipoOperandos = ETipo.REAL;
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
			if (tipoOperandos == ETipo.INTEIRO || tipoOperandos == ETipo.REAL) {
				return;
			}
		} else if (lexeme.equals("\\")) {
			if (tipoOperandos == ETipo.INTEIRO) {
				tipoOperandos = ETipo.REAL;
				return;
			} else if (tipoOperandos == ETipo.REAL) {
				return;
			}
		} else if (lexeme.equals("div")) {
			if (tipoOperandos == ETipo.INTEIRO) {
				return;
			}
		} else if (lexeme.equals("ou") || lexeme.equals("e")) {
			if (tipoOperandos == ETipo.BOOLEANO) {
				return;
			}
		} else if (lexeme.equals("=") || lexeme.equals("<") || lexeme.equals(">") || lexeme.equals(">=") || lexeme.equals("<=") || lexeme.equals("<>")) {
			tipoExpressao = ETipo.BOOLEANO;
		} else {
			throw new SemanticError("Erro ao identificar lexeme '" + lexeme + "'");
		}
		throw new SemanticError("Operador invalido para expressão");

	}

	public ETipo finalizar() throws SemanticError {
		if (metodo != null && npa != metodo.getNumParametros()) {
			throw new SemanticError("Número de parametros abaixo do esperado");
		}
		return getTipo();
	}

	public boolean isMetodo() {
		return metodo != null;
	}
}
