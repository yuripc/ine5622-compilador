package controle;

import java.io.File;
import java.io.FilenameFilter;

import controle.analisador.SemanticError;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Teste {

	protected static final Arquivo arquivo = new Arquivo();

	public static String realizarTestes() {

		StringBuilder erros = new StringBuilder();
		File[] arquivos = listFiles();

		for (File arquivo : arquivos) {
			analisarArquivo(arquivo.getAbsolutePath(), erros);
		}
		/* TODO Criar testes
		 * 134
		 * 135
		 * 137
		 * 138
		 * 139
		 * 141
		 * 149
		 * 150
		 * 155
		 * 156
		 * 161
		 * 162
		 * 163
		 * 164
		 * 169
		 * 170
		 * 171
		 * 172
		 * 172
		 * 180
		 */

		return erros.toString();
	}

	protected static void analisarArquivo(String caminhoArquivo, StringBuilder erros) {
		String idChecagem;
		boolean erroEsperado;

		String nomeArquivo = caminhoArquivo.substring(caminhoArquivo.lastIndexOf("/")+1);

		if (Character.toUpperCase(nomeArquivo.charAt(0)) == 'E') {
			erroEsperado = true;
		} else {
			erroEsperado = false;
		}
		idChecagem = nomeArquivo.substring(0, nomeArquivo.lastIndexOf("."));

		try {

			Analisador.semantico(arquivo.abrir(caminhoArquivo));

			if (erroEsperado) {
				erros.append(idChecagem + " - Esperava-se erro \n");
			}
		} catch (SemanticError e) {
			if (!erroEsperado) {
				erros.append(idChecagem + " - Erro indesejado - " + e.getMessage() + "\n");
			}
		} catch (Exception e){
			erros.append(idChecagem + " - Tipo de erro inesperado - " + e.getMessage() + "\n");
		}
	}

	protected static File[] listFiles() {
		File dir = new File("testes/");

		return dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				return filename.endsWith(".txt") && !filename.startsWith("_");
			}
		});
	}

}
