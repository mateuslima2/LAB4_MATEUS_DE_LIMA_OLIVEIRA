package classes;

public class Aluno {
	
	private String nome;
	private String matricula;
	private String curso;
	
	/**
	 * Cria um novo aluno
	 * @param nome do aluno
	 * @param matricula do aluno
	 * @param curso do aluno
	 */
	public Aluno(String nome, String matricula, String curso) {
		
		if(nome == null)
			throw new NullPointerException();
		else if(nome.trim().equals(""))
			throw new IllegalArgumentException();
		
		if(matricula == null)
			throw new NullPointerException();
		else if(matricula.trim().equals(""))
			throw new IllegalArgumentException();
				
		if(curso == null)
			throw new NullPointerException();
		else if(curso.trim().equals(""))
			throw new IllegalArgumentException();
	
		this.curso = curso;	
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Verifica igualdade de Alunos com base na matricula
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Representação de aluno, com matricula, nome e curso
	 * @returns String
	 */
	@Override
	public String toString() {
		return  getMatricula() +" - " + getNome() + " - " + getCurso()+"\n" ;
	}
	
}
