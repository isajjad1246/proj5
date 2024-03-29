package com.example.proj5;
/**
 * @author Reiya Dave, Ifrah Sajjad
 * */
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * class method for new york method activity file
 * */
public class NewYorkStyleActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private ListView availableToppings;
    private ListView displayToppings;
    //ArrayAdapter<String> tempTopping;

    PizzaFactory pf = new NYPizza();
    Pizza deluxe = pf.createDeluxe();
    Pizza bbq = pf.createBBQChicken();
    Pizza meatzza = pf.createMeatzza();
    Pizza byo = pf.createBuildYourOwn();

    String small = String.valueOf(Size.SMALL);
    String medium = String.valueOf(Size.MEDIUM);
    String large = String.valueOf(Size.LARGE);



    String flavorChoices[] = new String[]{"Build Your Own", "Deluxe", "Meatzza", "BBQ Chicken"};

    //String flavorChoices[] = new String[]{String.valueOf(byo), String.valueOf(deluxe), String.valueOf(meatzza), String.valueOf(bbq)};
    String size[] = new String[]{small, medium, large};
    private ImageView image;

    private Spinner flavor;
    private Spinner sizeSpin;


    //private ComboBox<String> sizeBox2;
    private EditText priceBox2;
    private Button addButton;
    private Button removeButton;
    private Button addToOrderButton;
    //private ComboBox<String> flavorBox;

    //imageview stuff
    /*private Image deluxeImage = new Image(getClass().getResourceAsStream("deluxe-ny.png"));
    private Image bbqImage = new Image(getClass().getResourceAsStream("bbq-ny.png"));
    private Image meatzzaImage = new Image(getClass().getResourceAsStream("meatzza-ny.png"));
    private Image byoImage = new Image(getClass().getResourceAsStream("byo-ny.png"));*/

    private MainActivity mainController; //controller for main view

    /**
     * Method for handling controllers for main view controller
     *
     * @param mainController
     */
    public void setMainController(MainActivity mainController) {
        this.mainController = mainController;
    }

    /**
     * Method for selecting pizza flavor type
     *
     * @param view
     */
    /*void selectFlavor(View view) {
        String flavorString = flavor.getSelectedItem().toString();
        if (flavorString.equalsIgnoreCase("Deluxe")) {
            //imageView2.setImage(deluxeImage);
            addButton.setEnabled(false);
            removeButton.setEnabled(false);
            deluxeFlavor();
            //selectSize(event, deluxe);
        }
        if (flavorString.equalsIgnoreCase("BBQ")) {
            //imageView2.setImage(bbqImage);
            addButton.setEnabled(false);
            removeButton.setEnabled(false);
            BBQChickenFlavor();
        }
        if (flavorString.equalsIgnoreCase("Meatzza")) {
            //imageView2.setImage(meatzzaImage);
            addButton.setEnabled(false);
            removeButton.setEnabled(false);
            meatzzaFlavor();
        }
        if (flavorString.equalsIgnoreCase("Build Your Own")) {
            //imageView2.setImage(byoImage);
            addButton.setEnabled(true);
            removeButton.setEnabled(true);
            byoFlavor();
        }

    }*/

    /**
     * Method for size box
     *
     * @param view
     */
//    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//            // your code here
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parentView) {
//            // your code here
//        }
//
//    });
    void selectSize(View view) {
        String flavorString = flavor.getSelectedItem().toString();
        String sizeString = sizeSpin.getSelectedItem().toString();
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
     * @param view
     */
    void addButton(View view) {
        if (displayToppings.getAdapter().getCount() >= 7) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Maximum number of toppings");
            alert.setMessage("At most 7 toppings!");
            alert.setPositiveButton("Ok", null);
            alert.show();
            /*ButtonType ButtonType = null;
            Alert alarm = new Alert(Alert.AlertType.ERROR, "cannot exceed 7 toppings!", ButtonType);
            alarm.setHeaderText("This is the maximum number of toppings");
            alarm.show();*/
        } else {
            String availableItem = availableToppings.getSelectedItem().toString();
            //String availableItem = availableToppings.getItemAtPosition();
            //availableToppings.remove(availableItem);
            //displayToppings.getItems().add(availableItem);
            String result = flavor.getSelectedItem().toString();
            if (result.equals("Build Your Own")) {
                byo.add(availableItem);
                priceBox2.setText(Double.toString(byo.price()));
            }
        }
    }

    /**
     * Method for remove button
     *
     * @param view
     */
    void removeButton(View view) {
        String availableItem = displayToppings.getSelectedItem().toString();
        //displayToppings.getItems().remove(availableItem);
        //availableToppings.getItems().add(availableItem);
        String result = flavor.getSelectedItem().toString();
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
    /*@Override
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
    }*/

    /**
     * Method for handling adding to order button
     *
     * @param view
     */
    public void addToOrderButton(View view) {

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

        //ObservableList<String> temp = FXCollections.observableArrayList();
        ArrayList temp = new ArrayList();
        for (int i = 0; i < deluxe.getToppings().size(); i++) {
            temp.add(deluxe.getToppings().get(i).toString());
        }
        //displayToppings.setItems(temp);
        /*ArrayAdapter<String> tempTopping = new ArrayAdapter<String>(this, R.layout.activity_new_york_style, R.id.displayToppings, temp);
        displayToppings.setAdapter(tempTopping);
        System.out.println("in deluxe");*/

        if (flavor.getSelectedItem() == "Deluxe") {
            deluxe.setCrust(Crust.BROOKLYN);
            //imageView2.setImage(deluxeImage);
        }
        if (sizeSpin.getSelectedItem() == "small ") {
            deluxe.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(deluxe.price()));
            System.out.println("price" + deluxe.price());

        } else if (sizeSpin.getSelectedItem() == "medium") {
            deluxe.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(deluxe.price()));
        } else if (sizeSpin.getSelectedItem() == "large") {
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
        //ObservableList<String> temp = FXCollections.observableArrayList();
        ArrayList temp = new ArrayList();
        for (int i = 0; i < bbq.getToppings().size(); i++) {
            temp.add(bbq.getToppings().get(i).toString());
        }
        //displayToppings.setItems(temp);
        /*ArrayAdapter<String> tempTopping = new ArrayAdapter<String>(this, R.layout.activity_new_york_style, R.id.displayToppings, temp);
        displayToppings.setAdapter(tempTopping);
        if (flavor.getSelectedItem() == "BBQ") {
            bbq.setCrust(Crust.THIN);
            //imageView2.setImage(bbqImage);
        }*/
        if (sizeSpin.getSelectedItem() == "small") {
            bbq.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(bbq.price()));
        } else if (sizeSpin.getSelectedItem() == "medium") {
            bbq.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(bbq.price()));
        } else if (sizeSpin.getSelectedItem() == "large") {
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
        //ObservableList<String> temp = FXCollections.observableArrayList();
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < meatzza.getToppings().size(); i++) {
            temp.add(meatzza.getToppings().get(i).toString());
        }
        //displayToppings.setItems(temp);
        /*ArrayAdapter<String> tempTopping = new ArrayAdapter<String>(this, R.layout.activity_new_york_style, R.id.displayToppings, temp);
        displayToppings.setAdapter(tempTopping);
        if (flavor.getSelectedItem() == "Meatzza") {
            meatzza.setCrust(Crust.HAND_TOSSED);
            //imageView2.setImage(meatzzaImage);
        }*/
        if (sizeSpin.getSelectedItem() == "small") {
            meatzza.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(meatzza.price()));
        } else if (sizeSpin.getSelectedItem() == "medium") {
            meatzza.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(meatzza.price()));
        } else if (sizeSpin.getSelectedItem() == "large") {
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
        if (flavor.getSelectedItem() == "Build Your Own") {
            byo.setCrust(Crust.HAND_TOSSED);
            //imageView2.setImage(byoImage);
        }
        if (sizeSpin.getSelectedItem() == "small") {
            byo.setSize(Size.SMALL);
            priceBox2.setText(String.valueOf(byo.price()));
        } else if (sizeSpin.getSelectedItem() == "medium") {
            byo.setSize(Size.MEDIUM);
            priceBox2.setText(String.valueOf(byo.price()));
        } else if (sizeSpin.getSelectedItem() == "large") {
            byo.setSize(Size.LARGE);
            priceBox2.setText(String.valueOf(byo.price()));
        }
    }

    /**
     * Method for handling adding to order button
     *
     * @param view
     */
    public void addPizzaToOrder(View view) {
        if (flavor.getSelectedItem().toString() == "Deluxe") {
            mainController.addPizzaToOrder(deluxe);
        } else if (flavor.getSelectedItem().toString() == "BBQ") {
            mainController.addPizzaToOrder(bbq);
        } else if (flavor.getSelectedItem().toString() == "Meatzza") {
            mainController.addPizzaToOrder(meatzza);
        } else if (flavor.getSelectedItem().toString() == "Build Your Own") {
            mainController.addPizzaToOrder(byo);
        }
        //System.out.println("added");
    }


    /**
     * on create method for new york activity file
     * @param savedInstanceState
     * */
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


    /**
     * method for when item is selected
     * @param adapterView
     * @param i
     * @param view
     * @param l
     * */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = flavor.getSelectedItemPosition();
        image = new ImageView(this);
//        byo_ny = new ImageView();
//        deluxe_ny = new ImageView();
//        meatzza_ny = new ImageView();

        switch (position) {
            case 0:
                image.setImageResource(R.drawable.bbq_ny);
                //addButton.setEnabled(false);
                //removeButton.setEnabled(false);
                BBQChickenFlavor();
                break;
            case 1:
                image.setImageResource(R.drawable.byo_ny);
                //addButton.setEnabled(true);
                //removeButton.setEnabled(true);
                byoFlavor();
                break;
            case 2:
                image.setImageResource(R.drawable.deluxe_ny);
                //addButton.setEnabled(false);
                //removeButton.setEnabled(false);
                deluxeFlavor();
                break;
            case 3:
                image.setImageResource(R.drawable.meatzza_ny);
                //addButton.setEnabled(false);
                //removeButton.setEnabled(false);
                meatzzaFlavor();
                break;
        }
    }

    /**
     * method for when nothing is selected
     * @param adapterView
     * */
    @Override
    public void onNothingSelected (AdapterView < ? > adapterView){

    }

}