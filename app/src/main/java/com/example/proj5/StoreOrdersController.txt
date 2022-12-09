package com.example.proj5;

import com.example.proj5.CurrentOrderController;
import com.example.proj5.MainController;
import com.example.proj5.StoreOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * @author Ifrah Sajjad, Reiya Dave
 *
 * Class for StoreOrdersController
 *
 * */
public class StoreOrdersController {
    private CurrentOrderController currentOrderController;

    private StoreOrders storeOrder = new StoreOrders();
    @FXML
    private ComboBox <Integer> orderNumBox;
    @FXML
    public TextField orderTotalTextBox;
    @FXML
    public ListView storeOrderListView;
    @FXML
    public Button cancelOrderButton;
    @FXML
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
     * @param actionEvent
     *
     * */
    public void orderDropDown(ActionEvent actionEvent) {

    }
}
