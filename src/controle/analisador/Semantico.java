package controle.analisador;

public class Semantico implements Constants {
	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);

		switch (action) {
		case 1: // TODO
		}
	}
}
