package controle;

import controle.analisador.SyntaticError;

public abstract class Simbolo {
	protected String nome;
	protected ECategoria categoria;
	protected ETipo tipo;
	protected int nivel;

	protected Simbolo(String nome, ECategoria categoria, int nivel) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public ETipo getTipo() {
		return tipo;
	}

	public void setTipo(ETipo tipo) throws SyntaticError {
		if (this.tipo == null) {
			this.tipo = tipo;
		} else {
			throw new SyntaticError("Tipo ja definido");
		}
	}

	public ECategoria getCategoria() {
		return categoria;
	}

	public int getNivel() {
		return nivel;
	}
}
