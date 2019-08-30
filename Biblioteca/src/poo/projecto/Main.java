package poo.projecto;

import java.util.List;
import java.lang.Runtime;



public class Main {

	public static void main(String[] args) {
		
//		Runtime.getRuntime().exec("");

		
//		Usuario user = new Usuario("Gorge","123","12345");
//		Biblioteca biblioteca = new Biblioteca("Escola","2520");
//		Prateleira prateleira = new Prateleira("Mangás","252");
//		Documento documento = new Livro(" Rosas", "Rozinha", 100.0, "5564");
//		Documento documento1 = new Livro(" castelo", "pedeiro", 100.0, "1321");
//
//		
//		
//		for(int i = 0; i <= 10; i++) {
//			prateleira.getDocumento().add(documento);
//			prateleira.getDocumento().add(documento1);
//			prateleira.getDocumento().add(documento);
//			prateleira.getDocumento().add(documento1);
//		}	
//		
//		biblioteca.getPrateleira().add(prateleira);
//		user.getBiblioteca().add(biblioteca);
//		Tela.desenharTabelaComDadosDasBibliotecas(user);
//           		
	
		
	    
		
		
		
		// Sistema.buscarUsuario();
		 Tela.exibirMsg("\t\t\tBem vindo ao sistema de cadastro de Livros");
		 Tela.exibirMsg("Vamos começar!\n");
		 
		 Sistema.cadastrarUsuario();
		 System.out.println("Login:"); 
		 Sistema.retornarUmUsuarioCadastradoNoSistema();
		
		
	}
}