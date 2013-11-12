package com.fa11.dvdverleih;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.fa11.dvdverleih.datenhaltung.DatenhaltungFactory;
import com.fa11.dvdverleih.datenhaltung.DatenhaltungType;
import com.fa11.dvdverleih.fachkonzept.Fachkonzept;
import com.fa11.dvdverleih.ui.StarterGUI;
import com.fa11.dvdverleih.ui.TUI;

/**
 * Startklasse des DVD Verleihs
 * 
 * @author Timo
 */
public class DVDVerleih {

	public static void main(String[] args) {
		if (args.length != 0) {
			switch (args[0]) {
			case "sqlite":
				new TUI(new Fachkonzept(
						DatenhaltungFactory
								.getDatenhaltung(DatenhaltungType.sqlite)));
				break;
			case "xml":
				new TUI(new Fachkonzept(
						DatenhaltungFactory
								.getDatenhaltung(DatenhaltungType.xml)));
				break;
			default:
				startGui();
				break;
			}
		} else {
			startGui();
		}
	}

	/**
	 * Startet die GUI
	 */
	public static void startGui() {
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
