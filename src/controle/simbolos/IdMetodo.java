package controle.simbolos;

import java.util.Vector;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class IdMetodo extends Id {
	protected Vector<IdParametro> parametros;
	protected ETipo tipoRetorno;

	public IdMetodo(String nome, int nivel) {
		super(nome, ECategoria.METODO, null, nivel);
	}

	public int getNumParametros() {
		return parametros.size();
	}

	public void setParametros(Vector<IdParametro> parametros){
		this.parametros = parametros;
	}

	public ETipo getTipoParametro(int index) {
		return parametros.get(index).getTipo();
	}

	public ETipo getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(ETipo tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

}
