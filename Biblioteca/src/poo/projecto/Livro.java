package poo.projecto;

public class Livro extends Documento {

	private String isbn;

	public Livro( String titulo, String autor, double paginas, String matricula) {
		super(titulo, autor, paginas, matricula);
	}

	public String getIsbn() {
		return isbn;
	}
}
