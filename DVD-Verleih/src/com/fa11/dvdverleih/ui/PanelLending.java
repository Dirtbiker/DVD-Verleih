package com.fa11.dvdverleih.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
 * Leih-Verwaltungspanel
 * 
 * @author Timo Raschke
 */
public class PanelLending extends JPanel {

	private static final long serialVersionUID = -223237189138542458L;
	private JPanel panelLendingControls;
	private JTextField txtCustomerNo;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JLabel lblCustomerNoDesc;
	private JLabel lblFirstNameDesc;
	private JLabel lblLastNameDesc;
	private JTextField txtDvdNo;
	private JTextField txtDvdTitle;
	private JCheckBox chkAvailable;
	private JLabel lblDvdNoDesc;
	private JLabel lblDvdTitleDesc;
	private JPanel panelLendingButtons;
	private JButton btnCheck;
	private JButton btnOk;
	private JPanel panelLendingTable;
	private JScrollPane scrollPaneLendingTable;
	private JTable tableLending;
	private JButton btnReset;
	private JPanel panel;
	private JButton btnDelete;
	private JButton btnEdit;

	/**
	 * PanelLending erstellen
	 */
	public PanelLending() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		this.panelLendingControls = new JPanel();
		this.panelLendingControls.setBorder(new TitledBorder(null,
				"Vorgang erfassen", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		GridBagConstraints gbc_panelLendingControls = new GridBagConstraints();
		gbc_panelLendingControls.insets = new Insets(0, 0, 5, 0);
		gbc_panelLendingControls.fill = GridBagConstraints.BOTH;
		gbc_panelLendingControls.gridx = 0;
		gbc_panelLendingControls.gridy = 0;
		add(this.panelLendingControls, gbc_panelLendingControls);
		GridBagLayout gbl_panelLendingControls = new GridBagLayout();
		gbl_panelLendingControls.columnWidths = new int[] { 128, 128, 128, 0 };
		gbl_panelLendingControls.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelLendingControls.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelLendingControls.rowWeights = new double[] { 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		this.panelLendingControls.setLayout(gbl_panelLendingControls);

		this.txtCustomerNo = new JTextField();
		this.txtCustomerNo.setColumns(10);
		GridBagConstraints gbc_txtCustomerNo = new GridBagConstraints();
		gbc_txtCustomerNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomerNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustomerNo.gridx = 0;
		gbc_txtCustomerNo.gridy = 0;
		this.panelLendingControls.add(this.txtCustomerNo, gbc_txtCustomerNo);

		this.txtFirstName = new JTextField();
		this.txtFirstName.setEditable(false);
		this.txtFirstName.setColumns(10);
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstName.gridx = 1;
		gbc_txtFirstName.gridy = 0;
		this.panelLendingControls.add(this.txtFirstName, gbc_txtFirstName);

		this.txtLastName = new JTextField();
		this.txtLastName.setEditable(false);
		this.txtLastName.setColumns(10);
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastName.gridx = 2;
		gbc_txtLastName.gridy = 0;
		this.panelLendingControls.add(this.txtLastName, gbc_txtLastName);

		this.lblCustomerNoDesc = new JLabel("Kunden-Nummer");
		GridBagConstraints gbc_lblCustomerNoDesc = new GridBagConstraints();
		gbc_lblCustomerNoDesc.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCustomerNoDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerNoDesc.gridx = 0;
		gbc_lblCustomerNoDesc.gridy = 1;
		this.panelLendingControls.add(this.lblCustomerNoDesc,
				gbc_lblCustomerNoDesc);

		this.lblFirstNameDesc = new JLabel("Vorname");
		GridBagConstraints gbc_lblFirstNameDesc = new GridBagConstraints();
		gbc_lblFirstNameDesc.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFirstNameDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstNameDesc.gridx = 1;
		gbc_lblFirstNameDesc.gridy = 1;
		this.panelLendingControls.add(this.lblFirstNameDesc,
				gbc_lblFirstNameDesc);

		this.lblLastNameDesc = new JLabel("Nachname");
		GridBagConstraints gbc_lblLastNameDesc = new GridBagConstraints();
		gbc_lblLastNameDesc.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLastNameDesc.insets = new Insets(0, 0, 5, 0);
		gbc_lblLastNameDesc.gridx = 2;
		gbc_lblLastNameDesc.gridy = 1;
		this.panelLendingControls
				.add(this.lblLastNameDesc, gbc_lblLastNameDesc);

		this.txtDvdNo = new JTextField();
		this.txtDvdNo.setColumns(10);
		GridBagConstraints gbc_txtDvdNo = new GridBagConstraints();
		gbc_txtDvdNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdNo.anchor = GridBagConstraints.NORTH;
		gbc_txtDvdNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdNo.gridx = 0;
		gbc_txtDvdNo.gridy = 2;
		this.panelLendingControls.add(this.txtDvdNo, gbc_txtDvdNo);

		this.txtDvdTitle = new JTextField();
		this.txtDvdTitle.setEnabled(false);
		this.txtDvdTitle.setColumns(10);
		GridBagConstraints gbc_txtDvdTitle = new GridBagConstraints();
		gbc_txtDvdTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdTitle.anchor = GridBagConstraints.NORTH;
		gbc_txtDvdTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdTitle.gridx = 1;
		gbc_txtDvdTitle.gridy = 2;
		this.panelLendingControls.add(this.txtDvdTitle, gbc_txtDvdTitle);

		this.chkAvailable = new JCheckBox("Verf\u00FCgbar?");
		this.chkAvailable.setEnabled(false);
		GridBagConstraints gbc_chkAvailable = new GridBagConstraints();
		gbc_chkAvailable.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkAvailable.anchor = GridBagConstraints.NORTH;
		gbc_chkAvailable.insets = new Insets(0, 0, 5, 0);
		gbc_chkAvailable.gridx = 2;
		gbc_chkAvailable.gridy = 2;
		this.panelLendingControls.add(this.chkAvailable, gbc_chkAvailable);

		this.lblDvdNoDesc = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDvdNoDesc = new GridBagConstraints();
		gbc_lblDvdNoDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdNoDesc.anchor = GridBagConstraints.NORTH;
		gbc_lblDvdNoDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdNoDesc.gridx = 0;
		gbc_lblDvdNoDesc.gridy = 3;
		this.panelLendingControls.add(this.lblDvdNoDesc, gbc_lblDvdNoDesc);

		this.lblDvdTitleDesc = new JLabel("DVD-Titel");
		GridBagConstraints gbc_lblDvdTitleDesc = new GridBagConstraints();
		gbc_lblDvdTitleDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdTitleDesc.anchor = GridBagConstraints.NORTH;
		gbc_lblDvdTitleDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdTitleDesc.gridx = 1;
		gbc_lblDvdTitleDesc.gridy = 3;
		this.panelLendingControls
				.add(this.lblDvdTitleDesc, gbc_lblDvdTitleDesc);

		this.panelLendingButtons = new JPanel();
		GridBagConstraints gbc_panelLendingButtons = new GridBagConstraints();
		gbc_panelLendingButtons.insets = new Insets(0, 0, 5, 0);
		gbc_panelLendingButtons.gridwidth = 2;
		gbc_panelLendingButtons.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelLendingButtons.gridx = 1;
		gbc_panelLendingButtons.gridy = 4;
		this.panelLendingControls.add(this.panelLendingButtons,
				gbc_panelLendingButtons);
		GridBagLayout gbl_panelLendingButtons = new GridBagLayout();
		gbl_panelLendingButtons.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelLendingButtons.rowHeights = new int[] { 0, 0 };
		gbl_panelLendingButtons.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelLendingButtons.rowWeights = new double[] { 0.0,
				Double.MIN_VALUE };
		this.panelLendingButtons.setLayout(gbl_panelLendingButtons);

		this.btnReset = new JButton("Zur\u00FCcksetzen");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 0;
		this.panelLendingButtons.add(this.btnReset, gbc_btnReset);

		this.btnCheck = new JButton("Pr\u00FCfen");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheck.gridx = 1;
		gbc_btnCheck.gridy = 0;
		this.panelLendingButtons.add(this.btnCheck, gbc_btnCheck);

		this.btnOk = new JButton("OK");
		this.btnOk.setEnabled(false);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 0;
		this.panelLendingButtons.add(this.btnOk, gbc_btnOk);

		this.panelLendingTable = new JPanel();
		this.panelLendingTable.setBorder(new TitledBorder(null,
				"Leihvorg\u00E4nge", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		GridBagConstraints gbc_panelLendingTable = new GridBagConstraints();
		gbc_panelLendingTable.insets = new Insets(0, 0, 5, 0);
		gbc_panelLendingTable.fill = GridBagConstraints.BOTH;
		gbc_panelLendingTable.gridx = 0;
		gbc_panelLendingTable.gridy = 1;
		add(this.panelLendingTable, gbc_panelLendingTable);
		GridBagLayout gbl_panelLendingTable = new GridBagLayout();
		gbl_panelLendingTable.columnWidths = new int[] { 0, 0 };
		gbl_panelLendingTable.rowHeights = new int[] { 0, 0 };
		gbl_panelLendingTable.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_panelLendingTable.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		this.panelLendingTable.setLayout(gbl_panelLendingTable);

		this.scrollPaneLendingTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneLendingTable = new GridBagConstraints();
		gbc_scrollPaneLendingTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneLendingTable.gridx = 0;
		gbc_scrollPaneLendingTable.gridy = 0;
		this.panelLendingTable.add(this.scrollPaneLendingTable,
				gbc_scrollPaneLendingTable);

		tableLending = new DVDVerleihTable(new String[] { "Leih-Nr.",
				"DVD-Titel", "Kunde", "Ausleihe", "R\u00FCckgabe" }, 0);
		tableLending.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						btnDelete.setEnabled(true);
						btnEdit.setEnabled(true);
					}
				});

		this.tableLending.getColumnModel().getColumn(0).setResizable(false);
		this.tableLending.getColumnModel().getColumn(1).setResizable(false);
		this.tableLending.getColumnModel().getColumn(2).setResizable(false);
		this.tableLending.getColumnModel().getColumn(3).setResizable(false);
		this.tableLending.getColumnModel().getColumn(0).setPreferredWidth(50);
		this.tableLending.getColumnModel().getColumn(0).setMinWidth(50);
		this.tableLending.getColumnModel().getColumn(0).setMaxWidth(50);
		this.tableLending.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.tableLending.getColumnModel().getColumn(2).setMinWidth(100);
		this.tableLending.getColumnModel().getColumn(2).setMaxWidth(100);
		this.tableLending.getColumnModel().getColumn(3).setPreferredWidth(100);
		this.tableLending.getColumnModel().getColumn(3).setMinWidth(100);
		this.tableLending.getColumnModel().getColumn(3).setMaxWidth(100);
		this.tableLending.getColumnModel().getColumn(4).setPreferredWidth(100);
		this.tableLending.getColumnModel().getColumn(4).setMinWidth(100);
		this.tableLending.getColumnModel().getColumn(4).setMaxWidth(100);
		// Der TableRowSorter wird die Daten des Models sortieren
		TableRowSorter<TableModel> tableLendingSorter = new TableRowSorter<TableModel>();

		// Der Sorter muss dem JTable bekannt sein
		this.tableLending.setRowSorter(tableLendingSorter);

		// ... und der Sorter muss wissen, welche Daten er sortieren muss
		tableLendingSorter.setModel(tableLending.getModel());

		tableLending.getTableHeader().setReorderingAllowed(false);
		
		scrollPaneLendingTable.setViewportView(tableLending);

		this.panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(this.panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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

	public void setTableLendingListSelectionListener(
			ListSelectionListener listener) {
		tableLending.getSelectionModel().addListSelectionListener(listener);
	}

	public JTextField getTxtCustomerNo() {
		return txtCustomerNo;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public JTextField getTxtDvdNo() {
		return txtDvdNo;
	}

	public JTextField getTxtDvdTitle() {
		return txtDvdTitle;
	}

	public JCheckBox getChkAvailable() {
		return chkAvailable;
	}

	public JTable getTableLending() {
		return tableLending;
	}

	public JButton getBtnCheck() {
		return btnCheck;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnCheckActionListener(ActionListener listener) {
		btnCheck.addActionListener(listener);
	}

	public void setBtnOkActionListener(ActionListener listener) {
		btnOk.addActionListener(listener);
	}

	public void setBtnResetActionListener(ActionListener listener) {
		btnReset.addActionListener(listener);
	}

	public void setBtnEditActionListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}

	public void setBtnDeleteActionListener(ActionListener listener) {
		btnDelete.addActionListener(listener);
	}
}
