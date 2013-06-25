package controle.analisador;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Semantico implements Constants {
	protected boolean fazerAnalise;

	public Semantico(boolean fazerAnalise) {
		this.fazerAnalise = fazerAnalise;
	}

	public void executeAction(int action, Token token) throws SemanticError {
		if (fazerAnalise) {
			System.out.println("Ação #" + action + ", Token: " + token);

			switch (action) {

			case 999:
				// TODO

			}
		}
	}
}
