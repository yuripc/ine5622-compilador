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
		pilha.add(new StackExpressaoItem());
	}

	public ETipo finalizarNivel() throws SemanticError {
		return pilha.pop().getTipo();
	}

	public ETipo adicionar(Token token) throws SemanticError {
		pilha.peek().adicionar(ts.get(token).getTipo());
		return pilha.peek().getTipo();
	}

	public ETipo adicionar(ETipo tipo) throws SemanticError {
		pilha.peek().adicionar(tipo);
		return tipo;
	}

	public void checarOperacao(Token token) throws Exception {
		pilha.peek().checarOperacao(token.getLexeme());
	}

	public ETipo getTipo(){
		return pilha.peek().getTipo();
	}
}
