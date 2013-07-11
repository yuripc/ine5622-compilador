package controle.simbolos;


public abstract class Id {
	protected String nome;
	protected ECategoria categoria;
	protected ETipo tipo;
	protected int nivel;

	protected Id(String nome, ECategoria categoria, ETipo tipo, int nivel) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.tipo = tipo;
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public ETipo getTipo() {
		return tipo;
	}

	public void setTipo(ETipo tipo) {
		this.tipo = tipo;
	}

	public ECategoria getCategoria() {
		return categoria;
	}

	public int getNivel() {
		return nivel;
	}

	@Override
	public String toString(){
		return String.format("Nome: %s | Categoria: %s | Tipo: %s | Nivel: %s", nome, categoria, tipo, nivel);
	}
}
