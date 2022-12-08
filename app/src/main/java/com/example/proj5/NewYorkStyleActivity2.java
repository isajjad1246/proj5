package com.example.proj5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class NewYorkStyleActivity2 extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    PizzaFactory pf = new NYPizza();
    Pizza deluxe = pf.createDeluxe();
    Pizza bbq = pf.createBBQChicken();
    Pizza meatzza = pf.createMeatzza();
    Pizza byo = pf.createBuildYourOwn();

    String small = String.valueOf(Size.SMALL);
    String medium = String.valueOf(Size.MEDIUM);
    String large = String.valueOf(Size.LARGE);


    String flavorChoices[] = new String[] {String.valueOf(byo), String.valueOf(deluxe), String.valueOf(meatzza), String.valueOf(bbq)};
    String size[] = new String [] {small, medium, large};

    private ImageView image;
//    private ImageView byo_ny;
//    private ImageView deluxe_ny;
//    private ImageView meatzza_ny;

    Spinner flavor;
    Spinner sizeSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_york_style);
        flavor = (Spinner) findViewById(R.id.pizzaFlavor); //getting instance of spinner
        flavor.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having flavor list
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, flavorChoices);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flavor.setAdapter(adapter1);

        sizeSpin = (Spinner) findViewById(R.id.sizeBox);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, size);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flavor.setAdapter(adapter2);

        //ImageView img= (ImageView) findViewById(R.id.imageView);
        //img.setImageResource(R.drawable.my_image);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getApplicationContext(),flavorChoices[position] , Toast.LENGTH_LONG).show();
        //String items = flavor.getSelectedItem();
        int position = sizeSpin.getSelectedItemPosition();
        image = new ImageView(this);
//        byo_ny = new ImageView();
//        deluxe_ny = new ImageView();
//        meatzza_ny = new ImageView();

        switch(position){
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
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}