package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fa11.dvdverleih.datenhaltung.tables.DVD;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDvdDialog extends JDialog {

	public final static int OK = 1;
	public final static int ABORT = 0;
	
	private int dialogResult;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitle;
	private JTextField txtGenre;
	private JTextField txtYear;
	private DVD dvd;

	/**
	 * Create the dialog.
	 */
	public EditDvdDialog(Component owner, DVD dvd) {
		this.dvd = dvd;
		setModal(true);
		setResizable(false);
		setTitle("DVD bearbeiten");
		setBounds(100, 100, 322, 148);
		setLocationRelativeTo(owner);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblTitleDesc = new JLabel("Titel:");
			GridBagConstraints gbc_lblTitleDesc = new GridBagConstraints();
			gbc_lblTitleDesc.anchor = GridBagConstraints.EAST;
			gbc_lblTitleDesc.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitleDesc.gridx = 0;
			gbc_lblTitleDesc.gridy = 0;
			contentPanel.add(lblTitleDesc, gbc_lblTitleDesc);
		}
		{
			this.txtTitle = new JTextField();
			GridBagConstraints gbc_txtTitle = new GridBagConstraints();
			gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
			gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTitle.gridx = 1;
			gbc_txtTitle.gridy = 0;
			contentPanel.add(this.txtTitle, gbc_txtTitle);
			this.txtTitle.setColumns(10);
		}
		{
			JLabel lblGenreDesc = new JLabel("Genre");
			GridBagConstraints gbc_lblGenreDesc = new GridBagConstraints();
			gbc_lblGenreDesc.anchor = GridBagConstraints.EAST;
			gbc_lblGenreDesc.insets = new Insets(0, 0, 5, 5);
			gbc_lblGenreDesc.gridx = 0;
			gbc_lblGenreDesc.gridy = 1;
			contentPanel.add(lblGenreDesc, gbc_lblGenreDesc);
		}
		{
			this.txtGenre = new JTextField();
			GridBagConstraints gbc_txtGenre = new GridBagConstraints();
			gbc_txtGenre.insets = new Insets(0, 0, 5, 0);
			gbc_txtGenre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGenre.gridx = 1;
			gbc_txtGenre.gridy = 1;
			contentPanel.add(this.txtGenre, gbc_txtGenre);
			this.txtGenre.setColumns(10);
		}
		{
			JLabel lblYearDesc = new JLabel("Erscheinungsjahr:");
			GridBagConstraints gbc_lblYearDesc = new GridBagConstraints();
			gbc_lblYearDesc.anchor = GridBagConstraints.EAST;
			gbc_lblYearDesc.insets = new Insets(0, 0, 0, 5);
			gbc_lblYearDesc.gridx = 0;
			gbc_lblYearDesc.gridy = 2;
			contentPanel.add(lblYearDesc, gbc_lblYearDesc);
		}
		{
			this.txtYear = new JTextField();
			GridBagConstraints gbc_txtYear = new GridBagConstraints();
			gbc_txtYear.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYear.gridx = 1;
			gbc_txtYear.gridy = 2;
			contentPanel.add(this.txtYear, gbc_txtYear);
			this.txtYear.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						EditDvdDialog.this.dvd.setTitel(EditDvdDialog.this.txtTitle.getText());
						EditDvdDialog.this.dvd.setGenre(EditDvdDialog.this.txtGenre.getText());
						EditDvdDialog.this.dvd.setErscheinungsjahr(Integer.valueOf(EditDvdDialog.this.txtYear.getText()));
						EditDvdDialog.this.dialogResult = EditDvdDialog.OK;
						EditDvdDialog.this.setVisible(false);
						EditDvdDialog.this.dispose();
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
						EditDvdDialog.this.dialogResult = EditDvdDialog.ABORT;
						EditDvdDialog.this.setVisible(false);
						EditDvdDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		this.txtTitle.setText(dvd.getTitel());
		this.txtGenre.setText(dvd.getGenre());
		this.txtYear.setText(String.valueOf(dvd.getErscheinungsjahr()));
	}

	public DVD getDvdResult(){
		return this.dvd;
	}

	public int getDialogResult() {
		return dialogResult;
	}
	
}
