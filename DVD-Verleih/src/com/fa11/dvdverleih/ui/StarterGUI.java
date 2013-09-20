package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;

public class StarterGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblBitteTreffenSie;
	private JLabel lblOberflche;
	private JLabel lblDatenhaltung;
	private JComboBox cmbUserInterface;
	private JComboBox cmbData;
	private JButton btnStarten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterGUI frame = new StarterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StarterGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StarterGUI.class.getResource("/com/fa11/dvdverleih/ui/ressources/dvd_unmount.png")));
		setResizable(false);
		setTitle("DVD-Verleih");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 140);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.contentPane.setLayout(gbl_contentPane);
		
		this.lblBitteTreffenSie = new JLabel("Bitte treffen Sie eine Auswahl");
		this.lblBitteTreffenSie.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBitteTreffenSie = new GridBagConstraints();
		gbc_lblBitteTreffenSie.anchor = GridBagConstraints.WEST;
		gbc_lblBitteTreffenSie.gridwidth = 2;
		gbc_lblBitteTreffenSie.insets = new Insets(0, 0, 5, 0);
		gbc_lblBitteTreffenSie.gridx = 0;
		gbc_lblBitteTreffenSie.gridy = 0;
		this.contentPane.add(this.lblBitteTreffenSie, gbc_lblBitteTreffenSie);
		
		this.lblOberflche = new JLabel("Oberfl\u00E4che");
		GridBagConstraints gbc_lblOberflche = new GridBagConstraints();
		gbc_lblOberflche.insets = new Insets(0, 0, 5, 5);
		gbc_lblOberflche.gridx = 0;
		gbc_lblOberflche.gridy = 1;
		this.contentPane.add(this.lblOberflche, gbc_lblOberflche);
		
		this.lblDatenhaltung = new JLabel("Datenhaltung");
		GridBagConstraints gbc_lblDatenhaltung = new GridBagConstraints();
		gbc_lblDatenhaltung.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatenhaltung.gridx = 1;
		gbc_lblDatenhaltung.gridy = 1;
		this.contentPane.add(this.lblDatenhaltung, gbc_lblDatenhaltung);
		
		this.cmbUserInterface = new JComboBox();
		this.cmbUserInterface.setModel(new DefaultComboBoxModel(new String[] {"GUI", "TUI"}));
		GridBagConstraints gbc_cmbUserInterface = new GridBagConstraints();
		gbc_cmbUserInterface.insets = new Insets(0, 0, 5, 5);
		gbc_cmbUserInterface.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUserInterface.gridx = 0;
		gbc_cmbUserInterface.gridy = 2;
		this.contentPane.add(this.cmbUserInterface, gbc_cmbUserInterface);
		
		this.cmbData = new JComboBox();
		this.cmbData.setModel(new DefaultComboBoxModel(new String[] {"XML", "SQLite"}));
		GridBagConstraints gbc_cmbData = new GridBagConstraints();
		gbc_cmbData.insets = new Insets(0, 0, 5, 0);
		gbc_cmbData.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbData.gridx = 1;
		gbc_cmbData.gridy = 2;
		this.contentPane.add(this.cmbData, gbc_cmbData);
		
		this.btnStarten = new JButton("Starten");
		GridBagConstraints gbc_btnStarten = new GridBagConstraints();
		gbc_btnStarten.gridwidth = 2;
		gbc_btnStarten.insets = new Insets(0, 0, 0, 5);
		gbc_btnStarten.gridx = 0;
		gbc_btnStarten.gridy = 3;
		this.contentPane.add(this.btnStarten, gbc_btnStarten);
		pack();
		setLocationRelativeTo(null);
	}

}
