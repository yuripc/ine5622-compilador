package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdVarVetor extends IdVar {
	protected final int tamanho;
	protected final ETipo subTipo;

	public IdVarVetor(String nome, int nivel, int deslocamento, int tamanho, ETipo subTipo) {
		super(nome, nivel, deslocamento, ETipo.VETOR);
		this.tamanho = tamanho;
		this.subTipo = subTipo;
	}

	public ETipo getSubTipo() {
		return subTipo;
	}

}
