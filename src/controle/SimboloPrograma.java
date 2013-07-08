package controle;

import controle.analisador.SyntaticError;

public class SimboloPrograma extends Simbolo {

	public SimboloPrograma(String nome) {
		super(nome, ECategoria.PROGRAMA, 0);
	}

	@Override
	public void setTipo(ETipo tipo) throws SyntaticError {
		throw new SyntaticError("Não se pode definir tipo do identificador do programa");
	}
}
