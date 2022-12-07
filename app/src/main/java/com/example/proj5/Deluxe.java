package com.example.proj5;

/**
 * @author Reiya Dave, Ifrah Sajjad
 * */


/**
 * subclass for deluxe type
 * */
public class Deluxe extends Pizza {


    //sets toppings
    /**
     * constructor to initialize deluxe pizza
     * */
    public Deluxe(){
        getToppings().add(Topping.SAUSAGE);
        getToppings().add(Topping.PEPPERONI);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.ONION);
        getToppings().add(Topping.MUSHROOM);
    }

    /**
     * method to give price of deluxe pizza
     * @return double
     * */
    public double price(){
        double result = 0;
        if (getSize() == Size.SMALL){
            result = 14.99;
        }
        else if (getSize() == Size.MEDIUM){
            result = 16.99;
        }
        else{
            result = 18.99;
        }
        return (double) Math.round(result*100)/100;
    }

    //crust- figure out cuz depends on chicago or ny
}
