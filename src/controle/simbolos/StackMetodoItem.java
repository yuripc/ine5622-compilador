package controle.simbolos;

import controle.analisador.SemanticError;

public class StackMetodoItem {
	protected IdMetodo metodo;
	protected int npa;

	public StackMetodoItem(IdMetodo metodo) {
		this.metodo = metodo;
	}

	public void adicionar(EMpp mppArgumento, ETipo tipoArgumento) throws SemanticError {
		IdParametro parametro = null;
		try {
			parametro = metodo.getParametro(npa);
		} catch (IndexOutOfBoundsException e) {
			throw new SemanticError("Número de parametros passados é maior que o declarado");
		}

		ETipo tipoParametro = parametro.getTipo();
		EMpp mppParametro = parametro.getMpp();

		if(mppParametro == EMpp.REFERENCIA && mppArgumento == EMpp.VALOR){
			throw new SemanticError("Tipo de argumento inválido");
		}

		if (tipoParametro == tipoArgumento || (tipoParametro == ETipo.REAL && tipoArgumento == ETipo.INTEIRO) || (tipoParametro == ETipo.CADEIA && tipoArgumento == ETipo.CARACTERE)) {
			npa++;
		} else {
			throw new SemanticError("Tipo incompatível com o parametro");
		}
	}

	public ETipo finalizar() throws SemanticError {
		if (npa < metodo.getNumParametros()) {
			throw new SemanticError("Número de parametros passados é menor que o declarado");
		}
		return metodo.getTipoRetorno();
	}
}
