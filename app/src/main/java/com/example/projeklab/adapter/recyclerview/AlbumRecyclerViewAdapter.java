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
import com.example.projeklab.model.Album;

import java.util.Vector;

public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.viewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;
    Vector<Album> VAlbum;

    public AlbumRecyclerViewAdapter(Context context, Vector<Album> VAlbum, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.VAlbum = VAlbum;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Album album = VAlbum.get(position);
        holder.AlbumImage.setImageResource(album.getImage());
        holder.AlbumName.setText(album.getName());
        holder.AlbumDesc.setText(album.getDesc());
        holder.AlbumPrice.setText("Rp " + album.getPrice());
    }

    @Override
    public int getItemCount() {
        return VAlbum.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView AlbumImage;
        TextView AlbumName, AlbumDesc, AlbumPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            AlbumImage = itemView.findViewById(R.id.iv_ItemImage);
            AlbumName = itemView.findViewById(R.id.tv_ItemName);
            AlbumDesc = itemView.findViewById(R.id.tv_ItemDesc);
            AlbumPrice = itemView.findViewById(R.id.tv_ItemPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
