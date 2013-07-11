package controle.simbolos;

import java.util.Vector;

import controle.analisador.SemanticError;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class TabelaSimbolos {
	protected Vector<Id> tabela;

	// TODO

	public TabelaSimbolos() {
		tabela = new Vector<Id>();
	}

	public void add(Id simbolo) throws SemanticError {
		inserirTabela(simbolo);
		// TODO
	}

	public void remover() throws SemanticError {
		// TODO
	}

	public Id get(int index) throws SemanticError {
		return tabela.get(index);
	}

	public void atualizar() throws SemanticError {
		// TODO
	}

	public int size(){
		return tabela.size();
	}

	public Id getSimbolo(String nome) throws SemanticError {
		for (int pos = tabela.size() - 1; pos >= 0; pos--) {
			if (tabela.get(pos).getNome().equals(nome)) {
				return tabela.get(pos);
			}
		}

		throw new SemanticError("Id " + nome + " não declarado");

	}

	public int getNivelSimbolo(String nome) {
		try {
			return getSimbolo(nome).getNivel();
		} catch (SemanticError e) {
			return -1;
		}
	}

	protected void inserirTabela(Id simbolo) throws SemanticError {
		int nivelUltDeclaracao = getNivelSimbolo(simbolo.getNome());
		if (nivelUltDeclaracao == simbolo.getNivel()) {
			throw new SemanticError("Id " + simbolo.getNome() + " ja declarado");
		}
		if (nivelUltDeclaracao == 0) {
			throw new SemanticError("Id " + simbolo.getNome() + "é usado como identificador do programa, e não pode ser usado em outros lugares");
		}

		tabela.add(simbolo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Id simbolo : tabela) {
			sb.append(simbolo).append("\n");
		}
		return sb.toString();
	}
}
