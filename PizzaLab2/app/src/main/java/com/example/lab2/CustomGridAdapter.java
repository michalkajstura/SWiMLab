package com.example.lab2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.lab2.ingredients.Ingredient;

import java.util.List;

public class CustomGridAdapter extends BaseAdapter {

    private Context context;
    private List<Ingredient> ingredients;
    private static final int IMAGE_SIZE = 300;

    public CustomGridAdapter(Context context, List<Ingredient> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
    }

    @Override
    public int getCount() {
       return ingredients.size();
    }

    @Override
    public Object getItem(int position) {
        return ingredients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(IMAGE_SIZE, IMAGE_SIZE));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(
                convertIngredientToImage(ingredients.get(position))
        );
        return imageView;
    }

    private Integer convertIngredientToImage(Ingredient ingredient) {
        return ingredient.getImage();
    }
}
