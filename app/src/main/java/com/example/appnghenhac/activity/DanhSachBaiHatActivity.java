package com.example.appnghenhac.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appnghenhac.R;
import com.example.appnghenhac.adapter.DanhSachBaiHatAdapter;
import com.example.appnghenhac.model.Album;
import com.example.appnghenhac.model.BaiHat;
import com.example.appnghenhac.model.PlayList;
import com.example.appnghenhac.model.QuangCao;
import com.example.appnghenhac.model.TheLoai;
import com.example.appnghenhac.service.APIService;
import com.example.appnghenhac.service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    ImageView imgdanhsachcakhuc;
    ArrayList<BaiHat> mangbaihat;
    DanhSachBaiHatAdapter danhSachBaiHatAdapter;
    PlayList playList;
    TheLoai theLoai;
    Album album;


    QuangCao quangCao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DataIntent();
        anhXa();
        init();
        if (quangCao != null && !quangCao.getTenBaiHat().equals("")) {
            setValueInView(quangCao.getTenBaiHat(), quangCao.getHinhBaiHat());
            GetDataQuangcao(quangCao.getIdQuangCao());
        }
        if (playList != null && !playList.getTen().equals("")){
            setValueInView(playList.getTen(), playList.getHinhPlaylist());
            GetDataPlaylist(playList.getIdPlaylist());
        }
        if (theLoai != null && !theLoai.getTenTheLoai().equals("")){
            setValueInView(theLoai.getTenTheLoai(), theLoai.getHinhTheLoai());
            GetDataTheLoai(theLoai.getIdTheLoai());
        }
        if (album != null && !album.getTenAlbul().equals("")){
            setValueInView(album.getTenAlbul(), album.getHinhAnhAlbum());
            GetDataAlbum(album.getIdAlbum());
        }
    }

    private void GetDataAlbum(String idAlbum) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callback = dataService.GetDanhsachbaihattheoalbum(idAlbum);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }


    private void GetDataTheLoai(String idtheloai) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callback = dataService.GetDanhsachbaihattheotheloai(idtheloai);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });

    }

    private void GetDataPlaylist(String idplaylist) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callback = dataService.GetDanhsachbaihattheoplaylist(idplaylist);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void GetDataQuangcao(String idquancao) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callback = dataService.GetDanhsachbaihattheoquangcao(idquancao);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                mangbaihat = (ArrayList<BaiHat>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });

    }

    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        Picasso.get().load(hinh).into(imgdanhsachcakhuc);
        new LoadImageInternet().execute(hinh);


//        try {
//            URL url = new URL(hinh);
//            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
//            collapsingToolbarLayout.setBackground(bitmapDrawable);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private class LoadImageInternet extends AsyncTask <String , Void, Bitmap>{
        Bitmap bitmap = null;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        }
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false); //bài hát chưa load hết thì falsse
    }

    private void anhXa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
            }
            if (intent.hasExtra("itemplaylist")){
                playList = (PlayList) intent.getSerializableExtra("itemplaylist");
            }
            if (intent.hasExtra("idtheloai")){
                theLoai = (TheLoai) intent.getSerializableExtra("idtheloai");
            }
            if (intent.hasExtra("album")){
                album = (Album) intent.getSerializableExtra("album");
            }
        }
    }

    private void eventClick(){
        floatingActionButton.setEnabled(true); //load hết rồi thì true
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachBaiHatActivity.this, PlayNhacActivity.class);
                intent.putExtra("cacbaihat", mangbaihat);
                startActivity(intent);
            }
        });
    }
}