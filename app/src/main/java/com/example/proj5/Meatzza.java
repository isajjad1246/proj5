package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * subclass for meatzza type
 * */
public class Meatzza extends Pizza {

    /**
     * constructor to initialize meatzza pizza
     * */
    public Meatzza(){
        getToppings().add(Topping.SAUSAGE);
        getToppings().add(Topping.PEPPERONI);
        getToppings().add(Topping.BEEF);
        getToppings().add(Topping.HAM);
    }

    /**
     * method to give price of meatzza pizza
     * @return double
     * */
     public double price(){
        double result = 0;
        if (getSize() == Size.SMALL){
            result = 15.99;
        }
        else if (getSize() == Size.MEDIUM){
            result = 17.99;
        }
        else{
            result = 19.99;
        }
         return (double) Math.round(result*100)/100;
    }
}