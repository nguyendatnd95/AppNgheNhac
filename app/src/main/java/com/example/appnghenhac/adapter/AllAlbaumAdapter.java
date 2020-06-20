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

public class AllAlbaumAdapter extends RecyclerView.Adapter<AllAlbaumAdapter.ViewHolder>{
    Context context;
    ArrayList<Album> albumArrayList;

    public AllAlbaumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);
        Picasso.get().load(album.getHinhAnhAlbum()).into(holder.imgAllAlbum);
        holder.tvtenallabum.setText(album.getTenAlbul());
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAllAlbum;
        TextView tvtenallabum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAllAlbum = itemView.findViewById(R.id.imageviewallalbum);
            tvtenallabum = itemView.findViewById(R.id.textviewtenallalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("album",albumArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
