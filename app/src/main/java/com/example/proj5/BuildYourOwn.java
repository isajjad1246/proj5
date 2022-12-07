package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * subclass for build your own
 * */
public class BuildYourOwn extends Pizza {
    //add toppings in controller when they are added
    /**
     * Method to set price of build your own pizza
     * @return double
     * */
    public double price(){
        double result = 0;
        if (getSize() == Size.SMALL){
            result = 8.99 + (1.59*super.getToppings().size());
        }
        else if (getSize() == Size.MEDIUM){
            result = 10.99 + (1.59*super.getToppings().size());
        }
        else{
            result = 12.99 + (1.59*super.getToppings().size());
        }
        return (double) Math.round(result*100)/100;
    }
    private double cost;
    public BuildYourOwn(){
        cost = price();
    }

    public double getCost(){
        return cost;
    }
    public void setCost(Double cost2){
        this.cost = cost2;
    }
}
