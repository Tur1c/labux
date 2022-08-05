package com.example.projeklab.adapter.recyclerview;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeklab.R;
import com.example.projeklab.model.Cloth;

import java.util.Vector;

public class ClothRecyclerViewAdapter extends RecyclerView.Adapter<ClothRecyclerViewAdapter.viewHolder> {
    private Context context;
    private Vector<Cloth> VCloth;

    public ClothRecyclerViewAdapter(Context context, Vector<Cloth> VCloth){
        this.context = context;
        this.VCloth = VCloth;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Cloth cloth = VCloth.get(position);
        holder.ClothImage.setImageResource(cloth.getImage());
        holder.ClothName.setText(cloth.getName());
        holder.ClothDesc.setText(cloth.getDesc());
        holder.ClothPrice.setText("Rp " + cloth.getPrice());
    }

    @Override
    public int getItemCount() {
        return VCloth.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ClothImage;
        TextView ClothName, ClothDesc, ClothPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            ClothImage = itemView.findViewById(R.id.iv_ItemImage);
            ClothName = itemView.findViewById(R.id.tv_ItemName);
            ClothDesc = itemView.findViewById(R.id.tv_ItemDesc);
            ClothPrice = itemView.findViewById(R.id.tv_ItemPrice);
        }
    }
}
