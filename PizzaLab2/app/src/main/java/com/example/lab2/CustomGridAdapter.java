package com.example.lab2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.lab2.Ingredient;

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
        if (ingredient.equals(Ingredient.BROCCOLI))
            return R.drawable.brocolli;
        if (ingredient.equals(Ingredient.GARLIC))
           return R.drawable.garlic;
        if (ingredient.equals(Ingredient.ONION))
           return R.drawable.onion;
        if (ingredient.equals(Ingredient.PINEAPPLE))
           return R.drawable.pineapple;
        if (ingredient.equals(Ingredient.PEPPERONI))
           return R.drawable.pepperoni;
        if (ingredient.equals(Ingredient.CHILLI))
            return R.drawable.chilli;
        if (ingredient.equals(Ingredient.SHROOM))
            return R.drawable.shroom;
       if (ingredient.equals(Ingredient.CORN))
            return R.drawable.corn;
       if (ingredient.equals(Ingredient.SAUCE))
            return R.drawable.sauce;
        return R.drawable.qm;
    }
}
