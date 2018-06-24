package br.prontoSocorro.data;

public class Paciente implements Comparable<Paciente> {
	@Override
	public String toString() {

		return this.getId() + "\t" + this.getNome() + "\t" + this.getSobrenome() + "\t" + this.getGenero() + "\t"
				+ this.getCpf() + "\t" + this.getEmail() + "\t" + this.getCondicao();
	}

	private String nome;
	private String sobrenome;
	private String genero;
	private String cpf;
	private String email;
	private int condicao;
	private int id;
	private static int ultimo;
	private final int ordem;

	public Paciente(int pid, String pnome, String psobrenome, String pgenero, String pcpf, String pemail,
			int pcondicao) {
		super();
		this.nome = pnome;
		this.sobrenome = psobrenome;
		this.genero = pgenero;
		this.cpf = pcpf;
		this.email = pemail;
		this.condicao = pcondicao;
		this.id = pid;
		this.ordem = ultimo + 1;
		ultimo = this.ordem;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdem() {
		return ordem;
	}

	// Para retornar a condição em forma de texto;
	public String getCondicao() {
		if (this.condicao == 0) {
			return "Azul";
		} else if (this.condicao == 1) {
			return "Verde";
		} else if (this.condicao == 2) {
			return "Amarelo";
		} else if (this.condicao == 3) {
			return "Laranja";
		} else if (this.condicao == 4) {
			return "Vermelho";

		} else {
			return "Erro";
		}
	}

	public void setCondicao(int condicao) {
		this.condicao = condicao;
	}

	@Override

	public int compareTo(Paciente outro) {
		if (this.condicao < outro.condicao) {
			return 1;
		}

  if (this.condicao-4 > outro.condicao) {
			return -5;
		} else if (this.condicao -3 > outro.condicao) {
			return -4;
		} else if (this.condicao -2 > outro.condicao) {
			return -3;
		} else if (this.condicao -1 > outro.condicao) {
			return -2;
		} else 

		if (this.condicao > outro.condicao) {
			return -1;
		}else {
			return 0;
		}

		//return Integer.valueOf(this.ordem).compareTo(outro.getOrdem());
		
	}

}
