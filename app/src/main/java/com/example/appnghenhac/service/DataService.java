package com.example.appnghenhac.service;

import com.example.appnghenhac.model.PlayList;
import com.example.appnghenhac.model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("songbanner.php") //đọc dữu liệu
    Call<List<QuangCao>> GetDataBanner();

    @GET("playlistforcurren.php")
    Call<List<PlayList>> GetPlaylistCurrentDay();

}
