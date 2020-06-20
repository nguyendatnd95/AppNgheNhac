package com.example.appnghenhac.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.appnghenhac.R;
import com.example.appnghenhac.adapter.AllAlbaumAdapter;
import com.example.appnghenhac.model.Album;
import com.example.appnghenhac.service.APIService;
import com.example.appnghenhac.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachTatCaAlbumActivity extends AppCompatActivity {
    RecyclerView recyclerViewAllAlbum;
    Toolbar toolbar;
    AllAlbaumAdapter allAlbaumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_tat_ca_album);
        init();
        GetData();
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> callback = dataService.GetAlbumHot();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangAlbum = (ArrayList<Album>) response.body();
                allAlbaumAdapter = new AllAlbaumAdapter(DanhSachTatCaAlbumActivity.this,mangAlbum);
                recyclerViewAllAlbum.setLayoutManager(new GridLayoutManager(DanhSachTatCaAlbumActivity.this,2));
                recyclerViewAllAlbum.setAdapter(allAlbaumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewAllAlbum = findViewById(R.id.recyclerviewtatcaalbum);
        toolbar = findViewById(R.id.toolbaralbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Album");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}