package com.example.proj5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class StoreOrdersActivity extends AppCompatActivity {

    private CurrentOrderController currentOrderController;

    private StoreOrders storeOrder = new StoreOrders();
    //private ComboBox <Integer> orderNumBox;
    private Spinner orderNumBox;
    public TextView orderTotalTextBox;
    public ListView storeOrderListView;
    public Button cancelOrderButton;
    public Button exportStoreOrdersButton;

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
     * Method for handling orderDropDown
     * @param view
     *
     * */
    public void orderDropDown(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
    }
}