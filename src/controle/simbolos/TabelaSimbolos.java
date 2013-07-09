package controle.simbolos;

import java.util.Vector;

import controle.analisador.SyntaticError;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class TabelaSimbolos {
	protected Vector<Simbolo> tabela;

	// TODO

	public TabelaSimbolos() {
		tabela = new Vector<Simbolo>();
	}

	public void inserir(String nome, String categoria, int nivel) throws SyntaticError {
		// TODO
		int nivelUltDeclaracao = getNivelSimbolo(nome);
		if (nivelUltDeclaracao == nivel) {
			throw new SyntaticError("Id " + nome + " ja declarado");
		}
		if (nivelUltDeclaracao == 0) {
			throw new SyntaticError("Id " + nome + "é usado como identificador do programa, e não pode ser usado em outros lugares");
		}

	}

	public void remover() throws SyntaticError {
		// TODO
	}

	public void consultar() throws SyntaticError {
		// TODO
	}

	public void atualizar() throws SyntaticError {
		// TODO
	}

	protected int getNivelSimbolo(String nome) {
		try {
			return getSimbolo(nome).getNivel();
		} catch (SyntaticError e) {
			return -1;
		}
	}

	public Simbolo getSimbolo(String nome) throws SyntaticError {
		for (int pos = tabela.size() - 1; pos >= 0; pos--) {
			if (tabela.get(pos).getNome().equals(nome)) {
				return tabela.get(pos);
			}
		}

		throw new SyntaticError("Id " + nome + " não declarado");

	}
}
