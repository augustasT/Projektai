package coffeeMainPack;

import java.util.*;
import coffeeCups.*;

public class CoffeeMachine {
	// KURIAMAS PRODUKTU OBJEKTAS

	private CoffeeCup coffeeType;
	CoffeeProducts produktai;
	boolean productsEnough = true;

	// PLOVIMAS
	private int panaudojimuSkaicius;
	private final int SERVISAS = 3;

	// KONSTRUKTORIUS
	public CoffeeMachine() {
		Random rnd = new Random();
		produktai = new CoffeeProducts(100, 80, 60, 100);
	}

	// USER INTERFEISAS
	public void meniu() throws OutOfProducts, TimeToClean {
		Scanner scn = new Scanner(System.in);

		System.out.printf(
				"Meniu%nSmall coffee: SMALL     Big coffee: BIG    Extra coffee: EXTRA%nIsjungti aparata: EXIT%n");
		String choice = scn.nextLine().toUpperCase();

		if (choice.equals("EXIT")) {
			scn.close();
			System.exit(0);
		} else if (panaudojimuSkaicius == SERVISAS) {
			throw new TimeToClean("Time to clean");
		} else {
			CoffeeTypes coffeeType = CoffeeTypes.valueOf(choice);
			CoffeeCup cofeeCup = coffeeType.getCoffeeTypes();
			makeCoffee(getCopy(cofeeCup));
		}

	}

	private CoffeeCup getCopy(CoffeeCup cup) {
		coffeeType = new CoffeeCup(cup.getSugar(), cup.getBeans(), cup.getWater(), cup.getMilk(), cup.getName());
		return coffeeType;

	}

	/*
	 * public void meniuMap() { Scanner scn = new Scanner(System.in);
	 * 
	 * Map<String, CoffeeTypes> coffees = new HashMap();
	 * 
	 * System.out.printf(
	 * "Meniu%nSmall coffee: SMALL     Big coffee: BIG    Extra coffee: EXTRA%nIsjungti aparata: EXIT%nRodyti visus sukurtus aparatus: MAP%n"
	 * );
	 * 
	 * for (int i = 0; i < 5; i++) { String choice = scn.nextLine().toUpperCase();
	 * switch (choice) { case "EXIT": scn.close(); System.exit(0); case "MAP":
	 * System.out.println(coffees.keySet()); break; default: coffees.put(choice,
	 * CoffeeTypes.valueOf(choice)); coffees.get(choice); CoffeeCup coffeeCupCopy =
	 * CoffeeTypes.valueOf(choice).getCoffeeTypes()
	 * .CopyOfCoffeeCup(CoffeeTypes.valueOf(choice).getCoffeeTypes());
	 * makeCoffee(coffeeCupCopy); break; } } scn.close(); System.exit(0);
	 * 
	 * }
	 */

	public final void makeCoffee(CoffeeCup drink) throws OutOfProducts {
		if (checkLeftovers(drink)) {
			drink = useProducts(drink);
			panaudojimuSkaicius++;
			System.out.println(drink.getName() + " made: " + drink.coffeeStatus());
			System.out.println("______________________________________________");
		} else {
			System.out.println(drink.getName() + " made: " + drink.coffeeStatus());
			System.out.println("______________________________________________");
			throw new OutOfProducts("Products empty");

		}

	}

	private CoffeeCup useProducts(CoffeeCup drink) {
		// NUSKAICIUOJA PRODUKTUS
		produktai.setCukrus(produktai.getCukrus() - drink.getSugar());
		produktai.setPupeles(produktai.getPupeles() - drink.getBeans());
		produktai.setVanduo(produktai.getVanduo() - drink.getWater());
		produktai.setPienas(produktai.getPienas() - drink.getMilk());
		drink.setStatusDone();

		// PRISKAICIUOJA +1 PRIE BENDRO KAVOS PUODELIU SKAICIAUS
		drink.coffeesMade++;

		// PRISKAICIUOJA +1 PRIE KIEKVIENOS RUSIES BENDRO PUODELIU SKAICIAUS
		drink.thisCoffeeMade();
		// padidina panaudojimu skaiciu

		return drink;
	}

	public boolean checkLeftovers(CoffeeCup drink) {
		int cukrausLikutis = produktai.getCukrus();
		int pupeliuLikutis = produktai.getPupeles();
		int vandensLikutis = produktai.getVanduo();
		int pienoLikutis = produktai.getPienas();

		if (cukrausLikutis <= drink.getSugar()) {
			System.out.println("Reikia papildyti cukraus!");
			productsEnough = false;
		}
		if (pupeliuLikutis <= drink.getBeans()) {
			System.out.println("Reikia papildyti pupeliu!");
			productsEnough = false;
		}
		if (vandensLikutis <= drink.getWater()) {
			System.out.println("Reikia papildyti vandens!");
			productsEnough = false;
		}
		if (pienoLikutis <= drink.getMilk()) {
			System.out.println("Reikia papildyti pieno!");
			productsEnough = false;
		}
		System.out.printf("%nProduktu likuciai%nCukrus: %d    Pupeles: %d    Vanduo: %d\t Pienas: %d%n%n",
				produktai.getCukrus(), produktai.getPupeles(), produktai.getVanduo(), produktai.getPienas());

		return productsEnough;
	}

	public int getPanaudojimuSkaicius() {
		return panaudojimuSkaicius;
	}

	public void setPanaudojimuSkaicius(int panaudojimuSkaicius) {
		this.panaudojimuSkaicius = panaudojimuSkaicius;
	}

	public int getSERVISAS() {
		return SERVISAS;
	}

	public boolean getIsEnough() {
		return productsEnough;
	}

}
