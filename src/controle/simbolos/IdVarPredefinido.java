package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdVarPredefinido extends IdVar {
	// TODO
	protected String valor;

	public IdVarPredefinido(String nome, int nivel, int deslocamento, ETipo tipo) {
		// TODO
		super(nome, nivel, deslocamento, tipo);
	}

	public void toConstante(String valor) {
		categoria = ECategoria.CONSTANTE;
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
