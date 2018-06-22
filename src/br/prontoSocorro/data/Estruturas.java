package br.prontoSocorro.data;

import java.awt.List;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Estruturas {

	private PriorityQueue<Paciente> filaPaciente = new PriorityQueue<Paciente>(5, new ComparaPacientes());

	public class ComparaPacientes implements Comparator<Paciente> {
		// Overriding compare()method of Comparator
		// for descending order of Paciente
		public int compare(Paciente s1, Paciente s2) {
			if (s1.getCondicaoN() < s2.getCondicaoN())
				return 1;
			else if (s1.getCondicaoN() > s2.getCondicaoN())
				return -1;
			return 0;
		}
	}

	public PriorityQueue<Paciente> getFilaPaciente() {
		return filaPaciente;
	}

	public void addPaciente(Paciente novoPaciente) {
		filaPaciente.add(novoPaciente);
	}

	public Paciente verificaPaciente() {
		// Mostra o Próximo Paciente da fila
		return filaPaciente.peek();
	}

	public Paciente chamaPaciente() {
		// Mostra o próximo paciente da fila, e o retira da fila.
		return filaPaciente.poll();
	}

	private LinkedList<Medico> listaDeMedicos = new LinkedList<Medico>();

	public Medico medico(int index) {
		// Mostra um médico
		return listaDeMedicos.get(index);
	}

	public void addCadastraMedico(Medico novoMedico) {
		listaDeMedicos.add(novoMedico);
	}

	private Queue<Medico> medicoAtendendo = new LinkedList<Medico>();

	public void entrouMedico(int medicoEntrada) {
		medicoAtendendo.add(listaDeMedicos.get(medicoEntrada));
	}

	public Medico saiuMedico() {
		return medicoAtendendo.poll();
	}

	public void escreverNoArquivo() {
		
	}
	
	public void lerDoArquivo() {
		
	}
}
