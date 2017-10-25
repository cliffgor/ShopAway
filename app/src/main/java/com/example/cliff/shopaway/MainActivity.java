package com.example.cliff.shopaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import android.app.AlertDialog;
import android.widget.EditText;
import android.content.DialogInterface;
import android.content.Context;
import android.content.SharedPreferences;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
    ListView lv = null;


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_sort) {
            Collections.sort(shoppingList);
            lv.setAdapter(adapter);
            return true;
        }


        if (id == R.id.action_add) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add Item");
            final EditText input = new EditText(this);
            builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    shoppingList.add(preferredCase(input.getText().toString()));
                    Collections.sort(shoppingList);
                    lv.setAdapter(adapter);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String preferredCase(String original)
    {
        if (original.isEmpty())
            return original;

        return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();
    }
}
