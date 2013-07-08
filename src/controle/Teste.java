package controle;

import java.io.File;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Teste {

	protected Arquivo arquivo;
	protected String separador;

	public Teste() {
		arquivo = new Arquivo();
		separador = File.separator;
	}

	public String testes() {
		StringBuilder erros = new StringBuilder();
		// TODO Sintatico 109

		// TODO Sintatico 110

		// TODO Sintatico 112

		// TODO Sintatico 113

		// TODO Sintatico 115

		// TODO Sintatico 121

		// TODO Sintatico 122

		// TODO Sintatico 126

		// TODO Sintatico 127

		// TODO Sintatico 129

		// TODO Sintatico 130

		// TODO Sintatico 131

		// TODO Sintatico 132

		// TODO Sintatico 133

		// TODO Sintatico 134

		// TODO Sintatico 135

		// TODO Sintatico 137

		// TODO Sintatico 138

		// TODO Sintatico 139

		// TODO Sintatico 141

		// TODO Sintatico 149

		// TODO Sintatico 150

		// TODO Sintatico 155

		// TODO Sintatico 156

		// TODO Sintatico 161

		// TODO Sintatico 162

		// TODO Sintatico 163

		// TODO Sintatico 164

		// TODO Sintatico 169

		// TODO Sintatico 170

		// TODO Sintatico 171

		// TODO Sintatico 172

		// TODO Sintatico 172

		// TODO Sintatico 178

		// TODO Sintatico 179

		return erros.toString();
	}

	protected void analisar(String idChecagem, String caminhoArquivo, StringBuilder erros) {
		boolean erroEsperado;

		if (Character.toUpperCase(caminhoArquivo.charAt(0)) == 'E') {
			erroEsperado = true;
		} else {
			erroEsperado = false;
		}

		try {
			Analisador.semantico(abrir(caminhoArquivo));

			if (erroEsperado) {
				erros.append(idChecagem + " - Esperava-se erro \n");
			}
		} catch (Exception e) {
			if (!erroEsperado) {
				erros.append(idChecagem + " - Erro não esperado - " + e.getMessage() + "\n");
			}
		}
	}

	protected String abrir(String nomeArquivo) {
		return arquivo.abrir("testes" + separador + nomeArquivo + ".txt");
	}

}
