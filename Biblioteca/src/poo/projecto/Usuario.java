package poo.projecto;

import java.util.List;
import java.util.ArrayList;

public class Usuario implements ManterTipoDeObjeto {
	private String nome;
	private String cpf;
	private String senha;
	
	private List<Biblioteca> bibliotecas;

	public Usuario(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		bibliotecas = new ArrayList<Biblioteca>();
	}
	
	public List<Biblioteca> getBiblioteca() {
		return  bibliotecas;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrarBiblioteca(String nome, String id) {
		int indice = 0;
		bibliotecas.add(new Biblioteca(nome, id));
		indice = bibliotecas.size() - 1;
		Tela.exibirMsg("Biblioteca " + bibliotecas.get(indice).getNome() + " cadastrada com sucesso!");
	}

	public void buscarInformacaoDeUmaBiblioteca() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);

		Tela.exibirMsg("Bibliotecas cadastradas: " + bibliotecas.get(indice).getNome());
	}

	public void cadastrarPrateleiraNaBiblioteca() {

		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);

		if (indice >= 0) {

			bibliotecas.get(indice).cadastrarPrateleira();
		} else {
			Tela.exibirMsgErro("Erro na operação!\n");
		}

	}

	public void cadastrarDocumentoNaPrateleira() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);

		bibliotecas.get(indice).adicionarDocumentoNaPrateleiraDestaBiblioteca();
	}

	public void buscarDocumento() {

		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);
	}

	public void listarPrateleirasDeUmaBiblioteca() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);

		bibliotecas.get(indice).listarTodasPrateleirasDestaBiblioteca();
	}

	public boolean confirmarSenhaDoUsuario() {
		String senha = Tela.lerSenha();
		if (getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	public void chamarMetodoDeRemocaoDeUmaPrateleiraDeUmaBiblioteca() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();

		int indice = retornarIndiceDeUmObjeto(nome, id);

		if (indice >= 0 && bibliotecas.get(indice).removerUmObjetoDeUmaLista()) {
			Tela.exibirMsg("A prateleira foi removida com sucesso!");
		} else {
			Tela.exibirMsgErro("Erro na operação!");
		}

	}

	public void chamarMetodoParaListarDocumentosDeUmaPrateleira(String nome, String id) {
		int indice = retornarIndiceDeUmObjeto(nome, id);
		bibliotecas.get(indice).listarTodosDocumentosDeUmaPrateleira();
	}

	public void chamarMetodoDeRemocaoDeUmDocumentoDeUmaPrateleira(String nome, String id) {
		int indice = retornarIndiceDeUmObjeto(nome, id);
		bibliotecas.get(indice).removerDocumentoNaPrateleiraDestaBiblioteca();
	}

	public void chamarMetodoDeAtualizacaoDeUmaPrateleira() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);
		bibliotecas.get(indice).atualizarUmObjetoDeUmaLista();
	}

	public void chamarMetodoParaAtualizarUmDocumentoDaPrateleira() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);
		bibliotecas.get(indice).atuailizarDocumentoDeUmaPrateleira();
	}

	@Override
	public boolean retornarIndiceDeUmObjeto(String nome) {
		for (Biblioteca biblioteca : bibliotecas) {
			if (biblioteca.getNome().startsWith(nome))
				return true;
		}
		return false;
	}

	public int retornarIndiceDeUmObjeto(String nome, String id) {
		for (Biblioteca biblioteca : bibliotecas) {
			if (biblioteca.getNome().startsWith(nome) && biblioteca.getId().startsWith(id))
				return bibliotecas.size() - 1;
		}
		return -1;
	}

	public void listarObjetosDeUmaLista() {
		int condicao = -1;
		int indice = bibliotecas.size() - 1;
		while (indice > condicao) {
			condicao++;
			Tela.exibirMsg("Biblioteca cadastradas: " + bibliotecas.get(condicao).getNome());
		}
	}

	@Override
	public boolean removerUmObjetoDeUmaLista() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();

		int indice = retornarIndiceDeUmObjeto(nome, id);
		if (indice >= 0) {
			bibliotecas.remove(indice);
			return true;
		} else {
			return false;
		}

	}


	@Override
	public void atualizarUmObjetoDeUmaLista() {
		String nome = Tela.lerNomeDaBiblioteca();
		String id = Tela.lerIdDaBiblioteca();
		int indice = retornarIndiceDeUmObjeto(nome, id);
		if (indice >= 0) {
			Tela.exibirMsg("Informe qual será o novo nome da biblioteca" + bibliotecas.get(indice));
			nome = Tela.lerNomeDaBiblioteca();
			bibliotecas.get(indice).setNome(nome);
		}		
	}
	
	

	}