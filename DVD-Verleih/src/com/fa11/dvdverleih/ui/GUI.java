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
	private JPanel panelBorrow;
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
		
		this.panelBorrow = new JPanel();
		this.tabbedPane.addTab("DVD-Leihe", null, this.panelBorrow, null);
		GridBagLayout gbl_panelBorrow = new GridBagLayout();
		gbl_panelBorrow.columnWidths = new int[]{128, 128, 128, 0, 0};
		gbl_panelBorrow.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBorrow.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBorrow.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.panelBorrow.setLayout(gbl_panelBorrow);
		
		this.lblVorgangErfassen = new JLabel("Vorgang erfassen");
		this.lblVorgangErfassen.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVorgangErfassen = new GridBagConstraints();
		gbc_lblVorgangErfassen.gridwidth = 4;
		gbc_lblVorgangErfassen.anchor = GridBagConstraints.WEST;
		gbc_lblVorgangErfassen.insets = new Insets(0, 0, 5, 0);
		gbc_lblVorgangErfassen.gridx = 0;
		gbc_lblVorgangErfassen.gridy = 0;
		this.panelBorrow.add(this.lblVorgangErfassen, gbc_lblVorgangErfassen);
		
		this.txtCustomerNo = new JTextField();
		GridBagConstraints gbc_txtCustomerNo = new GridBagConstraints();
		gbc_txtCustomerNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerNo.gridx = 0;
		gbc_txtCustomerNo.gridy = 1;
		this.panelBorrow.add(this.txtCustomerNo, gbc_txtCustomerNo);
		this.txtCustomerNo.setColumns(10);
		
		this.txtCustomerFirstName = new JTextField();
		this.txtCustomerFirstName.setEditable(false);
		GridBagConstraints gbc_txtCustomerFirstName = new GridBagConstraints();
		gbc_txtCustomerFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerFirstName.gridx = 1;
		gbc_txtCustomerFirstName.gridy = 1;
		this.panelBorrow.add(this.txtCustomerFirstName, gbc_txtCustomerFirstName);
		this.txtCustomerFirstName.setColumns(10);
		
		this.txtCustomerLastName = new JTextField();
		this.txtCustomerLastName.setEditable(false);
		GridBagConstraints gbc_txtCustomerLastName = new GridBagConstraints();
		gbc_txtCustomerLastName.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerLastName.gridx = 2;
		gbc_txtCustomerLastName.gridy = 1;
		this.panelBorrow.add(this.txtCustomerLastName, gbc_txtCustomerLastName);
		this.txtCustomerLastName.setColumns(10);
		
		this.lblKundennr = new JLabel("Kunden-Nummer");
		GridBagConstraints gbc_lblKundennr = new GridBagConstraints();
		gbc_lblKundennr.anchor = GridBagConstraints.WEST;
		gbc_lblKundennr.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennr.gridx = 0;
		gbc_lblKundennr.gridy = 2;
		this.panelBorrow.add(this.lblKundennr, gbc_lblKundennr);
		
		this.lblVorname = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.WEST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 1;
		gbc_lblVorname.gridy = 2;
		this.panelBorrow.add(this.lblVorname, gbc_lblVorname);
		
		this.lblNachname = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.WEST;
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.gridx = 2;
		gbc_lblNachname.gridy = 2;
		this.panelBorrow.add(this.lblNachname, gbc_lblNachname);
		
		this.txtDVDNo = new JTextField();
		GridBagConstraints gbc_txtDVDNo = new GridBagConstraints();
		gbc_txtDVDNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDVDNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDVDNo.gridx = 0;
		gbc_txtDVDNo.gridy = 3;
		this.panelBorrow.add(this.txtDVDNo, gbc_txtDVDNo);
		this.txtDVDNo.setColumns(10);
		
		this.txtDVDTitle = new JTextField();
		GridBagConstraints gbc_txtDVDTitle = new GridBagConstraints();
		gbc_txtDVDTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtDVDTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDVDTitle.gridx = 1;
		gbc_txtDVDTitle.gridy = 3;
		this.panelBorrow.add(this.txtDVDTitle, gbc_txtDVDTitle);
		this.txtDVDTitle.setColumns(10);
		
		this.chckbxDvdavailable = new JCheckBox("Verf\u00FCgbar?");
		this.chckbxDvdavailable.setEnabled(false);
		GridBagConstraints gbc_chckbxDvdavailable = new GridBagConstraints();
		gbc_chckbxDvdavailable.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDvdavailable.gridx = 2;
		gbc_chckbxDvdavailable.gridy = 3;
		this.panelBorrow.add(this.chckbxDvdavailable, gbc_chckbxDvdavailable);
		
		this.lblDvdnr = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDvdnr = new GridBagConstraints();
		gbc_lblDvdnr.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDvdnr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdnr.gridx = 0;
		gbc_lblDvdnr.gridy = 4;
		this.panelBorrow.add(this.lblDvdnr, gbc_lblDvdnr);
		
		this.lblDvdtitel = new JLabel("DVD-Titel");
		GridBagConstraints gbc_lblDvdtitel = new GridBagConstraints();
		gbc_lblDvdtitel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDvdtitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdtitel.gridx = 1;
		gbc_lblDvdtitel.gridy = 4;
		this.panelBorrow.add(this.lblDvdtitel, gbc_lblDvdtitel);
		
		this.panelBorrowButtons = new JPanel();
		GridBagConstraints gbc_panelBorrowButtons = new GridBagConstraints();
		gbc_panelBorrowButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelBorrowButtons.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelBorrowButtons.gridx = 2;
		gbc_panelBorrowButtons.gridy = 4;
		this.panelBorrow.add(this.panelBorrowButtons, gbc_panelBorrowButtons);
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
		this.panelBorrow.add(this.lblLeihvorgngeDesKunden, gbc_lblLeihvorgngeDesKunden);
		
		this.scrollPaneLendings = new JScrollPane();
		GridBagConstraints gbc_scrollPaneLendings = new GridBagConstraints();
		gbc_scrollPaneLendings.gridwidth = 4;
		gbc_scrollPaneLendings.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneLendings.gridx = 0;
		gbc_scrollPaneLendings.gridy = 6;
		this.panelBorrow.add(this.scrollPaneLendings, gbc_scrollPaneLendings);
		
		this.panelDVDs = new JPanel();
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDVDs, null);
		
		this.panelCustomers = new JPanel();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers, null);
	}

}
