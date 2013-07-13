package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdParametro extends Id {
	protected int deslocamento;
	protected EMpp mpp;

	public IdParametro(String nome, int nivel, EMpp mpp) {
		super(nome, ECategoria.PARAMETRO, ETipo.NULO, nivel);
		this.mpp = mpp;
	}

	public int getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}

	public EMpp getMpp() {
		return mpp;
	}
}
