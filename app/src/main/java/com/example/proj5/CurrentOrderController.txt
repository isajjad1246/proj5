package com.example.proj5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * @author Ifrah Sajjad, Reiya Dave
 * Class for CurrentOrderController
 * */
public class CurrentOrderController {
    private ChicagoStyleController chicagoStyleController;
    private NewYorkStyleController newYorkStyleController;

    private Order currOrder = new Order();
    private ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();

    @FXML
    private TextField orderNum;

    @FXML
    private ListView listViewOrders;

    @FXML
    private TextField subtotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button removePizza;

    @FXML
    private Button placeOrder;

    @FXML
    private Button clearOrder;

    //methods for actions and stuff

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
    @FXML
    public void display(){
        orderNum.setText(String.valueOf(currOrder.orderNumber));
        listViewOrders.setItems((ObservableList) currOrder.pizzaOrder);
        subtotal.setText(String.valueOf(currOrder.orderCost));
        salesTax.setText(String.valueOf(currOrder.orderCost*.0625));
        currOrder.orderCost = currOrder.orderCost*1.0625;
        orderTotal.setText(String.valueOf(currOrder.orderCost));

    }

    /**
     * Method for adding order to store orders
     * */
    @FXML
    public void addToStoreOrder(){
        //add the order to store order
    }

//    @FXML
//    public void controllerMethod() throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("CurrentOrder-view.xml"));
//        Parent root = loader.load();
//        if(flavorBox.getSelectionModel().getSelectedItem() == "Deluxe") {
//            mainController.add(deluxe);
//        }
//        else if (flavorBox.getSelectionModel().getSelectedItem() == "BBQ") {
//            mainController.add(bbq);
//        }
//        else if (flavorBox.getSelectionModel().getSelectedItem() == "Meatzza") {
//            mainController.add(meatzza);
//        }
//        else if (flavorBox.getSelectionModel().getSelectedItem() == "Build Your Own") {
//            mainController.add(byo);
//        }

    //}
}
