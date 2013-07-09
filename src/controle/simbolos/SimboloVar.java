package controle.simbolos;

public abstract class SimboloVar extends Simbolo {
	// TODO
	protected int deslocamento;

	public SimboloVar(String nome, int nivel, int deslocamento) {
		// TODO
		super(nome, ECategoria.VARIAVEL, nivel);
		this.deslocamento = deslocamento;
	}
}
