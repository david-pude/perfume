package com.example.perfume;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PerfumeAdapter extends RecyclerView.Adapter<PerfumeAdapter.PerfumeViewHolder> {

    private final Context context;
    private final List<perf> perfumeList;
    private final Cart cart;

    public PerfumeAdapter(Context context, List<perf> perfumeList, Cart cart) {
        this.context = context;
        this.perfumeList = perfumeList;
        this.cart = cart;
    }

    @NonNull
    @Override
    public PerfumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_perfume, parent, false);
        return new PerfumeViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PerfumeViewHolder holder, int position) {
        perf perfume = perfumeList.get(position);
        holder.nameTextView.setText(perfume.getName());
        holder.descriptionTextView.setText(perfume.getDescription());
        holder.priceTextView.setText("$" + perfume.getPrice());

        holder.addToCartButton.setOnClickListener(v -> cart.addItem(perfume));
    }

    @Override
    public int getItemCount() {
        return perfumeList.size();
    }

    public static class PerfumeViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descriptionTextView, priceTextView;
        Button addToCartButton;

        public PerfumeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.perfume_name);
            descriptionTextView = itemView.findViewById(R.id.perfume_description);
            priceTextView = itemView.findViewById(R.id.perfume_price);
            addToCartButton = itemView.findViewById(R.id.add_to_cart_button);
        }
    }
}
