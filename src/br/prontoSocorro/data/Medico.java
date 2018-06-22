package br.prontoSocorro.data;

public class Medico {
	private String nome;
	private String sobrenome;
	private String genero;
	private String email;
	private String especialidade;

	public Medico(String pnome, String psobrenome, String pgenero, String pcpf, String pemail, String pespecialidade) {
		super();
		this.nome = pnome;
		this.sobrenome = psobrenome;
		this.genero = pgenero;
		this.email = pemail;
		this.especialidade = pespecialidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {

		return getNome() + "\t" + getSobrenome() + "\t" +getGenero() + "\t" +getEmail() + "\t" +getEspecialidade();
	}

}
