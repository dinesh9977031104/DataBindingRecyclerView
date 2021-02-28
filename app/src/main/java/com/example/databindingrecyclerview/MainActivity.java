package com.example.databindingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.databindingrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(this,setItems());
        mainBinding.recyclerView.setAdapter(adapter);
    }

    private List<Fruits> setItems(){
        List<String> nameList = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> detailsList = Arrays.asList(getResources().getStringArray(R.array.details));

        int[] imageId = {R.drawable.fruit_one,R.drawable.fruit_two,R.drawable.fruit_three,R.drawable.fruit_four,
                R.drawable.fruit_five,R.drawable.fruit_six,R.drawable.fruit_seven,R.drawable.fruit_eight,
                R.drawable.fruit_nine,R.drawable.fruit_ten};


        List<Fruits> fruitsList = new ArrayList<>();

        int count = 0;
        for (String name : nameList){
            fruitsList.add(new Fruits(name,detailsList.get(count),imageId[count]));
            count++;
        }

        return fruitsList;
    }
}