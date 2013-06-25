package controle.analisador;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class SemanticError extends AnalysisError
{
	public SemanticError(String msg, int position)
	{
		super(msg, position);
	}

	public SemanticError(String msg)
	{
		super(msg);
	}
}
