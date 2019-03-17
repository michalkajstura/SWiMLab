package com.example.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import com.example.lab2.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Ingredient> ingredients = getIngredientsFromCheckbox();

        // Check sauce
        ToggleButton sauceButton = findViewById(R.id.sauce_btn);
        if (sauceButton.isChecked())
            ingredients.add(Ingredient.SAUCE);

        ArrayList<String> ingredientNames =
                ingredients.stream()
                    .map(Ingredient::name)
                    .collect(Collectors.toCollection(ArrayList::new));


        goToOrder.putStringArrayListExtra(PIZZA_INGREDIENTS, ingredientNames);
        startActivity(goToOrder);
    }

    private List<Ingredient> getIngredientsFromCheckbox() {
        List<Ingredient> ingredients = new ArrayList<>();
        if (((CheckBox) findViewById(R.id.pepperoni)).isChecked())
            ingredients.add(Ingredient.PEPPERONI);
        if (((CheckBox) findViewById(R.id.broccoli)).isChecked())
           ingredients.add(Ingredient.BROCCOLI);
        if (((CheckBox) findViewById(R.id.onion)).isChecked())
           ingredients.add(Ingredient.ONION);
        if (((CheckBox) findViewById(R.id.garlic)).isChecked())
           ingredients.add(Ingredient.GARLIC);
        if (((CheckBox) findViewById(R.id.shrooms)).isChecked())
           ingredients.add(Ingredient.SHROOM);
        if (((CheckBox) findViewById(R.id.pineapple)).isChecked())
           ingredients.add(Ingredient.PINEAPPLE);
        if (((CheckBox) findViewById(R.id.corn)).isChecked())
           ingredients.add(Ingredient.CORN);
        if (((CheckBox) findViewById(R.id.chilli)).isChecked())
           ingredients.add(Ingredient.CHILLI);
        return ingredients;
    }

}
