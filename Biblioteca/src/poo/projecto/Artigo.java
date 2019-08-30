package poo.projecto;

public class Artigo extends Documento{
	
	private String tema;
	
	public Artigo(String titulo, String autor, double paginas, String matricula, String tema) {
		super( titulo, autor, paginas, matricula);
		this.tema = tema;
	}
	
	public String getTema() {
		return tema;
	}
}
