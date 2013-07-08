package controle.simbolos;

public abstract class SimboloVariavel extends Simbolo {
	// TODO
	protected int deslocamento;

	public SimboloVariavel(String nome, int nivel, int deslocamento) {
		// TODO
		super(nome, ECategoria.VARIAVEL, nivel);
		this.deslocamento = deslocamento;
	}
}
