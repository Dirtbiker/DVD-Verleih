package com.fa11.dvdverleih.ui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {

	public static void main(String[] args) {
		Helper.readString();
	}

	public static String getDDMMYYYDate(Date date){
		DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
		return df.format(date);
	}
	
	public static String readString() {
		boolean korrekt = true;
		Scanner scanner = new Scanner(System.in);
		String temp = "";
		do{
			korrekt = true;
				temp = scanner.nextLine();
			if(temp.equals("")) {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
		} while(!korrekt);
//		scanner.close();
		return temp;
	}
	
	public static char readChar() {
		boolean korrekt = true;
		Scanner scanner = new Scanner(System.in);
		String temp = "";
		do{
			korrekt = true;
				temp = scanner.next();
			if(temp == "") {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
			scanner.nextLine();
		} while(!korrekt);
//		scanner.close();
		return temp.charAt(0);
	}
	
	public static char readToLowerChar() {
		boolean korrekt = true;
		Scanner scanner = new Scanner(System.in);
		String temp = "";
		do{
			korrekt = true;
				temp = scanner.next();
			if(temp == "") {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
			scanner.nextLine();
		} while(!korrekt);
//		scanner.close();
		return temp.toLowerCase().charAt(0);
	}

	public static int readInt(){
		boolean korrekt = true;
		Scanner scanner = new Scanner(System.in);
		int temp = 0;
		do{
			korrekt = true;
			try {
				temp = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("Falsche Eingabe, nochmals versuchen: ");
				korrekt = false;
			}
			scanner.nextLine();
		} while(!korrekt);
//		scanner.close();
		return temp;
	}
	
	public static void warteAufTaste() {
		System.out.print("Drücken Sie eine beliebige Taste um fortzufahren...");
		// scanner.nextLine();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
