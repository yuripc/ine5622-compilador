package controle.simbolos;

public abstract class IdVar extends Id {
	protected int deslocamento;

	public IdVar(String nome, int nivel, int deslocamento, ETipo tipo) {
		super(nome, ECategoria.VARIAVEL, tipo, nivel);
		this.deslocamento = deslocamento;
	}
}
