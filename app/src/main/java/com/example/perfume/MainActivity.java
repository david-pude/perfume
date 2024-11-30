package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Cart cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart = new Cart();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<perf> perfumes = new ArrayList<>();
        perfumes.add(new perf("Rose Bliss", "A floral scent with a hint of spice.", 50.0));
        perfumes.add(new perf("Ocean Mist", "A fresh aquatic fragrance.", 65.0));
        perfumes.add(new perf("Citrus Charm", "An invigorating citrus blend.", 45.0));

        PerfumeAdapter adapter = new PerfumeAdapter(this, perfumes, cart);
        recyclerView.setAdapter(adapter);

        Button viewCartButton = findViewById(R.id.view_cart_button);
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}
