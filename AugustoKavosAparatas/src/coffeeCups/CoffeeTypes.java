/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeCups;

/**
 *
 * @author Brigita
 */
public enum CoffeeTypes {
    SMALL(new SmallCoffee()), BIG(new BigCoffee()), EXTRA(new ExtraCoffee());

    private CoffeeCup coffeeCup;

    CoffeeTypes(CoffeeCup coffeeCup) {
        this.coffeeCup = coffeeCup;
    }

    public CoffeeCup getCoffeeTypes() {
        return coffeeCup;
    }
    

}
