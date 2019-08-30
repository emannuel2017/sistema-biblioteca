package poo.projecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca implements ManterTipoDeObjeto {
	private String nome;
	private String id;
	private List<Prateleira> prateleiras;

	public Biblioteca(String nome, String id) {
		this.nome = nome;
		this.id = id;
		this.prateleiras = new ArrayList<Prateleira>();
	}

	public List<Prateleira> getPrateleira(){
		return prateleiras;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void cadastrarPrateleira() {

		String categoria = Tela.lerCategoriaDaPrateleira();
		String id = Tela.lerIdDaPrateleira();

		this.prateleiras.add(new Prateleira(categoria, id));
		int indice = prateleiras.size() - 1;
		Tela.exibirMsg("Categoria 'prateleira " + prateleiras.get(indice).getCategoria() + " e Id "
				+ prateleiras.get(indice).getId()+"' foram cadastrados com sucesso!");
	}

	public void listarTodasPrateleirasDestaBiblioteca() {
		int indice = 0;
		for (Prateleira pr : prateleiras) {
			Tela.exibirMsg(pr.getId() + " Categoria " + pr.getCategoria());
		}

	}

	public void listarTodosDocumentosDeUmaPrateleira() {
		String categoria = Tela.lerCategoriaDaPrateleira();

		String id = Tela.lerIdDaPrateleira();
		int indice = retornarIndiceDeUmObjeto(categoria, id);

		prateleiras.get(indice).listarObjetosDeUmaLista();

	}

	public void adicionarDocumentoNaPrateleiraDestaBiblioteca() {
		String categoria = Tela.lerCategoriaDaPrateleira();
		String id = Tela.lerIdDaPrateleira();
		int indice = retornarIndiceDeUmObjeto(categoria, id);

		prateleiras.get(indice).cadastrarDocumento();
	}

	public void removerDocumentoNaPrateleiraDestaBiblioteca() {
		String categoria = Tela.lerCategoriaDaPrateleira();
		String id = Tela.lerIdDaPrateleira();
		int indice = retornarIndiceDeUmObjeto(categoria, id);
		if (prateleiras.get(indice).removerUmObjetoDeUmaLista()) {
			Tela.exibirMsg("O documento foi removido com sucesso!");
		} else {
			Tela.exibirMsgErro("Erro na remoção!");
		}
	}

	public void atuailizarDocumentoDeUmaPrateleira() {
		String categoria = Tela.lerCategoriaDaPrateleira();
		String id = Tela.lerIdDaPrateleira();
		int indice = retornarIndiceDeUmObjeto(categoria, id);
		prateleiras.get(indice).atualizarUmObjetoDeUmaLista();
	}

	public int retornarIndiceDeUmObjeto(String categoria, String id) {

		for (Prateleira prateleira : prateleiras) {
			if (prateleira.getCategoria().startsWith(categoria) && prateleira.getId().startsWith(id)) {
				return prateleiras.size() - 1;
			}
		}
		return -1;
	}

	@Override
	public boolean retornarIndiceDeUmObjeto(String categoria) {
		int indice = 0;
		for (Prateleira prateleira : prateleiras) {
			if (prateleira.getCategoria().startsWith(categoria)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void listarObjetosDeUmaLista() {
		int icrementa = -1;
		int quantidadeDePrateleiras = prateleiras.size() - 1;
		while (quantidadeDePrateleiras > icrementa) {
			icrementa++;
			Tela.exibirMsg("Prateleira: " + prateleiras.get(icrementa).getCategoria());
		}
	}

	@Override
	public boolean removerUmObjetoDeUmaLista() {
		String categoria = Tela.lerCategoriaDaPrateleira();
		String id = Tela.lerIdDaPrateleira();
		int indice = retornarIndiceDeUmObjeto(categoria, id);

		if (indice >= 0) {
			prateleiras.remove(indice);
			return true;
		}
		return false;

	}

	@Override
	public void atualizarUmObjetoDeUmaLista() {
		String categoria = Tela.lerCategoriaDaPrateleira();
		String id = Tela.lerIdDaPrateleira();
		int indice = retornarIndiceDeUmObjeto(categoria, id);
		if (indice >= 0) {
			Tela.exibirMsg("Informe qual é a nova categoria da prateleira:");
			categoria = Tela.lerCategoriaDaPrateleira();
			prateleiras.get(indice).setCategoria(categoria);
			Tela.exibirMsg("Categoria foi atualizada para: " + prateleiras.get(indice).getCategoria());
		}

	}

}
