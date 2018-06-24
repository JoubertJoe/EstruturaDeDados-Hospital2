package br.prontoSocorro.data;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Estruturas {

	private LinkedList<Paciente> listaPacientes = new LinkedList<Paciente>();
	private PriorityQueue<Paciente> filaPaciente = new PriorityQueue<>();
	private LinkedList<Medico> listaDeMedicos = new LinkedList<Medico>();
	private Queue<Medico> medicoAtendendo = new LinkedList<Medico>();
	private LinkedList<String[]> listaDeAtendimento = new LinkedList<String[]>();

	public void addCadastraMedico(Medico novoMedico) {
		listaDeMedicos.add(novoMedico);
	}

	public void addCadPaciente(Paciente novoPaciente) {
		listaPacientes.add(novoPaciente);
	}

	public void addPaciente(Paciente novoPaciente) {
		filaPaciente.add(novoPaciente);
	}

	public String[] atendendo(int index) {
		return listaDeAtendimento.get(index);
	}

	public void atenderProximo() {

		String[] atendendo = { getAtendimento().size() + "", filaPaciente.poll().getNome(),
				medicoAtendendo.poll().getNome() };
		listaDeAtendimento.add(atendendo);

	}

	public Paciente chamaCadPaciente() {
		// Mostra o próximo paciente da fila, e o retira da fila.
		return listaPacientes.poll();
	}

	public Paciente chamaPaciente() {
		// Mostra o próximo paciente da fila, e o retira da fila.
		return filaPaciente.poll();
	}

	public void entrouMedico(Medico medicoEntrada) {
		medicoAtendendo.add(medicoEntrada);
	}

	public String[] finalizaAtendimento() {
		return listaDeAtendimento.remove();
	}

	public String[] finalizaAtendimento(int id) {
		return listaDeAtendimento.remove(id);
	}

	public LinkedList<String[]> getAtendimento() {
		return listaDeAtendimento;
	}

	public LinkedList<Paciente> getCadastroPacientes() {
		return listaPacientes;
	}

	public PriorityQueue<Paciente> getFilaPaciente() {
		return filaPaciente;
	}

	public Paciente getPacienteFila() {
		return filaPaciente.peek();
	}
	int getIPrioridade(String prioridade) {
		if (prioridade.equalsIgnoreCase("azul")) {
			return 0;
		} else if (prioridade.equalsIgnoreCase("verde")) {
			return 1;
		} else if (prioridade.equalsIgnoreCase("amarelo")) {
			return 2;
		} else if (prioridade.equalsIgnoreCase("laranja")) {
			return 3;
		} else {
			return 4;
			// if(prioridade.equalsIgnoreCase("vermelho"))
		}

	}

	public Queue<Medico> getMedico() {
		return medicoAtendendo;
	}

	public Medico getMAt() {
		return medicoAtendendo.peek();
	}
	
	public LinkedList<Medico> getMedicos() {
		return listaDeMedicos;
	}

	public void ler() throws Exception {

		FileReader leitor = new FileReader(new File("data/medicos.gb"));
		BufferedReader buf = new BufferedReader(leitor);
		// System.out.println("Lendo o arquivo");
		String linha = buf.readLine();
		while (linha != null) {
			if (linha.length() > 0) {

				String[] pedacos = linha.split("\\t");
				addCadastraMedico(new Medico(Integer.parseInt(pedacos[0]), pedacos[1], pedacos[2], pedacos[3],
						pedacos[4], pedacos[5]));
			}
			linha = buf.readLine();
		}

		buf.close();
		leitor.close();

		leitor = new FileReader(new File("data/pacientes.gb"));
		buf = new BufferedReader(leitor);
		// System.out.println("Lendo o arquivo");
		linha = buf.readLine();
		while (linha != null) {
			if (linha.length() > 0) {
				String[] pedacos = linha.split("\t");
				addCadPaciente(new Paciente(Integer.parseInt(pedacos[0]), pedacos[1], pedacos[2], pedacos[3],
						pedacos[4], pedacos[5], getIPrioridade(pedacos[6])));
			}
			linha = buf.readLine();
		}

		buf.close();
		leitor.close();

	}

	public Medico medico(int index) {
		// Mostra um médico
		return listaDeMedicos.get(index);
	}

	public Medico saiuMedico() {
		return medicoAtendendo.poll();
	}

	public void salvar() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream("data/medicos.gb"));
		for (int i = 0; i < listaDeMedicos.size(); i++) {
			String tmp = listaDeMedicos.get(i).toString() + "\n";
			pw.write(tmp);
		}
		pw.close();

		pw = new PrintWriter(new FileOutputStream("data/pacientes.gb"));
		for (int i = 0; i < listaPacientes.size(); i++) {
			String tmp = listaPacientes.get(i).toString() + "\n";
			pw.write(tmp);
		}
		pw.close();

	}

	public Paciente verificaCadPaciente() {
		// Mostra o Próximo Paciente da fila
		return listaPacientes.peek();
	}

	public Paciente verificaCadPaciente(int id) {
		// Mostra o Próximo Paciente da fila
		return listaPacientes.get(id);
	}

	public Medico verificaMedico(int id) {
		return listaDeMedicos.get(id);
	}

	public Paciente verificaPaciente() {
		// Mostra o Próximo Paciente da fila
		return filaPaciente.peek();
	}
}
