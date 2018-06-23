package br.prontoSocorro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import br.prontoSocorro.data.Estruturas;
import br.prontoSocorro.data.Medico;
import br.prontoSocorro.data.Paciente;

import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;

public class JanelaAdministracao extends JFrame {

	private JPanel contentPane, panelCadastroClientes;
	private JTextField txtEmailDoMedico, txtEspecialidadeDoMdico, txtNomeDoMdico, txtSobrenomeDoMdico,
			txtPacienteSobrenome, txtNomePaciente, txtCpfPaciente, txtEmailPaciente;
	private JTabbedPane tabbedPane;
	private JPanel panelCadastroMedicos, pnlEmergencia;
	private GridBagLayout gbl_panelCadastroMedicos, gbl_panelCadastroClientes;
	private JLabel lblNome, lblSobrenome, lblEmailMedico, lblEpecialidade, lblNome_1, lblSobrenome_1, lblGnero_1,
			lblCpf, lblEmail_1, lblCondio;
	private GridBagConstraints gbc_txtNomeDoMdico, gbc_lblSobrenome, gbc_lblNome, gbc_txtSobrenomeDoMdico, gbc_lblGnero,
			gbc_comboGeneroMedico, gbc_lblEmailMedico, gbc_txtEmailDoMedico, gbc_lblEpecialidade,
			gbc_txtEspecialidadeDoMdico, gbc_btnCadastrarMdico, gbc_lblNome_1, gbc_txtNomePaciente, gbc_lblSobrenome_1,
			gbc_txtPacienteSobrenome, gbc_lblGnero_1, gbc_comboGeneroPaciente, gbc_lblCpf, gbc_txtCpfPaciente,
			gbc_lblEmail_1, gbc_pnlEmergencia, gbc_btnCadastrar, gbc_txtEmailPaciente;
	private JComboBox<String> comboGeneroMedico, comboGeneroPaciente;
	private JButton btnCadastrarMdico, btnCadastrar;
	private JRadioButton rdbtnAzul, rdbtnAmarelo, rdbtnVerde, rdbtnVermelho;
	private final ButtonGroup btgPrioridade = new ButtonGroup();
	private JRadioButton rdbtnLaranja;
	private JPanel pnlVoltar;
	private JButton btnVoltar;

	public JanelaAdministracao(Estruturas estruturas) {
		setTitle("Give me Blood!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 587);
		componentesAbaCadMedico();
		componentesAbaCadPaciente();
		acoes(estruturas);
		this.setVisible(true);

	}

	int getPrioridade() {
		if (btgPrioridade.getSelection().equals(rdbtnAzul)) {
			return 0;
		} else if (btgPrioridade.getSelection().equals(rdbtnVerde)) {
			return 1;
		} else if (btgPrioridade.getSelection().equals(rdbtnAmarelo)) {
			return 2;
		} else if (btgPrioridade.getSelection().equals(rdbtnLaranja)) {
			return 3;
		} else if (btgPrioridade.getSelection().equals(rdbtnVermelho)) {
			return 4;
		} else {
			return 0;
		}
	}

	void acoes(Estruturas estruturas) {
		btnCadastrarMdico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Medico novoMedico = new Medico(txtNomeDoMdico.getText(), txtSobrenomeDoMdico.getText(),
						comboGeneroMedico.getSelectedItem().toString(), txtCpfPaciente.getText(),
						txtEmailDoMedico.getText(), txtEspecialidadeDoMdico.getText());
				estruturas.addCadastraMedico(novoMedico);
				System.out.println(novoMedico.toString());

			}
		});

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Paciente novoPaciente = new Paciente(txtNomePaciente.getText(), txtPacienteSobrenome.getText(),
						comboGeneroPaciente.getSelectedItem().toString(), txtCpfPaciente.getText(),
						txtEmailPaciente.getText(), getPrioridade());
				estruturas.addPaciente(novoPaciente);
			}

		});

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Launcher launcher = new Launcher(estruturas);
				JanelaAdministracao.this.dispose();
			}
		});

	}

	void componentesAbaCadMedico() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panelCadastroMedicos = new JPanel();
		panelCadastroMedicos.setName("Cadastro de Medicos");
		tabbedPane.addTab("CadastroMedicos", null, panelCadastroMedicos, null);
		gbl_panelCadastroMedicos = new GridBagLayout();
		gbl_panelCadastroMedicos.columnWidths = new int[] { 49, 224, 86, 371, 116, 32, 0 };
		gbl_panelCadastroMedicos.rowHeights = new int[] { 24, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCadastroMedicos.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCadastroMedicos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelCadastroMedicos.setLayout(gbl_panelCadastroMedicos);

		lblNome = new JLabel("Nome :");
		gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panelCadastroMedicos.add(lblNome, gbc_lblNome);

		txtNomeDoMdico = new JTextField();
		txtNomeDoMdico.setText("Nome do Médico");
		gbc_txtNomeDoMdico = new GridBagConstraints();
		gbc_txtNomeDoMdico.gridwidth = 3;
		gbc_txtNomeDoMdico.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomeDoMdico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeDoMdico.gridx = 1;
		gbc_txtNomeDoMdico.gridy = 0;
		panelCadastroMedicos.add(txtNomeDoMdico, gbc_txtNomeDoMdico);
		txtNomeDoMdico.setColumns(10);

		lblSobrenome = new JLabel("Sobrenome:");
		gbc_lblSobrenome = new GridBagConstraints();
		gbc_lblSobrenome.anchor = GridBagConstraints.EAST;
		gbc_lblSobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobrenome.gridx = 0;
		gbc_lblSobrenome.gridy = 1;
		panelCadastroMedicos.add(lblSobrenome, gbc_lblSobrenome);

		txtSobrenomeDoMdico = new JTextField();
		txtSobrenomeDoMdico.setText("Sobrenome do Médico");
		gbc_txtSobrenomeDoMdico = new GridBagConstraints();
		gbc_txtSobrenomeDoMdico.gridwidth = 3;
		gbc_txtSobrenomeDoMdico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSobrenomeDoMdico.insets = new Insets(0, 0, 5, 5);
		gbc_txtSobrenomeDoMdico.gridx = 1;
		gbc_txtSobrenomeDoMdico.gridy = 1;
		panelCadastroMedicos.add(txtSobrenomeDoMdico, gbc_txtSobrenomeDoMdico);
		txtSobrenomeDoMdico.setColumns(10);

		JLabel lblGnero = new JLabel("Gênero :");
		lblGnero.setHorizontalAlignment(SwingConstants.RIGHT);
		gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.EAST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 2;
		panelCadastroMedicos.add(lblGnero, gbc_lblGnero);

		comboGeneroMedico = new JComboBox<String>();
		comboGeneroMedico.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Masculino", "Feminino", "Transgênero", "Não definido" }));
		comboGeneroMedico.setMaximumRowCount(20);
		gbc_comboGeneroMedico = new GridBagConstraints();
		gbc_comboGeneroMedico.gridwidth = 3;
		gbc_comboGeneroMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboGeneroMedico.insets = new Insets(0, 0, 5, 5);
		gbc_comboGeneroMedico.anchor = GridBagConstraints.NORTH;
		gbc_comboGeneroMedico.gridx = 1;
		gbc_comboGeneroMedico.gridy = 2;
		panelCadastroMedicos.add(comboGeneroMedico, gbc_comboGeneroMedico);

		lblEmailMedico = new JLabel("Email :");
		gbc_lblEmailMedico = new GridBagConstraints();
		gbc_lblEmailMedico.anchor = GridBagConstraints.EAST;
		gbc_lblEmailMedico.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailMedico.gridx = 0;
		gbc_lblEmailMedico.gridy = 3;
		panelCadastroMedicos.add(lblEmailMedico, gbc_lblEmailMedico);

		txtEmailDoMedico = new JTextField();
		txtEmailDoMedico.setText("email@email.com");
		gbc_txtEmailDoMedico = new GridBagConstraints();
		gbc_txtEmailDoMedico.gridwidth = 3;
		gbc_txtEmailDoMedico.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmailDoMedico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailDoMedico.gridx = 1;
		gbc_txtEmailDoMedico.gridy = 3;
		panelCadastroMedicos.add(txtEmailDoMedico, gbc_txtEmailDoMedico);
		txtEmailDoMedico.setColumns(10);

		lblEpecialidade = new JLabel("Epecialidade :");
		gbc_lblEpecialidade = new GridBagConstraints();
		gbc_lblEpecialidade.anchor = GridBagConstraints.EAST;
		gbc_lblEpecialidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblEpecialidade.gridx = 0;
		gbc_lblEpecialidade.gridy = 4;
		panelCadastroMedicos.add(lblEpecialidade, gbc_lblEpecialidade);

		txtEspecialidadeDoMdico = new JTextField();
		txtEspecialidadeDoMdico.setText("Especialidade do Médico");
		gbc_txtEspecialidadeDoMdico = new GridBagConstraints();
		gbc_txtEspecialidadeDoMdico.gridwidth = 3;
		gbc_txtEspecialidadeDoMdico.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecialidadeDoMdico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecialidadeDoMdico.gridx = 1;
		gbc_txtEspecialidadeDoMdico.gridy = 4;
		panelCadastroMedicos.add(txtEspecialidadeDoMdico, gbc_txtEspecialidadeDoMdico);
		txtEspecialidadeDoMdico.setColumns(10);

		btnCadastrarMdico = new JButton("CADASTRAR MÉDICO");
		gbc_btnCadastrarMdico = new GridBagConstraints();
		gbc_btnCadastrarMdico.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCadastrarMdico.insets = new Insets(0, 0, 5, 5);
		gbc_btnCadastrarMdico.gridx = 1;
		gbc_btnCadastrarMdico.gridy = 5;
		panelCadastroMedicos.add(btnCadastrarMdico, gbc_btnCadastrarMdico);

		pnlVoltar = new JPanel();
		contentPane.add(pnlVoltar, BorderLayout.SOUTH);

		btnVoltar = new JButton("VOLTAR");
		pnlVoltar.add(btnVoltar);

	}

	void componentesAbaCadPaciente() {
		panelCadastroClientes = new JPanel();
		tabbedPane.addTab("Cadastro de Clientes", null, panelCadastroClientes, null);
		gbl_panelCadastroClientes = new GridBagLayout();
		gbl_panelCadastroClientes.columnWidths = new int[] { 123, 209, 114, 81, 114, 0 };
		gbl_panelCadastroClientes.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0 };
		gbl_panelCadastroClientes.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCadastroClientes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCadastroClientes.setLayout(gbl_panelCadastroClientes);

		lblNome_1 = new JLabel("Nome:");
		gbc_lblNome_1 = new GridBagConstraints();
		gbc_lblNome_1.anchor = GridBagConstraints.EAST;
		gbc_lblNome_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome_1.gridx = 0;
		gbc_lblNome_1.gridy = 0;
		panelCadastroClientes.add(lblNome_1, gbc_lblNome_1);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setText("Nome do Paciente");
		gbc_txtNomePaciente = new GridBagConstraints();
		gbc_txtNomePaciente.gridwidth = 3;
		gbc_txtNomePaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomePaciente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomePaciente.anchor = GridBagConstraints.NORTH;
		gbc_txtNomePaciente.gridx = 1;
		gbc_txtNomePaciente.gridy = 0;
		panelCadastroClientes.add(txtNomePaciente, gbc_txtNomePaciente);
		txtNomePaciente.setColumns(10);

		lblSobrenome_1 = new JLabel("Sobrenome:");
		gbc_lblSobrenome_1 = new GridBagConstraints();
		gbc_lblSobrenome_1.anchor = GridBagConstraints.EAST;
		gbc_lblSobrenome_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobrenome_1.gridx = 0;
		gbc_lblSobrenome_1.gridy = 1;
		panelCadastroClientes.add(lblSobrenome_1, gbc_lblSobrenome_1);

		txtPacienteSobrenome = new JTextField();
		txtPacienteSobrenome.setText("Sobrenome do Paciente");
		gbc_txtPacienteSobrenome = new GridBagConstraints();
		gbc_txtPacienteSobrenome.gridwidth = 3;
		gbc_txtPacienteSobrenome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPacienteSobrenome.anchor = GridBagConstraints.NORTH;
		gbc_txtPacienteSobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_txtPacienteSobrenome.gridx = 1;
		gbc_txtPacienteSobrenome.gridy = 1;
		panelCadastroClientes.add(txtPacienteSobrenome, gbc_txtPacienteSobrenome);
		txtPacienteSobrenome.setColumns(10);

		lblGnero_1 = new JLabel("Gênero:");
		gbc_lblGnero_1 = new GridBagConstraints();
		gbc_lblGnero_1.anchor = GridBagConstraints.EAST;
		gbc_lblGnero_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero_1.gridx = 0;
		gbc_lblGnero_1.gridy = 2;
		panelCadastroClientes.add(lblGnero_1, gbc_lblGnero_1);

		comboGeneroPaciente = new JComboBox();
		comboGeneroPaciente.setModel(
				new DefaultComboBoxModel(new String[] { "Masculino", "Femino", "Transgênero", "Não Definido" }));
		gbc_comboGeneroPaciente = new GridBagConstraints();
		gbc_comboGeneroPaciente.gridwidth = 3;
		gbc_comboGeneroPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_comboGeneroPaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboGeneroPaciente.gridx = 1;
		gbc_comboGeneroPaciente.gridy = 2;
		panelCadastroClientes.add(comboGeneroPaciente, gbc_comboGeneroPaciente);

		lblCpf = new JLabel("CPF:");
		gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 3;
		panelCadastroClientes.add(lblCpf, gbc_lblCpf);

		txtCpfPaciente = new JTextField();
		txtCpfPaciente.setText("CPF");
		gbc_txtCpfPaciente = new GridBagConstraints();
		gbc_txtCpfPaciente.gridwidth = 3;
		gbc_txtCpfPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCpfPaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpfPaciente.gridx = 1;
		gbc_txtCpfPaciente.gridy = 3;
		panelCadastroClientes.add(txtCpfPaciente, gbc_txtCpfPaciente);
		txtCpfPaciente.setColumns(10);

		lblEmail_1 = new JLabel("Email:");
		gbc_lblEmail_1 = new GridBagConstraints();
		gbc_lblEmail_1.anchor = GridBagConstraints.EAST;
		gbc_lblEmail_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail_1.gridx = 0;
		gbc_lblEmail_1.gridy = 4;
		panelCadastroClientes.add(lblEmail_1, gbc_lblEmail_1);

		txtEmailPaciente = new JTextField();
		txtEmailPaciente.setText("EMAIL");
		gbc_txtEmailPaciente = new GridBagConstraints();
		gbc_txtEmailPaciente.gridwidth = 3;
		gbc_txtEmailPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmailPaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailPaciente.gridx = 1;
		gbc_txtEmailPaciente.gridy = 4;
		panelCadastroClientes.add(txtEmailPaciente, gbc_txtEmailPaciente);
		txtEmailPaciente.setColumns(10);

		lblCondio = new JLabel("Condição:");
		GridBagConstraints gbc_lblCondio = new GridBagConstraints();
		gbc_lblCondio.anchor = GridBagConstraints.EAST;
		gbc_lblCondio.insets = new Insets(0, 0, 0, 5);
		gbc_lblCondio.gridx = 0;
		gbc_lblCondio.gridy = 5;
		panelCadastroClientes.add(lblCondio, gbc_lblCondio);

		pnlEmergencia = new JPanel();
		gbc_pnlEmergencia = new GridBagConstraints();
		gbc_pnlEmergencia.anchor = GridBagConstraints.WEST;
		gbc_pnlEmergencia.insets = new Insets(0, 0, 0, 5);
		gbc_pnlEmergencia.fill = GridBagConstraints.VERTICAL;
		gbc_pnlEmergencia.gridx = 1;
		gbc_pnlEmergencia.gridy = 5;
		panelCadastroClientes.add(pnlEmergencia, gbc_pnlEmergencia);
		pnlEmergencia.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		rdbtnAzul = new JRadioButton("Azul");
		btgPrioridade.add(rdbtnAzul);
		rdbtnAzul.setBackground(Color.BLUE);
		rdbtnAzul.setForeground(Color.WHITE);
		pnlEmergencia.add(rdbtnAzul);

		rdbtnVerde = new JRadioButton("Verde");
		btgPrioridade.add(rdbtnVerde);
		rdbtnVerde.setBackground(new Color(0, 102, 51));
		rdbtnVerde.setForeground(Color.WHITE);
		pnlEmergencia.add(rdbtnVerde);

		rdbtnAmarelo = new JRadioButton("Amarelo");
		btgPrioridade.add(rdbtnAmarelo);
		rdbtnAmarelo.setBackground(new Color(255, 204, 51));
		rdbtnAmarelo.setForeground(Color.WHITE);
		pnlEmergencia.add(rdbtnAmarelo);

		rdbtnLaranja = new JRadioButton("Laranja");
		btgPrioridade.add(rdbtnLaranja);
		rdbtnLaranja.setForeground(Color.WHITE);
		rdbtnLaranja.setBackground(new Color(255, 165, 0));
		pnlEmergencia.add(rdbtnLaranja);

		rdbtnVermelho = new JRadioButton("Vermelho");
		btgPrioridade.add(rdbtnVermelho);
		rdbtnVermelho.setBackground(new Color(153, 0, 0));
		rdbtnVermelho.setForeground(Color.WHITE);
		pnlEmergencia.add(rdbtnVermelho);

		btnCadastrar = new JButton("Cadastrar");
		gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCadastrar.gridwidth = 2;
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 2;
		gbc_btnCadastrar.gridy = 5;
		panelCadastroClientes.add(btnCadastrar, gbc_btnCadastrar);
	}
}
