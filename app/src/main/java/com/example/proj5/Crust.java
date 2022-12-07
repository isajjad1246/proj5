package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * enum class for crust types
 * */
public enum Crust{
    DEEP_DISH("Deep dish"),
    PAN("Pan"),
    STUFFED("Stuffed"),
    BROOKLYN("Brooklyn"),
    THIN("Thin"),
    HAND_TOSSED("Hand tossed");

    private final String crust_type;

    /**
     * Setter method for pizza crust
     * */
    private Crust(String crust_type){
        this.crust_type = crust_type;
    }

    /**
     * toString method to cast crust type to string
     * @return String
     * */
    @Override
    public String toString() {
        return this.crust_type;
    }
}