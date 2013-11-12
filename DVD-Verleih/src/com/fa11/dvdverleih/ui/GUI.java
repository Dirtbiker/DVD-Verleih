package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;
import com.fa11.dvdverleih.datenhaltung.tables.Kunde;
import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;
import com.fa11.dvdverleih.fachkonzept.FachkonzeptUtility;
import com.fa11.dvdverleih.fachkonzept.IFachkonzept;

/**
 * Grafische Benutzeroberfläche für den DVD-Verleih mit Swing
 * 
 * @author Timo Raschke
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
	 * GUI erstellen
	 * 
	 * @param fachkonzept
	 */
	public GUI(IFachkonzept fachkonzept) {
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						GUI.class
								.getResource("/com/fa11/dvdverleih/ui/ressources/dvd_unmount.png")));
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
		this.tabbedPane.addTab("DVD-Leihe", null, this.panelLending, null);

		this.panelDvd = new PanelDvd();
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDvd, null);

		this.panelCustomers = new PanelCustomers();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers,
				null);

		// Lending-Panel
		this.panelLending.setBtnCheckActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkLending();
			}
		});

		this.panelLending.setBtnResetActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetLending();
			}
		});

		this.panelLending.setBtnOkActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addLending();
			}
		});

		this.panelLending.setBtnEditActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editLending();
			}
		});

		this.panelLending.setBtnDeleteActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteLending();
			}
		});

		// DVD-Panel
		this.panelDvd.setBtnEditActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editDvd();
			}
		});

		this.panelDvd.setBtnDeleteActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteDvd();
			}
		});

		this.panelDvd.setBtnSaveActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addDvd();
			}
		});

		this.panelDvd.setBtnResetActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetDvd();
			}
		});

		// Kunden-Panel
		this.panelCustomers.setBtnSaveActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});

		this.panelCustomers.setBtnResetActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetCustomer();
			}
		});

		this.panelCustomers.setBtnDeleteActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCustomer();
			}
		});

		this.panelCustomers.setBtnEditActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editCustomer();
			}
		});

		// Tabellen befüllen
		updateLendingTable();
		updateDvdTable();
		updateKundenTable();
	}

	/**
	 * Loescht ausgewaehlte Ausleihe.
	 */
	private void deleteLending() {
		int verleihnr = Integer
				.valueOf((String) panelLending.getTableLending().getValueAt(
						panelLending.getTableLending().getSelectedRow(), 0));
		Ausleihe ausleihe = GUI.this.fachkonzept.getVerleihByID(verleihnr);
		if (ausleihe != null) {
			GUI.this.fachkonzept.deleteVerleih(verleihnr);
			JOptionPane.showMessageDialog(GUI.this,
					"Die Ausleihe wurde erfolgreich gelöscht!", "Erfolg",
					JOptionPane.INFORMATION_MESSAGE);
			updateLendingTable();
		}
	}

	/**
	 * Oeffnet Dialog zum bearbeiten des ausgewaehlten Kunden.
	 */
	private void editCustomer() {
		int kdnr = Integer
				.valueOf((String) panelCustomers.getTableCustomers()
						.getValueAt(
								panelCustomers.getTableCustomers()
										.getSelectedRow(), 0));
		Kunde kunde = GUI.this.fachkonzept.getKundeByID(kdnr);
		if (kunde != null) {
			EditCustomerDialog editCustomerDialog = new EditCustomerDialog(
					GUI.this, kunde);
			editCustomerDialog.setVisible(true);
			if (editCustomerDialog.getDialogResult() == EditCustomerDialog.OK) {
				GUI.this.fachkonzept.updateKunde(editCustomerDialog.getKunde());
				updateKundenTable();
			}
		}
	}

	/**
	 * Loescht ausgewaehlten Kunden.
	 */
	private void deleteCustomer() {
		int kdnr = Integer
				.valueOf((String) panelCustomers.getTableCustomers()
						.getValueAt(
								panelCustomers.getTableCustomers()
										.getSelectedRow(), 0));
		Kunde kunde = GUI.this.fachkonzept.getKundeByID(kdnr);
		if (kunde != null) {
			GUI.this.fachkonzept.deleteKunde(kdnr);
			JOptionPane.showMessageDialog(
					GUI.this,
					"Der Kunde \"" + kunde.getVorname() + " "
							+ kunde.getNachname()
							+ "\" wurde erfolgreich gelöscht!", "Erfolg",
					JOptionPane.INFORMATION_MESSAGE);
			updateKundenTable();
		}
	}

	/**
	 * Setzt alle Felder im Kunden-Tab zurueck.
	 */
	private void resetCustomer() {
		GUI.this.panelCustomers.getTxtTitle().setText("");
		GUI.this.panelCustomers.getTxtFirstName().setText("");
		GUI.this.panelCustomers.getTxtLastName().setText("");
		GUI.this.panelCustomers.getTxtStreet().setText("");
		GUI.this.panelCustomers.getTxtNo().setText("");
		GUI.this.panelCustomers.getTxtZipCode().setText("");
		GUI.this.panelCustomers.getTxtCity().setText("");
		GUI.this.panelCustomers.getTxtPhone().setText("");

		GUI.this.panelCustomers.getTableCustomers().getSelectionModel()
				.clearSelection();

		GUI.this.panelCustomers.getBtnDelete().setEnabled(false);
		GUI.this.panelCustomers.getBtnEdit().setEnabled(false);
	}

	/**
	 * Fuegt neuen Kunden hinzu.
	 */
	private void addCustomer() {
		try {
			String anrede = GUI.this.panelCustomers.getTxtTitle().getText();
			String vorname = GUI.this.panelCustomers.getTxtFirstName()
					.getText();
			String nachname = GUI.this.panelCustomers.getTxtLastName()
					.getText();
			String strasse = GUI.this.panelCustomers.getTxtStreet().getText();
			String hausnr = GUI.this.panelCustomers.getTxtNo().getText();
			String plz = GUI.this.panelCustomers.getTxtZipCode().getText();
			String ort = GUI.this.panelCustomers.getTxtCity().getText();
			String telefon = GUI.this.panelCustomers.getTxtPhone().getText();

			if (!anrede.equals("")) {
				if (!vorname.equals("")) {
					if (!nachname.equals("")) {
						if (!strasse.equals("")) {
							if (!hausnr.equals("")) {
								if (!plz.equals("")) {
									if (!ort.equals("")) {
										if (!telefon.equals("")) {
											Kunde kunde = new Kunde(anrede,
													vorname, nachname,
													new Date(), plz, ort,
													strasse,
													Integer.valueOf(hausnr),
													telefon);

											GUI.this.fachkonzept
													.createKunde(kunde);
											JOptionPane
													.showMessageDialog(
															GUI.this,
															"Kunde wurde erfolgreich hinzugefügt!",
															"Erfolg",
															JOptionPane.INFORMATION_MESSAGE);
											GUI.this.panelCustomers
													.getTxtTitle().setText("");
											GUI.this.panelCustomers
													.getTxtFirstName().setText(
															"");
											GUI.this.panelCustomers
													.getTxtLastName().setText(
															"");
											GUI.this.panelCustomers
													.getTxtStreet().setText("");
											GUI.this.panelCustomers.getTxtNo()
													.setText("");
											GUI.this.panelCustomers
													.getTxtZipCode()
													.setText("");
											GUI.this.panelCustomers
													.getTxtCity().setText("");
											GUI.this.panelCustomers
													.getTxtPhone().setText("");
											updateKundenTable();
										} else {
											JOptionPane
													.showMessageDialog(
															GUI.this,
															"Die Telefonnummer darf nicht leer sein!",
															"Fehler",
															JOptionPane.ERROR_MESSAGE);
										}
									} else {
										JOptionPane
												.showMessageDialog(
														GUI.this,
														"Der Ort darf nicht leer sein!",
														"Fehler",
														JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane
											.showMessageDialog(
													GUI.this,
													"Die Postleitzahl darf nicht leer sein!",
													"Fehler",
													JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(GUI.this,
										"Die Hausnummer darf nicht leer sein!",
										"Fehler", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(GUI.this,
									"Die Straße darf nicht leer sein!",
									"Fehler", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(GUI.this,
								"Der Nachname darf nicht leer sein!", "Fehler",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(GUI.this,
							"Der Vorname darf nicht leer sein!", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(GUI.this,
						"Die Anrede darf nicht leer sein!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(GUI.this,
					"Die Hausnummer darf nur aus Ziffern bestehen!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Setzt alle Felder im DVD-Tab zurueck.
	 */
	private void resetDvd() {
		GUI.this.panelDvd.getTxtDvdTitle().setText("");
		GUI.this.panelDvd.getTxtDvdGenre().setText("");
		GUI.this.panelDvd.getTxtDvdYear().setText("");

		GUI.this.panelDvd.getTableDvd().getSelectionModel().clearSelection();

		GUI.this.panelDvd.getBtnDelete().setEnabled(false);
		GUI.this.panelDvd.getBtnEdit().setEnabled(false);
	}

	/**
	 * Fuegt eine neue DVD hinzu.
	 */
	private void addDvd() {
		String dvdTitel = GUI.this.panelDvd.getTxtDvdTitle().getText();
		String dvdGenre = GUI.this.panelDvd.getTxtDvdGenre().getText();
		try {
			int dvdYear = Integer.valueOf(GUI.this.panelDvd.getTxtDvdYear()
					.getText());
			if (!dvdTitel.equals("")) {
				if (!dvdGenre.equals("")) {
					DVD dvd = new DVD(dvdTitel, dvdGenre, dvdYear);
					GUI.this.fachkonzept.createDVD(dvd);
					JOptionPane.showMessageDialog(GUI.this,
							"DVD wurde erfolgreich hinzugefügt!", "Erfolg",
							JOptionPane.INFORMATION_MESSAGE);
					GUI.this.panelDvd.getTxtDvdTitle().setText("");
					GUI.this.panelDvd.getTxtDvdGenre().setText("");
					GUI.this.panelDvd.getTxtDvdYear().setText("");
					updateDvdTable();
				} else {
					JOptionPane.showMessageDialog(GUI.this,
							"Das Genre darf nicht leer sein!", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(GUI.this,
						"Der Titel darf nicht leer sein!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(GUI.this,
					"Das Jahr darf nur aus Zahlen bestehen!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Loescht die ausgewaehlte DVD.
	 */
	private void deleteDvd() {
		int dvdid = Integer.valueOf((String) panelDvd.getTableDvd().getValueAt(
				panelDvd.getTableDvd().getSelectedRow(), 0));
		DVD dvd = GUI.this.fachkonzept.getDVDByID(dvdid);
		if (dvd != null) {
			GUI.this.fachkonzept.deleteDVD(dvdid);
			JOptionPane.showMessageDialog(GUI.this,
					"Die DVD \"" + dvd.getTitel()
							+ "\" wurde erfolgreich gelöscht!", "Erfolg",
					JOptionPane.INFORMATION_MESSAGE);
			updateDvdTable();
		}
	}

	/**
	 * Oeffnet Dialog zum bearbeiten der ausgewaehlten DVD.
	 */
	private void editDvd() {
		int dvdid = Integer.valueOf((String) panelDvd.getTableDvd().getValueAt(
				panelDvd.getTableDvd().getSelectedRow(), 0));
		DVD dvd = GUI.this.fachkonzept.getDVDByID(dvdid);
		if (dvd != null) {
			EditDvdDialog editDvdDialog = new EditDvdDialog(GUI.this, dvd);
			editDvdDialog.setVisible(true);
			if (editDvdDialog.getDialogResult() == EditDvdDialog.OK) {
				GUI.this.fachkonzept.updateDVD(editDvdDialog.getDvd());
				updateDvdTable();
			}
		}
	}

	/**
	 * Oeffnet Dialog zum bearbeiten der ausgewaehlten Ausleihe.
	 */
	private void editLending() {
		int verleihid = Integer
				.valueOf((String) panelLending.getTableLending().getValueAt(
						panelLending.getTableLending().getSelectedRow(), 0));
		Ausleihe ausleihe = GUI.this.fachkonzept.getVerleihByID(verleihid);
		if (ausleihe != null) {
			EditLendingDialog editLendingDialog = new EditLendingDialog(
					GUI.this, ausleihe);
			editLendingDialog.setVisible(true);
			if (editLendingDialog.getDialogResult() == EditLendingDialog.OK) {
				GUI.this.fachkonzept.updateVerleih(editLendingDialog
						.getAusleihe());
				updateLendingTable();
			}
		}
	}

	/**
	 * Fuegt eine neue Ausleihe hinzu.
	 */
	private void addLending() {
		if (GUI.this.panelLending.getChkAvailable().isSelected()) {
			int dvd_nr = Integer.valueOf(GUI.this.panelLending.getTxtDvdNo()
					.getText());
			int kunden_nr = Integer.valueOf(GUI.this.panelLending
					.getTxtCustomerNo().getText());

			GUI.this.fachkonzept.createVerleih(new Ausleihe(dvd_nr, kunden_nr,
					new Date(), null));
			JOptionPane.showMessageDialog(GUI.this,
					"Die Leihe wurde erfolgreich hinzugefügt!", "Erfolg",
					JOptionPane.INFORMATION_MESSAGE);
			updateLendingTable();
		} else {
			JOptionPane
					.showMessageDialog(
							GUI.this,
							"Die DVD ist nicht verfügbar oder wurde noch nicht geprüft!",
							"Fehler", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Setzt alle Felder im Verleih-Tab zurueck.
	 */
	private void resetLending() {
		GUI.this.panelLending.getTxtCustomerNo().setText("");
		GUI.this.panelLending.getTxtDvdNo().setText("");
		GUI.this.panelLending.getTxtDvdTitle().setText("");
		GUI.this.panelLending.getTxtFirstName().setText("");
		GUI.this.panelLending.getTxtLastName().setText("");
		GUI.this.panelLending.getChkAvailable().setSelected(false);

		GUI.this.panelLending.getTableLending().getSelectionModel()
				.clearSelection();

		GUI.this.panelLending.getBtnDelete().setEnabled(false);
		GUI.this.panelLending.getBtnEdit().setEnabled(false);
		GUI.this.panelLending.getBtnOk().setEnabled(false);
	}

	/**
	 * Fuellt Felder im Verleih-Tab mit passenden Kunden / DVD Attributen.
	 */
	private void checkLending() {
		boolean kundeOk = true;
		boolean dvdOk = true;
		GUI.this.panelLending.getBtnOk().setEnabled(false);
		try {
			int kdNr = Integer.valueOf(GUI.this.panelLending.getTxtCustomerNo()
					.getText());
			Kunde kunde = GUI.this.fachkonzept.getKundeByID(kdNr);
			if (kunde != null) {
				GUI.this.panelLending.getTxtFirstName().setText(
						kunde.getVorname());
				GUI.this.panelLending.getTxtLastName().setText(
						kunde.getNachname());
			} else {
				JOptionPane.showMessageDialog(GUI.this,
						"Der Kunde mit der Kundennummer \"" + kdNr
								+ "\" wurde nicht gefunden!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
				kundeOk = false;
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(GUI.this,
					"Die Kundennummer darf nur aus Zahlen bestehen!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			kundeOk = false;
		}

		try {
			int dvdNr = Integer.valueOf(GUI.this.panelLending.getTxtDvdNo()
					.getText());
			DVD dvd = GUI.this.fachkonzept.getDVDByID(dvdNr);
			if (dvd != null) {
				GUI.this.panelLending.getTxtDvdTitle().setText(dvd.getTitel());
				if (FachkonzeptUtility.isDVDAvailable(dvd.getDvd_nr(),
						GUI.this.fachkonzept)) {
					panelLending.getChkAvailable().setSelected(true);
				} else {
					panelLending.getChkAvailable().setSelected(false);
				}
			} else {
				JOptionPane.showMessageDialog(GUI.this,
						"Die DVD mit der Nummer \"" + dvdNr
								+ "\" wurde nicht gefunden!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
				dvdOk = false;
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(GUI.this,
					"Die DVD-Nummer darf nur aus Zahlen bestehen!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			dvdOk = false;
		}

		if (kundeOk && dvdOk) {
			GUI.this.panelLending.getBtnOk().setEnabled(true);
		}
	}

	/**
	 * Aktualisiert die Eintraege in der DVD Tabelle
	 */
	private void updateDvdTable() {
		List<DVD> dvdlist = fachkonzept.getAllDVDs();
		DefaultTableModel model = (DefaultTableModel) panelDvd.getTableDvd()
				.getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if (dvdlist != null) {
			for (DVD dvd : dvdlist) {
				model.addRow(new String[] { String.valueOf(dvd.getDvd_nr()),
						dvd.getTitel(), dvd.getGenre(),
						String.valueOf(dvd.getErscheinungsjahr()) });
			}
		}

	}

	/**
	 * Aktualisiert die Eintraege in der KundenTabelle
	 */
	private void updateKundenTable() {
		List<Kunde> kundenlist = fachkonzept.getAllKunden();
		DefaultTableModel model = (DefaultTableModel) panelCustomers
				.getTableCustomers().getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if (kundenlist != null) {
			for (Kunde kunde : kundenlist) {
				model.addRow(new String[] {
						String.valueOf(kunde.getKunden_nr()),
						kunde.getNachname(), kunde.getVorname(),
						kunde.getTelefonnr() });
			}
		}
	}

	/**
	 * Aktualisiert die Eintraege in der Leih-Tabelle
	 */
	private void updateLendingTable() {
		List<Ausleihe> verleihlist = fachkonzept.getAllVerleihe();
		DefaultTableModel model = (DefaultTableModel) panelLending
				.getTableLending().getModel();
		// Tabelle leeren
		clearTablemodel(model);
		// Tabelle füllen
		if (verleihlist != null) {
			for (Ausleihe verleih : verleihlist) {
				String rueckgabe = "";
				if (verleih.getRueckgabe() != null)
					rueckgabe = Helper.getDDMMYYYDate(verleih.getRueckgabe());
				model.addRow(new String[] {
						String.valueOf(verleih.getLeihvorgangs_nr()),
						fachkonzept.getDVDByID(verleih.getDvd_nr()).getTitel(),
						fachkonzept.getKundeByID(verleih.getKunden_nr())
								.getNachname()
								+ ", "
								+ fachkonzept.getKundeByID(
										verleih.getKunden_nr()).getVorname(),
						Helper.getDDMMYYYDate(verleih.getAusleihe()), rueckgabe });
			}
		}
	}

	/**
	 * Loescht alle Elemente eines DefaultTableModel
	 * 
	 * @param model
	 */
	private void clearTablemodel(DefaultTableModel model) {
		model.setRowCount(0);
	}
}