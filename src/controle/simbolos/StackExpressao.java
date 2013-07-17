package controle.simbolos;

import java.util.Stack;

import controle.analisador.SemanticError;
import controle.analisador.Token;

public class StackExpressao {

	protected final Stack<StackExpressaoItem> pilha;
	protected final TabelaSimbolos ts;


	protected boolean ultPopReferencia;

	public StackExpressao(TabelaSimbolos ts) {
		pilha = new Stack<StackExpressaoItem>();
		this.ts = ts;
	}

	public void adicionarNivel() throws SemanticError {
		pilha.add(new StackExpressaoItem());
	}

	public ETipo finalizarNivel() throws SemanticError {
		ultPopReferencia = pilha.peek().isReferecia();
		return pilha.pop().getTipo();
	}

	public void adicionar(EMpp mpp, ETipo tipo) throws SemanticError {
		pilha.peek().adicionar(mpp, tipo);
	}

	public void checarOperacao(Token token) throws Exception {
		pilha.peek().checarOperacao(token.getLexeme());
	}

	public ETipo getTipo(){
		return pilha.peek().getTipo();
	}

	public boolean isUltPopReferencia(){
		return ultPopReferencia;
	}
}
