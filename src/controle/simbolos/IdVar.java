package controle.simbolos;

public abstract class IdVar extends Id {
	// TODO
	protected int deslocamento;

	public IdVar(String nome, int nivel, int deslocamento, ETipo tipo) {
		// TODO
		super(nome, ECategoria.VARIAVEL, tipo, nivel);
		this.deslocamento = deslocamento;
	}
}
