package com.fa11.dvdverleih;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.fa11.dvdverleih.ui.StarterGUI;

public class DVDVerleih {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterGUI frame = new StarterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
