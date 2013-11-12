package com.fa11.dvdverleih.ui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hilfsklasse fuer das User Interface
 * 
 * @author Timo
 */
public class Helper {

	public static String getDDMMYYYYString(Date date) {
		DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
		return df.format(date);
	}

	/**
	 * Liest String von der Konsole ein
	 * 
	 * @return String
	 */
	public static String readString() {
		boolean korrekt = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String temp = "";
		do {
			korrekt = true;
			temp = scanner.nextLine();
			if (temp.equals("")) {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
		} while (!korrekt);
		return temp;
	}

	/**
	 * Liest char von der Konsole ein
	 * 
	 * @return Character
	 */
	public static char readChar() {
		boolean korrekt = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String temp = "";
		do {
			korrekt = true;
			temp = scanner.next();
			if (temp == "") {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
			scanner.nextLine();
		} while (!korrekt);
		return temp.charAt(0);
	}

	/**
	 * Liest char von der Konsole ein und gibt in als Kleinbuchstabe zurueck
	 * 
	 * @return Character
	 */
	public static char readToLowerChar() {
		boolean korrekt = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String temp = "";
		do {
			korrekt = true;
			temp = scanner.next();
			if (temp == "") {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
			scanner.nextLine();
		} while (!korrekt);
		return temp.toLowerCase().charAt(0);
	}

	/**
	 * Liest Integer von der Konsole ein
	 * 
	 * @return Integer
	 */
	public static int readInt() {
		boolean korrekt = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int temp = 0;
		do {
			korrekt = true;
			try {
				temp = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
			scanner.nextLine();
		} while (!korrekt);
		return temp;
	}

	/**
	 * Wartet in der Konsole so lange, bis Enter oder Return gedrueckt wurde
	 */
	public static void warteAufTaste() {
		System.out.print("Drücken Sie ENTER um fortzufahren...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
