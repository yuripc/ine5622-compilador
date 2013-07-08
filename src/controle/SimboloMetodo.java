package controle;

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
