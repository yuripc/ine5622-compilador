package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdVarVetor extends IdVar {
	// TODO
	protected int tamanho;
	protected ETipo subTipo;

	public IdVarVetor(String nome, int nivel, int deslocamento, int tamanho) {
		// TODO
		super(nome, nivel, deslocamento, ETipo.VETOR);
		this.tamanho = tamanho;
	}
}
