package br.prontoSocorro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.prontoSocorro.data.Estruturas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JFrame {

	private JPanel contentPane;

	public Launcher(Estruturas estruturas) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 234);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAdministrao = new JButton("ADMINISTRAÇÃO");
		btnAdministrao.setBackground(Color.WHITE);
		contentPane.add(btnAdministrao);
		btnAdministrao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JanelaAdministracao admin = new JanelaAdministracao(estruturas);
			}
		});

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/home/joubertjoe/Imagens/Seleção_028.png"));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogo);

		JButton btnProntoSocorro = new JButton("PRONTO SOCORRO");
		btnProntoSocorro.setBackground(Color.WHITE);
		contentPane.add(btnProntoSocorro);
		btnProntoSocorro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ProntoSocorro gimeBlood = new ProntoSocorro(estruturas);
			}
		});

		this.setVisible(true);
	}
}
