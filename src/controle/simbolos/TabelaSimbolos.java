package controle.simbolos;

import java.util.Vector;

import controle.analisador.SyntaticError;

public class TabelaSimbolos {
	protected Vector<Simbolo> tabela;

	// TODO

	public TabelaSimbolos() {
		tabela = new Vector<Simbolo>();
	}

	public void inserir() throws SyntaticError{
		// TODO
	}

	public void remover() throws SyntaticError{
		// TODO
	}

	public void consultar() throws SyntaticError{
		// TODO
	}

	public void atualizar() throws SyntaticError{
		// TODO
	}

	protected int getNivelSimbolo(String nome){
		for(int pos = tabela.size()-1 ; pos>=0 ; pos--){
			if(tabela.get(pos).getNome().equals(nome)) {
				return tabela.get(pos).getNivel();
			}
		}

		return -1;
	}
}
