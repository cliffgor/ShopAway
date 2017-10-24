package com.example.cliff.shopaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter=null;
    ListView lv =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        shoppingList = new ArrayList<>();
        Collections.addAll(shoppingList, "eggs", "tommatoes", "apples", "milk");
        shoppingList.addAll(Arrays.asList("dog food", "chapstiks", "bread", "Napkins"));
        shoppingList.add("sunscreen");
        shoppingList.add("toothpaste");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(adapter);




    }
}
