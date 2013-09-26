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

import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;

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
	private JPanel panelDvd;
	private JPanel panelCustomers;
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
	private JTextField txtDvdNo;
	private JTextField txtDvdTitle;
	private JTextField txtDvdGenre;
	private JTextField txtDvdYear;
	private JLabel lblDVDNo;
	private JLabel lblDVDTitle;
	private JLabel lblDVDGenre;
	private JLabel lblDVDYear;
	private JPanel panelDVDButtons;
	private JButton btnZurcksetzen;
	private JButton btnSpeichern;
	private JPanel panelLendingControls;
	private JPanel panelLendingList;
	private JPanel panelDvdControls;
	private JPanel panelDvdList;
	private JPanel panelCustomersControls;
	private JPanel panelCustomersList;
	private JTextField txtCustomersCustomerNo;
	private JTextField txtCustomersAnrede;
	private JTextField txtCustomersFirstname;
	private JTextField txtCustomersLastname;
	private JLabel lblKundennummer;
	private JLabel lblAnrede;
	private JLabel lblVorname_1;
	private JLabel lblNachname_1;
	private JTextField txtCustomersZipcode;
	private JTextField txtCustomersCity;
	private JTextField txtCustomersStreet;
	private JTextField txtCustomersTelephone;
	private JLabel lblPlz;
	private JLabel lblOrt;
	private JLabel lblStrae;
	private JLabel lblTelefon;
	private JPanel panelCustomersControlsButtons;
	private JButton btnZurcksetzen_1;
	private JButton btnSpeichern_1;
	private JScrollPane scrollPaneCustomers;
	private JScrollPane scrollPaneDvd;
	private JScrollPane scrollPaneLending;
	private JTable tableDvd;
	private JTable tableCustomers;
	private JTable tableLending;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/com/fa11/dvdverleih/ui/ressources/dvd_unmount.png")));
		setMinimumSize(new Dimension(575, 420));
		setTitle("DVD-Verleih");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 420);
		
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
		gbl_panelLending.columnWidths = new int[]{128, 0};
		gbl_panelLending.rowHeights = new int[]{0, 0, 0};
		gbl_panelLending.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelLending.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		this.panelLending.setLayout(gbl_panelLending);
		
		panelLendingControls = new JPanel();
		panelLendingControls.setBorder(new TitledBorder(null, "Vorgang erfassen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelLendingControls = new GridBagConstraints();
		gbc_panelLendingControls.insets = new Insets(0, 0, 5, 0);
		gbc_panelLendingControls.fill = GridBagConstraints.BOTH;
		gbc_panelLendingControls.gridx = 0;
		gbc_panelLendingControls.gridy = 0;
		panelLending.add(panelLendingControls, gbc_panelLendingControls);
		GridBagLayout gbl_panelLendingControls = new GridBagLayout();
		gbl_panelLendingControls.columnWidths = new int[]{128, 128, 128, 0};
		gbl_panelLendingControls.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelLendingControls.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelLendingControls.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelLendingControls.setLayout(gbl_panelLendingControls);
		
		this.txtCustomerNo = new JTextField();
		GridBagConstraints gbc_txtCustomerNo = new GridBagConstraints();
		gbc_txtCustomerNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerNo.gridx = 0;
		gbc_txtCustomerNo.gridy = 0;
		panelLendingControls.add(txtCustomerNo, gbc_txtCustomerNo);
		this.txtCustomerNo.setColumns(10);
		
		this.txtCustomerFirstName = new JTextField();
		GridBagConstraints gbc_txtCustomerFirstName = new GridBagConstraints();
		gbc_txtCustomerFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerFirstName.gridx = 1;
		gbc_txtCustomerFirstName.gridy = 0;
		panelLendingControls.add(txtCustomerFirstName, gbc_txtCustomerFirstName);
		this.txtCustomerFirstName.setEditable(false);
		this.txtCustomerFirstName.setColumns(10);
		
		this.txtCustomerLastName = new JTextField();
		GridBagConstraints gbc_txtCustomerLastName = new GridBagConstraints();
		gbc_txtCustomerLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomerLastName.gridx = 2;
		gbc_txtCustomerLastName.gridy = 0;
		panelLendingControls.add(txtCustomerLastName, gbc_txtCustomerLastName);
		this.txtCustomerLastName.setEditable(false);
		this.txtCustomerLastName.setColumns(10);
		
		this.lblKundennr = new JLabel("Kunden-Nummer");
		GridBagConstraints gbc_lblKundennr = new GridBagConstraints();
		gbc_lblKundennr.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblKundennr.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennr.gridx = 0;
		gbc_lblKundennr.gridy = 1;
		panelLendingControls.add(lblKundennr, gbc_lblKundennr);
		
		this.lblVorname = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 1;
		gbc_lblVorname.gridy = 1;
		panelLendingControls.add(lblVorname, gbc_lblVorname);
		
		this.lblNachname = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNachname.insets = new Insets(0, 0, 5, 0);
		gbc_lblNachname.gridx = 2;
		gbc_lblNachname.gridy = 1;
		panelLendingControls.add(lblNachname, gbc_lblNachname);
		
		this.txtDVDNo = new JTextField();
		GridBagConstraints gbc_txtDVDNo = new GridBagConstraints();
		gbc_txtDVDNo.anchor = GridBagConstraints.NORTH;
		gbc_txtDVDNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDVDNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDVDNo.gridx = 0;
		gbc_txtDVDNo.gridy = 2;
		panelLendingControls.add(txtDVDNo, gbc_txtDVDNo);
		this.txtDVDNo.setColumns(10);
		
		this.txtDVDTitle = new JTextField();
		GridBagConstraints gbc_txtDVDTitle = new GridBagConstraints();
		gbc_txtDVDTitle.anchor = GridBagConstraints.NORTH;
		gbc_txtDVDTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDVDTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtDVDTitle.gridx = 1;
		gbc_txtDVDTitle.gridy = 2;
		panelLendingControls.add(txtDVDTitle, gbc_txtDVDTitle);
		this.txtDVDTitle.setColumns(10);
		
		this.chckbxDvdavailable = new JCheckBox("Verf\u00FCgbar?");
		GridBagConstraints gbc_chckbxDvdavailable = new GridBagConstraints();
		gbc_chckbxDvdavailable.anchor = GridBagConstraints.NORTH;
		gbc_chckbxDvdavailable.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxDvdavailable.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDvdavailable.gridx = 2;
		gbc_chckbxDvdavailable.gridy = 2;
		panelLendingControls.add(chckbxDvdavailable, gbc_chckbxDvdavailable);
		this.chckbxDvdavailable.setEnabled(false);
		
		this.lblDvdnr = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDvdnr = new GridBagConstraints();
		gbc_lblDvdnr.anchor = GridBagConstraints.NORTH;
		gbc_lblDvdnr.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdnr.insets = new Insets(0, 0, 0, 5);
		gbc_lblDvdnr.gridx = 0;
		gbc_lblDvdnr.gridy = 3;
		panelLendingControls.add(lblDvdnr, gbc_lblDvdnr);
		
		this.lblDvdtitel = new JLabel("DVD-Titel");
		GridBagConstraints gbc_lblDvdtitel = new GridBagConstraints();
		gbc_lblDvdtitel.anchor = GridBagConstraints.NORTH;
		gbc_lblDvdtitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdtitel.insets = new Insets(0, 0, 0, 5);
		gbc_lblDvdtitel.gridx = 1;
		gbc_lblDvdtitel.gridy = 3;
		panelLendingControls.add(lblDvdtitel, gbc_lblDvdtitel);
		
		this.panelBorrowButtons = new JPanel();
		GridBagConstraints gbc_panelBorrowButtons = new GridBagConstraints();
		gbc_panelBorrowButtons.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelBorrowButtons.gridx = 2;
		gbc_panelBorrowButtons.gridy = 3;
		panelLendingControls.add(panelBorrowButtons, gbc_panelBorrowButtons);
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
		
		panelLendingList = new JPanel();
		panelLendingList.setBorder(new TitledBorder(null, "Leihvorg\u00E4nge", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelLendingList = new GridBagConstraints();
		gbc_panelLendingList.fill = GridBagConstraints.BOTH;
		gbc_panelLendingList.gridx = 0;
		gbc_panelLendingList.gridy = 1;
		panelLending.add(panelLendingList, gbc_panelLendingList);
		GridBagLayout gbl_panelLendingList = new GridBagLayout();
		gbl_panelLendingList.columnWidths = new int[]{0, 0};
		gbl_panelLendingList.rowHeights = new int[]{0, 0};
		gbl_panelLendingList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelLendingList.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelLendingList.setLayout(gbl_panelLendingList);
		
		scrollPaneLending = new JScrollPane();
		GridBagConstraints gbc_scrollPaneLending = new GridBagConstraints();
		gbc_scrollPaneLending.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneLending.gridx = 0;
		gbc_scrollPaneLending.gridy = 0;
		panelLendingList.add(scrollPaneLending, gbc_scrollPaneLending);
		
		tableLending = new JTable();
		tableLending.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Leih-Nr.", "DVD-Titel", "Ausleihe", "R\u00FCckgabe"
			}
		));
		tableLending.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent lse) {
						if (!lse.getValueIsAdjusting()) {
//							DefaultListSelectionModel dlsm = (DefaultListSelectionModel) lse
//									.getSource();
//							DefaultTableModel model = (DefaultTableModel) tableLending
//									.getModel();
//							System.out.println("Selection Changed: "
//									+ dlsm.getLeadSelectionIndex());
							System.out.println("Selection Changed: "
									+ tableLending.getSelectedRow());
						}
					}
				});
		scrollPaneLending.setViewportView(tableLending);
		
		this.panelDvd = new JPanel();
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDvd, null);
		GridBagLayout gbl_panelDvd = new GridBagLayout();
		gbl_panelDvd.columnWidths = new int[]{128, 0};
		gbl_panelDvd.rowHeights = new int[]{0, 0, 0};
		gbl_panelDvd.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDvd.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		this.panelDvd.setLayout(gbl_panelDvd);
		
		panelDvdControls = new JPanel();
		panelDvdControls.setBorder(new TitledBorder(null, "Vorgang erfassen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDvdControls = new GridBagConstraints();
		gbc_panelDvdControls.insets = new Insets(0, 0, 5, 0);
		gbc_panelDvdControls.fill = GridBagConstraints.BOTH;
		gbc_panelDvdControls.gridx = 0;
		gbc_panelDvdControls.gridy = 0;
		panelDvd.add(panelDvdControls, gbc_panelDvdControls);
		GridBagLayout gbl_panelDvdControls = new GridBagLayout();
		gbl_panelDvdControls.columnWidths = new int[]{128, 128, 128, 128, 0};
		gbl_panelDvdControls.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelDvdControls.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDvdControls.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDvdControls.setLayout(gbl_panelDvdControls);
		
		this.txtDvdNo = new JTextField();
		GridBagConstraints gbc_txtDvdNo = new GridBagConstraints();
		gbc_txtDvdNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdNo.gridx = 0;
		gbc_txtDvdNo.gridy = 0;
		panelDvdControls.add(txtDvdNo, gbc_txtDvdNo);
		this.txtDvdNo.setEditable(false);
		this.txtDvdNo.setColumns(10);
		
		this.txtDvdTitle = new JTextField();
		GridBagConstraints gbc_txtDvdTitle = new GridBagConstraints();
		gbc_txtDvdTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdTitle.gridx = 1;
		gbc_txtDvdTitle.gridy = 0;
		panelDvdControls.add(txtDvdTitle, gbc_txtDvdTitle);
		this.txtDvdTitle.setColumns(10);
		
		this.txtDvdGenre = new JTextField();
		GridBagConstraints gbc_txtDvdGenre = new GridBagConstraints();
		gbc_txtDvdGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdGenre.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdGenre.gridx = 2;
		gbc_txtDvdGenre.gridy = 0;
		panelDvdControls.add(txtDvdGenre, gbc_txtDvdGenre);
		this.txtDvdGenre.setColumns(10);
		
		this.txtDvdYear = new JTextField();
		GridBagConstraints gbc_txtDvdYear = new GridBagConstraints();
		gbc_txtDvdYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdYear.insets = new Insets(0, 0, 5, 0);
		gbc_txtDvdYear.gridx = 3;
		gbc_txtDvdYear.gridy = 0;
		panelDvdControls.add(txtDvdYear, gbc_txtDvdYear);
		this.txtDvdYear.setColumns(10);
		
		this.lblDVDNo = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDVDNo = new GridBagConstraints();
		gbc_lblDVDNo.anchor = GridBagConstraints.WEST;
		gbc_lblDVDNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDNo.gridx = 0;
		gbc_lblDVDNo.gridy = 1;
		panelDvdControls.add(lblDVDNo, gbc_lblDVDNo);
		
		this.lblDVDTitle = new JLabel("DVD Titel");
		GridBagConstraints gbc_lblDVDTitle = new GridBagConstraints();
		gbc_lblDVDTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDVDTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDTitle.gridx = 1;
		gbc_lblDVDTitle.gridy = 1;
		panelDvdControls.add(lblDVDTitle, gbc_lblDVDTitle);
		
		this.lblDVDGenre = new JLabel("DVD Genre");
		GridBagConstraints gbc_lblDVDGenre = new GridBagConstraints();
		gbc_lblDVDGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDVDGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblDVDGenre.gridx = 2;
		gbc_lblDVDGenre.gridy = 1;
		panelDvdControls.add(lblDVDGenre, gbc_lblDVDGenre);
		
		this.lblDVDYear = new JLabel("Erscheinungsjahr");
		GridBagConstraints gbc_lblDVDYear = new GridBagConstraints();
		gbc_lblDVDYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDVDYear.insets = new Insets(0, 0, 5, 0);
		gbc_lblDVDYear.gridx = 3;
		gbc_lblDVDYear.gridy = 1;
		panelDvdControls.add(lblDVDYear, gbc_lblDVDYear);
		
		this.panelDVDButtons = new JPanel();
		GridBagConstraints gbc_panelDVDButtons = new GridBagConstraints();
		gbc_panelDVDButtons.anchor = GridBagConstraints.EAST;
		gbc_panelDVDButtons.gridwidth = 2;
		gbc_panelDVDButtons.insets = new Insets(0, 0, 0, 5);
		gbc_panelDVDButtons.gridx = 2;
		gbc_panelDVDButtons.gridy = 2;
		panelDvdControls.add(panelDVDButtons, gbc_panelDVDButtons);
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
		
		panelDvdList = new JPanel();
		panelDvdList.setBorder(new TitledBorder(null, "Vorhandene DVDs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDvdList = new GridBagConstraints();
		gbc_panelDvdList.fill = GridBagConstraints.BOTH;
		gbc_panelDvdList.gridx = 0;
		gbc_panelDvdList.gridy = 1;
		panelDvd.add(panelDvdList, gbc_panelDvdList);
		GridBagLayout gbl_panelDvdList = new GridBagLayout();
		gbl_panelDvdList.columnWidths = new int[]{0, 0};
		gbl_panelDvdList.rowHeights = new int[]{0, 0};
		gbl_panelDvdList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDvdList.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDvdList.setLayout(gbl_panelDvdList);
		
		scrollPaneDvd = new JScrollPane();
		GridBagConstraints gbc_scrollPaneDvd = new GridBagConstraints();
		gbc_scrollPaneDvd.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDvd.gridx = 0;
		gbc_scrollPaneDvd.gridy = 0;
		panelDvdList.add(scrollPaneDvd, gbc_scrollPaneDvd);
		
		this.tableDvd = new JTable();
		this.tableDvd.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DVD-Nr.", "Titel", "Genre", "Jahr" }));

		tableDvd.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent lse) {
						if (!lse.getValueIsAdjusting()) {
							DefaultListSelectionModel dlsm = (DefaultListSelectionModel) lse
									.getSource();
							DefaultTableModel model = (DefaultTableModel) tableDvd
									.getModel();
							System.out.println("Selection Changed: "
									+ dlsm.getLeadSelectionIndex());
							System.out.println(model.getValueAt(
									dlsm.getLeadSelectionIndex(), 0));
							System.out.println(model.getValueAt(
									dlsm.getLeadSelectionIndex(), 1));
							System.out.println(model.getValueAt(
									dlsm.getLeadSelectionIndex(), 2));
							System.out.println(model.getValueAt(
									dlsm.getLeadSelectionIndex(), 3));
							txtDvdNo.setText(String.valueOf(model.getValueAt(
									dlsm.getLeadSelectionIndex(), 0)));
							txtDvdTitle.setText(String.valueOf(model
									.getValueAt(dlsm.getLeadSelectionIndex(), 1)));
							txtDvdGenre.setText(String.valueOf(model
									.getValueAt(dlsm.getLeadSelectionIndex(), 2)));
							txtDvdYear.setText(String.valueOf(model.getValueAt(
									dlsm.getLeadSelectionIndex(), 3)));
						}
					}
				});
		this.scrollPaneDvd.setViewportView(this.tableDvd);
		
		this.panelCustomers = new JPanel();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers, null);
		GridBagLayout gbl_panelCustomers = new GridBagLayout();
		gbl_panelCustomers.columnWidths = new int[]{0, 0};
		gbl_panelCustomers.rowHeights = new int[]{0, 0, 0};
		gbl_panelCustomers.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCustomers.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelCustomers.setLayout(gbl_panelCustomers);
		
		panelCustomersControls = new JPanel();
		panelCustomersControls.setBorder(new TitledBorder(null, "Kunde erfassen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelCustomersControls = new GridBagConstraints();
		gbc_panelCustomersControls.insets = new Insets(0, 0, 5, 0);
		gbc_panelCustomersControls.fill = GridBagConstraints.BOTH;
		gbc_panelCustomersControls.gridx = 0;
		gbc_panelCustomersControls.gridy = 0;
		panelCustomers.add(panelCustomersControls, gbc_panelCustomersControls);
		GridBagLayout gbl_panelCustomersControls = new GridBagLayout();
		gbl_panelCustomersControls.columnWidths = new int[]{128, 128, 128, 128, 0};
		gbl_panelCustomersControls.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelCustomersControls.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCustomersControls.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCustomersControls.setLayout(gbl_panelCustomersControls);
		
		txtCustomersCustomerNo = new JTextField();
		txtCustomersCustomerNo.setEditable(false);
		GridBagConstraints gbc_txtCustomersCustomerNo = new GridBagConstraints();
		gbc_txtCustomersCustomerNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomersCustomerNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersCustomerNo.gridx = 0;
		gbc_txtCustomersCustomerNo.gridy = 0;
		panelCustomersControls.add(txtCustomersCustomerNo, gbc_txtCustomersCustomerNo);
		txtCustomersCustomerNo.setColumns(10);
		
		txtCustomersAnrede = new JTextField();
		GridBagConstraints gbc_txtCustomersAnrede = new GridBagConstraints();
		gbc_txtCustomersAnrede.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomersAnrede.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersAnrede.gridx = 1;
		gbc_txtCustomersAnrede.gridy = 0;
		panelCustomersControls.add(txtCustomersAnrede, gbc_txtCustomersAnrede);
		txtCustomersAnrede.setColumns(10);
		
		txtCustomersFirstname = new JTextField();
		GridBagConstraints gbc_txtCustomersFirstname = new GridBagConstraints();
		gbc_txtCustomersFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomersFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersFirstname.gridx = 2;
		gbc_txtCustomersFirstname.gridy = 0;
		panelCustomersControls.add(txtCustomersFirstname, gbc_txtCustomersFirstname);
		txtCustomersFirstname.setColumns(10);
		
		txtCustomersLastname = new JTextField();
		GridBagConstraints gbc_txtCustomersLastname = new GridBagConstraints();
		gbc_txtCustomersLastname.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomersLastname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersLastname.gridx = 3;
		gbc_txtCustomersLastname.gridy = 0;
		panelCustomersControls.add(txtCustomersLastname, gbc_txtCustomersLastname);
		txtCustomersLastname.setColumns(10);
		
		lblKundennummer = new JLabel("Kundennummer");
		GridBagConstraints gbc_lblKundennummer = new GridBagConstraints();
		gbc_lblKundennummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblKundennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennummer.gridx = 0;
		gbc_lblKundennummer.gridy = 1;
		panelCustomersControls.add(lblKundennummer, gbc_lblKundennummer);
		
		lblAnrede = new JLabel("Anrede");
		GridBagConstraints gbc_lblAnrede = new GridBagConstraints();
		gbc_lblAnrede.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAnrede.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnrede.gridx = 1;
		gbc_lblAnrede.gridy = 1;
		panelCustomersControls.add(lblAnrede, gbc_lblAnrede);
		
		lblVorname_1 = new JLabel("Vorname");
		GridBagConstraints gbc_lblVorname_1 = new GridBagConstraints();
		gbc_lblVorname_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVorname_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname_1.gridx = 2;
		gbc_lblVorname_1.gridy = 1;
		panelCustomersControls.add(lblVorname_1, gbc_lblVorname_1);
		
		lblNachname_1 = new JLabel("Nachname");
		GridBagConstraints gbc_lblNachname_1 = new GridBagConstraints();
		gbc_lblNachname_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNachname_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNachname_1.gridx = 3;
		gbc_lblNachname_1.gridy = 1;
		panelCustomersControls.add(lblNachname_1, gbc_lblNachname_1);
		
		txtCustomersZipcode = new JTextField();
		GridBagConstraints gbc_txtCustomersZipcode = new GridBagConstraints();
		gbc_txtCustomersZipcode.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomersZipcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersZipcode.gridx = 0;
		gbc_txtCustomersZipcode.gridy = 3;
		panelCustomersControls.add(txtCustomersZipcode, gbc_txtCustomersZipcode);
		txtCustomersZipcode.setColumns(10);
		
		txtCustomersCity = new JTextField();
		GridBagConstraints gbc_txtCustomersCity = new GridBagConstraints();
		gbc_txtCustomersCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomersCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersCity.gridx = 1;
		gbc_txtCustomersCity.gridy = 3;
		panelCustomersControls.add(txtCustomersCity, gbc_txtCustomersCity);
		txtCustomersCity.setColumns(10);
		
		txtCustomersStreet = new JTextField();
		GridBagConstraints gbc_txtCustomersStreet = new GridBagConstraints();
		gbc_txtCustomersStreet.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomersStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersStreet.gridx = 2;
		gbc_txtCustomersStreet.gridy = 3;
		panelCustomersControls.add(txtCustomersStreet, gbc_txtCustomersStreet);
		txtCustomersStreet.setColumns(10);
		
		txtCustomersTelephone = new JTextField();
		GridBagConstraints gbc_txtCustomersTelephone = new GridBagConstraints();
		gbc_txtCustomersTelephone.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomersTelephone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomersTelephone.gridx = 3;
		gbc_txtCustomersTelephone.gridy = 3;
		panelCustomersControls.add(txtCustomersTelephone, gbc_txtCustomersTelephone);
		txtCustomersTelephone.setColumns(10);
		
		lblPlz = new JLabel("PLZ");
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.gridx = 0;
		gbc_lblPlz.gridy = 4;
		panelCustomersControls.add(lblPlz, gbc_lblPlz);
		
		lblOrt = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 1;
		gbc_lblOrt.gridy = 4;
		panelCustomersControls.add(lblOrt, gbc_lblOrt);
		
		lblStrae = new JLabel("Stra\u00DFe");
		GridBagConstraints gbc_lblStrae = new GridBagConstraints();
		gbc_lblStrae.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrae.gridx = 2;
		gbc_lblStrae.gridy = 4;
		panelCustomersControls.add(lblStrae, gbc_lblStrae);
		
		lblTelefon = new JLabel("Telefon");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.insets = new Insets(0, 0, 5, 0);
		gbc_lblTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTelefon.gridx = 3;
		gbc_lblTelefon.gridy = 4;
		panelCustomersControls.add(lblTelefon, gbc_lblTelefon);
		
		panelCustomersControlsButtons = new JPanel();
		GridBagConstraints gbc_panelCustomersControlsButtons = new GridBagConstraints();
		gbc_panelCustomersControlsButtons.gridwidth = 2;
		gbc_panelCustomersControlsButtons.anchor = GridBagConstraints.EAST;
		gbc_panelCustomersControlsButtons.insets = new Insets(0, 0, 0, 5);
		gbc_panelCustomersControlsButtons.fill = GridBagConstraints.VERTICAL;
		gbc_panelCustomersControlsButtons.gridx = 2;
		gbc_panelCustomersControlsButtons.gridy = 5;
		panelCustomersControls.add(panelCustomersControlsButtons, gbc_panelCustomersControlsButtons);
		GridBagLayout gbl_panelCustomersControlsButtons = new GridBagLayout();
		gbl_panelCustomersControlsButtons.columnWidths = new int[]{0, 0, 0};
		gbl_panelCustomersControlsButtons.rowHeights = new int[]{0, 0};
		gbl_panelCustomersControlsButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCustomersControlsButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelCustomersControlsButtons.setLayout(gbl_panelCustomersControlsButtons);
		
		btnZurcksetzen_1 = new JButton("Zur\u00FCcksetzen");
		GridBagConstraints gbc_btnZurcksetzen_1 = new GridBagConstraints();
		gbc_btnZurcksetzen_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnZurcksetzen_1.gridx = 0;
		gbc_btnZurcksetzen_1.gridy = 0;
		panelCustomersControlsButtons.add(btnZurcksetzen_1, gbc_btnZurcksetzen_1);
		
		btnSpeichern_1 = new JButton("Speichern");
		GridBagConstraints gbc_btnSpeichern_1 = new GridBagConstraints();
		gbc_btnSpeichern_1.gridx = 1;
		gbc_btnSpeichern_1.gridy = 0;
		panelCustomersControlsButtons.add(btnSpeichern_1, gbc_btnSpeichern_1);
		
		panelCustomersList = new JPanel();
		panelCustomersList.setBorder(new TitledBorder(null, "Kunden\u00FCbersicht", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelCustomersList = new GridBagConstraints();
		gbc_panelCustomersList.fill = GridBagConstraints.BOTH;
		gbc_panelCustomersList.gridx = 0;
		gbc_panelCustomersList.gridy = 1;
		panelCustomers.add(panelCustomersList, gbc_panelCustomersList);
		GridBagLayout gbl_panelCustomersList = new GridBagLayout();
		gbl_panelCustomersList.columnWidths = new int[]{0, 0};
		gbl_panelCustomersList.rowHeights = new int[]{0, 0};
		gbl_panelCustomersList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCustomersList.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelCustomersList.setLayout(gbl_panelCustomersList);
		
		scrollPaneCustomers = new JScrollPane();
		GridBagConstraints gbc_scrollPaneCustomers = new GridBagConstraints();
		gbc_scrollPaneCustomers.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCustomers.gridx = 0;
		gbc_scrollPaneCustomers.gridy = 0;
		panelCustomersList.add(scrollPaneCustomers, gbc_scrollPaneCustomers);
		
		tableCustomers = new JTable();
		tableCustomers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kd.-Nr.", "Nachname", "Vorname", "Telefon"
			}
		));
		tableCustomers.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent lse) {
						if (!lse.getValueIsAdjusting()) {
							DefaultListSelectionModel dlsm = (DefaultListSelectionModel) lse
									.getSource();
							DefaultTableModel model = (DefaultTableModel) tableCustomers
									.getModel();
							System.out.println("Selection Changed: "
									+ dlsm.getLeadSelectionIndex());
						}
					}
				});
		scrollPaneCustomers.setViewportView(tableCustomers);
	}

}
