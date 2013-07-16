package controle.simbolos;

import java.util.Stack;

import controle.analisador.SemanticError;

public class StackFuncao {
	protected final Stack<StackFuncaoItem> pilha;

	public StackFuncao() {
		pilha = new Stack<StackFuncaoItem>();
	}

	public void adicionarFuncao(IdMetodo metodo) throws SemanticError {
		pilha.add(new StackFuncaoItem(metodo));
	}

	public void finalizarFuncao() throws SemanticError {
		pilha.pop().finalizar();
	}

	public void adicionarParametro(ETipo tipo) throws SemanticError{
		pilha.peek().adicionar(tipo);
	}
}
