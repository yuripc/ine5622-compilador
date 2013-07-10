package controle.simbolos;

public abstract class SimboloVar extends Simbolo {
	// TODO
	protected int deslocamento;

	public SimboloVar(String nome, int nivel, int deslocamento, ETipo tipo) {
		// TODO
		super(nome, ECategoria.VARIAVEL, tipo, nivel);
		this.deslocamento = deslocamento;
	}
}
