package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import com.fa11.dvdverleih.datenhaltung.tables.Kunde;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Dialog zum Bearbeiten von Kunden
 * 
 * @author Timo Raschke
 */
public class EditCustomerDialog extends JDialog {

	private static final long serialVersionUID = 1257636699266058429L;
	public final static int OK = 1;
	public final static int ABORT = 0;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAnrede;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtStrasse;
	private JTextField txtPLZ;
	private JTextField txtOrt;
	private JTextField txtTel;
	private JTextField txtHausnr;
	private int dialogResult;
	private Kunde kunde;

	/**
	 * Create the dialog.
	 */
	public EditCustomerDialog(Component owner, Kunde kunde) {
		this.kunde = kunde;
		setResizable(false);
		setModal(true);
		setTitle("Kunde bearbeiten");
		setBounds(100, 100, 343, 280);
		setLocationRelativeTo(owner);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAnrede = new JLabel("Anrede");
			GridBagConstraints gbc_lblAnrede = new GridBagConstraints();
			gbc_lblAnrede.anchor = GridBagConstraints.EAST;
			gbc_lblAnrede.insets = new Insets(0, 0, 5, 5);
			gbc_lblAnrede.gridx = 0;
			gbc_lblAnrede.gridy = 0;
			contentPanel.add(lblAnrede, gbc_lblAnrede);
		}
		{
			this.txtAnrede = new JTextField();
			GridBagConstraints gbc_txtAnrede = new GridBagConstraints();
			gbc_txtAnrede.insets = new Insets(0, 0, 5, 0);
			gbc_txtAnrede.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAnrede.gridx = 1;
			gbc_txtAnrede.gridy = 0;
			contentPanel.add(this.txtAnrede, gbc_txtAnrede);
			this.txtAnrede.setColumns(10);
		}
		{
			JLabel lblVorname = new JLabel("Vorname");
			GridBagConstraints gbc_lblVorname = new GridBagConstraints();
			gbc_lblVorname.anchor = GridBagConstraints.EAST;
			gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
			gbc_lblVorname.gridx = 0;
			gbc_lblVorname.gridy = 1;
			contentPanel.add(lblVorname, gbc_lblVorname);
		}
		{
			this.txtVorname = new JTextField();
			GridBagConstraints gbc_txtVorname = new GridBagConstraints();
			gbc_txtVorname.insets = new Insets(0, 0, 5, 0);
			gbc_txtVorname.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtVorname.gridx = 1;
			gbc_txtVorname.gridy = 1;
			contentPanel.add(this.txtVorname, gbc_txtVorname);
			this.txtVorname.setColumns(10);
		}
		{
			JLabel lblNachname = new JLabel("Nachname");
			GridBagConstraints gbc_lblNachname = new GridBagConstraints();
			gbc_lblNachname.anchor = GridBagConstraints.EAST;
			gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
			gbc_lblNachname.gridx = 0;
			gbc_lblNachname.gridy = 2;
			contentPanel.add(lblNachname, gbc_lblNachname);
		}
		{
			this.txtNachname = new JTextField();
			GridBagConstraints gbc_txtNachname = new GridBagConstraints();
			gbc_txtNachname.insets = new Insets(0, 0, 5, 0);
			gbc_txtNachname.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNachname.gridx = 1;
			gbc_txtNachname.gridy = 2;
			contentPanel.add(this.txtNachname, gbc_txtNachname);
			this.txtNachname.setColumns(10);
		}
		{
			JLabel lblStrae = new JLabel("Stra\u00DFe");
			GridBagConstraints gbc_lblStrae = new GridBagConstraints();
			gbc_lblStrae.anchor = GridBagConstraints.EAST;
			gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
			gbc_lblStrae.gridx = 0;
			gbc_lblStrae.gridy = 3;
			contentPanel.add(lblStrae, gbc_lblStrae);
		}
		{
			this.txtStrasse = new JTextField();
			GridBagConstraints gbc_txtStrasse = new GridBagConstraints();
			gbc_txtStrasse.insets = new Insets(0, 0, 5, 0);
			gbc_txtStrasse.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStrasse.gridx = 1;
			gbc_txtStrasse.gridy = 3;
			contentPanel.add(this.txtStrasse, gbc_txtStrasse);
			this.txtStrasse.setColumns(10);
		}
		{
			JLabel lblHausnr = new JLabel("Haus-Nr.");
			GridBagConstraints gbc_lblHausnr = new GridBagConstraints();
			gbc_lblHausnr.anchor = GridBagConstraints.EAST;
			gbc_lblHausnr.insets = new Insets(0, 0, 5, 5);
			gbc_lblHausnr.gridx = 0;
			gbc_lblHausnr.gridy = 4;
			contentPanel.add(lblHausnr, gbc_lblHausnr);
		}
		{
			this.txtHausnr = new JTextField();
			GridBagConstraints gbc_txtHausnr = new GridBagConstraints();
			gbc_txtHausnr.insets = new Insets(0, 0, 5, 0);
			gbc_txtHausnr.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHausnr.gridx = 1;
			gbc_txtHausnr.gridy = 4;
			contentPanel.add(this.txtHausnr, gbc_txtHausnr);
			this.txtHausnr.setColumns(10);
		}
		{
			JLabel lblPlz = new JLabel("PLZ");
			GridBagConstraints gbc_lblPlz = new GridBagConstraints();
			gbc_lblPlz.anchor = GridBagConstraints.EAST;
			gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
			gbc_lblPlz.gridx = 0;
			gbc_lblPlz.gridy = 5;
			contentPanel.add(lblPlz, gbc_lblPlz);
		}
		{
			this.txtPLZ = new JTextField();
			GridBagConstraints gbc_txtPLZ = new GridBagConstraints();
			gbc_txtPLZ.insets = new Insets(0, 0, 5, 0);
			gbc_txtPLZ.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPLZ.gridx = 1;
			gbc_txtPLZ.gridy = 5;
			contentPanel.add(this.txtPLZ, gbc_txtPLZ);
			this.txtPLZ.setColumns(10);
		}
		{
			JLabel lblOrt = new JLabel("Ort");
			GridBagConstraints gbc_lblOrt = new GridBagConstraints();
			gbc_lblOrt.anchor = GridBagConstraints.EAST;
			gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
			gbc_lblOrt.gridx = 0;
			gbc_lblOrt.gridy = 6;
			contentPanel.add(lblOrt, gbc_lblOrt);
		}
		{
			this.txtOrt = new JTextField();
			GridBagConstraints gbc_txtOrt = new GridBagConstraints();
			gbc_txtOrt.insets = new Insets(0, 0, 5, 0);
			gbc_txtOrt.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOrt.gridx = 1;
			gbc_txtOrt.gridy = 6;
			contentPanel.add(this.txtOrt, gbc_txtOrt);
			this.txtOrt.setColumns(10);
		}
		{
			JLabel lblTelefon = new JLabel("Telefon");
			GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
			gbc_lblTelefon.anchor = GridBagConstraints.EAST;
			gbc_lblTelefon.insets = new Insets(0, 0, 0, 5);
			gbc_lblTelefon.gridx = 0;
			gbc_lblTelefon.gridy = 7;
			contentPanel.add(lblTelefon, gbc_lblTelefon);
		}
		{
			this.txtTel = new JTextField();
			GridBagConstraints gbc_txtTel = new GridBagConstraints();
			gbc_txtTel.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTel.gridx = 1;
			gbc_txtTel.gridy = 7;
			contentPanel.add(this.txtTel, gbc_txtTel);
			this.txtTel.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String anrede = txtAnrede.getText();
							String vorname = txtVorname.getText();
							String nachname = txtNachname.getText();
							String strasse = txtStrasse.getText();
							String hausnr = txtHausnr.getText();
							String plz = txtPLZ.getText();
							String ort = txtOrt.getText();
							String telefon = txtTel.getText();

							if (!anrede.equals("")) {
								if (!vorname.equals("")) {
									if (!nachname.equals("")) {
										if (!strasse.equals("")) {
											if (!hausnr.equals("")) {
												if (!plz.equals("")) {
													if (!ort.equals("")) {
														if (!telefon.equals("")) {
															EditCustomerDialog.this.kunde
																	.setHausnr(Integer
																			.valueOf(hausnr));
															EditCustomerDialog.this.kunde
																	.setAnrede(anrede);
															EditCustomerDialog.this.kunde
																	.setNachname(nachname);
															EditCustomerDialog.this.kunde
																	.setOrt(ort);
															EditCustomerDialog.this.kunde
																	.setPlz(plz);
															EditCustomerDialog.this.kunde
																	.setStrasse(strasse);
															EditCustomerDialog.this.kunde
																	.setTelefonnr(telefon);
															EditCustomerDialog.this.kunde
																	.setVorname(vorname);
															dialogResult = EditCustomerDialog.OK;
															EditCustomerDialog.this
																	.setVisible(false);
															EditCustomerDialog.this
																	.dispose();
														} else {
															JOptionPane
																	.showMessageDialog(
																			EditCustomerDialog.this,
																			"Die Telefonnummer darf nicht leer sein!",
																			"Fehler",
																			JOptionPane.ERROR_MESSAGE);
														}
													} else {
														JOptionPane
																.showMessageDialog(
																		EditCustomerDialog.this,
																		"Der Ort darf nicht leer sein!",
																		"Fehler",
																		JOptionPane.ERROR_MESSAGE);
													}
												} else {
													JOptionPane
															.showMessageDialog(
																	EditCustomerDialog.this,
																	"Die Postleitzahl darf nicht leer sein!",
																	"Fehler",
																	JOptionPane.ERROR_MESSAGE);
												}
											} else {
												JOptionPane
														.showMessageDialog(
																EditCustomerDialog.this,
																"Die Hausnummer darf nicht leer sein!",
																"Fehler",
																JOptionPane.ERROR_MESSAGE);
											}
										} else {
											JOptionPane
													.showMessageDialog(
															EditCustomerDialog.this,
															"Die Straﬂe darf nicht leer sein!",
															"Fehler",
															JOptionPane.ERROR_MESSAGE);
										}
									} else {
										JOptionPane
												.showMessageDialog(
														EditCustomerDialog.this,
														"Der Nachname darf nicht leer sein!",
														"Fehler",
														JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane
											.showMessageDialog(
													EditCustomerDialog.this,
													"Der Vorname darf nicht leer sein!",
													"Fehler",
													JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(
										EditCustomerDialog.this,
										"Die Anrede darf nicht leer sein!",
										"Fehler", JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException nfe) {
							JOptionPane
									.showMessageDialog(
											EditCustomerDialog.this,
											"Die Hausnummer darf nur aus Ziffern bestehen!",
											"Fehler", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditCustomerDialog.this.dialogResult = EditCustomerDialog.ABORT;
						EditCustomerDialog.this.setVisible(false);
						EditCustomerDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.txtAnrede.setText(kunde.getAnrede());
		this.txtHausnr.setText(String.valueOf(kunde.getHausnr()));
		this.txtNachname.setText(kunde.getNachname());
		this.txtOrt.setText(kunde.getOrt());
		this.txtPLZ.setText(kunde.getPlz());
		this.txtStrasse.setText(kunde.getStrasse());
		this.txtTel.setText(kunde.getTelefonnr());
		this.txtVorname.setText(kunde.getVorname());
	}

	/**
	 * Gibt Dialogergebnis zurueck
	 * 
	 * @return dialogResult
	 */
	public int getDialogResult() {
		return dialogResult;
	}

	public Kunde getKunde() {
		return kunde;
	}

}
