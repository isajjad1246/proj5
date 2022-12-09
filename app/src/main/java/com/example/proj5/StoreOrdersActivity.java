package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * class method for store orders activity file
 * */
public class StoreOrdersActivity extends AppCompatActivity {

    private CurrentOrderActivity currentOrderController;

    private StoreOrders storeOrder = new StoreOrders();
    //private ComboBox <Integer> orderNumBox;
    private Spinner orderNumBox;
    public TextView orderTotalTextBox;
    public ListView storeOrderListView;
    public Button cancelOrderButton;
    public Button exportStoreOrdersButton;

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
     * Method for handling orderDropDown
     * @param view
     *
     * */
    public void orderDropDown(View view) {

    }

    /**
     * on create method for activity for store orders
     * @param savedInstanceState
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
    }
}