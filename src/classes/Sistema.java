package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Sistema {
	
	private static HashMap<String, Aluno> alunos = new HashMap<>();
	private static HashMap<String,Grupo> grupos = new HashMap<>();
	private static ArrayList<Aluno> responderam = new ArrayList<>();
	
	public Sistema() {}

	/**
	 * Recebe dados do contato e cadastra. 
	 * @param matricula do aluno
	 * @param nome do aluno
	 * @param curso do aluno
	 * @returns String com o resultado do método
	 */
	public String cadastrar(String matricula, String nome, String curso) {
		
		if(alunos.containsKey(matricula)) {
			return("MATRACULA JA CADSTRADA!\n");
			
		}else {
			try {
				alunos.put(matricula, new Aluno(nome, matricula, curso));
				return("CADASTRO REALIZADO\n");
			}catch(IllegalArgumentException iae) {
				return("Campo vazio\n");
			}catch(NullPointerException iae) {
				return("Campo nulo\n");
			}
		}
	}
	
	/**
	 * Exibe o aluno procurado por meio da matricula 
	 * @param matricula do aluno
	 * @returns void
	 */
	public String exibirAluno(String matricula) {
		if(alunos.containsKey(matricula)) 
			return("Aluno: " + alunos.get(matricula).toString());
		else
			return("Aluno nao cadastrado.\n");
	}
	
	/**
	 * Cria um novo grupo a partir do nome
	 * @param grupo nome do grupo
	 * @returns void
	 */
	public boolean novoGrupo(String grupo) {
		Grupo novo = new Grupo(grupo);

		if(grupos.containsKey(grupo)) {
			return false;
		}else { 
			grupos.put(grupo.toLowerCase(), novo);
			return true;
		}
	}
	
	/**
	 * Abre novas opções (alocar e imprimir) para o user
	 * @param op opcao do menu
	 * @returns void
	 */
	public void alocarOuImprimir(String op) {
		/*if(op.equals("A"))
			alocar();
		else if(op.equals("I"))
			imprimirGrupos();*/
	}
	
	/**
	 * Recebe matricula de aluno e grupo, e aloca o mesmo caso ambos estejam cadastrados
	 * @param matricula matricula do aluno
	 * @param grupo nome do grupo
	 * @returns void
	 */
	public String alocar(String matricula, String grupo) {
		
		if (alunos.containsKey(matricula)) {
			if (!grupos.containsKey(grupo.toLowerCase()))
				return("Grupo nao cadastrado\n");
			else
				grupos.get(grupo.toLowerCase()).alocar(alunos.get(matricula));
				return("ALUNO ALOCADO!\r\n");

		}else {
			return("Aluno nao Cadastrado\n");
		}
	}
	
	/**
	 * Lista alunos do respectivo grupo passado
	 * @param grupo nome do grupo
	 * @returns void
	 */
	public String imprimirGrupos(String grupo) {
		if (!grupos.containsKey(grupo.toLowerCase()))
			return("Grupo nao cadastrado\n");
		else
			return("Alunos do grupo " + grupo +":\r\n" + grupos.get(grupo.toLowerCase()).imprimir());
	}
	
	/**
	 *Registra aluno que respondeu o professor 
	 *@param matricula matricula do aluno
	 * @returns void
	*/
	public boolean registrar(String matricula) {

		if(alunos.containsKey(matricula)){
			responderam.add(alunos.get(matricula));
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Lista alunos que responderam
	 * @returns void
	 */
	public String imprimirResponderam() {
		String aux = "";
		for (int i = 0; i < responderam.size() ; i++) 
			aux+=((i+1)+". " + responderam.get(i).toString());
		return aux;
	}
	
}
