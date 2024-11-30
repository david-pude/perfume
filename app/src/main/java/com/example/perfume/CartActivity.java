package com.example.perfume;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Cart cart = MainActivity.cart; // Assuming it's a static variable in MainActivity

        TextView cartItemsTextView = findViewById(R.id.cart_items);
        StringBuilder itemsText = new StringBuilder();
        for (perf perfume : cart.getItems()) {
            itemsText.append(perfume.getName())
                    .append(" - $")
                    .append(perfume.getPrice())
                    .append("\n");
        }

        cartItemsTextView.setText(itemsText.toString());
    }
}
