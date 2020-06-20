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
import com.example.appnghenhac.model.PlayList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachcacplaylistAdapter extends RecyclerView.Adapter<DanhsachcacplaylistAdapter.ViewHolder>{
    Context context;
    ArrayList<PlayList> mangplaylist;

    public DanhsachcacplaylistAdapter(Context context, ArrayList<PlayList> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_cac_playlist, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayList playList = mangplaylist.get(position);
        holder.tvtenplaylist.setText(playList.getTen());
        Picasso.get().load(playList.getHinhPlaylist()).into(holder.imghinhnen);

    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView tvtenplaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewdanhsachcacplaylist);
            tvtenplaylist = itemView.findViewById(R.id.textviewtendanhsachcacplaylist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("itemplaylist",mangplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }

}
