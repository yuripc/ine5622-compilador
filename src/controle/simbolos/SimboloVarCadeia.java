package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class SimboloVarCadeia extends SimboloVar {
	// TODO
	protected int tamanho;

	public SimboloVarCadeia(String nome, int nivel, int deslocamento, int tamanho) {
		// TODO
		super(nome, nivel, deslocamento);
		this.tamanho = tamanho;
	}
}
