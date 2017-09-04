package coffeeCups;

public class SmallCoffee extends CoffeeCup {
	public static int smallsMade = 0;

	public SmallCoffee() {
		super(10, 10, 10, 10, "Small coffee");
	}

	@Override
	public void thisCoffeeMade() {
		smallsMade++;
	}

}