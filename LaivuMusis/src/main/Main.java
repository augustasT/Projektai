package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		AplinkaImplementation aplinka = new AplinkaImplementation();

		aplinka.padetiLaiva(3, 7, 1, Kryptis.HORIZONTAL);
		aplinka.gautiLenta();
		
		while (aplinka.patikrinkArYraGyvuLaivu()) {
			aplinka.atspausdinkLenta();
			System.out.println("Ivesk X ir Y");
			aplinka.sauti(scn.nextInt()-1, scn.nextInt()-1);
		}
		aplinka.atspausdinkLenta();
		scn.close();
		

	}

	

}
