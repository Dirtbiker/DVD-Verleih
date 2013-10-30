package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.fa11.dvdverleih.datenhaltung.XMLDatenhaltung;
import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Verleih;
import com.fa11.dvdverleih.fachkonzept.Fachkonzept;
import com.fa11.dvdverleih.fachkonzept.IFachkonzept;

/**
 * Grafische Benutzeroberfläche für den DVD-Verleih mit Swing
 * 
 * @author Timo Raschke
 * @version 1.0
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = -3004396365580658126L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JTabbedPane tabbedPane;
	private PanelLending panelLending;
	private PanelDvd panelDvd;
	private PanelCustomers panelCustomers;
	private IFachkonzept fachkonzept;

	/**
	 * GUI Testweise starten
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
					GUI frame = new GUI(new Fachkonzept(new XMLDatenhaltung()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * GUI erstellen
	 */
	public GUI(IFachkonzept fachkonzept) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/com/fa11/dvdverleih/ui/ressources/dvd_unmount.png")));
		this.fachkonzept = fachkonzept;
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

		this.panelLending = new PanelLending();
		this.panelLending.setBtnCheckActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel)panelLending.getTableLending().getModel();
				model.addRow(new String[]{"1", panelLending.getTxtDvdTitle().getText(), "19.12.1900", "25.06.1958"});
			}
		});
		this.tabbedPane.addTab("DVD-Leihe", null, this.panelLending, null);

		this.panelDvd = new PanelDvd();
		this.panelDvd.setBtnNewActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GUI.this.fachkonzept.createDVD(new DVD());
				//TODO DVD mit passender ID in Liste einfügen
				DefaultTableModel model = (DefaultTableModel)panelDvd.getTableDvd().getModel();
				model.addRow(new String[]{"","","",""});
			}
		});
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDvd, null);
		
		this.panelCustomers = new PanelCustomers();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers, null);
		
		// ListSelectionChangedListenerHinzufügen
		panelDvd.setTableDvdListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				dvdTableListSelectionChanged();
			}
		});
		panelCustomers.setTableCustomersListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				customerTableListSelectionChanged();
			}
		});
		panelLending.setTableLendingListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				lendingTableListSelectionChanged();
			}
		});
		
		// Button ActionListener hinzufügen
		// TODO: Buttons ActionListener hinzufügen
		
		// Tabellen befüllen
		updateLendingTable();
		updateDvdTable();
		updateKundenTable();
	}
	
	/**
	 * Aktualisiert die Einträge in der DVD Tabelle
	 */
	private void updateDvdTable(){
		List<DVD> dvdlist = fachkonzept.getAllDVDs();
		DefaultTableModel model = (DefaultTableModel) panelDvd.getTableDvd().getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if(dvdlist != null) {
			for (DVD dvd : dvdlist) {
			model.addRow(new String[]{
					String.valueOf(dvd.getDvd_nr()),
					dvd.getTitel(),
					dvd.getGenre(),
					String.valueOf(dvd.getErscheinungsjahr())});
			}
		}
		
	}
	
	/**
	 * Aktualisiert die Einträge in der KundenTabelle
	 */
	private void updateKundenTable(){
		List<Kunde> kundenlist = fachkonzept.getAllKunden();
		DefaultTableModel model = (DefaultTableModel) panelCustomers.getTableCustomers().getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if(kundenlist != null) {
			for (Kunde kunde : kundenlist) {
				model.addRow(new String[]{
						String.valueOf(kunde.getKunden_nr()),
						kunde.getAnrede(),
						kunde.getNachname(),
						kunde.getVorname(),
						kunde.getTelefon_nummer()});
			}
		}
	}
	
	/**
	 * Aktualisiert die Einträge in der Leih-Tabelle
	 */
	private void updateLendingTable() {
		List<Verleih> verleihlist = fachkonzept.getAllVerleihe();
		DefaultTableModel model = (DefaultTableModel) panelCustomers.getTableCustomers().getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if(verleihlist != null) {
			for (Verleih verleih : verleihlist) {
				model.addRow(new String[]{
						String.valueOf(verleih.getLeihvorgangs_nr()),
						fachkonzept.getDVDByID(verleih.getDvd_nr()).getTitel(),
						verleih.getAusleihe().toString(),
						verleih.getRueckgabe().toString()
				});
			}
		}
	}
	
	/**
	 * Löscht alle Elemente eines DefaultTableModel
	 * @param model
	 */
	private void clearTablemodel(DefaultTableModel model){
		// Tabelle leeren
		for (int i = 0; i < model.getRowCount(); i++) {
			model.removeRow(i);
		}
	}

	/**
	 * Überträgt Parameter der ausgewählten DVD in der Tabelle in die Textfelder
	 */
	private void dvdTableListSelectionChanged(){
		int dvdid = Integer.valueOf((String) panelDvd.getTableDvd().getValueAt(panelDvd.getTableDvd().getSelectedRow(), 0));
		DVD dvd = fachkonzept.getDVDByID(dvdid);
		panelDvd.getTxtDvdNo().setText(String.valueOf(dvd.getDvd_nr()));
		panelDvd.getTxtDvdTitle().setText(dvd.getTitel());
		panelDvd.getTxtDvdGenre().setText(dvd.getGenre());
		panelDvd.getTxtDvdYear().setText(String.valueOf(dvd.getErscheinungsjahr()));
	}
	
	/**
	 * Überträgt Parameter des ausgewählten Kunden in der Tabelle in die Textfelder
	 */
	private void customerTableListSelectionChanged(){
		int customerid = Integer.valueOf((String) panelCustomers.getTableCustomers().getValueAt(panelCustomers.getTableCustomers().getSelectedRow(), 0));
		Kunde kunde = fachkonzept.getKundeByID(customerid);
		panelCustomers.getTxtCustomerNo().setText(String.valueOf(kunde.getKunden_nr()));
		panelCustomers.getTxtTitle().setText(kunde.getAnrede());
		panelCustomers.getTxtFirstName().setText(kunde.getVorname());
		panelCustomers.getTxtLastName().setText(kunde.getNachname());
		panelCustomers.getTxtZipCode().setText(kunde.getPlz());
		panelCustomers.getTxtCity().setText(kunde.getOrt());
		panelCustomers.getTxtStreet().setText(kunde.getStrasse());
		panelCustomers.getTxtPhone().setText(kunde.getTelefon_nummer());
	}
	
	/**
	 * Überträgt Parameter der ausgewählten Leihe in der Tabelle in die Textfelder
	 */
	private void lendingTableListSelectionChanged(){
		//TODO: Kann nicht auf einzelnes Lending zugreifen
		int lendingid = Integer.valueOf((String) panelLending.getTableLending().getValueAt(panelLending.getTableLending().getSelectedRow(), 0));
		//Verleih verleih = fachkonzept.getVerleihById(lendingid);
	}
}