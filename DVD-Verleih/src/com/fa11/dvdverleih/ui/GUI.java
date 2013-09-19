package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * Grafische Benutzeroberfläche für den DVD-Verleih mit Swing.
 * @author Timo Raschke
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = -3004396365580658126L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JTabbedPane tabbedPane;
	private JPanel panelLending;
	private JPanel panelDVDs;
	private JPanel panelCustomers;
	private JLabel lblVorgangErfassen;
	private JTextField txtCustomerNo;
	private JTextField txtCustomerFirstName;
	private JTextField txtCustomerLastName;
	private JLabel lblKundennr;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JTextField txtDVDNo;
	private JTextField txtDVDTitle;
	private JCheckBox chckbxDvdavailable;
	private JLabel lblDvdnr;
	private JLabel lblDvdtitel;
	private JPanel panelBorrowButtons;
	private JButton btnPrfen;
	private JButton btnOk;
	private JScrollPane scrollPaneLendings;
	private JLabel lblLeihvorgngeDesKunden;
	private JLabel lblVorgangErfassen_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblDVDNo;
	private JLabel lblDVDTitel;
	private JLabel lblDVDGenre;
	private JLabel lblDVDYear;
	private JPanel panelDVDButtons;
	private JButton btnZurcksetzen;
	private JButton btnSpeichern;
	private JLabel lblVorhandeneDvds;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("DVD-Verleih");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 417);
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane.add(this.tabbedPane, BorderLayout.CENTER);
		
		this.panelLending = new JPanel();
		this.tabbedPane.addTab("DVD-Leihe", null, this.panelLending, null);
		GridBagLayout gbl_panelLending = new GridBagLayout();
		gbl_panelLending.columnWidths = new int[]{128, 128, 128, 0, 0};
		gbl_panelLending.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLending.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelLending.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.panelLending.setLayout(gbl_panelLending);
		
		this.lblVorgangErfassen = new JLabel("Vorgang erfassen");
		this.lblVorgangErfassen.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVorgangErfassen = new GridBagConstraints();
		gbc_lblVorgangErfassen.gridwidth = 4;
		gbc_lblVorgangErfassen.anchor = GridBagConstraints.WEST;
		gbc_lblVorgangErfassen.insets = new Insets(0, 0, 5, 0);
		gbc_lblVorgangErfassen.gridx = 0;
		gbc_lblVorgangErfassen.gridy = 0;
		this.panelLending.add(this.lblVorgangErfassen, gbc_lblVorgangErfassen);
		
		this.txtCustomerNo = new JTextField();
		GridBagConstraints gbc_txtCustomerNo = new GridBagConstraints();
		gbc_txtCustomerNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerNo.gridx = 0;
		gbc_txtCustomerNo.gridy = 1;
		this.panelLending.add(this.txtCustomerNo, gbc_txtCustomerNo);
		this.txtCustomerNo.setColumns(10);
		
		this.txtCustomerFirstName = new JTextField();
		this.txtCustomerFirstName.setEditable(false);
		GridBagConstraints gbc_txtCustomerFirstName = new GridBagConstraints();
		gbc_txtCustomerFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerFirstName.gridx = 1;
		gbc_txtCustomerFirstName.gridy = 1;
		this.panelLending.add(this.txtCustomerFirstName, gbc_txtCustomerFirstName);
		this.txtCustomerFirstName.setColumns(10);
		
		this.txtCustomerLastName = new JTextField();
		this.txtCustomerLastName.setEditable(false);
		GridBagConstraints gbc_txtCustomerLastName = new GridBagConstraints();
		gbc_txtCustomerLastName.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerLastName.gridx = 2;
		gbc_txtCustomerLastName.gridy = 1;
		this.panelLending.add(this.txtCustomerLastName, gbc_txtCustomerLastName);
		this.txtCustomerLastName.setColumns(10);
		
		this.lblKundennr = new JLabel("Kunden-Nummer");
		GridBagConstraints gbc_lblKundennr = new GridBagConstraints();
		gbc_lblKundennr.anchor = GridBagConstraints.WEST;
		gbc_lblKundennr.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennr.gridx = 0;
		gbc_lblKundennr.gridy = 2;
		this.panelLending.add(this.lblKundennr, gbc_lblKundennr);
		
		this.lblVorname = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.WEST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 1;
		gbc_lblVorname.gridy = 2;
		this.panelLending.add(this.lblVorname, gbc_lblVorname);
		
		this.lblNachname = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.WEST;
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.gridx = 2;
		gbc_lblNachname.gridy = 2;
		this.panelLending.add(this.lblNachname, gbc_lblNachname);
		
		this.txtDVDNo = new JTextField();
		GridBagConstraints gbc_txtDVDNo = new GridBagConstraints();
		gbc_txtDVDNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDVDNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDVDNo.gridx = 0;
		gbc_txtDVDNo.gridy = 3;
		this.panelLending.add(this.txtDVDNo, gbc_txtDVDNo);
		this.txtDVDNo.setColumns(10);
		
		this.txtDVDTitle = new JTextField();
		GridBagConstraints gbc_txtDVDTitle = new GridBagConstraints();
		gbc_txtDVDTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtDVDTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDVDTitle.gridx = 1;
		gbc_txtDVDTitle.gridy = 3;
		this.panelLending.add(this.txtDVDTitle, gbc_txtDVDTitle);
		this.txtDVDTitle.setColumns(10);
		
		this.chckbxDvdavailable = new JCheckBox("Verf\u00FCgbar?");
		this.chckbxDvdavailable.setEnabled(false);
		GridBagConstraints gbc_chckbxDvdavailable = new GridBagConstraints();
		gbc_chckbxDvdavailable.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDvdavailable.gridx = 2;
		gbc_chckbxDvdavailable.gridy = 3;
		this.panelLending.add(this.chckbxDvdavailable, gbc_chckbxDvdavailable);
		
		this.lblDvdnr = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDvdnr = new GridBagConstraints();
		gbc_lblDvdnr.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDvdnr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdnr.gridx = 0;
		gbc_lblDvdnr.gridy = 4;
		this.panelLending.add(this.lblDvdnr, gbc_lblDvdnr);
		
		this.lblDvdtitel = new JLabel("DVD-Titel");
		GridBagConstraints gbc_lblDvdtitel = new GridBagConstraints();
		gbc_lblDvdtitel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDvdtitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdtitel.gridx = 1;
		gbc_lblDvdtitel.gridy = 4;
		this.panelLending.add(this.lblDvdtitel, gbc_lblDvdtitel);
		
		this.panelBorrowButtons = new JPanel();
		GridBagConstraints gbc_panelBorrowButtons = new GridBagConstraints();
		gbc_panelBorrowButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelBorrowButtons.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelBorrowButtons.gridx = 2;
		gbc_panelBorrowButtons.gridy = 4;
		this.panelLending.add(this.panelBorrowButtons, gbc_panelBorrowButtons);
		GridBagLayout gbl_panelBorrowButtons = new GridBagLayout();
		gbl_panelBorrowButtons.columnWidths = new int[]{0, 0, 0};
		gbl_panelBorrowButtons.rowHeights = new int[]{0, 0};
		gbl_panelBorrowButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBorrowButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panelBorrowButtons.setLayout(gbl_panelBorrowButtons);
		
		this.btnPrfen = new JButton("Pr\u00FCfen");
		GridBagConstraints gbc_btnPrfen = new GridBagConstraints();
		gbc_btnPrfen.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrfen.gridx = 0;
		gbc_btnPrfen.gridy = 0;
		this.panelBorrowButtons.add(this.btnPrfen, gbc_btnPrfen);
		
		this.btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 0;
		this.panelBorrowButtons.add(this.btnOk, gbc_btnOk);
		
		this.lblLeihvorgngeDesKunden = new JLabel("Leihvorg\u00E4nge des Kunden");
		this.lblLeihvorgngeDesKunden.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblLeihvorgngeDesKunden = new GridBagConstraints();
		gbc_lblLeihvorgngeDesKunden.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLeihvorgngeDesKunden.gridwidth = 4;
		gbc_lblLeihvorgngeDesKunden.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeihvorgngeDesKunden.gridx = 0;
		gbc_lblLeihvorgngeDesKunden.gridy = 5;
		this.panelLending.add(this.lblLeihvorgngeDesKunden, gbc_lblLeihvorgngeDesKunden);
		
		this.scrollPaneLendings = new JScrollPane();
		GridBagConstraints gbc_scrollPaneLendings = new GridBagConstraints();
		gbc_scrollPaneLendings.gridwidth = 4;
		gbc_scrollPaneLendings.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneLendings.gridx = 0;
		gbc_scrollPaneLendings.gridy = 6;
		this.panelLending.add(this.scrollPaneLendings, gbc_scrollPaneLendings);
		
		this.panelDVDs = new JPanel();
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDVDs, null);
		GridBagLayout gbl_panelDVDs = new GridBagLayout();
		gbl_panelDVDs.columnWidths = new int[]{128, 128, 128, 128, 0, 0};
		gbl_panelDVDs.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelDVDs.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelDVDs.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.panelDVDs.setLayout(gbl_panelDVDs);
		
		this.lblVorgangErfassen_1 = new JLabel("Vorgang erfassen");
		this.lblVorgangErfassen_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVorgangErfassen_1 = new GridBagConstraints();
		gbc_lblVorgangErfassen_1.gridwidth = 4;
		gbc_lblVorgangErfassen_1.anchor = GridBagConstraints.WEST;
		gbc_lblVorgangErfassen_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorgangErfassen_1.gridx = 0;
		gbc_lblVorgangErfassen_1.gridy = 0;
		this.panelDVDs.add(this.lblVorgangErfassen_1, gbc_lblVorgangErfassen_1);
		
		this.textField = new JTextField();
		this.textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		this.panelDVDs.add(this.textField, gbc_textField);
		this.textField.setColumns(10);
		
		this.textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		this.panelDVDs.add(this.textField_1, gbc_textField_1);
		this.textField_1.setColumns(10);
		
		this.textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 1;
		this.panelDVDs.add(this.textField_2, gbc_textField_2);
		this.textField_2.setColumns(10);
		
		this.textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 1;
		this.panelDVDs.add(this.textField_3, gbc_textField_3);
		this.textField_3.setColumns(10);
		
		this.lblDVDNo = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDVDNo = new GridBagConstraints();
		gbc_lblDVDNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDVDNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDNo.gridx = 0;
		gbc_lblDVDNo.gridy = 2;
		this.panelDVDs.add(this.lblDVDNo, gbc_lblDVDNo);
		
		this.lblDVDTitel = new JLabel("DVD Titel");
		GridBagConstraints gbc_lblDVDTitel = new GridBagConstraints();
		gbc_lblDVDTitel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDVDTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDTitel.gridx = 1;
		gbc_lblDVDTitel.gridy = 2;
		this.panelDVDs.add(this.lblDVDTitel, gbc_lblDVDTitel);
		
		this.lblDVDGenre = new JLabel("DVD Genre");
		GridBagConstraints gbc_lblDVDGenre = new GridBagConstraints();
		gbc_lblDVDGenre.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDVDGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDGenre.gridx = 2;
		gbc_lblDVDGenre.gridy = 2;
		this.panelDVDs.add(this.lblDVDGenre, gbc_lblDVDGenre);
		
		this.lblDVDYear = new JLabel("Erscheinungsjahr");
		GridBagConstraints gbc_lblDVDYear = new GridBagConstraints();
		gbc_lblDVDYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDYear.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDVDYear.gridx = 3;
		gbc_lblDVDYear.gridy = 2;
		this.panelDVDs.add(this.lblDVDYear, gbc_lblDVDYear);
		
		this.panelDVDButtons = new JPanel();
		GridBagConstraints gbc_panelDVDButtons = new GridBagConstraints();
		gbc_panelDVDButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelDVDButtons.gridwidth = 2;
		gbc_panelDVDButtons.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelDVDButtons.gridx = 2;
		gbc_panelDVDButtons.gridy = 3;
		this.panelDVDs.add(this.panelDVDButtons, gbc_panelDVDButtons);
		GridBagLayout gbl_panelDVDButtons = new GridBagLayout();
		gbl_panelDVDButtons.columnWidths = new int[]{0, 0, 0};
		gbl_panelDVDButtons.rowHeights = new int[]{0, 0};
		gbl_panelDVDButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDVDButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panelDVDButtons.setLayout(gbl_panelDVDButtons);
		
		this.btnZurcksetzen = new JButton("Zur\u00FCcksetzen");
		GridBagConstraints gbc_btnZurcksetzen = new GridBagConstraints();
		gbc_btnZurcksetzen.insets = new Insets(0, 0, 0, 5);
		gbc_btnZurcksetzen.gridx = 0;
		gbc_btnZurcksetzen.gridy = 0;
		this.panelDVDButtons.add(this.btnZurcksetzen, gbc_btnZurcksetzen);
		
		this.btnSpeichern = new JButton("Speichern");
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.gridx = 1;
		gbc_btnSpeichern.gridy = 0;
		this.panelDVDButtons.add(this.btnSpeichern, gbc_btnSpeichern);
		
		this.lblVorhandeneDvds = new JLabel("Vorhandene DVDs");
		this.lblVorhandeneDvds.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVorhandeneDvds = new GridBagConstraints();
		gbc_lblVorhandeneDvds.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorhandeneDvds.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVorhandeneDvds.gridwidth = 4;
		gbc_lblVorhandeneDvds.gridx = 0;
		gbc_lblVorhandeneDvds.gridy = 4;
		this.panelDVDs.add(this.lblVorhandeneDvds, gbc_lblVorhandeneDvds);
		
		this.scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		this.panelDVDs.add(this.scrollPane, gbc_scrollPane);
		
		this.panelCustomers = new JPanel();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers, null);
	}

}
