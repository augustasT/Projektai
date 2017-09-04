package coffeeCups;

public class ExtraCoffee extends CoffeeCup {
	public static int extrasMade = 0;

	public ExtraCoffee() {
		super(30, 30, 30, 30, "Extra Coffee");
	}

        @Override 
	public void thisCoffeeMade() {
		extrasMade++;
	}

}
