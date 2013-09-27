package com.fa11.dvdverleih.ui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * DVD-Verwaltungspanel
 * 
 * @author Timo Raschke
 * @version 1.0
 */
public class PanelDvd extends JPanel {
	
	private static final long serialVersionUID = -8289759117740520155L;
	private JPanel panelDvdControls;
	private JTextField txtDvdNo;
	private JTextField txtDvdTitle;
	private JTextField txtDvdGenre;
	private JTextField txtDvdYear;
	private JLabel lblDvdNoDesc;
	private JLabel lblDvdTitleDesc;
	private JLabel lblDvdGenreDesc;
	private JLabel lblDvdYearDesc;
	private JPanel panelDvdButtons;
	private JButton btnNew;
	private JButton btnSave;
	private JPanel panelDvdPanel;
	private JScrollPane scrollPaneDvdTable;
	private JTable tableDvd;
	private JButton btnDelete;
	
	public PanelDvd() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		this.panelDvdControls = new JPanel();
		this.panelDvdControls.setBorder(new TitledBorder(null, "DVD erfassen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDvdControls = new GridBagConstraints();
		gbc_panelDvdControls.insets = new Insets(0, 0, 5, 0);
		gbc_panelDvdControls.fill = GridBagConstraints.BOTH;
		gbc_panelDvdControls.gridx = 0;
		gbc_panelDvdControls.gridy = 0;
		add(this.panelDvdControls, gbc_panelDvdControls);
		GridBagLayout gbl_panelDvdControls = new GridBagLayout();
		gbl_panelDvdControls.columnWidths = new int[]{128, 128, 128, 128, 0};
		gbl_panelDvdControls.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelDvdControls.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDvdControls.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panelDvdControls.setLayout(gbl_panelDvdControls);
		
		this.txtDvdNo = new JTextField();
		this.txtDvdNo.setEditable(false);
		this.txtDvdNo.setColumns(10);
		GridBagConstraints gbc_txtDvdNo = new GridBagConstraints();
		gbc_txtDvdNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdNo.gridx = 0;
		gbc_txtDvdNo.gridy = 0;
		this.panelDvdControls.add(this.txtDvdNo, gbc_txtDvdNo);
		
		this.txtDvdTitle = new JTextField();
		this.txtDvdTitle.setColumns(10);
		GridBagConstraints gbc_txtDvdTitle = new GridBagConstraints();
		gbc_txtDvdTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdTitle.gridx = 1;
		gbc_txtDvdTitle.gridy = 0;
		this.panelDvdControls.add(this.txtDvdTitle, gbc_txtDvdTitle);
		
		this.txtDvdGenre = new JTextField();
		this.txtDvdGenre.setColumns(10);
		GridBagConstraints gbc_txtDvdGenre = new GridBagConstraints();
		gbc_txtDvdGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdGenre.insets = new Insets(0, 0, 5, 5);
		gbc_txtDvdGenre.gridx = 2;
		gbc_txtDvdGenre.gridy = 0;
		this.panelDvdControls.add(this.txtDvdGenre, gbc_txtDvdGenre);
		
		this.txtDvdYear = new JTextField();
		this.txtDvdYear.setColumns(10);
		GridBagConstraints gbc_txtDvdYear = new GridBagConstraints();
		gbc_txtDvdYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDvdYear.insets = new Insets(0, 0, 5, 0);
		gbc_txtDvdYear.gridx = 3;
		gbc_txtDvdYear.gridy = 0;
		this.panelDvdControls.add(this.txtDvdYear, gbc_txtDvdYear);
		
		this.lblDvdNoDesc = new JLabel("DVD-Nummer");
		GridBagConstraints gbc_lblDvdNoDesc = new GridBagConstraints();
		gbc_lblDvdNoDesc.anchor = GridBagConstraints.WEST;
		gbc_lblDvdNoDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdNoDesc.gridx = 0;
		gbc_lblDvdNoDesc.gridy = 1;
		this.panelDvdControls.add(this.lblDvdNoDesc, gbc_lblDvdNoDesc);
		
		this.lblDvdTitleDesc = new JLabel("DVD Titel");
		GridBagConstraints gbc_lblDvdTitleDesc = new GridBagConstraints();
		gbc_lblDvdTitleDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdTitleDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdTitleDesc.gridx = 1;
		gbc_lblDvdTitleDesc.gridy = 1;
		this.panelDvdControls.add(this.lblDvdTitleDesc, gbc_lblDvdTitleDesc);
		
		this.lblDvdGenreDesc = new JLabel("DVD Genre");
		GridBagConstraints gbc_lblDvdGenreDesc = new GridBagConstraints();
		gbc_lblDvdGenreDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdGenreDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDvdGenreDesc.gridx = 2;
		gbc_lblDvdGenreDesc.gridy = 1;
		this.panelDvdControls.add(this.lblDvdGenreDesc, gbc_lblDvdGenreDesc);
		
		this.lblDvdYearDesc = new JLabel("Erscheinungsjahr");
		GridBagConstraints gbc_lblDvdYearDesc = new GridBagConstraints();
		gbc_lblDvdYearDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDvdYearDesc.insets = new Insets(0, 0, 5, 0);
		gbc_lblDvdYearDesc.gridx = 3;
		gbc_lblDvdYearDesc.gridy = 1;
		this.panelDvdControls.add(this.lblDvdYearDesc, gbc_lblDvdYearDesc);
		
		this.panelDvdButtons = new JPanel();
		GridBagConstraints gbc_panelDvdButtons = new GridBagConstraints();
		gbc_panelDvdButtons.insets = new Insets(0, 0, 0, 5);
		gbc_panelDvdButtons.anchor = GridBagConstraints.EAST;
		gbc_panelDvdButtons.gridwidth = 2;
		gbc_panelDvdButtons.gridx = 2;
		gbc_panelDvdButtons.gridy = 2;
		this.panelDvdControls.add(this.panelDvdButtons, gbc_panelDvdButtons);
		GridBagLayout gbl_panelDvdButtons = new GridBagLayout();
		gbl_panelDvdButtons.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelDvdButtons.rowHeights = new int[]{0, 0};
		gbl_panelDvdButtons.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDvdButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.panelDvdButtons.setLayout(gbl_panelDvdButtons);
		
		this.btnNew = new JButton("Neu");
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 0, 5);
		gbc_btnNew.gridx = 0;
		gbc_btnNew.gridy = 0;
		this.panelDvdButtons.add(this.btnNew, gbc_btnNew);
		
		this.btnDelete = new JButton("L\u00F6schen");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 0;
		this.panelDvdButtons.add(this.btnDelete, gbc_btnDelete);
		
		this.btnSave = new JButton("Speichern");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		this.panelDvdButtons.add(this.btnSave, gbc_btnSave);
		
		this.panelDvdPanel = new JPanel();
		this.panelDvdPanel.setBorder(new TitledBorder(null, "Vorhandene DVDs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDvdPanel = new GridBagConstraints();
		gbc_panelDvdPanel.fill = GridBagConstraints.BOTH;
		gbc_panelDvdPanel.gridx = 0;
		gbc_panelDvdPanel.gridy = 1;
		add(this.panelDvdPanel, gbc_panelDvdPanel);
		GridBagLayout gbl_panelDvdPanel = new GridBagLayout();
		gbl_panelDvdPanel.columnWidths = new int[]{0, 0};
		gbl_panelDvdPanel.rowHeights = new int[]{0, 0};
		gbl_panelDvdPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDvdPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.panelDvdPanel.setLayout(gbl_panelDvdPanel);
		
		this.scrollPaneDvdTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneDvdTable = new GridBagConstraints();
		gbc_scrollPaneDvdTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDvdTable.gridx = 0;
		gbc_scrollPaneDvdTable.gridy = 0;
		this.panelDvdPanel.add(this.scrollPaneDvdTable, gbc_scrollPaneDvdTable);
		
		this.tableDvd = new JTable();
		this.tableDvd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DVD-Nr.", "Titel", "Genre", "Jahr"
			}
		));
		this.tableDvd.getColumnModel().getColumn(0).setResizable(false);
		this.tableDvd.getColumnModel().getColumn(0).setPreferredWidth(80);
		this.tableDvd.getColumnModel().getColumn(0).setMinWidth(80);
		this.tableDvd.getColumnModel().getColumn(0).setMaxWidth(80);
		this.tableDvd.getColumnModel().getColumn(1).setResizable(false);
		this.tableDvd.getColumnModel().getColumn(2).setResizable(false);
		this.tableDvd.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.tableDvd.getColumnModel().getColumn(2).setMinWidth(100);
		this.tableDvd.getColumnModel().getColumn(2).setMaxWidth(100);
		this.tableDvd.getColumnModel().getColumn(3).setResizable(false);
		this.tableDvd.getColumnModel().getColumn(3).setPreferredWidth(100);
		this.tableDvd.getColumnModel().getColumn(3).setMinWidth(100);
		this.tableDvd.getColumnModel().getColumn(3).setMaxWidth(100);
		
		 // Der TableRowSorter wird die Daten des Models sortieren
        TableRowSorter<TableModel> tableDvdSorter = new TableRowSorter<TableModel>();
       
        // Der Sorter muss dem JTable bekannt sein
        this.tableDvd.setRowSorter(tableDvdSorter);
       
        // ... und der Sorter muss wissen, welche Daten er sortieren muss
        tableDvdSorter.setModel(tableDvd.getModel());
        
        tableDvd.getTableHeader().setReorderingAllowed(false);

		tableDvd.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent lse) {
						if (!lse.getValueIsAdjusting()) {
							DefaultTableModel model = (DefaultTableModel) tableDvd
									.getModel();
							txtDvdNo.setText(String.valueOf(model.getValueAt(tableDvd.getSelectedRow(), 0)));
							txtDvdTitle.setText(String.valueOf(model.getValueAt(tableDvd.getSelectedRow(), 1)));
							txtDvdGenre.setText(String.valueOf(model.getValueAt(tableDvd.getSelectedRow(), 2)));
							txtDvdYear.setText(String.valueOf(model.getValueAt(tableDvd.getSelectedRow(), 3)));
						}
					}
				});
		this.scrollPaneDvdTable.setViewportView(this.tableDvd);
	}

	public JTextField getTxtDvdNo() {
		return txtDvdNo;
	}

	public JTextField getTxtDvdTitle() {
		return txtDvdTitle;
	}

	public JTextField getTxtDvdGenre() {
		return txtDvdGenre;
	}

	public JTextField getTxtDvdYear() {
		return txtDvdYear;
	}

	public JTable getTableDvd() {
		return tableDvd;
	}
	
	public void setBtnResetActionListener(ActionListener listener){
		btnNew.addActionListener(listener);
	}
	
	public void setBtnSaveActionListener(ActionListener listener){
		btnSave.addActionListener(listener);
	}
	
	public void setBtnDeleteActionListener(ActionListener listener){
		btnDelete.addActionListener(listener);
	}
	
}
