package controle.simbolos;

import controle.analisador.SemanticError;

public class StackMetodoItem {
	protected IdMetodo metodo;
	protected int npa;

	public StackMetodoItem(IdMetodo metodo) {
		this.metodo = metodo;
	}

	public void adicionar(ETipo tipo) throws SemanticError {
		ETipo tipoParametro = null;
		try {
			tipoParametro = metodo.getTipoParametro(npa);
		} catch (IndexOutOfBoundsException e) {
			throw new SemanticError("Número de parametros passados é maior que o declarado");
		}
		if (tipoParametro == tipo || (tipoParametro == ETipo.REAL && tipo == ETipo.INTEIRO) || (tipoParametro == ETipo.CADEIA && tipo == ETipo.CARACTERE)) {
			npa++;
		} else {
			throw new SemanticError("Tipo incompatível com o parametro");
		}
	}

	public void finalizar() throws SemanticError {
		if (npa < metodo.getNumParametros()) {
			throw new SemanticError("Número de parametros passados é menor que o declarado");
		}
	}
}
