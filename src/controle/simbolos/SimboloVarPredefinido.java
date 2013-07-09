package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class SimboloVarPredefinido extends SimboloVar {
	// TODO
	protected String valor;

	public SimboloVarPredefinido(String nome, int nivel, int deslocamento) {
		// TODO
		super(nome, nivel, deslocamento);
	}

	public void toConstante(String valor){
		categoria = ECategoria.CONSTANTE;
		this.valor = valor;
	}
}
