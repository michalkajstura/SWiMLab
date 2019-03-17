package com.example.lab2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import com.example.lab2.ingredients.Brocolli;
import com.example.lab2.ingredients.Cheese;
import com.example.lab2.ingredients.Chilli;
import com.example.lab2.ingredients.Corn;
import com.example.lab2.ingredients.Garlic;
import com.example.lab2.ingredients.Ingredient;
import com.example.lab2.ingredients.Olives;
import com.example.lab2.ingredients.Onion;
import com.example.lab2.ingredients.Pepperoni;
import com.example.lab2.ingredients.Pineapple;
import com.example.lab2.ingredients.Sauce;
import com.example.lab2.ingredients.Shroom;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PIZZA_INGREDIENTS = "INGREDIENTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToOrderActivityOnClick(View view) {
        Intent goToOrder = new Intent(this, OrderActivity.class);

        // Check ingredients
        ArrayList<Ingredient> ingredients = getIngredientsFromCheckbox();

        // Check sauce
        ToggleButton sauceButton = findViewById(R.id.sauce_btn);
        if (sauceButton.isChecked())
            ingredients.add(new Sauce());

        goToOrder.putParcelableArrayListExtra(PIZZA_INGREDIENTS, ingredients);
        startActivity(goToOrder);
    }

    private ArrayList<Ingredient> getIngredientsFromCheckbox() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        if (((CheckBox) findViewById(R.id.pepperoni)).isChecked())
            ingredients.add(new Pepperoni());
        if (((CheckBox) findViewById(R.id.broccoli)).isChecked())
           ingredients.add(new Brocolli());
        if (((CheckBox) findViewById(R.id.onion)).isChecked())
           ingredients.add(new Onion());
        if (((CheckBox) findViewById(R.id.garlic)).isChecked())
           ingredients.add(new Garlic());
        if (((CheckBox) findViewById(R.id.shrooms)).isChecked())
           ingredients.add(new Shroom());
        if (((CheckBox) findViewById(R.id.pineapple)).isChecked())
           ingredients.add(new Pineapple());
        if (((CheckBox) findViewById(R.id.corn)).isChecked())
           ingredients.add(new Corn());
        if (((CheckBox) findViewById(R.id.chilli)).isChecked())
           ingredients.add(new Chilli());
        if (((CheckBox) findViewById(R.id.cheese)).isChecked())
            ingredients.add(new Cheese());
        if (((CheckBox) findViewById(R.id.olives)).isChecked())
           ingredients.add(new Olives());
        return ingredients;
    }

}
