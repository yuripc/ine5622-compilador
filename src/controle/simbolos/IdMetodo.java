package controle.simbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdMetodo extends Id {
	// TODO
	protected int endPriInstrucao;
	protected int numParametros;
	protected int pontListaParametros;
	protected ETipo tipoRetorno;

	public IdMetodo(String nome, int nivel) {
		// TODO
		super(nome, ECategoria.METODO, null, nivel);
	}

	public int getEndPriInstrucao() {
		return endPriInstrucao;
	}

	public void setEndPriInstrucao(int endPriInstrucao) {
		this.endPriInstrucao = endPriInstrucao;
	}

	public int getNumParametros() {
		return numParametros;
	}

	public void setNumParametros(int numParametros) {
		this.numParametros = numParametros;
	}

	public int getPontListaParametros() {
		return pontListaParametros;
	}

	public void setPontListaParametros(int pontListaParametros) {
		this.pontListaParametros = pontListaParametros;
	}

	public ETipo getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(ETipo tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

}
