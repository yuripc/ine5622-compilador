package controle.analisador;

import controle.simbolos.ECategoria;
import controle.simbolos.EContextoEXP;
import controle.simbolos.EContextoLID;
import controle.simbolos.EMpp;
import controle.simbolos.ETipo;
import controle.simbolos.SimboloPrograma;
import controle.simbolos.SimboloVarCadeia;
import controle.simbolos.SimboloVarPredefinido;
import controle.simbolos.SimboloVarVetor;
import controle.simbolos.TabelaSimbolos;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Semantico implements Constants {
	protected boolean fazerAnalise;

	protected int na;

	protected EContextoLID contextoLID;
	protected EContextoEXP contextoEXPR;

	protected ECategoria categoriaAtual;

	protected ETipo tipoAtual, tipoConst, tipoFator, tipoMetodo, tipoExpressao, subCategoria;

	protected EMpp mpp;

	protected int priElemLista, ultElemLista, deslocamento;

	protected boolean opUnario, opNega;

	protected String valConst;

	protected TabelaSimbolos ts;

	public Semantico(boolean fazerAnalise) {
		this.fazerAnalise = fazerAnalise;
		this.ts = new TabelaSimbolos();
	}

	public void executeAction(int action, Token token) throws SemanticError {
		if (fazerAnalise) {
			System.out.println("---- Ação #" + action + ", Token: " + token);
			try {
				switch (action) {
				case 101:
					SimboloPrograma simboloPrograma = new SimboloPrograma(token.getLexeme());
					ts.add(simboloPrograma);
					break;
				case 102:
					contextoLID = EContextoLID.DECL;
					priElemLista = ts.size();
					break;
				case 103:
					ultElemLista = ts.size() - 1;
					break;
				case 104:
					if (categoriaAtual == ECategoria.CONSTANTE) {
						for (int i = priElemLista; i <= ultElemLista; i++) {
							SimboloVarPredefinido simbolo = (SimboloVarPredefinido) ts.get(i);
							simbolo.toConstante(valConst);
						}
					}
					break;
				case 105:
					tipoAtual = ETipo.INTEIRO;
					break;
				case 106:
					tipoAtual = ETipo.REAL;
					break;
				case 107:
					tipoAtual = ETipo.BOOLEANO;
					break;
				case 108:
					tipoAtual = ETipo.CARACTERE;
					break;
				case 109:
					if (tipoConst != ETipo.INTEIRO) {
						throw new SemanticError("Esperava-se um número inteiro");
					} else if (Integer.parseInt(valConst) > 256) {
						throw new SemanticError("Tamanho máximo da cadeia é 256");
					} else {
						tipoAtual = ETipo.CADEIA;
					}
					break;
				case 110:
					if (tipoAtual == ETipo.CADEIA) {
						throw new SemanticError("Não é permitido vetor do tipo cadeia");
					} else {
						subCategoria = ETipo.VETOR;
					}
					break;
				case 111:
					subCategoria = tipoAtual;
					break;
				case 112:
					if (contextoLID == EContextoLID.DECL) {
						if (subCategoria == ETipo.CADEIA) {
							SimboloVarCadeia simboloVarCadeia = new SimboloVarCadeia(token.getLexeme(), na, deslocamento, Integer.parseInt(valConst));
							ts.add(simboloVarCadeia);
							deslocamento++;
						} else if (subCategoria == ETipo.VETOR) {
							SimboloVarVetor simboloVarVetor = new SimboloVarVetor(token.getLexeme(), na, deslocamento, Integer.parseInt(valConst));
							ts.add(simboloVarVetor);
							deslocamento += Integer.parseInt(valConst);
						} else if (subCategoria.isPreDefinido()) {
							SimboloVarPredefinido simboloVarPredefinido = new SimboloVarPredefinido(token.getLexeme(), na, deslocamento);
							ts.add(simboloVarPredefinido);
							deslocamento++;
						} else {
							throw new SemanticError("Erro ao identificar 'tipoAtual'");
						}
					}

					//TODO Semantico 112 par-formal e leitura
					break;
				case 113:
					if (subCategoria.isPreDefinido()) {
						categoriaAtual = ECategoria.CONSTANTE;
					} else {
						throw new SemanticError("Apenas id do tipo pré-definido pode ser declarados como constantes");
					}
					break;
				case 114:
					categoriaAtual = ECategoria.VARIAVEL;
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
				case 122:
					if (!tipoAtual.isPreDefinido()) {
						throw new SemanticError("Métodos devem ser do tipo pré-definido");
					} else {
						tipoMetodo = tipoAtual;
					}
					break;
				case 123:
					tipoMetodo = ETipo.NULO;
					break;
				case 124:
					mpp = EMpp.REFERENCIA;
					break;
				case 125:
					mpp = EMpp.VALOR;
					break;
				case 126: //TODO Semantico 126
					break;
				case 127: //TODO Semantico 127
					break;
				case 128:
					contextoLID = EContextoLID.LEITURA;
					break;
				case 129:
					contextoEXPR = EContextoEXP.IMPRESSAO;
					if (tipoExpressao == ETipo.BOOLEANO) {
						throw new SemanticError("Booleano não pode ser usado para impressão");
					}
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
					// 142 a 147 não existem
				case 148: //TODO Semantico 148
					break;
				case 149: //TODO Semantico 149
					break;
				case 150: //TODO Semantico 150
					break;
					// 141 a 153 não existem
				case 154: //TODO Semantico 154
					break;
				case 155: //TODO Semantico 155
					break;
				case 156: //TODO Semantico 156
					break;
					// 157 a 160 não existem
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
				case 168: //TODO Semantico 168 ERRATAS
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
				case 174:
					tipoConst = ETipo.INTEIRO;
					valConst = token.getLexeme();
					break;
				case 175:
					tipoConst = ETipo.REAL;
					valConst = token.getLexeme();
					break;
				case 176:
					tipoConst = ETipo.BOOLEANO;
					valConst = token.getLexeme();
					break;
				case 177:
					tipoConst = ETipo.BOOLEANO;
					valConst = token.getLexeme();
					break;
				case 178:
					tipoConst = ETipo.CARACTERE;
					valConst = token.getLexeme();
					break;
				case 179:
					if (tipoConst != ETipo.INTEIRO) {
						throw new SemanticError("Esperava-se um número inteiro");
					}
					break;
				case 180: //TODO Semantico 180 ERRATAS
					break;

				}
			} catch (Exception e) {
				throw new SemanticError(e.getMessage(), token.getPosition());
			}

			System.out.println(toString());
			System.out.println("|||||||||||||||||||||||||||");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Variaveis ---------------------");
		sb.append("contextoLID: " + contextoLID);
		sb.append("\n").append("contextoEXPR: " + contextoEXPR);
		sb.append("\n").append("categoriaAtual: " + categoriaAtual);
		sb.append("\n").append("subCategoria: " + subCategoria);
		sb.append("\n").append("tipoAtual: " + tipoAtual);
		sb.append("\n").append("tipoConst: " + tipoConst);
		sb.append("\n").append("tipoFator: " + tipoFator);
		sb.append("\n").append("tipoMetodo: " + tipoMetodo);
		sb.append("\n").append("tipoExpressao: " + tipoExpressao);
		sb.append("\n").append("valConst: " + valConst);
		if (opUnario) {
			sb.append("\n").append("opUnario: " + opUnario);
		}
		if (opNega) {
			sb.append("\n").append("opNega: " + opNega);
		}

		sb.append("\n").append("TS ---------------------");
		sb.append("\n").append(ts.toString());
		sb.append("FIM TS ---------------------");

		return sb.toString();
	}
}
