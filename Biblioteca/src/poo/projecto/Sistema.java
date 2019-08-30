package poo.projecto;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Sistema {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static Scanner read = new Scanner(System.in);

	public static boolean cadastrarUsuario() {
		String nome = "";
		String cpf = "";
		String senha = "";
		int indice = 0;

		nome = Tela.lerNomeDoUsuario();

		cpf = Tela.lerCpfDoUsuario();

		senha = Tela.lerSenha();

		if (usuarios.add(new Usuario(nome, cpf, senha))) {
			indice = usuarios.size() - 1;
			Tela.exibirMsg(usuarios.get(indice).getNome() + " você foi cadastrado com sucesso!\n");
			return true;
		} else {
			Tela.exibirMsgErro("\nErro! Você não informou algum dado corretamente.");
			return false;
		}
	}

	public static int retornarIndiceDoUsuario(String nome, String senha) {
		int indice = 0;

		for (Usuario usuario : usuarios) {
			if (usuario.getNome().startsWith(nome) && usuario.getSenha().startsWith(senha)) {
				return indice = usuarios.size() - 1;
			}
		}

		return indice = -1;
	}

	// public static void listarBibliorecaUsuario() {
	// int indice = 0;
	//
	// for (Usuario usuario : usuarios) {
	// indice = usuarios.size() - 1;
	// usuarios.get(indice).buscarBiblioteca();
	// }
	//
	// }

	public static boolean retornarUmUsuarioCadastradoNoSistema() {
		boolean condicao = true;
		int limiteDeTentativas = 1;
		String nome = "";
		String senha = "";

		while (condicao) {
			nome = Tela.lerNomeDoUsuario();
			senha = Tela.lerSenha();

			int indice = retornarIndiceDoUsuario(nome, senha);

			if (indice >= 0) {
				Tela.exibirMsg("\nBem vindo " + usuarios.get(indice).getNome() + "!");
				Usuario usuario = usuarios.get(indice);
				Tela.telaMenu(usuario);

				return condicao;

			} else if (limiteDeTentativas == 4) {
				Tela.exibirMsgErro("Você não está cadastrado!");
					break;
			} else {
				Tela.exibirMsgErro("\nNome ou Senha inválidos!");

				Tela.exibirMsg("\nDeseja tentar novamente[s][n]?");
				String escolha = read.nextLine();
				String confirmacao = "s";

				limiteDeTentativas++;

				if (escolha.equals(confirmacao)) {
					Sistema.retornarIndiceDoUsuario(nome, senha);
				} else {
					Tela.exibirMsgErro("Até a próxima!");
					return false;
				}
			}
		}
		return condicao;
	}

}
