package coffeeMainPack;

import java.util.*;

public class Aptarnavimas {

    private CoffeeMachine aparatuMasyvas[];
    private ArrayList<CoffeeMachine> machineList;
    private Map<Integer, CoffeeMachine> machineMap;
    private int aparatuSkaicius;
    private static int totalOfMachines;

    // KONSTRUKTORIUS, PRIIMA APARATU KIEKI
    public Aptarnavimas(int aparatuSkaicius) {
        this.aparatuSkaicius = aparatuSkaicius;
        aparatuMasyvas = new CoffeeMachine[aparatuSkaicius];
        sukurkAparatus();
    }

    // KURIA i NAUJU APARATU
    public void sukurkAparatus() {
        for (int i = 0; i < aparatuSkaicius; i++) {
            aparatuMasyvas[i] = new CoffeeMachine();
            totalOfMachines++;
        }

    }

    //KURIA LISTA
    /*public void createMachineList(CoffeeMachine machine, int amount) {
		machineList = new ArrayList<CoffeeMachine>();

		for (int i = 0; i < amount; i++) {
			machineList.add(new CoffeeMachine());
		}
		totalOfMachines += amount;
	}*/
    // KURIA MAPA
    /*public void createMachineMap(CoffeeMachine machine, int amount) {
		machineMap = new HashMap<Integer, CoffeeMachine>();

		for (int i = 0; i < amount; i++) {
			machineMap.put(i, new CoffeeMachine());
		}
		totalOfMachines += amount;

	}*/
    public void jeiguReikiaIsvalyk(CoffeeMachine x) { //geras  metodas, man patiko
        if (x.getPanaudojimuSkaicius() == x.getSERVISAS()) {
            isvalyk(x);
        }
    }

    // ISVALO PASIRINKTA KAVOS APARATA
    private void isvalyk(CoffeeMachine machine) {
        machine.setPanaudojimuSkaicius(0);
        System.out.println("Aparatas isvalytas. Panaudojimu skaicius: " + machine.getPanaudojimuSkaicius());
    }

    // ISVALO VISUS PER MASYVA PERDUOTUS APARATUS
    public void isvalykVisus(CoffeeMachine[] machine) {
        for (CoffeeMachine aparatas : machine) {
            isvalyk(aparatas);
        }
    }

    // VALO LISTA
    /*public void isvalykVisus(ArrayList<CoffeeMachine> machines) {
		for (CoffeeMachine machine : machines)
			isvalyk(machine);
	}*/
    // VALO MAPA
    /*public void isvalykVisus(Map<Integer, CoffeeMachine> machines) {
		machines.entrySet();
		machines.keySet(); // machines.get(key)
		for (CoffeeMachine machine : machines.values()) {
			isvalyk(machine);
		}
	}*/
    // ISKVIECIA MENIU
    public void issaukMeniu(CoffeeMachine x) throws OutOfProducts, TimeToClean {
        x.meniu();
    }

    public CoffeeMachine getAparatai(int numeris) {
        return aparatuMasyvas[numeris];
    }

    public void replenishIngredients(CoffeeMachine aparatas) {
        if (!aparatas.getIsEnough()) {
            aparatas.produktai.setCukrus(aparatas.produktai.getCukrus() + 200);
            aparatas.produktai.setPupeles(aparatas.produktai.getPupeles() + 200);
            aparatas.produktai.setVanduo(aparatas.produktai.getVanduo() + 200);
            aparatas.produktai.setPienas(aparatas.produktai.getPienas() + 200);

            System.out.println("Products were replenished");
            aparatas.productsEnough = true;
        }
    }

    /*public static void printNumberOfMachinesInList() {
		System.out.println("Number of machines in list is: " + totalOfMachines);
	}*/
}
