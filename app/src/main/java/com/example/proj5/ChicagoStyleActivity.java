package com.example.proj5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ChicagoStyleActivity extends AppCompatActivity {
    private ComboBox<String> sizeBox2;
    private TextView priceBox2;
    private Button addButton;
    private Button removeButton;
    private Button addToOrderButton;
    private ComboBox<String> flavorBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago_style);
    }
}