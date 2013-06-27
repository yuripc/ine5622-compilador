package controle.analisador;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Semantico implements Constants {
	protected boolean fazerAnalise;

	// Possíveis variáveis
	protected String contextoLID;
	protected String ContextoEXPR;

	protected String tipoAtual;
	protected String tipoConst;
	protected int valConst;

	protected String tipoFator;
	protected boolean opUnario;
	protected boolean opNega;

	public Semantico(boolean fazerAnalise) {
		this.fazerAnalise = fazerAnalise;
	}

	public void executeAction(int action, Token token) throws SemanticError {
		if (fazerAnalise) {
			System.out.println("Ação #" + action + ", Token: " + token);

			switch (action) {
			case 101: //TODO Semantico
				break;
			case 102: //TODO Semantico
				break;
			case 103: //TODO Semantico
				break;
			case 104: //TODO Semantico
				break;
			case 105: //TODO Semantico
				break;
			case 106: //TODO Semantico
				break;
			case 107: //TODO Semantico
				break;
			case 108: //TODO Semantico
				break;
			case 109: //TODO Semantico
				break;
			case 110: //TODO Semantico
				break;
			case 111: //TODO Semantico
				break;
			case 112: //TODO Semantico
				break;
			case 113: //TODO Semantico
				break;
			case 114: //TODO Semantico
				break;
			case 115: //TODO Semantico
				break;
			case 116: //TODO Semantico
				break;
			case 117: //TODO Semantico
				break;
			case 118: //TODO Semantico
				break;
			case 119: //TODO Semantico
				break;
			case 120: //TODO Semantico
				break;
			case 121: //TODO Semantico
				break;
			case 122: //TODO Semantico
				break;
			case 123: //TODO Semantico
				break;
			case 124: //TODO Semantico
				break;
			case 125: //TODO Semantico
				break;
			case 126: //TODO Semantico
				break;
			case 127: //TODO Semantico
				break;
			case 128: //TODO Semantico
				break;
			case 129: //TODO Semantico
				break;
			case 130: //TODO Semantico
				break;
			case 131: //TODO Semantico
				break;
			case 132: //TODO Semantico
				break;
			case 133: //TODO Semantico
				break;
			case 134: //TODO Semantico
				break;
			case 135: //TODO Semantico
				break;
			case 136: //TODO Semantico
				break;
			case 137: //TODO Semantico
				break;
			case 138: //TODO Semantico
				break;
			case 139: //TODO Semantico
				break;
			case 140: //TODO Semantico
				break;
			case 141: //TODO Semantico
				break;
			case 142: //TODO Semantico
				break;
			case 143: //TODO Semantico
				break;
			case 144: //TODO Semantico
				break;
			case 145: //TODO Semantico
				break;
			case 146: //TODO Semantico
				break;
			case 147: //TODO Semantico
				break;
			case 148: //TODO Semantico
				break;
			case 149: //TODO Semantico
				break;
			case 150: //TODO Semantico
				break;
			case 151: //TODO Semantico
				break;
			case 152: //TODO Semantico
				break;
			case 153: //TODO Semantico
				break;
			case 154: //TODO Semantico
				break;
			case 155: //TODO Semantico
				break;
			case 156: //TODO Semantico
				break;
			case 157: //TODO Semantico
				break;
			case 158: //TODO Semantico
				break;
			case 159: //TODO Semantico
				break;
			case 160: //TODO Semantico
				break;
			case 161: //TODO Semantico
				break;
			case 162: //TODO Semantico
				break;
			case 163: //TODO Semantico
				break;
			case 164: //TODO Semantico
				break;
			case 165: //TODO Semantico
				break;
			case 166: //TODO Semantico
				break;
			case 167: //TODO Semantico
				break;
			case 168: //TODO Semantico
				break;
			case 169: //TODO Semantico
				break;
			case 170: //TODO Semantico
				break;
			case 171: //TODO Semantico
				break;
			case 172: //TODO Semantico
				break;
			case 173: //TODO Semantico
				break;
			case 174: //TODO Semantico
				break;
			case 175: //TODO Semantico
				break;
			case 176: //TODO Semantico
				break;
			case 177: //TODO Semantico
				break;
			case 178: //TODO Semantico
				break;
			}
		}
	}
}
