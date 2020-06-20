package com.example.appnghenhac.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.R;
import com.example.appnghenhac.activity.PlayNhacActivity;
import com.example.appnghenhac.model.BaiHat;
import com.example.appnghenhac.service.APIService;
import com.example.appnghenhac.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBaiHatAdapter extends RecyclerView.Adapter<SearchBaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> mangbaihat;

    public SearchBaiHatAdapter(Context context, ArrayList<BaiHat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_search_bai_hat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = mangbaihat.get(position);
        holder.tvTenbaihat.setText(baiHat.getTenBaiHat());
        holder.tvcasi.setText(baiHat.getCaSi());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.imgBaiHat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenbaihat, tvcasi;
        ImageView imgBaiHat, imgLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            tvcasi = itemView.findViewById(R.id.textviewsearchtencasi);
            imgBaiHat = itemView.findViewById(R.id.imageviewsearchbaihat);
            imgLuotThich = itemView.findViewById(R.id.imageviewSearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });

            imgLuotThich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgLuotThich.setImageResource(R.drawable.iconloved);
                    DataService dataService = APIService.getService();
                    Call<String> callback = dataService.UpdateLuotThich("1", mangbaihat.get(getPosition()).getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")){
                                Toast.makeText(context, "Đã Thích", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "Loi!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgLuotThich.setEnabled(false);
                }
            });
        }
    }
}
