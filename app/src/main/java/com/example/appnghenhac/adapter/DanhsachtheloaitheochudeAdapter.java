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
import com.example.appnghenhac.model.TheLoai;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtheloaitheochudeAdapter extends RecyclerView.Adapter<DanhsachtheloaitheochudeAdapter.ViewHolder>{
    Context context;
    ArrayList<TheLoai> mangTheLoai;

    public DanhsachtheloaitheochudeAdapter(Context context, ArrayList<TheLoai> mangTheLoai) {
        this.context = context;
        this.mangTheLoai = mangTheLoai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_the_loai_theo_chu_de,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TheLoai theLoai = mangTheLoai.get(position);
        Picasso.get().load(theLoai.getHinhTheLoai()).into(holder.imghinhtheloai);
        holder.tvTentheloai.setText(theLoai.getTenTheLoai());

    }

    @Override
    public int getItemCount() {
        return mangTheLoai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhtheloai;
        TextView tvTentheloai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhtheloai = itemView.findViewById(R.id.imageviewtheloaitheochude);
            tvTentheloai = itemView.findViewById(R.id.textviewtentheloaitheochude);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                    intent.putExtra("idtheloai",mangTheLoai.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
