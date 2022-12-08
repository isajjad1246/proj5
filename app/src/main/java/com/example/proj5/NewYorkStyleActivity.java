package com.example.proj5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.URL;
import java.util.ResourceBundle;

public class NewYorkStyleActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private ListView<String> availableToppings = new ListView<>();

    private ListView<String> displayToppings = new ListView<>();
    PizzaFactory pf = new NYPizza();
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

    private Spinner flavor;
    private Spinner sizeSpin;


    //private ComboBox<String> sizeBox2;
    private TextView priceBox2;
    private Button addButton;
    private Button removeButton;
    private Button addToOrderButton;
    //private ComboBox<String> flavorBox;

    //imageview stuff
    /*private Image deluxeImage = new Image(getClass().getResourceAsStream("deluxe-ny.png"));
    private Image bbqImage = new Image(getClass().getResourceAsStream("bbq-ny.png"));
    private Image meatzzaImage = new Image(getClass().getResourceAsStream("meatzza-ny.png"));
    private Image byoImage = new Image(getClass().getResourceAsStream("byo-ny.png"));*/

    private MainController mainController; //controller for main view

    /**
     * Method for handling controllers for main view controller
     *
     * @param mainController
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * Method for selecting pizza flavor type
     *
     * @param event
     */
    void selectFlavor(ActionEvent event) {
        String flavorString = flavorBox.getSelectionModel().getSelectedItem().toString();
        if (flavorString.equalsIgnoreCase("Deluxe")) {
            imageView2.setImage(deluxeImage);
            addButton.setDisable(true);
            removeButton.setDisable(true);
            deluxeFlavor();
            //selectSize(event, deluxe);
        }
        if (flavorString.equalsIgnoreCase("BBQ")) {
            imageView2.setImage(bbqImage);
            addButton.setDisable(true);
            removeButton.setDisable(true);
            BBQChickenFlavor();
        }
        if (flavorString.equalsIgnoreCase("Meatzza")) {
            imageView2.setImage(meatzzaImage);
            addButton.setDisable(true);
            removeButton.setDisable(true);
            meatzzaFlavor();
        }
        if (flavorString.equalsIgnoreCase("Build Your Own")) {
            imageView2.setImage(byoImage);
            addButton.setDisable(false);
            removeButton.setDisable(false);
            byoFlavor();
        }

    }

    /**
     * Method for size box
     *
     * @param event
     */
    void selectSize(ActionEvent event) {
        String flavorString = flavorBox.getSelectionModel().getSelectedItem().toString();
        String sizeString = sizeBox2.getSelectionModel().getSelectedItem().toString();
        if (flavorString.equalsIgnoreCase("Deluxe")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                deluxe.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(deluxe.price()));
            } else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                deluxe.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(deluxe.price()));
            } else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                deluxe.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(deluxe.price()));
            }
        } else if (flavorString.equalsIgnoreCase("BBQ")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                bbq.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(bbq.price()));
            } else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                bbq.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(bbq.price()));
            } else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                bbq.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(bbq.price()));
            }
        } else if (flavorString.equalsIgnoreCase("Meatzza")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                meatzza.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(meatzza.price()));
            } else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                meatzza.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(meatzza.price()));
            } else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                meatzza.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(meatzza.price()));
            }
        } else if (flavorString.equalsIgnoreCase("Build Your Own")) {
            if (sizeString.equalsIgnoreCase(Size.SMALL.toString())) {
                byo.setSize(Size.SMALL);
                priceBox2.setText(Double.toString(byo.price()));
            } else if (sizeString.equalsIgnoreCase(Size.MEDIUM.toString())) {
                byo.setSize(Size.MEDIUM);
                priceBox2.setText(Double.toString(byo.price()));
            } else if (sizeString.equalsIgnoreCase(Size.LARGE.toString())) {
                byo.setSize(Size.LARGE);
                priceBox2.setText(Double.toString(byo.price()));
            }
        }
    }

//    @FXML
//    void selectToppings(ActionEvent event){
//        String toppingsString = toppingsBox1.getSelectionModel().getSelectedItem().toString();
//
//    }

    /**
     * Method for add button
     *
     * @param event
     */
    void addButton(MouseEvent event) {
        if (displayToppings.getItems().size() >= 7) {
            ButtonType ButtonType = null;
            Alert alarm = new Alert(Alert.AlertType.ERROR, "cannot exceed 7 toppings!", ButtonType);
            alarm.setHeaderText("This is the maximum number of toppings");
            alarm.show();
        } else {
            String availableItem = availableToppings.getSelectionModel().getSelectedItem();
            availableToppings.getItems().remove(availableItem);
            displayToppings.getItems().add(availableItem);
            String result = flavorBox.getSelectionModel().getSelectedItem();
            if (result.equals("Build Your Own")) {
                byo.add(availableItem);
                priceBox2.setText(Double.toString(byo.price()));
            }
        }
    }

    /**
     * Method for remove button
     *
     * @param event
     */
    void removeButton(MouseEvent event) {
        String availableItem = displayToppings.getSelectionModel().getSelectedItem();
        displayToppings.getItems().remove(availableItem);
        availableToppings.getItems().add(availableItem);
        String result = flavorBox.getSelectionModel().getSelectedItem();
        if (result.equals("Build Your Own")) {
            byo.remove(availableItem);
            priceBox2.setText(Double.toString(byo.price()));
        }
    }

    String[] NYView = {Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(), Topping.GREEN_PEPPER.toString(), Topping.ONION.toString(), Topping.MUSHROOM.toString(), Topping.BBQ_CHICKEN.toString(), Topping.PROVOLONE.toString(), Topping.CHEDDAR.toString(), Topping.BEEF.toString(), Topping.HAM.toString(), Topping.PINEAPPLE.toString(), Topping.JALAPENO.toString(), Topping.OLIVES.toString()};
    //String currentViewItem;


    /**
     * Method for intialize since we are implementing initializable interface
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> flavorList = FXCollections.observableArrayList("Deluxe", "BBQ", "Meatzza", "Build Your Own");
        flavorBox.setItems(flavorList);

        flavorBox.getSelectionModel().select("Build Your Own");

        ObservableList<String> size = FXCollections.observableArrayList("small", "medium", "large");
        sizeBox2.setItems(size);

        availableToppings.getItems().addAll(NYView);
//        toppingsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//
//            }
//        });
    }

    /**
     * Method for handling adding to order button
     *
     * @param event
     */
    public void addToOrderButton(ActionEvent event) {

    }

    /**
     * Method for handling deluxe flavor for pizza type
     */
    public void deluxeFlavor() {
        //size button
        //set crust option to deep dish
        //1st list view and add remove topping buttons disabled
        //set 2nd list view to chicago deluxe toppings
        //when add pizza is clicked, create pizza.deluxe() type
        //display price

        ObservableList<String> temp = FXCollections.observableArrayList();
        for (int i = 0; i < deluxe.getToppings().size(); i++) {
            temp.add(deluxe.getToppings().get(i).toString());
        }
        displayToppings.setItems(temp);
        System.out.println("in deluxe");

        if (flavorBox.getSelectionModel().getSelectedItem() == "Deluxe") {
            deluxe.setCrust(Crust.BROOKLYN);
            imageView2.setImage(deluxeImage);
        }
        if (sizeBox2.getSelectionModel().getSelectedItem() == "small ") {
            deluxe.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(deluxe.price()));
            System.out.println("price" + deluxe.price());

        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "medium") {
            deluxe.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(deluxe.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "large") {
            deluxe.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(deluxe.price()));
        }


    }

    /**
     * Method for handling bbq flavor for pizza type
     */
    public void BBQChickenFlavor() {
        //size button
        //set crust option to pan
        //1st list view and add remove topping buttons disabled
        //set 2nd list view to chicago bbqchicken toppings
        //when add pizza is clicked, create pizza.bbqchicken() type
        //display price
        ObservableList<String> temp = FXCollections.observableArrayList();
        for (int i = 0; i < bbq.getToppings().size(); i++) {
            temp.add(bbq.getToppings().get(i).toString());
        }
        displayToppings.setItems(temp);
        if (flavorBox.getSelectionModel().getSelectedItem() == "BBQ") {
            bbq.setCrust(Crust.THIN);
            imageView2.setImage(bbqImage);
        }
        if (sizeBox2.getSelectionModel().getSelectedItem() == "small") {
            bbq.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(bbq.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "medium") {
            bbq.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(bbq.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "large") {
            bbq.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(bbq.price()));
        }
    }

    /**
     * Method for handling meatzza flavor for pizza type
     */
    public void meatzzaFlavor() {
        //size button
        //set crust option to stuffed
        //1st list view and add remove topping buttons disabled
        //set 2nd list view to chicago deluxe toppings
        //when add pizza is clicked, create pizza.deluxe() type
        //display price
        ObservableList<String> temp = FXCollections.observableArrayList();
        for (int i = 0; i < meatzza.getToppings().size(); i++) {
            temp.add(meatzza.getToppings().get(i).toString());
        }
        displayToppings.setItems(temp);
        if (flavorBox.getSelectionModel().getSelectedItem() == "Meatzza") {
            meatzza.setCrust(Crust.HAND_TOSSED);
            imageView2.setImage(meatzzaImage);
        }
        if (sizeBox2.getSelectionModel().getSelectedItem() == "small") {
            meatzza.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(meatzza.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "medium") {
            meatzza.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(meatzza.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "large") {
            meatzza.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(meatzza.price()));
        }
    }

    /**
     * Method for handling byo flavor for pizza type
     */
    public void byoFlavor() {
        //size button
        //set crust option to pan
        //1st list view shows all available toppings
        //set 2nd list view empty but changes on button click
        //when add pizza is clicked, create pizza.buildyourown() type
        //display price- increase every time topping is added
        if (flavorBox.getSelectionModel().getSelectedItem() == "Build Your Own") {
            byo.setCrust(Crust.HAND_TOSSED);
            imageView2.setImage(byoImage);
        }
        if (sizeBox2.getSelectionModel().getSelectedItem() == "small") {
            byo.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(byo.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "medium") {
            byo.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(byo.price()));
        } else if (sizeBox2.getSelectionModel().getSelectedItem() == "large") {
            byo.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(byo.price()));
        }
    }

    /**
     * Method for handling adding to order button
     *
     * @param event
     */
    public void addPizzaToOrder(ActionEvent event) {
        if (flavorBox.getSelectionModel().getSelectedItem() == "Deluxe") {
            mainController.addPizzaToOrder(deluxe);
        } else if (flavorBox.getSelectionModel().getSelectedItem() == "BBQ") {
            mainController.addPizzaToOrder(bbq);
        } else if (flavorBox.getSelectionModel().getSelectedItem() == "Meatzza") {
            mainController.addPizzaToOrder(meatzza);
        } else if (flavorBox.getSelectionModel().getSelectedItem() == "Build Your Own") {
            mainController.addPizzaToOrder(byo);
        }
        //System.out.println("added");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_york_style);
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
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = sizeSpin.getSelectedItemPosition();
        image = new ImageView(this);
//        byo_ny = new ImageView();
//        deluxe_ny = new ImageView();
//        meatzza_ny = new ImageView();

        switch (position) {
            case 0:
                image.setImageResource(R.drawable.bbq_ny);
                break;
            case 1:
                image.setImageResource(R.drawable.byo_ny);
                break;
            case 2:
                image.setImageResource(R.drawable.deluxe_ny);
                break;
            case 3:
                image.setImageResource(R.drawable.meatzza_ny);
                break;
        }
    }
    @Override
    public void onNothingSelected (AdapterView < ? > adapterView){

    }

}