package com.example.appnghenhac.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appnghenhac.R;
import com.example.appnghenhac.activity.DanhSachBaiHatActivity;
import com.example.appnghenhac.model.QuangCao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);

        ImageView imgBackgroundBanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgSongBanner = view.findViewById(R.id.imageviewbanner);
        TextView tvTitleSongBanner = view.findViewById(R.id.textviewtitlebannerbaihat);
        TextView tvNoiDung = view.findViewById(R.id.textviewnoidung);

        Picasso.get().load(arrayListBanner.get(position).getHinhanh()).into(imgBackgroundBanner);
        Picasso.get().load(arrayListBanner.get(position).getHinhBaiHat()).into(imgSongBanner);
        tvTitleSongBanner.setText(arrayListBanner.get(position).getTenBaiHat());
        tvNoiDung.setText(arrayListBanner.get(position).getNoidung());

        //add vào viewpager
        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("banner",arrayListBanner.get(position));
                context.startActivity(intent);
            }
        });

        return view;
    }

    //pager cuối cùng phải remove
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
