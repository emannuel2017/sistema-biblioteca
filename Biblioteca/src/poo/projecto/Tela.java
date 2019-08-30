package poo.projecto;

import java.util.Scanner;


public class Tela {

	private static Scanner ler = new Scanner(System.in);
	private static Scanner lerOpcao = new Scanner(System.in);

	public static String lerNomeDoUsuario() {
		String nome = "";
		Tela.exibirMsg("Digite seu nome:");
		nome = ler.nextLine();
		return nome;
	}

	private static void limparScanner() {
		ler.next("");
		lerOpcao.next("");
	} 
	
	public static void exibirMsgErro(String msg) {
		System.err.println(msg);
	}

	public static String lerCpfDoUsuario() {
		String cpf = "";
		Tela.exibirMsg("Digite seu cpf:");
		cpf = ler.nextLine();
		return cpf;
	}

	public static String lerSenha() {
		String senha = "";
		Tela.exibirMsg("Digite sua Senha:");
		senha = ler.nextLine();
		return senha;
	}

	public static String lerNomeDaBiblioteca() {
		String nome = "";
		Tela.exibirMsg("\nDigite o nome da Biblioteca:");
		nome = ler.nextLine();
		return nome;
	}

	public static String lerIdDaBiblioteca() {
		String id = "";
		Tela.exibirMsg("Digite o id da Biblioteca:");
		id = ler.nextLine();
		return id;
	}

	public static String lerCategoriaDaPrateleira() {
		String categoria = "";
		Tela.exibirMsg("Digite o nome da prateleira:");
		categoria = ler.nextLine();
		return categoria;
	}

	public static String lerIdDaPrateleira() {
		String id = "";
		Tela.exibirMsg("Digite o id da prateleira:");
		id = ler.nextLine();
		return id;
	}
//Métodos mais genéricos
	public static String lerTipoDoDocumento() {
		String tipo = "";
		Tela.exibirMsg("Digite o tipo do documento:");
		tipo = ler.nextLine();
		return tipo;
	}
	
	public static String lerMatriculaDoDocumento() {
		String matricula = "";
		Tela.exibirMsg("Digite a matricula do documento:");
		matricula = ler.nextLine();
		return matricula;
	}
	
	public static String lerAutorDoDocumento() {
		String autor = "";
		Tela.exibirMsg("Digite o autor do documento");
		autor = ler.nextLine();
		return autor;
	}
	
	public static String lerTituloDoDocumento() {
		String titulo = "";
		Tela.exibirMsg("Digite o tílulo do documento");
		titulo = ler.nextLine();
		return titulo;
	}

	public static double lerQntDePaginasDoDocumento() {
		double paginas = 0;
		Tela.exibirMsg("Digite a quantidade de páginas do documento");
		paginas = ler.nextDouble();
		return paginas;
	}
	

	// Método de documentos de fatos
	public static String lerDocumentoLivro() {
		String nome = "";
		Tela.exibirMsg("Digite o nome do livro:");
		nome = ler.nextLine();
		return nome;
	}
	
	public static String lerIsbnDoLivro() {
		String isbn = "";
		Tela.exibirMsg("Digite o código isbn do livro");
		isbn = ler.nextLine();
		return isbn;
	}
	public static double lerPrecoDoDocumentoLivro() {
		double preco = 0;
		Tela.exibirMsg("Digite o preco do livro");
		preco = ler.nextDouble();
		return preco;
	}
	public static String lerNomeDoDocumentoArtigo() {
		String artigo = "";
		Tela.exibirMsg("Digite o nome do artigo:");
		artigo = ler.nextLine();
		return artigo;
	}

	public static String lerTemaDoDocumentoArtigo() {
		String assunto = "";
		Tela.exibirMsg("Digite o assunto do artigo:");
		assunto = ler.nextLine();
		return assunto;
	}

	public static void exibirMsg(String msg) {
		System.out.println(msg);
	}
//interação com o usuario
	public static void telaMenu(Usuario usuario) {
		int opcao = 0;
		exibirMsg("<1>Realizar cadastros");
		exibirMsg("<2>Realizar buscas");
		exibirMsg("<3>Remover item do usuário");
		exibirMsg("<4>Listar item do usuario");
		exibirMsg("<5>Atualizar item do usuário");
		exibirMsg("<6>Voltar.");
		Tela.exibirMsg("Faça a sua escolha:");
		opcao = lerOpcao.nextInt();
		if (opcao == 1) {
			lerOpcaoCadastro(usuario);
		} else if (opcao == 2) {
			// escolherOpcoesDeBuscas(user);
		} else if (opcao == 3) {
			lerOpcaoDeRemocaoDoUsuario(usuario);
		} else if (opcao == 4) {
			listarDominiosDoUsuario(usuario);
		} else if (opcao == 5) {
			lerOpcaoDeAtualizacao(usuario);
		} else {
			exibirMsgErro("Opção inválida!");
		}
		telaMenu(usuario);
	}
	
	
	public static void lerOpcaoCadastro(Usuario usuario) {
		int opcao = 0;
		exibirMsg("<1>Para cadastrar uma nova biblioteca");
		exibirMsg("<2>Para cadastrar uma nova prateleira");
		exibirMsg("<3>Para cadastrar um novo documento");
		exibirMsg("<4>Voltar");
		Tela.exibirMsg("Faça a sua escolha:");
		opcao = lerOpcao.nextInt();
		if (opcao == 1) {
			String nome = Tela.lerNomeDaBiblioteca();
			String id = Tela.lerIdDaBiblioteca();

			if (usuario.retornarIndiceDeUmObjeto(nome)) {
				exibirMsgErro("O nome especificado da biblioteca já existe!");
				lerOpcaoCadastro(usuario);
			} else {
				usuario.cadastrarBiblioteca(nome, id);
				lerOpcaoCadastro(usuario);
			}

		} else if (opcao == 2) {
			exibirMsg("Escolha uma biblioteca para efetuar a operação!\n");
			usuario.listarObjetosDeUmaLista();
			usuario.cadastrarPrateleiraNaBiblioteca();
			lerOpcaoCadastro(usuario);
		} else if (opcao == 3) {
			escolherTipoDoDocumento(usuario);
			lerOpcaoCadastro(usuario);
		} else if (opcao == 4) {
			telaMenu(usuario);
		} else {
			exibirMsgErro("Opção inválida\n");
		}
		Tela.telaMenu(usuario);

	}
	

	public static void escolherTipoDoDocumento(Usuario usuario) {
		 int opcao = 0;
		  Tela.exibirMsg("<1>- Para cadastrar Livros");
		  Tela.exibirMsg("<2>- Para cadastrar Artigos");
		  Tela.exibirMsg("Faça a sua escolha:");
		  opcao = lerOpcao.nextInt();
		  if(opcao == 1) {
				usuario.cadastrarDocumentoNaPrateleira();

		  }
		  limparScanner();
	}


	public static void lerOpcaoDeAtualizacao(Usuario usuario) {
		int opcao = 0;
		exibirMsg("<1>Atualizar usuário");
		exibirMsg("<2>Atualizar bibliotecas");
		exibirMsg("<3>Atualizar prateleiras");
		exibirMsg("<4>Atualizar documentos");
		exibirMsg("<5>Voltar");
		Tela.exibirMsg("Faça a sua escolha:");
		opcao = lerOpcao.nextInt();
		if (opcao == 1) {

		} else if (opcao == 2) {
			
			desenharTabelaComDadosDasBibliotecas(usuario);
			usuario.listarObjetosDeUmaLista();

            usuario.atualizarUmObjetoDeUmaLista();

			usuario.listarObjetosDeUmaLista();

			lerOpcaoDeAtualizacao(usuario);
		} else if (opcao == 3) {
			desenharTabelaComDadosDasBibliotecas(usuario);
			usuario.chamarMetodoDeAtualizacaoDeUmaPrateleira();

			lerOpcaoDeAtualizacao(usuario);
		} else if (opcao == 4) {
			desenharTabelaComDadosDasBibliotecas(usuario);
			usuario.chamarMetodoParaAtualizarUmDocumentoDaPrateleira();
			lerOpcaoDeAtualizacao(usuario);
		} else if (opcao == 5) {
			telaMenu(usuario);
		} else {
			exibirMsgErro("Opção inválida!");
		}
		limparScanner();
		Tela.telaMenu(usuario);
	}

	public static void lerOpcaoDeRemocaoDoUsuario(Usuario usuario) {
		int opcao = 0;
		boolean condicao;
		String senha = "";
		exibirMsg("Para poder remover digite sua senha");
		if (usuario.confirmarSenhaDoUsuario()) {
			condicao = true;
		} else {
			exibirMsgErro("Senha inválida!");
			telaMenu(usuario);
			condicao = false;
		}

		while (condicao) {
			exibirMsg("Escolha O item que você deseja remover");
			exibirMsg("<1>Biblioteca.");
			exibirMsg("<2>Prateleira.");
			exibirMsg("<3>Documento.");
			exibirMsg("<4>Voltar.");
			opcao = lerOpcao.nextInt();
			if (opcao == 1) {
				if (usuario.removerUmObjetoDeUmaLista())
					exibirMsg("O item foi removido com sucesso!");
				else
					exibirMsgErro("Erro na operação!");

			} else if (opcao == 2) {
				usuario.chamarMetodoDeRemocaoDeUmaPrateleiraDeUmaBiblioteca();
			} else if (opcao == 3) {

				String nome = Tela.lerNomeDaBiblioteca();
				String id = Tela.lerIdDaBiblioteca();
				usuario.chamarMetodoDeRemocaoDeUmDocumentoDeUmaPrateleira(nome, id);

			} else if (opcao == 4) {
				telaMenu(usuario);
			} else {
				exibirMsgErro("Opção inválida!\n");
			}
		}
		Tela.telaMenu(usuario);
	}

	// public static void escolherOpcoesDeBuscas(Usuario user) {
	// int opcao = 0;
	// String nome = "";
	// String id = "";
	// exibirMsg("<1>Buscar uma das suas Biblioteca");
	// exibirMsg("<2>Buscar uma das suas Prateleiras");
	// exibirMsg("<3>Buscar um dos seus Documentos ou Livros ...");
	// opcao = lerOpcao.nextInt();
	// if (opcao == 1) {
	// user.buscarIformcaoDeUmaBiblioteca();
	// } else if (opcao == 2) {
	// user
	// }
	// }

	public static void listarDominiosDoUsuario(Usuario usuario) {
		int opcao = 1;
		boolean condicao = true;
		while (condicao) {
			exibirMsg("Usuário " + usuario.getNome() + "\n");
			exibirMsg("Informe o que você deseja listar!");
			exibirMsg("<1>Biblioteca.");
			exibirMsg("<2>Prateleira.");
			exibirMsg("<3>Documentos.");
			opcao = ler.nextInt();
			if (opcao == 1) {
				usuario.listarObjetosDeUmaLista();
			} else if (opcao == 2) {
				usuario.listarPrateleirasDeUmaBiblioteca();
			} else if (opcao == 3) {
				String nome = Tela.lerNomeDaBiblioteca();
				String id = Tela.lerIdDaBiblioteca();
				usuario.chamarMetodoParaListarDocumentosDeUmaPrateleira(nome, id);
			} else {
				condicao = false;
			}
		}
		telaMenu(usuario);
	}
	
	public static void desenharTabelaComDadosDasBibliotecas(Usuario usuario) {
	   for (Biblioteca biblioteca : usuario.getBiblioteca()) {
		

	        System.out.printf("%s\n","________________________________________________________________");
	        System.out.printf("%s%10s%10s\n", "|Biblioteca", biblioteca.getId(), biblioteca.getNome());
	        for(Prateleira prateleira: biblioteca.getPrateleira()) {
	        	System.out.printf("%s\n", " _______________________________________________________________ ");
		        System.out.printf("%s%10s%10s\n", "|Prateleira", prateleira.getId(), prateleira.getCategoria());
		        System.out.printf("%s\n", " _______________________________________________________________");
		        for(Documento documento: prateleira.getDocumento()) {
		         
		        	System.out.printf("%s%10s%10s%10s%10s\n", 
		        		   "|Documento |" ,
		        		    documento.getTitulo()+"|",
		        			documento.getTitulo()+"|" ,
		        			documento.getAutor()+"|" ,
		        			documento.getMatricula()+"|");
			        
		        	System.out.printf("%s\n","|__________|_________|_________|_________|");	
		        }
		        System.out.printf("%s%10s\n", "|---", "||");
	        }
	        
//	        for ( int i = 0; i <= 9; i++ ) {
//	            System.out.printf("|%5d%3s%7d |\n", i, " |", array[i]);
//	        }
//	        System.out.printf("%s%10s\n", "|---", "||");	   
	   }	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}