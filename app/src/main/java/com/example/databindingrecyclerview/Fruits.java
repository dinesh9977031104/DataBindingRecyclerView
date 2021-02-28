package com.example.databindingrecyclerview;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fruits {

    public String name, detail;
    public int imageId;

    public Fruits(String name, String detail, int imageId) {
        this.name = name;
        this.detail = detail;
        this.imageId = imageId;
    }


    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int imageId){

        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(),imageId));
    }
}
