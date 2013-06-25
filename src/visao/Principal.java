package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controle.Analisador;
import controle.Arquivo;
import controle.analisador.AnalysisError;
import controle.analisador.LexicalError;
import controle.analisador.SyntaticError;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class Principal extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private boolean documentoAlterado;
	private Arquivo arquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		arquivo = new Arquivo();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent ife) {
				sair();
			}
		});
		setBounds(100, 100, 450, 300);
		updateTitle();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		JMenuItem mntmNovo = new JMenuItem("Novo");
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		JSeparator sep1 = new JSeparator();
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		JMenuItem mntmSalvarComo = new JMenuItem("Salvar Como");
		JSeparator sep2 = new JSeparator();
		JMenuItem mntmSair = new JMenuItem("Sair");

		JMenu mnAnalise = new JMenu("Análise");
		JMenuItem mntmLexica = new JMenuItem("Léxica");
		JMenuItem mntmSintatica = new JMenuItem("Sintática");
		JMenuItem mntmSemantica = new JMenuItem("Semântica");

		mntmNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arquivo.resetCurrentFile();
				textArea.setText("");
				updateTitle();
			}
		});

		mntmAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (confirmarContinuarDocModificado("abrir outro documento")) {
					textArea.setText(arquivo.abrir());
					atualizarInfoArquivo();
				}
			}
		});

		mntmSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (arquivo.salvar(textArea.getText())) {
					atualizarInfoArquivo();
				}
			}
		});

		mntmSalvarComo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (arquivo.salvarComo(textArea.getText())) {
					atualizarInfoArquivo();
				}
			}
		});

		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});

		mntmLexica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Analisador.lexico(textArea.getText());
					OptionPane.messageInformation("Não há problemas léxicos no programa", "Sucesso");
				} catch (AnalysisError e1) {
					tratarExcecao(e1);
				}
			}
		});

		mntmSintatica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Analisador.sintatico(textArea.getText());
					OptionPane.messageInformation("Não há problemas léxicos ou sintáticos no programa", "Sucesso");
				} catch (AnalysisError e1) {
					tratarExcecao(e1);
				}
			}
		});

		mntmSemantica.setEnabled(false); // TODO Remover após implementação da análise sintática
		mntmSemantica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Analisador.semantico(textArea.getText());
					OptionPane.messageInformation("Não há problemas léxicos ou sintáticos no programa", "Sucesso");
				} catch (AnalysisError e1) {
					tratarExcecao(e1);
				}
			}
		});

		menuBar.add(mnArquivo);
		mnArquivo.add(mntmNovo);
		mnArquivo.add(mntmAbrir);
		mnArquivo.add(sep1);
		mnArquivo.add(mntmSalvar);
		mnArquivo.add(mntmSalvarComo);
		mnArquivo.add(sep2);
		mnArquivo.add(mntmSair);

		menuBar.add(mnAnalise);
		mnAnalise.add(mntmLexica);
		mnAnalise.add(mntmSintatica);
		mnAnalise.add(mntmSemantica);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		// Monitora mudanças no documento
		documentoAlterado = false;
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				documentoAlterado = true;
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				documentoAlterado = true;
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				documentoAlterado = true;
			}
		});
	}

	protected void atualizarInfoArquivo() {
		updateTitle();
		documentoAlterado = false;
	}

	protected void sair() {
		if (confirmarContinuarDocModificado("sair")) {
			System.exit(0);
		}
	}

	protected boolean confirmarContinuarDocModificado(String acaoFutura) {
		if (documentoAlterado) {
			int retorno = OptionPane.dialogConfirm("O arquivo foi modificado!\nDeseja salvar antes de " + acaoFutura + "?", "Confirmar saída", true);
			switch (retorno) {
			case OptionPane.YES_OPTION:
				return arquivo.salvar(textArea.getText());
			case OptionPane.NO_OPTION:
				return true;
			default:
				return false;
			}
		} else {
			return true;
		}
	}

	protected void updateTitle() {
		String localizacaoArquivo = arquivo.getCurrentFileLocation();
		String complemento = "";
		if (localizacaoArquivo != null && localizacaoArquivo.length() > 0) {
			complemento = " - " + localizacaoArquivo;
		}
		super.setTitle("Compilador LSI-131" + complemento);
	}

	protected void tratarExcecao(AnalysisError e) {
		String tipo;
		if (e instanceof LexicalError) {
			tipo = "léxico";
		} else if (e instanceof SyntaticError) {
			tipo = "sintático";
		} else {
			tipo = "semântico";
		}

		OptionPane.messageError("Há um erro " + tipo + " no programa: \n" + e.getMessage(), "Erro " + tipo);
		textArea.setCaretPosition(e.getPosition());
	}
}
