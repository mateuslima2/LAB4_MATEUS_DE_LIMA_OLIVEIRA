package classes;

import java.util.HashSet;

public class Grupo {
	
	private String nome;
	private HashSet<Aluno> pertencentes = new HashSet<>();
	
	public Grupo(String nome) {
		if(nome == null)
			throw new NullPointerException();
		else if(nome.trim().equals(""))
			throw new IllegalArgumentException();
		
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	/**
	 * Aloca aluno em determinado grupo
	 * @returns void
	 */
	public void alocar(Aluno aluno) {
		this.pertencentes.add(aluno);
	}
	
	/**
	 * Retorna lista de alunos pertencentes a tal grupo
	 * @returns String
	 */
	public String imprimir() {
		String aux = "";
		for (Aluno a : pertencentes) 
			aux+=("* " + a.toString());
		return aux;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Verifica igualdade de grupos com base no nome
	 * @returns boolean true se forem iguais, false se forem diferentes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
