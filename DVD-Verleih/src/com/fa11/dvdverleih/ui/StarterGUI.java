package com.fa11.dvdverleih.ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fa11.dvdverleih.datenhaltung.DatenhaltungFactory;
import com.fa11.dvdverleih.datenhaltung.DatenhaltungType;
import com.fa11.dvdverleih.fachkonzept.Fachkonzept;

/**
 * GUI zum Auswaehlen der Datenhaltung
 * 
 * @author Timo Raschke
 */
public class StarterGUI extends JFrame {

	private static final long serialVersionUID = -6090691783379043704L;
	private JPanel contentPane;
	private JLabel lblBitteTreffenSie;
	private JLabel lblDatenhaltung;
	private JComboBox<String> cmbData;
	private JButton btnStarten;

	/**
	 * StarterGUI erstellen
	 */
	public StarterGUI() {
		setResizable(false);
		setTitle("DVD-Verleih");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 140);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		this.contentPane.setLayout(gbl_contentPane);

		this.lblBitteTreffenSie = new JLabel("Bitte treffen Sie eine Auswahl");
		this.lblBitteTreffenSie.setFont(new Font("Segoe UI Semilight",
				Font.PLAIN, 20));
		GridBagConstraints gbc_lblBitteTreffenSie = new GridBagConstraints();
		gbc_lblBitteTreffenSie.anchor = GridBagConstraints.WEST;
		gbc_lblBitteTreffenSie.insets = new Insets(0, 0, 5, 0);
		gbc_lblBitteTreffenSie.gridx = 0;
		gbc_lblBitteTreffenSie.gridy = 0;
		this.contentPane.add(this.lblBitteTreffenSie, gbc_lblBitteTreffenSie);

		this.lblDatenhaltung = new JLabel("Datenhaltung");
		GridBagConstraints gbc_lblDatenhaltung = new GridBagConstraints();
		gbc_lblDatenhaltung.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatenhaltung.gridx = 0;
		gbc_lblDatenhaltung.gridy = 1;
		this.contentPane.add(this.lblDatenhaltung, gbc_lblDatenhaltung);

		this.btnStarten = new JButton("Starten");
		this.btnStarten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbData.getSelectedIndex() == 0) {
					// XML
					JFrame gui = new GUI(new Fachkonzept(DatenhaltungFactory
							.getDatenhaltung(DatenhaltungType.xml)));
					gui.setVisible(true);
					setVisible(false);
				} else if (cmbData.getSelectedIndex() == 1) {
					// SQLite
					JFrame gui = new GUI(new Fachkonzept(DatenhaltungFactory
							.getDatenhaltung(DatenhaltungType.sqlite)));
					gui.setVisible(true);
					setVisible(false);
				}
			}
		});

		this.cmbData = new JComboBox<String>();
		this.cmbData.setModel(new DefaultComboBoxModel<String>(new String[] {
				"XML", "SQLite" }));
		GridBagConstraints gbc_cmbData = new GridBagConstraints();
		gbc_cmbData.insets = new Insets(0, 0, 5, 0);
		gbc_cmbData.gridx = 0;
		gbc_cmbData.gridy = 2;
		this.contentPane.add(this.cmbData, gbc_cmbData);
		GridBagConstraints gbc_btnStarten = new GridBagConstraints();
		gbc_btnStarten.gridx = 0;
		gbc_btnStarten.gridy = 3;
		this.contentPane.add(this.btnStarten, gbc_btnStarten);
		pack();
		setLocationRelativeTo(null);
	}
}