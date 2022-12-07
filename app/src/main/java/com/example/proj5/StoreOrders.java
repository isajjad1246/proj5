package com.example.proj5;

import com.example.proj5.Customizable;
import com.example.proj5.Order;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */


/**
 *class for store orders
 * */
public class StoreOrders implements Customizable {

    //arraylist of order type
    public ArrayList<Order> orderList;
    public double totalCost;

    /**
     * method to add order to store order
     * @param obj
     * @return boolean
     * */
    public boolean add(Object obj){
        //add order type to arraylist
        Order temp = (Order) obj;
        if (orderList.add(temp) == true){
            return true;
        }
        return false;
    }

    /**
     * method to remove order from store order
     * @param obj
     * @return boolean
     * */
    public boolean remove(Object obj){
        //remove order type from arraylist
        Order temp = (Order) obj;
        if (orderList.remove(temp) == true){
            return true;
        }
        return false;
    }


    //method for total cost of order
    /**
     * method to add to total cost
     * @param cost
     * @return double
     * */
    public double addTotalCost(Double cost){
        totalCost += cost;
        return totalCost;
    }

    /**
     * method to remove from total cost
     * @param cost
     * @return double
     * */
    public double removeTotalCost(Double cost){
        totalCost -= cost;
        return totalCost;
    }

    //method to export orders to a text file
    /**
     * method to export store order data to file
     * */
    public void export(){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            //here write contents of arraylist
            for (int i = 0; i < orderList.size(); i++){
                myWriter.write(orderList.get(i).orderToString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
