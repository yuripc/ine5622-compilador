package controle.simbolos;

public class SimboloParametro extends Simbolo {
	// TODO
	protected int deslocamento;
	protected boolean referencia;

	public SimboloParametro(String nome, int nivel) {
		// TODO
		super(nome, ECategoria.PARAMETRO, nivel);
	}
}
