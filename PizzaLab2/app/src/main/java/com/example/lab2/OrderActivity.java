package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.ingredients.Ingredient;

import java.util.List;

public class OrderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            List<Ingredient> ingredients =
                    getIntent().getParcelableArrayListExtra(MainActivity.PIZZA_INGREDIENTS);

            GridView gridView = findViewById(R.id.ingredientGrid);
            gridView.setAdapter(new CustomGridAdapter(getApplicationContext(), ingredients));
        }

        Button backButton = findViewById(R.id.back_btn);
        backButton.setOnLongClickListener(view -> {
            onBackPressed();
            return true;
        });
    }

    public void orderOnClick(View view) {
        finish();
        TextView pizzaName = findViewById(R.id.pizza_name);
        Toast.makeText(getApplicationContext(),
                pizzaName.getText() + " zamówiona!",
                Toast.LENGTH_SHORT).show();
    }

}
