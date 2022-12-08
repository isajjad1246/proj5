package com.example.proj5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ResourceBundle;

public class ChicagoStyleActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    CurrentOrderController currentOrderController;

    private ListView availableToppings;
    private ListView displayToppings;

    PizzaFactory pf = new ChicagoPizza();
    Pizza deluxe = pf.createDeluxe();
    Pizza bbq = pf.createBBQChicken();
    Pizza meatzza = pf.createMeatzza();
    Pizza byo = pf.createBuildYourOwn();

    String small = String.valueOf(Size.SMALL);
    String medium = String.valueOf(Size.MEDIUM);
    String large = String.valueOf(Size.LARGE);


    String flavorChoices[] = new String[]{String.valueOf(byo), String.valueOf(deluxe), String.valueOf(meatzza), String.valueOf(bbq)};
    String size[] = new String[]{small, medium, large};
    private ImageView image;

    Spinner flavor;
    Spinner sizeSpin;

    //private ComboBox<String> sizeBox2;
    private EditText priceBox2;
    private Button addButton;
    private Button removeButton;
    private Button addToOrderButton;
    //private ComboBox<String> flavorBox;

    //image view stuff
    /*private ImageView imageView2;
    private Image deluxeImage = new Image(getClass().getResourceAsStream("deluxe-chicago.png"));
    private Image bbqImage = new Image(getClass().getResourceAsStream("bbq-chicago.png"));
    private Image meatzzaImage = new Image(getClass().getResourceAsStream("meatzza-chicago.png"));
    private Image byoImage = new Image(getClass().getResourceAsStream("byo-chicago.png"));*/

    /**
     * Method for flavor box
     * @param view
     * **/
    void selectFlavor(View view) {
        String flavorString = flavor.getSelectedItem().toString();
        if(flavorString.equalsIgnoreCase("Deluxe")){
            image.setImage(deluxeImage);
            addButton.setDisable(true);
            removeButton.setDisable(true);
            deluxeFlavor();
        }
        if(flavorString.equalsIgnoreCase("BBQ")){
            image.setImage(bbqImage);
            addButton.setDisable(true);
            removeButton.setDisable(true);
            BBQChickenFlavor();
        }
        if(flavorString.equalsIgnoreCase("Meatzza")){
            image.setImage(meatzzaImage);
            addButton.setDisable(true);
            removeButton.setDisable(true);
            meatzzaFlavor();
        }
        if(flavorString.equalsIgnoreCase("Build Your Own")){
            image.setImage(byoImage);
            addButton.setDisable(false);
            removeButton.setDisable(false);
            byoFlavor();
        }

    }

    /**
     * Method for size box
     * @param event
     * */
    void selectSize(View view){
        String flavorString = flavor.getSelectedItem().toString();
        String sizeString = sizeSpin.getSelectedItem().toString();
        if(flavorString.equalsIgnoreCase("Deluxe")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                deluxe.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(deluxe.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                deluxe.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(deluxe.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                deluxe.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(deluxe.price()));
            }
        }
        else if(flavorString.equalsIgnoreCase("BBQ")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                bbq.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(bbq.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                bbq.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString( bbq.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                bbq.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(bbq.price()));
            }
        }
        else if(flavorString.equalsIgnoreCase("Meatzza")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                meatzza.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(meatzza.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                meatzza.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(meatzza.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                meatzza.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(meatzza.price()));
            }
        }
        else if(flavorString.equalsIgnoreCase("Build Your Own")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                byo.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(byo.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                byo.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(byo.price()));
            }
            else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                byo.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(byo.price()));
            }
        }
    }


    /**
     * Method for add button
     * @param event
     * */
    void addButton(View view){ //Toast/AlertDialog
        if(displayToppings.getAdapter().getCount() >= 7){
            Button ButtonType = null;
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Maximum number of toppings");
            alert.setMessage("At most 7 toppings!");
            alert.setPositiveButton("Ok", null); /////
            alert.show();
        }
        else{
            String availableItem = availableToppings.getSelectedItem().toString();
            availableToppings.getItems().remove(availableItem);
            displayToppings.getItems().add(availableItem);
            String result = flavor.getSelectedItem().toString();
            if(result.equals("Build Your Own")){
                byo.add(availableItem);
                priceBox2.setText(Double.toString(byo.price()));
            }
        }
    }

    /**
     * Method for remove button
     * @param event
     * */
    void removeButton(View view){
        String availableItem = displayToppings.getSelectedItem().toString();
        displayToppings.getItems().remove(availableItem);
        availableToppings.getItems().add(availableItem);
        String result = flavor.getSelectedItem().toString();
        if(result.equals("Build Your Own")){
            byo.remove(availableItem);
            priceBox2.setText(Double.toString(byo.price()));
        }
    }

    String[] NYView = {Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(), Topping.GREEN_PEPPER.toString(), Topping.ONION.toString(), Topping.MUSHROOM.toString(), Topping.BBQ_CHICKEN.toString(), Topping.PROVOLONE.toString(), Topping.CHEDDAR.toString(), Topping.BEEF.toString(), Topping.HAM.toString(), Topping.PINEAPPLE.toString(), Topping.JALAPENO.toString(), Topping.OLIVES.toString()};
    //String currentViewItem;


//    /**
//     * Method for intialize since we are implementing initializable interface
//     * @param url
//     * @param rb
//     * */
//    @Override
//    public void initialize(URL url, ResourceBundle rb){
//        ObservableList<String> flavorList= FXCollections.observableArrayList("Deluxe", "BBQ", "Meatzza", "Build Your Own");
//        flavor.setItems(flavorList);
//
//        flavor.getSelectionModel().select("Build Your Own");
//
//        ObservableList<String> size = FXCollections.observableArrayList("small", "medium", "large");
//        sizeSpin.setItems(size);
//
//        availableToppings.getItems().addAll(NYView);
////        toppingsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
////            @Override
////            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
////
////            }
////        });
//    }

    /**
     * Method for handling deluxe flavor for pizza type
     *
     * */
    public void deluxeFlavor(){
        //size button
        //set crust option to deep dish
        //1st list view and add remove topping buttons disabled
        //set 2nd list view to chicago deluxe toppings
        //when add pizza is clicked, create pizza.deluxe() type
        //display price

        //ObservableList<String> temp = FXCollections.observableArrayList();
        for (int i = 0; i < deluxe.getToppings().size(); i++){
            temp.add(deluxe.getToppings().get(i).toString());
        }
        displayToppings.setItems(temp);
        if(flavor.getSelectedItem().toString() == "Deluxe"){
            deluxe.setCrust(Crust.DEEP_DISH);
            //imageView2.setImage(deluxeImage);
        }
        if(sizeSpin.getSelectedItem().toString() == "small"){
            deluxe.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(deluxe.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "medium"){
            deluxe.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(deluxe.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "large"){
            deluxe.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(deluxe.price()));
        }


    }

    /**
     * Method for handling bbq flavor for pizza type
     *
     * */
    public void BBQChickenFlavor(){
        //size button
        //set crust option to pan
        //1st list view and add remove topping buttons disabled
        //set 2nd list view to chicago bbqchicken toppings
        //when add pizza is clicked, create pizza.bbqchicken() type
        //display price
        ObservableList<String> temp = FXCollections.observableArrayList();
        for (int i = 0; i < bbq.getToppings().size(); i++){
            temp.add(bbq.getToppings().get(i).toString());
        }
        displayToppings.setItems(temp);
        if(flavor.getSelectedItem().toString() == "BBQ"){
            bbq.setCrust(Crust.PAN);
            //imageView2.setImage(bbqImage);
        }
        if(sizeSpin.getSelectedItem().toString() == "small"){
            bbq.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(bbq.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "medium"){
            bbq.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(bbq.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "large"){
            bbq.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(bbq.price()));
        }
    }

    /**
     * Method for handling meatzza flavor for pizza type
     *
     * */
    public void meatzzaFlavor(){
        //size button
        //set crust option to stuffed
        //1st list view and add remove topping buttons disabled
        //set 2nd list view to chicago deluxe toppings
        //when add pizza is clicked, create pizza.deluxe() type
        //display price
        ObservableList<String> temp = FXCollections.observableArrayList();
        for (int i = 0; i < meatzza.getToppings().size(); i++){
            temp.add(meatzza.getToppings().get(i).toString());
        }
        displayToppings.setItems(temp);
        if(flavor.getSelectedItem().toString() == "Meatzza"){
            meatzza.setCrust(Crust.STUFFED);
            //imageView2.setImage(meatzzaImage);
        }
        if(sizeSpin.getSelectedItem().toString() == "small"){
            meatzza.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(meatzza.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "medium"){
            meatzza.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(meatzza.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "large"){
            meatzza.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(meatzza.price()));
        }
    }

    /**
     * Method for handling byo flavor for pizza type
     *
     * */
    public void byoFlavor(){
        //size button
        //set crust option to pan
        //1st list view shows all available toppings
        //set 2nd list view empty but changes on button click
        //when add pizza is clicked, create pizza.buildyourown() type
        //display price-increase every time topping is added
        if(flavor.getSelectedItem().toString() == "Build Your Own"){
            byo.setCrust(Crust.PAN);
            //imageView2.setImage(byoImage);
        }
        if(sizeSpin.getSelectedItem().toString() == "small"){
            byo.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(byo.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "medium"){
            byo.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(byo.price()));
        }else if(sizeSpin.getSelectedItem().toString() == "large"){
            byo.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(byo.price()));
        }
    }

    private MainController mainController;

    /**
     * Method for handling controllers for main view controller
     * @param mainController
     *
     * */
    public void setMainController(MainController mainController) { //
        this.mainController = mainController;
    }

    /**
     * Method for handling adding to order button
     * @param event
     *
     * */
    public void addPizzaToOrder(View view){
        if (flavor.getSelectedItem().toString() == "Deluxe") {
            mainController.addPizzaToOrder(deluxe);
        }
        else if (flavor.getSelectedItem().toString() == "BBQ") {
            mainController.addPizzaToOrder(bbq);
        }
        else if (flavor.getSelectedItem().toString() == "Meatzza") {
            mainController.addPizzaToOrder(meatzza);
        }
        else if (flavor.getSelectedItem().toString() == "Build Your Own") {
            mainController.addPizzaToOrder(byo);
        }
        //System.out.println("added");
    }

    public void toastMessage(){ //will alert when it reaches the max number of toppings
        Context context = getApplicationContext();
        CharSequence message = "This is the maximum number of toppings";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
        Toast.makeText(context, message, duration).show();
    }

//    private Button alertButton;
//    private TextView alertTextView;
//
//    public void alertDialogMessage(){
//
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alertButton = (Button) findViewById(R.id.alertButton);
//        alert.setMessage("Error!").setTitle("error-message");
//
//
//        alert.setPositiveButton("OK", new DialogInterface.OnClickListener(){
//            public void onClick(DialogInterface dialog, int which){
//                alertTextView.setVisibility(View);
//            }
//        });
//        alert.setNegativeButton("Exit", new DialogInterface.OnClickListener(){
//            public void onClick(DialogInterface dialog, int which){
//                dialog.cancel();
//            }
//        });
//        AlertDialog dialog = alert.create();
//        dialog.show();
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago_style);

        flavor = (Spinner) findViewById(R.id.flavor); //getting instance of spinner
        flavor.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having flavor list
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, flavorChoices);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flavor.setAdapter(adapter1);

        sizeSpin = (Spinner) findViewById(R.id.sizeSpin);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, size);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flavor.setAdapter(adapter2);


//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("This is the maximum number of toppings");


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = flavor.getSelectedItemPosition();
        image = new ImageView(this);

        switch (position) {
            case 0:
                image.setImageResource(R.drawable.bbq_chicago);
                addButton.setEnabled(false);
                removeButton.setEnabled(false);
                BBQChickenFlavor();
                break;
            case 1:
                image.setImageResource(R.drawable.byo_chicago);
                addButton.setEnabled(true);
                removeButton.setEnabled(true);
                byoFlavor();
                break;
            case 2:
                image.setImageResource(R.drawable.deluxe_chicago);
                addButton.setEnabled(false);
                removeButton.setEnabled(false);
                deluxeFlavor();
                break;
            case 3:
                image.setImageResource(R.drawable.meatzza_chicago);
                addButton.setEnabled(false);
                removeButton.setEnabled(false);
                meatzzaFlavor();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}