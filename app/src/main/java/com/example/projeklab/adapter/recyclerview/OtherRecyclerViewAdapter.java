package com.example.projeklab.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeklab.R;
import com.example.projeklab.model.Other;

import java.util.Vector;

public class OtherRecyclerViewAdapter extends RecyclerView.Adapter<OtherRecyclerViewAdapter.viewHolder> {

    private Context context;
    private Vector<Other> VOther;

    public OtherRecyclerViewAdapter(Context context, Vector<Other> VOther){
        this.context = context;
        this.VOther = VOther;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Other other = VOther.get(position);
        holder.OtherImage.setImageResource(other.getImage());
        holder.OtherName.setText(other.getName());
        holder.OtherDesc.setText(other.getDesc());
        holder.OtherPrice.setText("Rp " + other.getPrice());
    }

    @Override
    public int getItemCount() {
        return VOther.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView OtherImage;
        TextView OtherName, OtherDesc, OtherPrice;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            OtherImage = itemView.findViewById(R.id.iv_ItemImage);
            OtherName = itemView.findViewById(R.id.tv_ItemName);
            OtherDesc = itemView.findViewById(R.id.tv_ItemDesc);
            OtherPrice = itemView.findViewById(R.id.tv_ItemPrice);
        }
    }
}
