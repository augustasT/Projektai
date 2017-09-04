package coffeeMainPack;

public class CoffeeMain {

    public static void main(String[] args) throws OutOfProducts, TimeToClean {

    	// komentaras
        Aptarnavimas aptarnavimasObject = new Aptarnavimas(1);
        CoffeeMachine manoAparatas = aptarnavimasObject.getAparatai(0);

        while (true) {
            try {
                manoAparatas.meniu();
                
                aptarnavimasObject.issaukMeniu(manoAparatas);

            } catch (OutOfProducts ep) {
            	System.err.println("Please replenish ingredients");
                aptarnavimasObject.replenishIngredients(manoAparatas);

            }
            catch (TimeToClean ep) {
            	System.err.println("clean");
            	aptarnavimasObject.jeiguReikiaIsvalyk(manoAparatas);

            }
        }

    }
}
