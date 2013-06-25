package controle.analisador;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class LexicalError extends AnalysisError
{
	public LexicalError(String msg, int position)
	{
		super(msg, position);
	}

	public LexicalError(String msg)
	{
		super(msg);
	}
}
