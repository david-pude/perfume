package com.example.perfume;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<perf> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(perf perfume) {
        items.add(perfume);
    }

    public List<perf> getItems() {
        return items;
    }
}