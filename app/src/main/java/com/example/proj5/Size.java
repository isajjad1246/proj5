package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */

/**
 * enum class for pizza size
 * */
public enum Size{
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String size_type;

    /**
     * setter for size type
     * */
    private Size(String size_type){
        this.size_type = size_type;
    }
}
