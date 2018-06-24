package br.prontoSocorro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.prontoSocorro.data.Estruturas;
import br.prontoSocorro.data.Medico;
import br.prontoSocorro.data.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;

public class ProntoSocorro extends JFrame {

	private JPanel contentPane, pnlAlto, pnlBaixo, pnlTabelaAtendimento, pnl_Geral, pnlTabelaPacientes, pnlBtnsGeral,
			pnlMedico;
	private JLabel lblProntoSocorro, lblTotal;
	private JButton btnVoltar, btnAtender, btnLiberar, btnImprimir;
	private JTabbedPane tabbedPane;
	private JTable tblPacientes, tblAtendimento, tblMedicos;
	private DefaultTableModel modeloPacientes, modeloMedico, modeloAtendimento, modeloEntrada, modeloCadCliente;
	private JScrollPane scrollAtendimento, scrollPane, scrollPacientes;
	private JPanel pnlEntradaDeMedicos;
	private JLabel lblGiveMeBlood;
	private JPanel pnlEntraMed;
	private JTextField txtPesquisaDeMedicos;
	private JButton btnEntrouMedico;
	private JButton btnPesquisa;
	private JPanel pnlTabelaEntrMedi;
	private JTable tblEntradaMedicos;
	private JPanel pnlPacienteCadastrado;
	private JPanel pnlPCBotoes;
	private JTextField txtPesquisaCliente;
	private JButton btnPesquisacliente;
	private JPanel pnlTabelaCliente;
	private JTable tblClienteCad;
	private JScrollPane scrollTbl;
	private JPanel pnlPrioridade;
	private JButton btnAzul;
	private JButton btnVerde;
	private JButton btnAmarelo;
	private JButton btnLaranja;
	private JButton btnVermelho;
	private TableRowSorter<DefaultTableModel> pesquisaM, pesquisaP;

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
		criaAcoes(estrutura);
		populaTabelaCadPaciente(estrutura);
		populaTabelaMedicos(estrutura);
		populaTabelaPaciente(estrutura);

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

		btnEntrouMedico = new JButton("Entrou");
		pnlEntraMed.add(btnEntrouMedico);

		pnlTabelaEntrMedi = new JPanel();
		pnlEntradaDeMedicos.add(pnlTabelaEntrMedi, BorderLayout.CENTER);
		pnlTabelaEntrMedi.setLayout(new CardLayout(0, 0));

		JScrollPane scrollEntrada = new JScrollPane();
		pnlTabelaEntrMedi.add(scrollEntrada, "name_21547625491067");

		tblEntradaMedicos = new JTable();
		tblEntradaMedicos.setForeground(Color.WHITE);
		tblEntradaMedicos.setBackground(UIManager.getColor("TabbedPane.focus"));

		tblEntradaMedicos.setFillsViewportHeight(true);
		modeloEntrada = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Sobre-Nome", "Especialidade" });
		tblEntradaMedicos.setModel(modeloEntrada);
		pesquisaM = new TableRowSorter<>(modeloEntrada);
		tblEntradaMedicos.setRowSorter(pesquisaM);
		scrollEntrada.setViewportView(tblEntradaMedicos);

		pnlPacienteCadastrado = new JPanel();
		tabbedPane.addTab("Pacientes Cadastrados", null, pnlPacienteCadastrado, null);
		pnlPacienteCadastrado.setLayout(new BorderLayout(0, 0));

		pnlPCBotoes = new JPanel();
		pnlPacienteCadastrado.add(pnlPCBotoes, BorderLayout.SOUTH);

		btnPesquisacliente = new JButton("");
		btnPesquisacliente.setIcon(new ImageIcon(("icon/search-icon.png")));
		pnlPCBotoes.add(btnPesquisacliente);

		txtPesquisaCliente = new JTextField();
		txtPesquisaCliente.setText("Pesquisa Cliente");
		pnlPCBotoes.add(txtPesquisaCliente);
		txtPesquisaCliente.setColumns(30);

		pnlTabelaCliente = new JPanel();
		pnlPacienteCadastrado.add(pnlTabelaCliente, BorderLayout.CENTER);
		pnlTabelaCliente.setLayout(new BorderLayout(0, 0));

		scrollTbl = new JScrollPane();
		pnlTabelaCliente.add(scrollTbl);

		tblClienteCad = new JTable();
		scrollTbl.setViewportView(tblClienteCad);
		modeloCadCliente = new DefaultTableModel(new Object[][] {}, new String[] { "Id", "nome", "sobrenome", "CPF" });
		tblClienteCad.setModel(modeloCadCliente);
		pesquisaP = new TableRowSorter<>(modeloCadCliente);
		tblClienteCad.setRowSorter(pesquisaP);
		pnlPrioridade = new JPanel();
		pnlPacienteCadastrado.add(pnlPrioridade, BorderLayout.NORTH);

		btnAzul = new JButton("Azul");
		pnlPrioridade.add(btnAzul);

		btnVerde = new JButton("Verde");
		pnlPrioridade.add(btnVerde);

		btnAmarelo = new JButton("Amarelo");
		pnlPrioridade.add(btnAmarelo);

		btnLaranja = new JButton("Laranja");
		pnlPrioridade.add(btnLaranja);

		btnVermelho = new JButton("Vermelho");
		pnlPrioridade.add(btnVermelho);
	}

	private void pesquisaTabela(JTextField pesquisa, TableRowSorter<DefaultTableModel> ordenador) {
		String text = pesquisa.getText();
		if (text.trim().length() == 0) {
			ordenador.setRowFilter(null);
		} else {
			ordenador.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		}

	}

	private void limparTabela(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void populaTabelaPaciente(Estruturas estruturas) {

		limparTabela(tblPacientes);

		for (int i = 0; i < estruturas.getFilaPaciente().size(); i++) {
			LinkedList<Paciente> filaPaciente = new LinkedList<Paciente>(estruturas.getFilaPaciente());
			modeloPacientes.addRow(new String[] { filaPaciente.get(i).getId() + "", filaPaciente.get(i).getNome(),
					filaPaciente.get(i).getCondicao() });
		}

	}

	public void populaTabelaAtendimento(Estruturas estruturas) {

		limparTabela(tblAtendimento);

		for (int i = 0; i < estruturas.getAtendimento().size(); i++) {
			modeloAtendimento.addRow(estruturas.atendendo(i));
		}

	}

	public void populaTabelaEntMed(Estruturas estruturas) {

		limparTabela(tblMedicos);

		for (int i = 0; i < estruturas.getMedico().size(); i++) {
			LinkedList<Medico> filaMedico = new LinkedList<Medico>(estruturas.getMedico());
			modeloMedico.addRow(new String[] { filaMedico.get(i).getId() + "", filaMedico.get(i).getNome(),
					filaMedico.get(i).getEspecialidade() });
		}

	}

	public void populaTabelaCadPaciente(Estruturas estruturas) {
		limparTabela(tblClienteCad);

		for (int i = 0; i < estruturas.getCadastroPacientes().size(); i++) {

			modeloCadCliente.addRow(new String[] { estruturas.getCadastroPacientes().get(i).getId() + "",
					estruturas.getCadastroPacientes().get(i).getNome(),
					estruturas.getCadastroPacientes().get(i).getSobrenome(),
					estruturas.getCadastroPacientes().get(i).getCpf() });
		}

	}

	public void populaTabelaMedicos(Estruturas estruturas) {
		limparTabela(tblMedicos);
		for (int i = 0; i < estruturas.getMedicos().size(); i++) {
			modeloEntrada.addRow(new String[] { estruturas.getMedicos().get(i).getId() + "",
					estruturas.getMedicos().get(i).getNome(), estruturas.getMedicos().get(i).getEspecialidade() });
		}
	}

	public void componentesVisaoGeral(Estruturas estrutura) {
		pnl_Geral = new JPanel();
		tabbedPane.addTab("Visão Geral", null, pnl_Geral, null);
		pnl_Geral.setLayout(new BorderLayout(0, 0));

		pnlBtnsGeral = new JPanel();
		pnlBtnsGeral.setBackground(UIManager.getColor("List.dropLineColor"));
		pnl_Geral.add(pnlBtnsGeral, BorderLayout.SOUTH);

		lblTotal = new JLabel("Total :");
		pnlBtnsGeral.add(lblTotal);

		btnAtender = new JButton("Atender");
		pnlBtnsGeral.add(btnAtender);

		btnLiberar = new JButton("Liberar");
		pnlBtnsGeral.add(btnLiberar);

		pnlTabelaPacientes = new JPanel();
		pnl_Geral.add(pnlTabelaPacientes, BorderLayout.WEST);
		pnlTabelaPacientes.setLayout(new CardLayout(0, 0));

		scrollPacientes = new JScrollPane();
		pnlTabelaPacientes.add(scrollPacientes, "name_7137143116263");

		modeloPacientes = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Paciente", "Condi\u00E7\u00E3o" });

		tblPacientes = new JTable(modeloPacientes);
		tblPacientes.setPreferredScrollableViewportSize(new Dimension(200, 200));
		scrollPacientes.setViewportView(tblPacientes);

		tblPacientes.getColumnModel().getColumn(1).setPreferredWidth(70);
		tblPacientes.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblPacientes.setDefaultEditor(Object.class, null);
		btnImprimir = new JButton("Imprimir");
		pnl_Geral.add(btnImprimir, BorderLayout.NORTH);

		modeloAtendimento = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Condi\u00E7\u00E3o", "Paciente" });
		pnlTabelaAtendimento = new JPanel();
		pnl_Geral.add(pnlTabelaAtendimento, BorderLayout.EAST);
		pnlTabelaAtendimento.setLayout(new CardLayout(0, 0));

		scrollAtendimento = new JScrollPane();
		scrollAtendimento.setMinimumSize(new Dimension(15, 15));
		pnlTabelaAtendimento.add(scrollAtendimento, "name_7529993937869");

		tblAtendimento = new JTable();
		tblAtendimento.setFillsViewportHeight(true);
		tblAtendimento.setPreferredScrollableViewportSize(new Dimension(200, 200));
		modeloAtendimento = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Medico", "Paciente" });
		tblAtendimento.setModel(modeloAtendimento);
		tblAtendimento.getColumnModel().getColumn(0).setPreferredWidth(15);
		scrollAtendimento.setViewportView(tblAtendimento);

		pnlMedico = new JPanel();
		pnl_Geral.add(pnlMedico, BorderLayout.CENTER);
		pnlMedico.setLayout(new CardLayout(0, 0));

		scrollPane = new JScrollPane();
		pnlMedico.add(scrollPane, "name_9232620015837");

		modeloMedico = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "M\u00E9dico", "Especializa\u00E7\u00E3o" });
		tblMedicos = new JTable();
		tblMedicos.setModel(modeloMedico);

		scrollPane.setViewportView(tblMedicos);
		tblMedicos.setPreferredScrollableViewportSize(new Dimension(200, 200));
		tblMedicos.setFillsViewportHeight(true);

	}

	void addNaFila(int prioridade, Estruturas estruturas) {
		int index = tblClienteCad.getSelectedRow();
		modeloCadCliente.getValueAt(index, 0);
		estruturas.verificaCadPaciente(index).setCondicao(prioridade);
		Paciente pacientep = new Paciente(estruturas.verificaCadPaciente(index).getId(),
				estruturas.verificaCadPaciente(index).getNome(), estruturas.verificaCadPaciente(index).getSobrenome(),
				estruturas.verificaCadPaciente(index).getGenero(), estruturas.verificaCadPaciente(index).getCpf(),
				estruturas.verificaCadPaciente(index).getEmail(), prioridade);
		estruturas.addPaciente(pacientep);
		estruturas.getFilaPaciente();
		populaTabelaPaciente(estruturas);

	}

	void criaAcoes(Estruturas estruturas) {
		btnPesquisa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisaTabela(txtPesquisaDeMedicos, pesquisaM);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnPesquisacliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisaTabela(txtPesquisaCliente, pesquisaP);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnLiberar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (estruturas.getAtendimento().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Erro Atendimento Vazio:");
				} else {

					if (tblAtendimento.getSelectionModel().isSelectionEmpty()) {
						estruturas.finalizaAtendimento();
						populaTabelaAtendimento(estruturas);
					} else {
						estruturas.finalizaAtendimento(tblAtendimento.getSelectedRow());
						populaTabelaAtendimento(estruturas);
					}

				}

			}
		});

		btnAtender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					estruturas.atenderProximo();
					populaTabelaEntMed(estruturas);
					populaTabelaPaciente(estruturas);
					populaTabelaAtendimento(estruturas);
				} catch (Exception eAt) {
					JOptionPane.showMessageDialog(rootPane, eAt);

				}

			}
		});

		btnEntrouMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer
							.parseInt(modeloCadCliente.getValueAt(tblEntradaMedicos.getSelectedRow(), 0).toString());

					estruturas.entrouMedico(estruturas.verificaMedico(id));
					populaTabelaEntMed(estruturas);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnAzul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addNaFila(0, estruturas);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addNaFila(1, estruturas);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnAmarelo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addNaFila(2, estruturas);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}

			}
		});

		btnLaranja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addNaFila(3, estruturas);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnVermelho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addNaFila(4, estruturas);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Launcher launcher = new Launcher(estruturas);
					ProntoSocorro.this.dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, e2);

				}
			}
		});
	}
}
