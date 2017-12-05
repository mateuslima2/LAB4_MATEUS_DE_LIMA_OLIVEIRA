package classes;

import java.util.Scanner;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	static String opcao = "";
	static Sistema sistema = new Sistema();
	
	public static void main(String[] args) {
		while (true) {
			menu();
			opcao = sc.nextLine();
			switch (opcao) {
			
			case "C":
				cadastrar();
				break;
			case "E":
				exibirAluno();
				break;
			case "N":
				novoGrupo();
				break;
			case "A":
				alocarOuImprimir();
				break;
			case "R":
				registrar();
				break;
				
			case "I":
				System.out.println(sistema.imprimirResponderam());
				break;
			case "O":
				System.exit(0);
			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}
		}
	}
	 /**
	 * apresenta o menu apresentado o user
	 * @returns void
	 */
	private static void menu() { // menu principal
		System.out.println("\n(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupo");
		System.out.println("(R)egistrar Resposta de Aluno");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!\n");
		System.out.print("Opcao>");
	}
	
	private static void cadastrar() {
		System.out.print("Matr�cula: ");
		String matricula = sc.nextLine();

		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		
		System.out.println(sistema.cadastrar(matricula, nome, curso));
	}
	
	private static void exibirAluno() {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		System.out.println(sistema.exibirAluno(matricula));
	}
	
	private static void novoGrupo() {
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		try {
			if(sistema.novoGrupo(grupo))
				System.out.println("CADASTRO REALIZADO\n");
			else
				System.out.println("GRUPO JA CADASTRADO\n");
		}catch(IllegalArgumentException iae) {
			System.out.println("NOME DO GRUPO NULO OU VAZIO\n");
		}
	}
	
	private static void alocarOuImprimir(){
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String op = sc.nextLine();
		
		if (op.equals("A")) {
			System.out.print("Matricula: ");
			String matricula = sc.nextLine();
					
			System.out.print("Grupo: ");
			String grupo = sc.nextLine();
			
			sistema.alocar(matricula, grupo);
		}else {
			System.out.print("Grupo: ");
			String grupo = sc.nextLine();
			
			System.out.println(sistema.imprimirGrupos(grupo));
		}
	}
	
	private static void registrar() {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		
		if (sistema.registrar(matricula))
			System.out.println("ALUNO REGISTRADO!\n");
		else
			System.out.println("Aluno nao cadastrado\n");
	}

}


