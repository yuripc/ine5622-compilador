package controle.simbolos;

import java.util.Collections;
import java.util.Vector;

import controle.analisador.SemanticError;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class TabelaSimbolos {
	protected Vector<Id> tabela;

	public TabelaSimbolos() {
		tabela = new Vector<Id>();
	}

	public void add(Id simbolo) throws SemanticError {
		inserirTabela(simbolo);
	}

	public void removerNivel(int nivel) throws SemanticError {
		while (tabela.size() > 0 && tabela.get(tabela.size() - 1).getNivel() == nivel) {
			tabela.remove(tabela.size() - 1);
		}
	}

	public Id get(int index) throws SemanticError {
		return tabela.get(index);
	}

	public IdMetodo getLastMetodo() throws SemanticError {
		for (int i = tabela.size() - 1; i >= 0; i--) {
			if (tabela.get(i).getCategoria() == ECategoria.METODO) {
				return (IdMetodo) tabela.get(i);
			}
		}
		throw new SemanticError("Nenhum método localizado");
	}

	public Vector<IdParametro> getParametros() {
		Vector<IdParametro> parametros = new Vector<IdParametro>();

		boolean continuarLoop = true;

		for (int i = tabela.size() - 1; i >= 0 && continuarLoop; i--) {
			if (tabela.get(i).getCategoria() == ECategoria.PARAMETRO) {
				parametros.add((IdParametro) tabela.get(i));
			} else {
				continuarLoop = false;
			}
		}

		Collections.reverse(parametros);

		for (int i = 0; i < parametros.size(); i++) {
			parametros.get(0).setDeslocamento(i);
		}

		return parametros;
	}

	public int size() {
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
