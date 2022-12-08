package com.example.proj5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity {

    private ChicagoStyleController chicagoStyleController;
    private NewYorkStyleController newYorkStyleController;

    private Order currOrder = new Order();
    //figure out alternative to observable list
    private ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();
    private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    private TextView orderNum;
    private ListView listViewOrders;
    private TextView subtotal;
    private TextView salesTax;
    private TextView orderTotal;
    private Button displayOrder;
    private Button removePizza;
    private Button placeOrder;
    private Button clearOrder;

    private MainController mainController; //controller for main view

    /**
     * Method for handling controllers for main view controller
     * @param mainController
     *
     * */
    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    /**
     * Method where every time pizza is set to order, this is called and updated
     * */
    public void display(){
        orderNum.setText(String.valueOf(currOrder.orderNumber));
        //figure out alternative to observable list
        listViewOrders.setItems((ObservableList) currOrder.pizzaOrder);
        subtotal = (TextView) findViewById(R.id.subtotal);
        subtotal.setText(String.valueOf(currOrder.orderCost));

        salesTax = (TextView) findViewById(R.id.salesTax);
        salesTax.setText(String.valueOf(currOrder.orderCost*.0625));

        orderTotal = (TextView) findViewById(R.id.orderTotal);
        currOrder.orderCost = currOrder.orderCost*1.0625;
        orderTotal.setText(String.valueOf(currOrder.orderCost));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
    }
}