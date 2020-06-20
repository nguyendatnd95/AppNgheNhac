package com.example.appnghenhac.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appnghenhac.R;
import com.example.appnghenhac.adapter.DanhSachTatCaChuDeAdapter;
import com.example.appnghenhac.model.ChuDe;
import com.example.appnghenhac.service.APIService;
import com.example.appnghenhac.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcachudeActivity extends AppCompatActivity {

    Toolbar toolbartatcachude;
    RecyclerView recyclerViewtatcachude;
    DanhSachTatCaChuDeAdapter danhSachTatCaChuDeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        init();
        GetData();
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<ChuDe>> callback = dataService.GetAllChuDe();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhSachTatCaChuDeAdapter = new DanhSachTatCaChuDeAdapter(DanhsachtatcachudeActivity.this,mangchude);
                recyclerViewtatcachude.setLayoutManager(new GridLayoutManager(DanhsachtatcachudeActivity.this,1));
                recyclerViewtatcachude.setAdapter(danhSachTatCaChuDeAdapter);

            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewtatcachude = findViewById(R.id.recyclerviewtatcachude);
        toolbartatcachude = findViewById(R.id.toolbarchude);
        setSupportActionBar(toolbartatcachude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartatcachude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}