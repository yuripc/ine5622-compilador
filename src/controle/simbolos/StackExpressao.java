package controle.simbolos;

import java.util.Stack;

import controle.analisador.SemanticError;
import controle.analisador.Token;

public class StackExpressao {

	protected final Stack<StackExpressaoItem> pilha;
	protected final TabelaSimbolos ts;

	public StackExpressao(TabelaSimbolos ts) {
		pilha = new Stack<StackExpressaoItem>();
		this.ts = ts;
	}

	public void adicionarNivel() throws SemanticError {
		StackExpressaoItem item = new StackExpressaoItem();
		pilha.add(item);
	}

	public ETipo finalizarNivel() throws SemanticError {
		StackExpressaoItem item = pilha.pop();
		item.finalizar();
		if (pilha.size() > 0) {
			if (pilha.peek().isMetodo()) {
				pilha.peek().adicionar(item.getTipo());
				return null;
			}
		}
		return item.getTipo();
	}

	public void adicionarExpressao(Token token) throws SemanticError {
		pilha.peek().adicionar(ts.getSimbolo(token.getLexeme()).getTipo());
	}

	public void checarTipo(ETipo tipo) throws SemanticError {
		pilha.peek().adicionar(tipo);
	}

	public void checarOperacao(Token token) throws Exception {
		pilha.peek().checarOperacao(token.getLexeme());
	}

	public ETipo getTipo(){
		return pilha.peek().getTipo();
	}
}
