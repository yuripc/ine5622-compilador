package controle.analisador;

import controle.simbolos.TabelaSimbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Semantico implements Constants {
	protected boolean fazerAnalise;

	protected int na; // nivel atual

	// Possíveis variáveis
	protected String contextoLID;
	protected String ContextoEXPR;

	protected String tipoAtual;
	protected String tipoConst;
	protected int valConst;

	protected String tipoFator;
	protected boolean opUnario;
	protected boolean opNega;

	protected TabelaSimbolos ts;

	public Semantico(boolean fazerAnalise) {
		this.fazerAnalise = fazerAnalise;
		this.ts = new TabelaSimbolos();
	}

	public void executeAction(int action, Token token) throws SemanticError {
		if (fazerAnalise) {
			System.out.println("Ação #" + action + ", Token: " + token);

			switch (action) {
			case 101: //TODO Semantico 101
				break;
			case 102: //TODO Semantico 102
				break;
			case 103: //TODO Semantico 103
				break;
			case 104: //TODO Semantico 104
				break;
			case 105: //TODO Semantico 105
				break;
			case 106: //TODO Semantico 106
				break;
			case 107: //TODO Semantico 107
				break;
			case 108: //TODO Semantico 108
				break;
			case 109: //TODO Semantico 109
				break;
			case 110: //TODO Semantico 110
				break;
			case 111: //TODO Semantico 111
				break;
			case 112: //TODO Semantico 112
				break;
			case 113: //TODO Semantico 113
				break;
			case 114: //TODO Semantico 114
				break;
			case 115: //TODO Semantico 115
				break;
			case 116: //TODO Semantico 116
				break;
			case 117: //TODO Semantico 117
				break;
			case 118: //TODO Semantico 118
				break;
			case 119: //TODO Semantico 119
				break;
			case 120: //TODO Semantico 120
				break;
			case 121: //TODO Semantico 121
				break;
			case 122: //TODO Semantico 122
				break;
			case 123: //TODO Semantico 123
				break;
			case 124: //TODO Semantico 124
				break;
			case 125: //TODO Semantico 125
				break;
			case 126: //TODO Semantico 126
				break;
			case 127: //TODO Semantico 127
				break;
			case 128: //TODO Semantico 128
				break;
			case 129: //TODO Semantico 129
				break;
			case 130: //TODO Semantico 130
				break;
			case 131: //TODO Semantico 131
				break;
			case 132: //TODO Semantico 132
				break;
			case 133: //TODO Semantico 133
				break;
			case 134: //TODO Semantico 134
				break;
			case 135: //TODO Semantico 135
				break;
			case 136: //TODO Semantico 136
				break;
			case 137: //TODO Semantico 137
				break;
			case 138: //TODO Semantico 138
				break;
			case 139: //TODO Semantico 139
				break;
			case 140: //TODO Semantico 140
				break;
			case 141: //TODO Semantico 141
				break;
			case 142: //TODO Semantico 142
				break;
			case 143: //TODO Semantico 143
				break;
			case 144: //TODO Semantico 144
				break;
			case 145: //TODO Semantico 145
				break;
			case 146: //TODO Semantico 146
				break;
			case 147: //TODO Semantico 147
				break;
			case 148: //TODO Semantico 148
				break;
			case 149: //TODO Semantico 149
				break;
			case 150: //TODO Semantico 150
				break;
			case 151: //TODO Semantico 151
				break;
			case 152: //TODO Semantico 152
				break;
			case 153: //TODO Semantico 153
				break;
			case 154: //TODO Semantico 154
				break;
			case 155: //TODO Semantico 155
				break;
			case 156: //TODO Semantico 156
				break;
			case 157: //TODO Semantico 157
				break;
			case 158: //TODO Semantico 158
				break;
			case 159: //TODO Semantico 159
				break;
			case 160: //TODO Semantico 160
				break;
			case 161: //TODO Semantico 161
				break;
			case 162: //TODO Semantico 162
				break;
			case 163: //TODO Semantico 163
				break;
			case 164: //TODO Semantico 164
				break;
			case 165: //TODO Semantico 165
				break;
			case 166: //TODO Semantico 166
				break;
			case 167: //TODO Semantico 167
				break;
			case 168: //TODO Semantico 168
				break;
			case 169: //TODO Semantico 169
				break;
			case 170: //TODO Semantico 170
				break;
			case 171: //TODO Semantico 171
				break;
			case 172: //TODO Semantico 172
				break;
			case 173: //TODO Semantico 173
				break;
			case 174: //TODO Semantico 174
				break;
			case 175: //TODO Semantico 175
				break;
			case 176: //TODO Semantico 176
				break;
			case 177: //TODO Semantico 177
				break;
			case 178: //TODO Semantico 178
				break;
			}
		}
	}
}
