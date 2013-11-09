package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
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
//		this.panelLending.setBtnCheckActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				DefaultTableModel model = (DefaultTableModel)panelLending.getTableLending().getModel();
//				model.addRow(new String[]{"1", panelLending.getTxtDvdTitle().getText(), "19.12.1900", "25.06.1958"});
//			}
//		});
		this.tabbedPane.addTab("DVD-Leihe", null, this.panelLending, null);

		this.panelDvd = new PanelDvd();
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDvd, null);
		
		this.panelCustomers = new PanelCustomers();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers, null);
		
		// ListSelectionChangedListenerHinzufügen
//		panelDvd.setTableDvdListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent arg0) {
//				dvdTableListSelectionChanged();
//			}
//		});
//		panelCustomers.setTableCustomersListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent arg0) {
//				customerTableListSelectionChanged();
//			}
//		});
//		panelLending.setTableLendingListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent arg0) {
//				lendingTableListSelectionChanged();
//			}
//		});
		
		// Button ActionListener hinzufügen
		// TODO: Buttons ActionListener hinzufügen
		
		//Lending-Panel
		this.panelLending.setBtnCheckActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int kdNr = Integer.valueOf(GUI.this.panelLending.getTxtCustomerNo().getText());
					Kunde kunde = GUI.this.fachkonzept.getKundeByID(kdNr);
					if(kunde != null){
						GUI.this.panelLending.getTxtFirstName().setText(kunde.getVorname());
						GUI.this.panelLending.getTxtLastName().setText(kunde.getNachname());
					} else {
						JOptionPane.showMessageDialog(GUI.this, "Der Kunde mit der Kundennummer \"" + kdNr + "\" wurde nicht gefunden!", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(GUI.this, "Die Kundennummer darf nur aus Zahlen bestehen!", "Fehler", JOptionPane.ERROR_MESSAGE);
				}
				
				try {
					int dvdNr = Integer.valueOf(GUI.this.panelLending.getTxtDvdNo().getText());
					DVD dvd = GUI.this.fachkonzept.getDVDByID(dvdNr);
					if(dvd != null){
						GUI.this.panelLending.getTxtDvdTitle().setText(dvd.getTitel());
					} else {
						JOptionPane.showMessageDialog(GUI.this, "Der DVD mit der Nummer \"" + dvdNr + "\" wurde nicht gefunden!", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(GUI.this, "Die DVD-Nummer darf nur aus Zahlen bestehen!", "Fehler", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//DVD-Panel
		this.panelDvd.setBtnEditActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dvdid = Integer.valueOf((String) panelDvd.getTableDvd().getValueAt(panelDvd.getTableDvd().getSelectedRow(), 0));
				DVD dvd = GUI.this.fachkonzept.getDVDByID(dvdid);
				if(dvd != null){
					int dvd_nr = dvd.getDvd_nr();
					EditDvdDialog editDvdDialog = new EditDvdDialog(GUI.this, dvd);
					editDvdDialog.setVisible(true);
					if(editDvdDialog.getDialogResult() == EditDvdDialog.OK){
						updateDvdTable();
					}
					
				}
			}
		});
		
		this.panelDvd.setBtnDeleteActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dvdid = Integer.valueOf((String) panelDvd.getTableDvd().getValueAt(panelDvd.getTableDvd().getSelectedRow(), 0));
				DVD dvd = GUI.this.fachkonzept.getDVDByID(dvdid);
				if(dvd != null){
					GUI.this.fachkonzept.deleteDVD(dvdid);
					JOptionPane.showMessageDialog(GUI.this, "Die DVD \"" + dvd.getTitel() + "\" wurde erfolgreich gelöscht!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
					updateDvdTable();
				}
			}
		});
		
		this.panelDvd.setBtnSaveActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dvdTitel = GUI.this.panelDvd.getTxtDvdTitle().getText();
				String dvdGenre = GUI.this.panelDvd.getTxtDvdGenre().getText();
				try {
					int dvdYear = Integer.valueOf(GUI.this.panelDvd.getTxtDvdYear().getText());
					if(!dvdTitel.equals("")){
						if(!dvdGenre.equals("")){
							DVD dvd = new DVD(dvdTitel, dvdGenre, dvdYear);
							GUI.this.fachkonzept.createDVD(dvd);
							JOptionPane.showMessageDialog(GUI.this, "DVD wurde erfolgreich hinzugefügt!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
							GUI.this.panelDvd.getTxtDvdTitle().setText("");
							GUI.this.panelDvd.getTxtDvdGenre().setText("");
							GUI.this.panelDvd.getTxtDvdYear().setText("");
							updateDvdTable();
						} else {
							JOptionPane.showMessageDialog(GUI.this, "Das Genre darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(GUI.this, "Der Titel darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(GUI.this, "Das Jahr darf nur aus Zahlen bestehen!", "Fehler", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		this.panelDvd.setBtnResetActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.this.panelDvd.getTxtDvdTitle().setText("");
				GUI.this.panelDvd.getTxtDvdGenre().setText("");
				GUI.this.panelDvd.getTxtDvdYear().setText("");
				
				GUI.this.panelDvd.getTableDvd().getSelectionModel().clearSelection();
				
				GUI.this.panelDvd.getBtnDelete().setEnabled(false);
				GUI.this.panelDvd.getBtnEdit().setEnabled(false);
			}
		});
		
		//Kunden-Panel
		this.panelCustomers.setBtnSaveActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				String anrede = GUI.this.panelCustomers.getTxtTitle().getText();
				String vorname = GUI.this.panelCustomers.getTxtFirstName().getText();
				String nachname = GUI.this.panelCustomers.getTxtLastName().getText();
				String strasse = GUI.this.panelCustomers.getTxtStreet().getText();
				String hausnr = GUI.this.panelCustomers.getTxtNo().getText();
				String plz = GUI.this.panelCustomers.getTxtZipCode().getText();
				String ort = GUI.this.panelCustomers.getTxtCity().getText();
				String telefon = GUI.this.panelCustomers.getTxtPhone().getText();
			
				if(!anrede.equals("")){
					if(!vorname.equals("")){
						if(!nachname.equals("")){
							if(!strasse.equals("")){
								if(!hausnr.equals("")){
									if(!plz.equals("")){
										if(!ort.equals("")){
											if(!telefon.equals("")){
												Kunde kunde = new Kunde(anrede, vorname, nachname, new Date(), plz, ort, strasse, Integer.valueOf(hausnr), telefon);
												
												GUI.this.fachkonzept.createKunde(kunde);
												JOptionPane.showMessageDialog(GUI.this, "Kunde wurde erfolgreich hinzugefügt!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
												GUI.this.panelCustomers.getTxtTitle().setText("");
												GUI.this.panelCustomers.getTxtFirstName().setText("");
												GUI.this.panelCustomers.getTxtLastName().setText("");
												GUI.this.panelCustomers.getTxtStreet().setText("");
												GUI.this.panelCustomers.getTxtNo().setText("");
												GUI.this.panelCustomers.getTxtZipCode().setText("");
												GUI.this.panelCustomers.getTxtCity().setText("");
												GUI.this.panelCustomers.getTxtPhone().setText("");
												updateKundenTable();
											}else {
												JOptionPane.showMessageDialog(GUI.this, "Die Telefonnummer darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
											}
										}else {
											JOptionPane.showMessageDialog(GUI.this, "Der Ort darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
										}
									}else {
										JOptionPane.showMessageDialog(GUI.this, "Die Postleitzahl darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
									}
								}else {
									JOptionPane.showMessageDialog(GUI.this, "Die Hausnummer darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(GUI.this, "Die Straße darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(GUI.this, "Der Nachname darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(GUI.this, "Der Vorname darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(GUI.this, "Die Anrede darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException nfe){
				JOptionPane.showMessageDialog(GUI.this, "Die Hausnummer darf nur aus Ziffern bestehen!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			} 
		});
		
		this.panelCustomers.setBtnResetActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GUI.this.panelCustomers.getTxtTitle().setText("");
				GUI.this.panelCustomers.getTxtFirstName().setText("");
				GUI.this.panelCustomers.getTxtLastName().setText("");
				GUI.this.panelCustomers.getTxtStreet().setText("");
				GUI.this.panelCustomers.getTxtNo().setText("");
				GUI.this.panelCustomers.getTxtZipCode().setText("");
				GUI.this.panelCustomers.getTxtCity().setText("");
				GUI.this.panelCustomers.getTxtPhone().setText("");
				
				GUI.this.panelCustomers.getTableCustomers().getSelectionModel().clearSelection();
				
				GUI.this.panelCustomers.getBtnDelete().setEnabled(false);
				GUI.this.panelCustomers.getBtnEdit().setEnabled(false);
			}
		});
		
		this.panelCustomers.setBtnDeleteActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int kdnr = Integer.valueOf((String) panelCustomers.getTableCustomers().getValueAt(panelCustomers.getTableCustomers().getSelectedRow(), 0));
				Kunde kunde = GUI.this.fachkonzept.getKundeByID(kdnr);
				if(kunde != null){
					GUI.this.fachkonzept.deleteKunde(kdnr);
					JOptionPane.showMessageDialog(GUI.this, "Der Kunde \"" + kunde.getVorname() + " " + kunde.getNachname() + "\" wurde erfolgreich gelöscht!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
					updateKundenTable();
				}
			}
		});
		
		this.panelCustomers.setBtnEditActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int kdnr = Integer.valueOf((String) panelCustomers.getTableCustomers().getValueAt(panelCustomers.getTableCustomers().getSelectedRow(), 0));
				Kunde kunde = GUI.this.fachkonzept.getKundeByID(kdnr);
				if(kunde != null){
					EditCustomerDialog editCustomerDialog = new EditCustomerDialog(GUI.this, kunde);
					editCustomerDialog.setVisible(true);
					if(editCustomerDialog.getDialogResult() == EditCustomerDialog.OK){
						updateKundenTable();
					}
					
				}
			}
		});
		
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
						kunde.getNachname(),
						kunde.getVorname(),
						kunde.getTelefonnr()});
			}
		}
	}
	
	/**
	 * Aktualisiert die Einträge in der Leih-Tabelle
	 */
	private void updateLendingTable() {
		List<Ausleihe> verleihlist = fachkonzept.getAllVerleihe();
		DefaultTableModel model = (DefaultTableModel) panelCustomers.getTableCustomers().getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if(verleihlist != null) {
			for (Ausleihe verleih : verleihlist) {
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
//		for (int i = 0; i < model.getRowCount(); i++) {
//			model.removeRow(i);
//		}
		model.setRowCount(0);
	}

	/**
	 * Überträgt Parameter der ausgewählten DVD in der Tabelle in die Textfelder
	 */
	private void dvdTableListSelectionChanged(){
		int dvdid = Integer.valueOf((String) panelDvd.getTableDvd().getValueAt(panelDvd.getTableDvd().getSelectedRow(), 0));
		DVD dvd = fachkonzept.getDVDByID(dvdid);
		//panelDvd.getTxtDvdNo().setText(String.valueOf(dvd.getDvd_nr()));
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
		//panelCustomers.getTxtCustomerNo().setText(String.valueOf(kunde.getKunden_nr()));
		panelCustomers.getTxtTitle().setText(kunde.getAnrede());
		panelCustomers.getTxtFirstName().setText(kunde.getVorname());
		panelCustomers.getTxtLastName().setText(kunde.getNachname());
		panelCustomers.getTxtZipCode().setText(kunde.getPlz());
		panelCustomers.getTxtCity().setText(kunde.getOrt());
		panelCustomers.getTxtStreet().setText(kunde.getStrasse());
		panelCustomers.getTxtPhone().setText(kunde.getTelefonnr());
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