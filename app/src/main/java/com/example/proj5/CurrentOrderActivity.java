package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/***
 * class method for current order activity file
 *
 */
public class CurrentOrderActivity extends AppCompatActivity {

    private ChicagoStyleActivity chicagoStyleController;
    private NewYorkStyleActivity newYorkStyleController;

    private Order currOrder = new Order();
    //figure out alternative to observable list
    //private ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();
    //private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    private TextView orderNum;
    private ListView listViewOrders;
    private EditText subtotal;
    private EditText salesTax;
    private EditText orderTotal;
    private Button displayOrder;
    private Button removePizza;
    private Button placeOrder;
    private Button clearOrder;

    private MainActivity mainController; //controller for main view

    /**
     * Method for handling controllers for main view controller
     * @param mainController
     *
     * */
    public void setMainController(MainActivity mainController){
        this.mainController = mainController;
    }

    /**
     * Method where every time pizza is set to order, this is called and updated
     * */
    public void display(){
        orderNum.setText(String.valueOf(currOrder.orderNumber));
        //figure out alternative to observable list
        ArrayAdapter<Pizza> temp = new ArrayAdapter<Pizza>(this, R.layout.activity_current_order, R.id.listViewOrders, currOrder.pizzaOrder );
        listViewOrders.setAdapter(temp);
        //listViewOrders.setItems((ObservableList) currOrder.pizzaOrder);
        subtotal = (EditText) findViewById(R.id.subtotal);
        subtotal.setText(String.valueOf(currOrder.orderCost));

        salesTax = (EditText) findViewById(R.id.salesTax);
        salesTax.setText(String.valueOf(currOrder.orderCost*.0625));

        orderTotal = (EditText) findViewById(R.id.orderTotal);
        currOrder.orderCost = currOrder.orderCost*1.0625;
        orderTotal.setText(String.valueOf(currOrder.orderCost));

    }


    /**
     * on create method to initialize activity file
     * @param savedInstanceState
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
    }
}