package br.prontoSocorro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.prontoSocorro.data.Estruturas;
import br.prontoSocorro.data.Paciente;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Window.Type;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ProntoSocorro extends JFrame {

	private JPanel contentPane, pnlAlto, pnlBaixo, pnlTabelaAtendimento, pnl_Geral, pnlTabelaPacientes, pnlBtnsGeral,
			pnlMedico;
	private JLabel lblProntoSocorro, lblTotal;
	private JButton btnVoltar, btnEntrar, btnLiberar, btnImprimir;
	private JTabbedPane tabbedPane;
	private JTable tblPacientes, tblAtendimento, tblMedicos;
	private DefaultTableModel modeloPacientes, modeloMedico, modeloAtendimento, modeloEntrada;
	private JScrollPane scrollAtendimento, scrollPane, scrollPacientes;
	private JPanel pnlEntradaDeMedicos;
	private JLabel lblGiveMeBlood;
	private JPanel pnlEntraMed;
	private JTextField txtPesquisaDeMedicos;
	private JButton btnEntrou;
	private JButton btnPesquisa;
	private JPanel pnlTabelaEntrMedi;
	private JTable tblEntradaMedicos;

	public ProntoSocorro(Estruturas estrutura) {
		setTitle("GIVE ME BLOOD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 479);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnlBaixo = new JPanel();
		pnlBaixo.setOpaque(false);
		pnlBaixo.setBackground(Color.WHITE);
		contentPane.add(pnlBaixo, BorderLayout.SOUTH);

		btnVoltar = new JButton("Voltar");
		pnlBaixo.add(btnVoltar);

		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		componentesVisaoGeral(estrutura);
		componentesEntradaMedicos(estrutura);

		this.setVisible(true);
	}

	public void componentesEntradaMedicos(Estruturas estruturas) {
		pnlAlto = new JPanel();
		pnlAlto.setBorder(UIManager.getBorder("EditorPane.border"));
		pnlAlto.setBackground(UIManager.getColor("RadioButtonMenuItem.acceleratorForeground"));
		contentPane.add(pnlAlto, BorderLayout.NORTH);

		lblGiveMeBlood = new JLabel("GIME BLOOD GIME HEART GIME THAT I DESIRE");
		pnlAlto.add(lblGiveMeBlood);

		pnlEntradaDeMedicos = new JPanel();
		pnlEntradaDeMedicos.setBackground(UIManager.getColor("RadioButtonMenuItem.acceleratorForeground"));
		tabbedPane.addTab("ENTRADA DE MEDICOS", null, pnlEntradaDeMedicos, null);
		pnlEntradaDeMedicos.setLayout(new BorderLayout(0, 0));

		pnlEntraMed = new JPanel();
		pnlEntraMed.setBackground(UIManager.getColor("ProgressBar.foreground"));
		pnlEntradaDeMedicos.add(pnlEntraMed, BorderLayout.SOUTH);

		btnPesquisa = new JButton("");
		btnPesquisa.setIcon(new ImageIcon("icon/search-icon.png"));
		pnlEntraMed.add(btnPesquisa);

		txtPesquisaDeMedicos = new JTextField();
		txtPesquisaDeMedicos.setText("PESQUISA DE MEDICOS");
		pnlEntraMed.add(txtPesquisaDeMedicos);
		txtPesquisaDeMedicos.setColumns(35);

		btnEntrou = new JButton("Entrou");
		pnlEntraMed.add(btnEntrou);

		pnlTabelaEntrMedi = new JPanel();
		pnlEntradaDeMedicos.add(pnlTabelaEntrMedi, BorderLayout.CENTER);
		pnlTabelaEntrMedi.setLayout(new CardLayout(0, 0));

		JScrollPane scrollEntrada = new JScrollPane();
		pnlTabelaEntrMedi.add(scrollEntrada, "name_21547625491067");

		tblEntradaMedicos = new JTable();
		tblEntradaMedicos.setBackground(UIManager.getColor("TabbedPane.focus"));
		tblEntradaMedicos.setFillsViewportHeight(true);
		modeloEntrada = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Sobre-Nome", "Especialidade" });
		tblEntradaMedicos.setModel(modeloEntrada);
		scrollEntrada.setViewportView(tblEntradaMedicos);
	}

	public void populaTabelaPaciente(Estruturas estruturas) {
		ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>(estruturas.getFilaPaciente());
		String linhaColuna[][] = new String[listaPacientes.size()][2];
		for (int i = 0; i < listaPacientes.size() - 1; i++) {
			linhaColuna[i][0] = listaPacientes.get(i).getNome() + " " + listaPacientes.get(i).getSobrenome();
			linhaColuna[i][1] = listaPacientes.get(i).getCondicao();
		}

	}

	void componentesVisaoGeral(Estruturas estrutura) {
		pnl_Geral = new JPanel();
		tabbedPane.addTab("Visão Geral", null, pnl_Geral, null);
		pnl_Geral.setLayout(new BorderLayout(0, 0));

		pnlBtnsGeral = new JPanel();
		pnlBtnsGeral.setBackground(UIManager.getColor("List.dropLineColor"));
		pnl_Geral.add(pnlBtnsGeral, BorderLayout.SOUTH);

		lblTotal = new JLabel("Total :");
		pnlBtnsGeral.add(lblTotal);

		btnEntrar = new JButton("Entrar");
		pnlBtnsGeral.add(btnEntrar);

		btnLiberar = new JButton("Liberar");
		pnlBtnsGeral.add(btnLiberar);

		pnlTabelaPacientes = new JPanel();
		pnl_Geral.add(pnlTabelaPacientes, BorderLayout.WEST);
		pnlTabelaPacientes.setLayout(new CardLayout(0, 0));

		scrollPacientes = new JScrollPane();
		pnlTabelaPacientes.add(scrollPacientes, "name_7137143116263");

		modeloPacientes = new DefaultTableModel(new Object[][] {}, new String[] { "Condi\u00E7\u00E3o", "paciente" });

		populaTabelaPaciente(estrutura);

		tblPacientes = new JTable();
		tblPacientes.setPreferredScrollableViewportSize(new Dimension(200, 200));
		scrollPacientes.setViewportView(tblPacientes);

		modeloAtendimento = new DefaultTableModel(new Object[][] {}, new String[] { "Condi\u00E7\u00E3o", "Paciente" });

		tblPacientes.setModel(modeloAtendimento);
		tblPacientes.getColumnModel().getColumn(1).setPreferredWidth(70);
		tblPacientes.getColumnModel().getColumn(0).setPreferredWidth(70);

		btnImprimir = new JButton("Imprimir");
		pnl_Geral.add(btnImprimir, BorderLayout.NORTH);

		pnlTabelaAtendimento = new JPanel();
		pnl_Geral.add(pnlTabelaAtendimento, BorderLayout.EAST);
		pnlTabelaAtendimento.setLayout(new CardLayout(0, 0));

		scrollAtendimento = new JScrollPane();
		scrollAtendimento.setMinimumSize(new Dimension(15, 15));
		pnlTabelaAtendimento.add(scrollAtendimento, "name_7529993937869");

		tblAtendimento = new JTable();
		tblAtendimento.setFillsViewportHeight(true);
		tblAtendimento.setPreferredScrollableViewportSize(new Dimension(200, 200));
		modeloAtendimento = new DefaultTableModel(new Object[][] {}, new String[] { "Medico", "Paciente" });
		tblAtendimento.setModel(modeloAtendimento);
		tblAtendimento.getColumnModel().getColumn(0).setPreferredWidth(15);
		scrollAtendimento.setViewportView(tblAtendimento);

		pnlMedico = new JPanel();
		pnl_Geral.add(pnlMedico, BorderLayout.CENTER);
		pnlMedico.setLayout(new CardLayout(0, 0));

		scrollPane = new JScrollPane();
		pnlMedico.add(scrollPane, "name_9232620015837");

		modeloMedico = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E9dico", "Especializa\u00E7\u00E3o" });
		tblMedicos = new JTable();
		tblMedicos.setModel(modeloMedico);

		scrollPane.setViewportView(tblMedicos);
		tblMedicos.setPreferredScrollableViewportSize(new Dimension(200, 200));
		tblMedicos.setFillsViewportHeight(true);

	}
}
