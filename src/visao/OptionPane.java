package visao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OptionPane extends JOptionPane {
	protected static final String[] messageDialogOptions = { "OK" };

	// Entrada
	public static String dialogInput(String mensagem) {
		return dialogInput(mensagem, "");
	}

	public static String dialogInput(String mensagem, String titulo) {
		return showInputDialog(null, mensagem, titulo).trim();
	}

	// Confirmação
	public static boolean dialogConfirm(String mensagem) {
		return dialogConfirm(mensagem, "");
	}

	public static boolean dialogConfirm(String mensagem, String titulo) {
		return dialogConfirm(mensagem, titulo, false) == YES_OPTION;
	}

	public static int dialogConfirm(String mensagem, boolean showCancel) {
		return dialogConfirm(mensagem, "", showCancel);
	}

	public static int dialogConfirm(String mensagem, String titulo, boolean showCancel) {
		int tipoMensagem = (showCancel) ? YES_NO_CANCEL_OPTION : YES_NO_OPTION;
		return showConfirmDialog(null, mensagem, titulo, tipoMensagem, WARNING_MESSAGE);
	}

	// Informação
	public static void messageInformation(String mensagem) {
		messageInformation(mensagem, "");
	}

	public static void messageInformation(String mensagem, String titulo) {
		messageDialog(mensagem, titulo, INFORMATION_MESSAGE);
	}

	// Erro
	public static void messageError(String mensagem) {
		messageError(mensagem, "");
	}

	public static void messageError(String mensagem, String titulo) {
		System.out.println(mensagem);
		messageDialog(mensagem, titulo, ERROR_MESSAGE);
	}

	// Metodos internos
	protected static void messageDialog(String mensagem, String titulo, int icone) {
		JPanel panel = new JPanel();
		// mensagem = "<html>"+mensagem.replace("\n", "<br>")+"</html>";
		JLabel lbl = new JLabel(mensagem);
		panel.add(lbl);
		showOptionDialog(null, panel, titulo, JOptionPane.NO_OPTION, icone, null, messageDialogOptions, messageDialogOptions[0]);

	}
}
