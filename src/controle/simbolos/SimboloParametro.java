package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class SimboloParametro extends Simbolo {
	// TODO
	protected int deslocamento;
	protected boolean referencia;

	public SimboloParametro(String nome, int nivel) {
		// TODO
		super(nome, ECategoria.PARAMETRO, nivel);
	}
}
