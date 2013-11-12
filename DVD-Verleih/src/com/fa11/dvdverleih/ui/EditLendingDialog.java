package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.fa11.dvdverleih.datenhaltung.tables.Ausleihe;

/**
 * Dialog zum Bearbeiten von Ausleihen
 * 
 * @author Timo Raschke
 */
public class EditLendingDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	public final static int OK = 1;
	public final static int ABORT = 0;

	private int dialogResult;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtKunde;
	private JTextField txtDVD;
	private JTextField txtAusleihe;
	private Ausleihe leihe;
	private JTextField txtRueckgabe;

	/**
	 * Dialog erstellen
	 */
	public EditLendingDialog(Component owner, Ausleihe leihe) {
		this.leihe = leihe;
		setModal(true);
		setResizable(false);
		setTitle("Ausleihe bearbeiten");
		setBounds(100, 100, 322, 173);
		setLocationRelativeTo(owner);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblKunde = new JLabel("Kunde:");
			GridBagConstraints gbc_lblKunde = new GridBagConstraints();
			gbc_lblKunde.anchor = GridBagConstraints.EAST;
			gbc_lblKunde.insets = new Insets(0, 0, 5, 5);
			gbc_lblKunde.gridx = 0;
			gbc_lblKunde.gridy = 0;
			contentPanel.add(lblKunde, gbc_lblKunde);
		}
		{
			this.txtKunde = new JTextField();
			this.txtKunde.setEnabled(false);
			GridBagConstraints gbc_txtKunde = new GridBagConstraints();
			gbc_txtKunde.insets = new Insets(0, 0, 5, 0);
			gbc_txtKunde.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtKunde.gridx = 1;
			gbc_txtKunde.gridy = 0;
			contentPanel.add(this.txtKunde, gbc_txtKunde);
			this.txtKunde.setColumns(10);
		}
		{
			JLabel lblDVD = new JLabel("DVD:");
			GridBagConstraints gbc_lblDVD = new GridBagConstraints();
			gbc_lblDVD.anchor = GridBagConstraints.EAST;
			gbc_lblDVD.insets = new Insets(0, 0, 5, 5);
			gbc_lblDVD.gridx = 0;
			gbc_lblDVD.gridy = 1;
			contentPanel.add(lblDVD, gbc_lblDVD);
		}
		{
			this.txtDVD = new JTextField();
			this.txtDVD.setEnabled(false);
			GridBagConstraints gbc_txtDVD = new GridBagConstraints();
			gbc_txtDVD.insets = new Insets(0, 0, 5, 0);
			gbc_txtDVD.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDVD.gridx = 1;
			gbc_txtDVD.gridy = 1;
			contentPanel.add(this.txtDVD, gbc_txtDVD);
			this.txtDVD.setColumns(10);
		}
		{
			JLabel lblAusleihe = new JLabel("Ausleihe:");
			GridBagConstraints gbc_lblAusleihe = new GridBagConstraints();
			gbc_lblAusleihe.anchor = GridBagConstraints.EAST;
			gbc_lblAusleihe.insets = new Insets(0, 0, 5, 5);
			gbc_lblAusleihe.gridx = 0;
			gbc_lblAusleihe.gridy = 2;
			contentPanel.add(lblAusleihe, gbc_lblAusleihe);
		}
		{
			this.txtAusleihe = new JTextField();
			this.txtAusleihe.setEnabled(false);
			GridBagConstraints gbc_txtAusleihe = new GridBagConstraints();
			gbc_txtAusleihe.insets = new Insets(0, 0, 5, 0);
			gbc_txtAusleihe.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAusleihe.gridx = 1;
			gbc_txtAusleihe.gridy = 2;
			contentPanel.add(this.txtAusleihe, gbc_txtAusleihe);
			this.txtAusleihe.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!EditLendingDialog.this.txtKunde.getText().equals(
								"")) {
							if (!EditLendingDialog.this.txtDVD.getText()
									.equals("")) {
								try {
									DateFormat df = new SimpleDateFormat(
											"dd.MM.YYYY");
									EditLendingDialog.this.leihe.setAusleihe(df
											.parse(EditLendingDialog.this.txtAusleihe
													.getText()));
									EditLendingDialog.this.leihe.setDvd_nr(Integer
											.valueOf(EditLendingDialog.this.txtDVD
													.getText()));
									EditLendingDialog.this.leihe.setKunden_nr(Integer
											.valueOf(EditLendingDialog.this.txtKunde
													.getText()));
									EditLendingDialog.this.leihe.setRueckgabe(df
											.parse(EditLendingDialog.this.txtRueckgabe
													.getText()));

									EditLendingDialog.this.dialogResult = EditLendingDialog.OK;
									EditLendingDialog.this.setVisible(false);
									EditLendingDialog.this.dispose();
								} catch (NumberFormatException e) {
									JOptionPane
											.showMessageDialog(
													EditLendingDialog.this,
													"Kundennummer und DVD dürfen nur aus Zahlen bestehen!",
													"Fehler",
													JOptionPane.ERROR_MESSAGE);
								} catch (ParseException e) {
									JOptionPane
											.showMessageDialog(
													EditLendingDialog.this,
													"Das Datum muss das Format DD.MM.YYYY haben!",
													"Fehler",
													JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(
										EditLendingDialog.this,
										"Das Genre darf nicht leer sein!",
										"Fehler", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(
									EditLendingDialog.this,
									"Der Titel darf nicht leer sein!",
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
					public void actionPerformed(ActionEvent arg0) {
						EditLendingDialog.this.dialogResult = EditLendingDialog.ABORT;
						EditLendingDialog.this.setVisible(false);
						EditLendingDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		{
			JLabel lblRueckgabe = new JLabel("R\u00FCckgabe:");
			GridBagConstraints gbc_lblRueckgabe = new GridBagConstraints();
			gbc_lblRueckgabe.anchor = GridBagConstraints.EAST;
			gbc_lblRueckgabe.insets = new Insets(0, 0, 0, 5);
			gbc_lblRueckgabe.gridx = 0;
			gbc_lblRueckgabe.gridy = 3;
			contentPanel.add(lblRueckgabe, gbc_lblRueckgabe);
		}
		{
			this.txtRueckgabe = new JTextField();
			GridBagConstraints gbc_txtRueckgabe = new GridBagConstraints();
			gbc_txtRueckgabe.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRueckgabe.gridx = 1;
			gbc_txtRueckgabe.gridy = 3;
			contentPanel.add(this.txtRueckgabe, gbc_txtRueckgabe);
			this.txtRueckgabe.setColumns(10);
		}

		this.txtKunde.setText(String.valueOf(this.leihe.getKunden_nr()));
		this.txtDVD.setText(String.valueOf(this.leihe.getDvd_nr()));
		this.txtAusleihe
				.setText(Helper.getDDMMYYYDate(this.leihe.getAusleihe()));
		if (this.leihe.getRueckgabe() != null) {
			this.txtRueckgabe.setText(Helper.getDDMMYYYDate(this.leihe
					.getRueckgabe()));
		}
	}

	public Ausleihe getAusleihe() {
		return this.leihe;
	}

	/**
	 * Gibt Dialogergebnis zurueck
	 * 
	 * @return dialogResult
	 */
	public int getDialogResult() {
		return dialogResult;
	}

}
