package com.example.appnghenhac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.R;
import com.example.appnghenhac.model.BaiHat;

import java.util.ArrayList;

public class PlayNhacAdapter extends RecyclerView.Adapter<PlayNhacAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat> mangbaihat;

    public PlayNhacAdapter(Context context, ArrayList<BaiHat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_play_bai_hat, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = mangbaihat.get(position);
        holder.tvCasi.setText(baiHat.getCaSi());
        holder.tvindex.setText(position + 1 + "");
        holder.tvTenbaihat.setText(baiHat.getTenBaiHat());
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvindex, tvTenbaihat, tvCasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCasi = itemView.findViewById(R.id.textviewplaynhactencasi);
            tvindex = itemView.findViewById(R.id.textviewplaynhacindex);
            tvTenbaihat = itemView.findViewById(R.id.textviewplaynhactenbaihat);
        }
    }
}
