package controle.analisador;

import controle.simbolos.ECategoria;
import controle.simbolos.EContextoEXP;
import controle.simbolos.EContextoLID;
import controle.simbolos.EMpp;
import controle.simbolos.ETipo;
import controle.simbolos.Id;
import controle.simbolos.IdMetodo;
import controle.simbolos.IdParametro;
import controle.simbolos.IdPrograma;
import controle.simbolos.IdVarCadeia;
import controle.simbolos.IdVarPredefinido;
import controle.simbolos.IdVarVetor;
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

	protected ETipo tipoAtual, tipoConst, tipoFator, tipoMetodo, tipoExpressao, tipoTermo, tipoVar, subCategoria;

	protected EMpp mpp;

	protected int priElemLista, ultElemLista, posid, deslocamento, npf;

	protected boolean opUnario, opNega, retornoDeclarado;

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
				case 101: {
					IdPrograma simbolo = new IdPrograma(token.getLexeme());
					ts.add(simbolo);
					na++;
					break;
				}
				case 102:
					contextoLID = EContextoLID.DECL;
					priElemLista = ts.size();
					break;
				case 103:
					ultElemLista = ts.size() - 1;
					break;
				case 104:
					if (categoriaAtual == ECategoria.CONSTANTE) {
						IdVarPredefinido simbolo;
						for (int i = priElemLista; i <= ultElemLista; i++) {
							simbolo = (IdVarPredefinido) ts.get(i);
							simbolo.toConstante(valConst);
						}
					}

					// Limpeza
					priElemLista = 0;
					ultElemLista = 0;
					categoriaAtual = null;
					tipoAtual = null;
					subCategoria = null;

					tipoConst = null;
					valConst = "";
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
					} else if (Integer.parseInt(valConst) <= 0) {
						throw new SemanticError("Tamanho da cadeia não pode ser menor ou igual a 0");
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
							IdVarCadeia simbolo = new IdVarCadeia(token.getLexeme(), na, deslocamento, Integer.parseInt(valConst));
							ts.add(simbolo);
							deslocamento++;
						} else if (subCategoria == ETipo.VETOR) {
							IdVarVetor simbolo = new IdVarVetor(token.getLexeme(), na, deslocamento, Integer.parseInt(valConst));
							ts.add(simbolo);
							deslocamento += Integer.parseInt(valConst);
						} else if (subCategoria.isPreDefinido()) {
							IdVarPredefinido simbolo = new IdVarPredefinido(token.getLexeme(), na, deslocamento, tipoAtual);
							ts.add(simbolo);
							deslocamento++;
						} else {
							throw new SemanticError("Erro ao identificar 'tipoAtual'");
						}
					} else if (contextoLID == EContextoLID.PARFORMAL) {
						IdParametro simbolo = new IdParametro(token.getLexeme(), na, mpp);
						ts.add(simbolo);
					} else if (contextoLID == EContextoLID.LEITURA) {
						if (!ts.getSimbolo(token.getLexeme()).getTipo().isLegivel()) {
							throw new SemanticError("Tipo inválido para leitura");
						}
					} else {
						throw new SemanticError("Erro ao identificar 'contextoLID'");
					}
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
				case 115: {
					contextoLID = EContextoLID.PARFORMAL;
					IdMetodo simbolo = new IdMetodo(token.getLexeme(), na);
					ts.add(simbolo);
					na++;
					break;
				}
				case 116:
					ts.getLastMetodo().setParametros(ts.getParametros());
					break;
				case 117: {
					IdMetodo simbolo = ts.getLastMetodo();
					simbolo.setTipoRetorno(tipoMetodo);
					break;
				}
				case 118:
					if ((ts.getLastMetodo().getTipoRetorno() != ETipo.NULO) != retornoDeclarado) {
						throw new SemanticError("Nenhum retorno declarado no método");
					}
					contextoLID = null;
					retornoDeclarado = false;
					priElemLista = 0;
					ultElemLista = 0;
					tipoMetodo = null;
					ts.removerNivel(na);
					na--;
					break;
				case 119:
					contextoLID = EContextoLID.PARFORMAL;
					if (priElemLista == 0) {
						priElemLista = ts.size();
					}
					break;
				case 120:
					ultElemLista = ts.size() - 1;
					break;
				case 121:
					if (tipoAtual.isPreDefinido()) {
						for (; ultElemLista >= priElemLista; ultElemLista--) {
							ts.get(ultElemLista).setTipo(tipoAtual);
						}
						priElemLista = ultElemLista = 0;
					} else {
						throw new SemanticError("Par deve ser do tipo pré-definido");
					}
					break;
				case 122:
					if (!tipoAtual.isPreDefinido()) {
						throw new SemanticError("Retorno dos métodos devem ser do tipo pré-definido");
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
				case 126:
					posid = ts.getNivelSimbolo(token.getLexeme());
					if (posid == -1) {
						throw new SemanticError("Id " + token.getLexeme() + " não declarado");
					}
					break;
				case 127:
					if (!ts.getSimbolo(token.getLexeme()).getTipo().isBooleano()) {
						throw new SemanticError("Tipo inválido da expressão");
					}
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

				case 130:
					if (contextoLID != EContextoLID.PARFORMAL) {
						throw new SemanticError("Retorne só pode ser usado em funções");
					} else if (ts.getLastMetodo().getTipoRetorno() == ETipo.NULO) {
						throw new SemanticError("Função atual não tem retorno definido");
					} else if (ts.getLastMetodo().getTipoRetorno() != tipoExpressao) {
						throw new SemanticError("Tipo da expressão inválido");
					} else {
						retornoDeclarado = true;
					}
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
				case 154:
					tipoTermo = tipoFator;
					tipoFator = null;
					break;
				case 155: //TODO Semantico 155
					break;
				case 156: //TODO Semantico 156
					break;
					// 157 a 160 não existem
				case 161:
					if (opNega) {
						throw new SemanticError("Não é permitido dois operadoes 'não' em sequencia");
					} else {
						opNega = true;
					}
					break;
				case 162:
					if (tipoFator != ETipo.BOOLEANO) {
						throw new SemanticError("Não exige operando booleano");
					}
					break;
				case 163:
					if (opUnario) {
						throw new SemanticError("Não é permitido dois operadoes unários em sequencia");
					} else {
						opUnario = true;
					}
					break;
				case 164:
					if (tipoFator != ETipo.INTEIRO || tipoFator != ETipo.REAL) {
						throw new SemanticError("Não exige operando numérico");
					}
					break;
				case 165:
					opNega = opUnario = false;
					break;
				case 166:
					tipoFator = tipoExpressao;
					tipoExpressao = null;
					opNega = opUnario = false;
					break;
				case 167:
					tipoFator = tipoVar;
					tipoVar = null;
					opNega = opUnario = false;
					break;
				case 168:
					tipoFator = tipoConst;
					tipoConst = null;
					opNega = opUnario = false;
					break;
				case 169: //TODO Semantico 169
					break;
				case 170: //TODO Semantico 170
					break;
				case 171: //TODO Semantico 171
					break;
				case 172: //TODO Semantico 172
					break;
				case 173:
					Id tempSimbolo;
					IdVarPredefinido simbolo;

					tempSimbolo = ts.getSimbolo(token.getLexeme());
					try {
						simbolo = (IdVarPredefinido) tempSimbolo;
						if (simbolo.getCategoria() == ECategoria.CONSTANTE) {
							tipoConst = simbolo.getTipo();
							valConst = simbolo.getValor();
						} else {
							throw new Exception("");
						}
					} catch (Exception e) {
						throw new SemanticError("Esperava-se Id de uma constante");
					}
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
					} else if (Integer.parseInt(valConst) <= 0) {
						throw new SemanticError("Tamanho da vetor não pode ser menor ou igual a 0");
					}
					break;
				case 180:
					if (tipoConst != tipoAtual) {
						throw new SemanticError("Tipo da constante incorreto");
					}
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SemanticError(e.getMessage(), token.getPosition());
			}
		}
	}
}
