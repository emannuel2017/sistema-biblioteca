package poo.projecto;

import java.util.List;
import java.util.ArrayList;

public class Prateleira implements ManterTipoDeObjeto {
	private String categoria;
	private String id;
	private List<Documento> documentos;

	public Prateleira(String categoria, String id) {
		this.id = id;
		this.categoria = categoria;
		this.documentos = new ArrayList<Documento>();
	}
	
	public List<Documento> getDocumento(){
		return documentos;
	}

	public String getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void cadastrarDocumento() {

		String titulo = Tela.lerTituloDoDocumento();
		String autor = Tela.lerAutorDoDocumento();
		double paginas = Tela.lerQntDePaginasDoDocumento();
		String matricula = Tela.lerMatriculaDoDocumento();

		this.documentos.add(new Livro(titulo, autor, paginas, matricula));
		int indice = documentos.size() - 1;

		Tela.exibirMsg("Livro: " + documentos.get(indice).getTitulo());
	}

	@Override
	public boolean retornarIndiceDeUmObjeto(String titulo) {

		for (Documento documento : documentos) {
			if (documento.getTitulo().startsWith(titulo)) {
				return true;
			}
		}
		return false;
	}

	public int retornarIndiceDeUmObjeto(String titulo, String matricula) {

		for (Documento documento : documentos) {
			if (documento.getTitulo().startsWith(titulo) && documento.getMatricula().startsWith(matricula)) {
				return documentos.size() - 1;
			}
		}
		return -1;
	}

	@Override
	public void listarObjetosDeUmaLista() {
		int icrementa = -1;
		int quantidadeDeDocumentos = documentos.size() - 1;
		while (quantidadeDeDocumentos > icrementa) {
			icrementa++;
			Tela.exibirMsg("Documento: " + documentos.get(icrementa).getTitulo());
		}

	}

	@Override
	public boolean removerUmObjetoDeUmaLista() {
		String titulo = Tela.lerTituloDoDocumento();
		//exemplo de livro
		String id = Tela.lerIsbnDoLivro();
		int indice = retornarIndiceDeUmObjeto(titulo, id);

		if (indice >= 0) {
			documentos.remove(indice);
			return true;
		}
		return false;
	}

	@Override
	public void atualizarUmObjetoDeUmaLista() {
		String titulo = Tela.lerTituloDoDocumento();
		String id = Tela.lerIsbnDoLivro();
		int indice = retornarIndiceDeUmObjeto(titulo, id);
		if (indice >= 0) {
			Tela.exibirMsg("Informe qual é o novo titulo do documento:");
			titulo = Tela.lerTituloDoDocumento();
			documentos.get(indice).setTitulo(titulo);
			Tela.exibirMsg("Novo título: " + documentos.get(indice).getTitulo());
		}
	}
}