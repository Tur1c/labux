package com.example.projeklab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailItem extends AppCompatActivity {

    Bundle extras;
    String itemName, itemDesc,itemPrice;
    int itemImage;
    TextView name,desc,price, error;
    EditText quantity;
    ImageView image;
    ImageButton back;
    Button buyBtn;
    ViewGroup transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        init();
        setUp();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        buyBtn.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View view) {
                if(quantity.getText().toString().isEmpty() ||
                Integer.parseInt(quantity.getText().toString()) == 0){
                    TransitionManager.beginDelayedTransition(transition);
                    error.setText("Quantity should not be 0");
                    error.setAlpha(1);
                    error.setVisibility(View.VISIBLE);
                    error.animate().alpha(0.0f).setDuration(2500);
                    error.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            error.setText("");

                            error.setVisibility(View.INVISIBLE);
                            error.setVisibility(View.GONE);
                        }
                    }, 3000);

                }
                else{
                    Intent items = new Intent(DetailItem.this, Items.class);
                    startActivity(items);
                }
            }
        });
    }

    private void init(){
        extras = getIntent().getExtras();
        itemName = extras.getString("itemName");
        itemDesc = extras.getString("itemDesc");
        itemPrice = extras.getString("itemPrice");
        itemImage = extras.getInt("itemImage");
        Log.d("DEBUG", "itemName: " + itemName + "\n" +
                "itemDesc: " + itemDesc + "\n" +
                "itemPrice: " + itemPrice + "\n" +
                "itemImage" + itemImage);
        buyBtn = findViewById(R.id.detail_buyBtn);
        error = findViewById(R.id.detail_error);
        quantity = findViewById(R.id.detail_quantity);
        transition = findViewById(R.id.detail_cardView);
    }

    private void setUp(){
        name = findViewById(R.id.detail_itemName);
        desc = findViewById(R.id.detail_itemDesc);
        price = findViewById(R.id.detail_itemPrice);
        image = findViewById(R.id.detail_itemImage);

        back = findViewById(R.id.detail_back);

        name.setText(itemName);
        desc.setText(itemDesc);
        price.setText("Rp " + itemPrice);
        image.setImageResource(itemImage);


    }
}