package com.fa11.dvdverleih.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

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
				model.addRow(new String[]{"X", panelLending.getTxtDvdTitle().getText(), "bla", "blubb"});
			}
		});
		this.tabbedPane.addTab("DVD-Leihe", null, this.panelLending, null);

		this.panelDvd = new PanelDvd();
		this.panelDvd.setBtnResetActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)panelDvd.getTableDvd().getModel();
				model.addRow(new String[]{"","","",""});
			}
		});
		this.tabbedPane.addTab("DVD-Verwaltung", null, this.panelDvd, null);
		
		this.panelCustomers = new PanelCustomers();
		this.tabbedPane.addTab("Kunden-Verwaltung", null, this.panelCustomers, null);
		
	}
}