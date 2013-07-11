package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdParametro extends Id {
	// TODO
	protected int deslocamento;
	protected boolean referencia;

	public IdParametro(String nome, int nivel, ETipo tipo) {
		// TODO
		super(nome, ECategoria.PARAMETRO, tipo, nivel);
	}
}
