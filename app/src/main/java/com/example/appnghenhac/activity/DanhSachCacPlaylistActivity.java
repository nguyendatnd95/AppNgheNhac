package com.example.appnghenhac.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appnghenhac.R;
import com.example.appnghenhac.adapter.DanhsachcacplaylistAdapter;
import com.example.appnghenhac.model.PlayList;
import com.example.appnghenhac.service.APIService;
import com.example.appnghenhac.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachCacPlaylistActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachcacplaylist;
    DanhsachcacplaylistAdapter danhsachcacplaylistAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_cac_playlist);

        anhXa();
        init();
        GetData();
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<PlayList>> callback = dataService.Getdanhsachcacplaylist();
        callback.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                ArrayList<PlayList> mangplaylist = (ArrayList<PlayList>) response.body();
                danhsachcacplaylistAdapter = new DanhsachcacplaylistAdapter(DanhSachCacPlaylistActivity.this,mangplaylist);
                recyclerViewdanhsachcacplaylist.setLayoutManager(new GridLayoutManager(DanhSachCacPlaylistActivity.this,2));
                recyclerViewdanhsachcacplaylist.setAdapter(danhsachcacplaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play Lists");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void anhXa() {
        toolbar = findViewById(R.id.toolbarplaylist);
        recyclerViewdanhsachcacplaylist = findViewById(R.id.recyclerviewdanhsachcacplaylist);
    }
}