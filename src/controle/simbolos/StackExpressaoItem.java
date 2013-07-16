package controle.simbolos;

import controle.analisador.SemanticError;

public class StackExpressaoItem {

	protected ETipo tipoOperandos;
	protected ETipo tipoExpressao;

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
		if (tipoOperandos == null) {
			tipoOperandos = tipoSimbolo;
		} else if (tipoOperandos == tipoSimbolo) {
			return;
		} else if ((tipoSimbolo == ETipo.REAL || tipoSimbolo == ETipo.INTEIRO) && (tipoOperandos == ETipo.REAL || tipoOperandos == ETipo.INTEIRO)) {
			tipoOperandos = ETipo.REAL;
		} else {
			throw new SemanticError("Tipo do item diferente do da expressão");
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
			return;
		} else {
			throw new SemanticError("Erro ao identificar lexeme '" + lexeme + "'");
		}
		throw new SemanticError("Operador invalido para expressão");

	}
}
