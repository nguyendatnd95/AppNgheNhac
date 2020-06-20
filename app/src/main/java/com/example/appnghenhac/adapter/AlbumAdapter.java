package com.example.appnghenhac.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.R;
import com.example.appnghenhac.activity.DanhSachBaiHatActivity;
import com.example.appnghenhac.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = mangalbum.get(position);
        holder.tvcasialbum.setText(album.getTenCaSiAlbum());
        holder.tvtenalbum.setText(album.getTenAlbul());
        Picasso.get().load(album.getHinhAnhAlbum()).into(holder.imghinhalbum);

    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imghinhalbum;
        TextView tvtenalbum, tvcasialbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhalbum = itemView.findViewById(R.id.imageviewalbum);
            tvtenalbum = itemView.findViewById(R.id.textviewtenalbum);
            tvcasialbum = itemView.findViewById(R.id.textviewtencasialbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("album",mangalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
