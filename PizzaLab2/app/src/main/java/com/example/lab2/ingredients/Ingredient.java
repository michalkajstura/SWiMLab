package com.example.lab2.ingredients;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {

    protected int image;

    public static final Creator<Parcelable> CREATOR = new Creator<Parcelable>() {
        @Override
        public Parcelable createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Parcelable[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    protected Ingredient() {
    }

    protected Ingredient(Parcel parcel) {
        image = parcel.readInt();
    }

    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getImage());
    }
}
