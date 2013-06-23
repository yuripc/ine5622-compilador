package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Arquivo {

	protected String currentFile = "";
	protected final JFileChooser fileChooser;
	protected final String extensao;


	public Arquivo() {
		currentFile = "";
		extensao = ".txt";
		fileChooser = new JFileChooser() {
			private static final long serialVersionUID = 1L;

			@Override
			public void approveSelection() {
				String selectedFile = getSelectedFile().getAbsolutePath();
				if (!selectedFile.toLowerCase().endsWith(extensao) && getDialogType() == SAVE_DIALOG) {
					selectedFile += extensao;
				}
				File f = new File(selectedFile);
				setSelectedFile(f);
				if (f.exists() && !selectedFile.equals(currentFile) && getDialogType() == SAVE_DIALOG) {
					int result = JOptionPane.showConfirmDialog(this, "O arquivo já existe, deseja substituir o arquivo existente?", "Arquivo já existente",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					switch (result) {
					case JOptionPane.YES_OPTION:
						super.approveSelection();
						return;
					case JOptionPane.NO_OPTION:
						return;
					case JOptionPane.CLOSED_OPTION:
						return;
					case JOptionPane.CANCEL_OPTION:
						cancelSelection();
						return;
					}
				}
				super.approveSelection();
			}
		};

		fileChooser.setFileFilter(new FileNameExtensionFilter("Linguagem SI", extensao.replace(".", "")));
		fileChooser.setDialogTitle("Selecione o arquivo");
	}

	public boolean salvar(String texto) {
		if (currentFile.equals("")) {
			return salvarComo(texto);
		} else {
			return gravar(texto, currentFile);
		}
	}

	public boolean salvarComo(String texto) {
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			currentFile = fileChooser.getSelectedFile().getAbsolutePath();
			return gravar(texto, currentFile);
		} else {
			return false;
		}

	}

	protected boolean gravar(String texto, String localizacao) {
		try {
			if (!localizacao.substring(localizacao.length() - extensao.length()).equals(extensao)) {
				localizacao += extensao;
			}

			BufferedWriter escritor = new BufferedWriter(new FileWriter(localizacao));

			escritor.write(texto);
			escritor.close();

			currentFile = localizacao;

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String abrir() {
		try {
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

				BufferedReader leitor;

				leitor = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));

				StringBuilder sb = new StringBuilder();
				String linha = leitor.readLine();

				String prefixo = "";
				while (linha != null) {
					sb.append(prefixo);
					sb.append(linha);
					prefixo = "\n";
					linha = leitor.readLine();
				}

				leitor.close();

				currentFile = fileChooser.getSelectedFile().getAbsolutePath();

				return sb.toString();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getCurrentFileLocation() {
		return currentFile;
	}

	public void resetCurrentFile() {
		currentFile = "";
	}

}