package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdVarCadeia extends IdVar {
	protected int tamanho;

	public IdVarCadeia(String nome, int nivel, int deslocamento, int tamanho) {
		super(nome, nivel, deslocamento, ETipo.CADEIA);
		this.tamanho = tamanho;
	}
}
