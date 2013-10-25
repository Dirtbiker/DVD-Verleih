package com.fa11.dvdverleih.ui;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {

	public static void main(String[] args) {
		Helper.readString();
	}

	public static String readString() {
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
