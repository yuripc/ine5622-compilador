package controle.analisador;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class SyntaticError extends AnalysisError
{
	public SyntaticError(String msg, int position)
	{
		super(msg, position);
	}

	public SyntaticError(String msg)
	{
		super(msg);
	}
}
