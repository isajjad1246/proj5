package com.example.proj5;

/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * subclass for bbq chicken
 * */
public class BBQChicken extends Pizza {

    /**
    Contructor to initialize bbq chicken type
    * */
    public BBQChicken(){
        getToppings().add(Topping.BBQ_CHICKEN);
        getToppings().add(Topping.GREEN_PEPPER);
        getToppings().add(Topping.PROVOLONE);
        getToppings().add(Topping.CHEDDAR);
    }

    /**
     * Sets price of bbq chicken pizza
     * @return double
     * */
    public double price(){
        double result = 0;
        if (getSize() == Size.SMALL){
            result = 13.99;
        }
        else if (getSize() == Size.MEDIUM){
            result = 15.99;
        }
        else{
            result = 17.99;
        }
        return (double) Math.round(result*100)/100;
    }

}