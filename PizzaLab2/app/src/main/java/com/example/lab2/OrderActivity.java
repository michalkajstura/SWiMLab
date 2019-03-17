package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.Ingredient;

import java.util.List;
import java.util.stream.Collectors;

public class OrderActivity extends AppCompatActivity {

    private static String DEFAULT_NAME = "Domyślna nazwa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            List<Ingredient> ingredients =
                    extras.getStringArrayList(MainActivity.PIZZA_INGREDIENTS)
                        .stream()
                        .map(Ingredient::valueOf)
                        .collect(Collectors.toList());

            GridView gridView = findViewById(R.id.ingredientGrid);
            gridView.setAdapter(new CustomGridAdapter(getApplicationContext(), ingredients));
        }

        Button backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(view -> onBackPressed());
    }

    public void orderOnClick(View view) {
        finish();
        TextView pizzaName = findViewById(R.id.pizza_name);
        Toast.makeText(getApplicationContext(),
                pizzaName.getText() + " zamówiona!",
                Toast.LENGTH_SHORT).show();
    }

}
