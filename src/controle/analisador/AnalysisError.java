package controle.analisador;

/**
 * @author Fernando Taranto, Yuri Pereira
 * @since 24/06/2013
 */

public class AnalysisError extends Exception
{
	private int position;

	public AnalysisError(String msg, int position)
	{
		super(msg);
		this.position = position;
	}

	public AnalysisError(String msg)
	{
		super(msg);
		this.position = -1;
	}

	public int getPosition()
	{
		return position;
	}

	@Override
	public String toString()
	{
		return super.toString() + ", @ "+position;
	}
}
