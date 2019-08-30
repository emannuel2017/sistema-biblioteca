package poo.projecto;

public class Documento {
	
	
	private String titulo;
	private String autor;
	private double paginas;
	private String matricula;

	public Documento(String titulo, String autor, double paginas, String matricula) {
		this.titulo = titulo;
		this.autor= autor;
		this.paginas = paginas;
		this.matricula = matricula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
	   this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public double getPaginas() {
		return paginas;
	}
	public String getMatricula() {
		return matricula;
	}
}
