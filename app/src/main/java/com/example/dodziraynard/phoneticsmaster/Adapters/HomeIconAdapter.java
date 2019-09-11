package com.example.dodziraynard.phoneticsmaster.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dodziraynard.phoneticsmaster.R;

public class HomeIconAdapter extends RecyclerView.Adapter<HomeIconAdapter.HomeIconViewHolder> {

private Context context;
        String [] home_items;
        Integer [] items_bg;

// Define listener member variable
private static OnItemClickListener listener;

// Define the listener interface
public interface OnItemClickListener {
    void onItemClick(View itemView, int position);
}

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public HomeIconAdapter(Context context, String [] home_items, Integer [] items_bg){
        this.context = context;
        this.home_items = home_items;
        this.items_bg = items_bg;
    }

    @NonNull
    @Override
    public HomeIconViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_item, null);
        return new HomeIconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeIconViewHolder homeIconViewHolder, int i) {
        String item = home_items[i];
        Integer item_bg = items_bg[i];
        homeIconViewHolder.item_text.setText(item);
        homeIconViewHolder.item_btn.setImageResource(item_bg);
    }

    @Override
    public int getItemCount() {
        return home_items.length;
    }


class HomeIconViewHolder extends RecyclerView.ViewHolder{
    ImageView item_btn;
    TextView item_text;
    CardView cardView;

    public HomeIconViewHolder(@NonNull View itemView) {
        super(itemView);

        item_btn = itemView.findViewById(R.id.item_btn);
        item_text = itemView.findViewById(R.id.item_text);
        cardView = itemView.findViewById(R.id.cardView);

        cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Triggers clicked upwards to the adapter on click
                if (listener != null)
                    listener.onItemClick(cardView, getLayoutPosition());
            }
        });
    }
}
}
