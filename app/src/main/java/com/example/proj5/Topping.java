package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * enum class for toppings
 * */
public enum Topping{
    SAUSAGE("Sausage"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    BBQ_CHICKEN("BBQ Chicken"),
    PROVOLONE("Provolone"),
    CHEDDAR("Cheddar"),
    BEEF("Beef"),
    HAM("Ham"),
    OLIVES("Olives"),
    PINEAPPLE("Pineapple"),
    JALAPENO("Jalapeno");

    private final String topping_type;

    /**
     * enum intializer for string topping
     * */
    private Topping(String topping_type){
        this.topping_type = topping_type;
    }

    /**
     * to string method for topping
     * @return String
     * */
    @Override
    public String toString() {
        return this.topping_type;
    }
}
