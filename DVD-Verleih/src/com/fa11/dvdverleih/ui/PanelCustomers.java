package com.fa11.dvdverleih.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Kundenverwaltungspanel
 * 
 * @author Timo Raschke
 */
public class PanelCustomers extends JPanel {
	
	private static final long serialVersionUID = -2965501132893403670L;
	private JPanel panelCustomersControls;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JLabel lblTitleDesc;
	private JLabel lblFirstNameDesc;
	private JLabel lblLastNameDesc;
	private JTextField txtZipCode;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtPhone;
	private JLabel lblZipCodeDesc;
	private JLabel lblCityDesc;
	private JLabel lblStreetDesc;
	private JLabel lblPhoneDesc;
	private JPanel panelCustomersButtons;
	private JButton btnReset;
	private JButton btnSave;
	private JPanel panelCustomersTable;
	private JScrollPane scrollPaneCustomersTable;
	private JTextField txtTitle;
	private JTable tableCustomers;
	private JTextField txtNo;
	private JLabel lblHausnummer;
	private JPanel panel;
	private JButton btnDelete;
	private JButton btnEdit;
	
	/**
	 * PanelCustomers erstellen
	 */
	public PanelCustomers() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		this.panelCustomersControls = new JPanel();
		this.panelCustomersControls.setBorder(new TitledBorder(null, "Kunde erfassen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelCustomersControls = new GridBagConstraints();
		gbc_panelCustomersControls.insets = new Insets(0, 0, 5, 0);
		gbc_panelCustomersControls.fill = GridBagConstraints.BOTH;
		gbc_panelCustomersControls.gridx = 0;
		gbc_panelCustomersControls.gridy = 0;
		add(this.panelCustomersControls, gbc_panelCustomersControls);
		GridBagLayout gbl_panelCustomersControls = new GridBagLayout();
		gbl_panelCustomersControls.columnWidths = new int[]{128, 128, 128, 128, 0};
		gbl_panelCustomersControls.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCustomersControls.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCustomersControls.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelCustomersControls.setLayout(gbl_panelCustomersControls);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitle.gridx = 0;
		gbc_txtTitle.gridy = 0;
		this.panelCustomersControls.add(txtTitle, gbc_txtTitle);
		
		this.txtFirstName = new JTextField();
		this.txtFirstName.setColumns(10);
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstName.gridx = 1;
		gbc_txtFirstName.gridy = 0;
		this.panelCustomersControls.add(this.txtFirstName, gbc_txtFirstName);
		
		this.txtLastName = new JTextField();
		this.txtLastName.setColumns(10);
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName.gridx = 2;
		gbc_txtLastName.gridy = 0;
		this.panelCustomersControls.add(this.txtLastName, gbc_txtLastName);
		
		this.lblTitleDesc = new JLabel("Anrede");
		GridBagConstraints gbc_lblTitleDesc = new GridBagConstraints();
		gbc_lblTitleDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitleDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleDesc.gridx = 0;
		gbc_lblTitleDesc.gridy = 1;
		this.panelCustomersControls.add(this.lblTitleDesc, gbc_lblTitleDesc);
		
		this.lblFirstNameDesc = new JLabel("Vorname");
		GridBagConstraints gbc_lblFirstNameDesc = new GridBagConstraints();
		gbc_lblFirstNameDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFirstNameDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstNameDesc.gridx = 1;
		gbc_lblFirstNameDesc.gridy = 1;
		this.panelCustomersControls.add(this.lblFirstNameDesc, gbc_lblFirstNameDesc);
		
		this.lblLastNameDesc = new JLabel("Nachname");
		GridBagConstraints gbc_lblLastNameDesc = new GridBagConstraints();
		gbc_lblLastNameDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLastNameDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastNameDesc.gridx = 2;
		gbc_lblLastNameDesc.gridy = 1;
		this.panelCustomersControls.add(this.lblLastNameDesc, gbc_lblLastNameDesc);
		
		this.txtStreet = new JTextField();
		this.txtStreet.setColumns(10);
		GridBagConstraints gbc_txtStreet = new GridBagConstraints();
		gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStreet.insets = new Insets(0, 0, 5, 5);
		gbc_txtStreet.gridx = 0;
		gbc_txtStreet.gridy = 2;
		this.panelCustomersControls.add(this.txtStreet, gbc_txtStreet);
		
		this.txtNo = new JTextField();
		GridBagConstraints gbc_txtNo = new GridBagConstraints();
		gbc_txtNo.anchor = GridBagConstraints.NORTH;
		gbc_txtNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNo.gridx = 1;
		gbc_txtNo.gridy = 2;
		this.panelCustomersControls.add(this.txtNo, gbc_txtNo);
		this.txtNo.setColumns(10);
		
		this.lblStreetDesc = new JLabel("Stra\u00DFe");
		GridBagConstraints gbc_lblStreetDesc = new GridBagConstraints();
		gbc_lblStreetDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblStreetDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreetDesc.gridx = 0;
		gbc_lblStreetDesc.gridy = 3;
		this.panelCustomersControls.add(this.lblStreetDesc, gbc_lblStreetDesc);
		
		this.lblHausnummer = new JLabel("Hausnummer");
		GridBagConstraints gbc_lblHausnummer = new GridBagConstraints();
		gbc_lblHausnummer.anchor = GridBagConstraints.WEST;
		gbc_lblHausnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblHausnummer.gridx = 1;
		gbc_lblHausnummer.gridy = 3;
		this.panelCustomersControls.add(this.lblHausnummer, gbc_lblHausnummer);
		
		this.txtZipCode = new JTextField();
		this.txtZipCode.setColumns(10);
		GridBagConstraints gbc_txtZipCode = new GridBagConstraints();
		gbc_txtZipCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtZipCode.gridx = 0;
		gbc_txtZipCode.gridy = 4;
		this.panelCustomersControls.add(this.txtZipCode, gbc_txtZipCode);
		
		this.txtCity = new JTextField();
		this.txtCity.setColumns(10);
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.gridx = 1;
		gbc_txtCity.gridy = 4;
		this.panelCustomersControls.add(this.txtCity, gbc_txtCity);
		
		this.txtPhone = new JTextField();
		this.txtPhone.setColumns(10);
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.gridx = 2;
		gbc_txtPhone.gridy = 4;
		this.panelCustomersControls.add(this.txtPhone, gbc_txtPhone);
		
		this.lblZipCodeDesc = new JLabel("PLZ");
		GridBagConstraints gbc_lblZipCodeDesc = new GridBagConstraints();
		gbc_lblZipCodeDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblZipCodeDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCodeDesc.gridx = 0;
		gbc_lblZipCodeDesc.gridy = 5;
		this.panelCustomersControls.add(this.lblZipCodeDesc, gbc_lblZipCodeDesc);
		
		this.lblCityDesc = new JLabel("Ort");
		GridBagConstraints gbc_lblCityDesc = new GridBagConstraints();
		gbc_lblCityDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCityDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblCityDesc.gridx = 1;
		gbc_lblCityDesc.gridy = 5;
		this.panelCustomersControls.add(this.lblCityDesc, gbc_lblCityDesc);
		
		this.lblPhoneDesc = new JLabel("Telefon");
		GridBagConstraints gbc_lblPhoneDesc = new GridBagConstraints();
		gbc_lblPhoneDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneDesc.gridx = 2;
		gbc_lblPhoneDesc.gridy = 5;
		this.panelCustomersControls.add(this.lblPhoneDesc, gbc_lblPhoneDesc);
		
		this.panelCustomersButtons = new JPanel();
		GridBagConstraints gbc_panelCustomersButtons = new GridBagConstraints();
		gbc_panelCustomersButtons.fill = GridBagConstraints.VERTICAL;
		gbc_panelCustomersButtons.anchor = GridBagConstraints.EAST;
		gbc_panelCustomersButtons.gridwidth = 2;
		gbc_panelCustomersButtons.gridx = 2;
		gbc_panelCustomersButtons.gridy = 6;
		this.panelCustomersControls.add(this.panelCustomersButtons, gbc_panelCustomersButtons);
		GridBagLayout gbl_panelCustomersButtons = new GridBagLayout();
		gbl_panelCustomersButtons.columnWidths = new int[]{0, 0, 0};
		gbl_panelCustomersButtons.rowHeights = new int[]{0, 0};
		gbl_panelCustomersButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCustomersButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panelCustomersButtons.setLayout(gbl_panelCustomersButtons);
		
		this.btnReset = new JButton("Zur\u00FCcksetzen");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 0;
		this.panelCustomersButtons.add(this.btnReset, gbc_btnReset);
		
		this.btnSave = new JButton("Speichern");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 0;
		this.panelCustomersButtons.add(this.btnSave, gbc_btnSave);
		
		this.panelCustomersTable = new JPanel();
		this.panelCustomersTable.setBorder(new TitledBorder(null, "Kunden\u00FCbersicht", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelCustomersTable = new GridBagConstraints();
		gbc_panelCustomersTable.insets = new Insets(0, 0, 5, 0);
		gbc_panelCustomersTable.fill = GridBagConstraints.BOTH;
		gbc_panelCustomersTable.gridx = 0;
		gbc_panelCustomersTable.gridy = 1;
		add(this.panelCustomersTable, gbc_panelCustomersTable);
		GridBagLayout gbl_panelCustomersTable = new GridBagLayout();
		gbl_panelCustomersTable.columnWidths = new int[]{0, 0};
		gbl_panelCustomersTable.rowHeights = new int[]{0, 0};
		gbl_panelCustomersTable.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCustomersTable.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panelCustomersTable.setLayout(gbl_panelCustomersTable);
		
		this.scrollPaneCustomersTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneCustomersTable = new GridBagConstraints();
		gbc_scrollPaneCustomersTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneCustomersTable.gridx = 0;
		gbc_scrollPaneCustomersTable.gridy = 0;
		this.panelCustomersTable.add(this.scrollPaneCustomersTable, gbc_scrollPaneCustomersTable);
		
		tableCustomers = new DVDVerleihTable(new String[] {"Kd.-Nr.", "Nachname", "Vorname", "Telefon"}, 0);
		tableCustomers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnDelete.setEnabled(true);
				btnEdit.setEnabled(true);
			}
		});
		this.tableCustomers.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		 // Der TableRowSorter wird die Daten des Models sortieren
        TableRowSorter<TableModel> tableCustomersSorter = new TableRowSorter<TableModel>();
       
        // Der Sorter muss dem JTable bekannt sein
        this.tableCustomers.setRowSorter(tableCustomersSorter);
       
        // ... und der Sorter muss wissen, welche Daten er sortieren muss
        tableCustomersSorter.setModel(tableCustomers.getModel());
        
        this.tableCustomers.getTableHeader().setReorderingAllowed(false);
		
//		this.tableCustomers.getSelectionModel().addListSelectionListener(
//				new ListSelectionListener() {
//
//					public void valueChanged(ListSelectionEvent lse) {
//						if (!lse.getValueIsAdjusting()) {
//							DefaultListSelectionModel dlsm = (DefaultListSelectionModel) lse
//									.getSource();
//							DefaultTableModel model = (DefaultTableModel) tableCustomers
//									.getModel();
//							System.out.println("Selection Changed: "
//									+ dlsm.getLeadSelectionIndex());
//						}
//					}
//				});
		this.scrollPaneCustomersTable.setViewportView(tableCustomers);
		
		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panel.setLayout(gbl_panel);
		
		this.btnDelete = new JButton("L\u00F6schen");
		this.btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 0;
		this.panel.add(this.btnDelete, gbc_btnDelete);
		
		this.btnEdit = new JButton("Bearbeiten");
		this.btnEdit.setEnabled(false);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 0;
		this.panel.add(this.btnEdit, gbc_btnEdit);
	}
	
	public void setTableCustomersListSelectionListener(ListSelectionListener listener){
		tableCustomers.getSelectionModel().addListSelectionListener(listener);
	}

	public JTextField getTxtNo() {
		return txtNo;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public JTextField getTxtZipCode() {
		return txtZipCode;
	}

	public JTextField getTxtCity() {
		return txtCity;
	}

	public JTextField getTxtStreet() {
		return txtStreet;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public JTextField getTxtTitle() {
		return txtTitle;
	}

	public JTable getTableCustomers() {
		return tableCustomers;
	}
	
	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnResetActionListener(ActionListener listener){
		btnReset.addActionListener(listener);
	}
	
	public void setBtnSaveActionListener(ActionListener listener){
		btnSave.addActionListener(listener);
	}
	
	public void setBtnEditActionListener(ActionListener listener){
		btnEdit.addActionListener(listener);
	}
	
	public void setBtnDeleteActionListener(ActionListener listener){
		btnDelete.addActionListener(listener);
	}
	
}
