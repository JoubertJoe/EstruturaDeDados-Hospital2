package br.prontoSocorro.data;

public class Paciente {
	private String nome;
	private String sobrenome;
	private String genero;
	private String cpf;
	private String email;
	private int condicao;

	private int compareTo(Paciente other) {
		return Integer.compare(this.condicao, other.condicao);
	}

	public Paciente() {
	};

	public Paciente(String pnome, String psobrenome, String pgenero, String pcpf, String pemail, int pcondicao) {
		super();
		this.nome = pnome;
		this.sobrenome = psobrenome;
		this.genero = pgenero;
		this.cpf = pcpf;
		this.email = pemail;
		this.condicao = pcondicao;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCondicaoN() {
		return this.condicao;
	}
	
//Para retornar a condição em forma de texto;	
	public String getCondicao() {
		if (this.condicao == 0) {
			return "Azul";
		} else if (this.condicao == 1) {
			return "Verde";
		} else if (this.condicao == 2) {
			return "Verde";
		}else if(this.condicao == 3) {
			return "Amarelo";
		} else if (this.condicao == 4) {
			return "Laranja";
		} else if (this.condicao == 5) {
			return "Vermelho";
		}else {
			return "Azul";
		}
	}

	public void setCondicao(int condicao) {
		this.condicao = condicao;
	}

}
