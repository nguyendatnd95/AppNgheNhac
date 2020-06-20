package com.example.appnghenhac.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnghenhac.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class Fragment_Dia_Nhac extends Fragment {

    View view;
    CircularImageView circularImageView;
    ObjectAnimator objectAnimator; //tạo ra các hoạt ảnh

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dia_nhac,container,false);
        circularImageView = view.findViewById(R.id.imageviewcircular);
        objectAnimator = ObjectAnimator.ofFloat(circularImageView,"rotation",0f,360f);
        objectAnimator.setDuration(10000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);//chạy xong chạy tiếp
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());//không bị ngắt quãng
        objectAnimator.start();

        return view;
    }
    public void PlayNhac (String hinhanh){
        Picasso.get().load(hinhanh).into(circularImageView);
    }
}
