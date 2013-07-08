package controle;

public enum ETipo {
	CADEIA(false, false, true),
	VETOR(false, false, false),
	INTEIRO(true, true, true),
	REAL(true, false, true),
	CARACTERE(true, true, true),
	BOOLEANO(true, false, false);

	private final boolean preDefinido;
	private final boolean booleano;
	private final boolean legivel;

	private ETipo(boolean preDefinido, boolean booleano, boolean legivel) {
		this.preDefinido = preDefinido;
		this.booleano = booleano;
		this.legivel = legivel;
	}

	public boolean isPreDefinido() {
		return preDefinido;
	}

	public boolean isBooleano() {
		return booleano;
	}

	public boolean isLegivel() {
		return legivel;
	}
}
