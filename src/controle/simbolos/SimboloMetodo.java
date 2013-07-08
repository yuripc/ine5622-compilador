package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class SimboloMetodo extends Simbolo {
	// TODO
	protected int endPriInstrucao;
	protected int numParametros;
	protected int pontListaParametros;
	protected ETipo tipoRetorno;

	public SimboloMetodo(String nome, int nivel) {
		// TODO
		super(nome, ECategoria.METODO, nivel);
	}
}
