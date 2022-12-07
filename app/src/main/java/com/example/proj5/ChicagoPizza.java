package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * class for chicago pizza
 * */
public class ChicagoPizza implements PizzaFactory {
    /**
     * Method to create chicago deluxe pizza
     * @return Pizza
     * */
    public Pizza createDeluxe(){
        //body
        Deluxe deluxePizza = new Deluxe();
        deluxePizza.setCrust(Crust.DEEP_DISH);
        return deluxePizza;
    }
    /**
     * Method to create chicago meatzaa
     * @return Pizza
     * */
    public Pizza createMeatzza(){
        //body
        Meatzza meatzzaPizza = new Meatzza();
        meatzzaPizza.setCrust(Crust.PAN);
        return meatzzaPizza;
    }
    /**
     * Method to create bbq chicken pizza
     * @return Pizza
     * */
    public Pizza createBBQChicken(){
        //body
        BBQChicken bbqPizza = new BBQChicken();
        bbqPizza.setCrust(Crust.STUFFED);
        return bbqPizza;
    }
    /**
     * Method to create build your own pizza
     * @return Pizza
     * */
    public Pizza createBuildYourOwn(){
        //body
        BuildYourOwn byoPizza = new BuildYourOwn();
        byoPizza.setCrust(Crust.PAN);
        return byoPizza;
    }

}
