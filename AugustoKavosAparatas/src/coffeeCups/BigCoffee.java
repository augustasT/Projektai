package coffeeCups;

public class BigCoffee extends CoffeeCup {

	public static int bigsMade = 0;

	public BigCoffee() {
		super(20, 20, 20, 20, "Big coffee");
	}

        @Override //pridėjau Override annotation'ą
	public void thisCoffeeMade() {
		bigsMade++;
	}
}
