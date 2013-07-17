package controle.simbolos;

import java.util.Stack;

import controle.analisador.SemanticError;

public class StackMetodo {
	protected final Stack<StackMetodoItem> pilha;

	public StackMetodo() {
		pilha = new Stack<StackMetodoItem>();
	}

	public void adicionarFuncao(Id simbolo) throws SemanticError {
		try {
			IdMetodo metodo = (IdMetodo) simbolo;
			pilha.add(new StackMetodoItem(metodo));
		} catch (ClassCastException e) {
			throw new SemanticError("Esperava-se um método");
		}
	}

	public ETipo finalizarFuncao() throws SemanticError {
		return pilha.pop().finalizar();
	}

	public void adicionarParametro(ETipo tipo) throws SemanticError {
		pilha.peek().adicionar(tipo);
	}
}
