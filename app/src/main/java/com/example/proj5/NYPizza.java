package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * class for ny pizza type
 * */
public class NYPizza implements PizzaFactory {
    /**
     * Method to create ny deluxe pizza
     * @return Pizza
     * */
    public Pizza createDeluxe(){
        //body
        Deluxe deluxePizza = new Deluxe();
        //deluxePizza.setToppings();
        deluxePizza.setCrust(Crust.BROOKLYN);
        return deluxePizza;
    }
    /**
     * Method to create ny meatzza
     * @return Pizza
     * */
    public Pizza createMeatzza(){
        //body
        Meatzza meatzzaPizza = new Meatzza();
        //meatzzaPizza.setToppings();
        meatzzaPizza.setCrust(Crust.THIN);
        return meatzzaPizza;
    }
    /**
     * Method to create ny bbq chicken pizza
     * @return Pizza
     * */
    public Pizza createBBQChicken(){
        //body
        BBQChicken bbqPizza = new BBQChicken();
        //bbqPizza.setToppings();
        bbqPizza.setCrust(Crust.HAND_TOSSED);
        return bbqPizza;

    }
    /**
     * Method to create ny build your own pizza
     * @return Pizza
     * */
    public Pizza createBuildYourOwn(){
        //body
        BuildYourOwn byoPizza = new BuildYourOwn();
        byoPizza.setCrust(Crust.HAND_TOSSED);
        return byoPizza;
    }
}
