package com.example.appnghenhac.service;

import com.example.appnghenhac.model.Album;
import com.example.appnghenhac.model.BaiHat;
import com.example.appnghenhac.model.ChuDe;
import com.example.appnghenhac.model.PlayList;
import com.example.appnghenhac.model.QuangCao;
import com.example.appnghenhac.model.TheLoai;
import com.example.appnghenhac.model.TheLoaiTrongNgay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("songbanner.php") //đọc dữu liệu
    Call<List<QuangCao>> GetDataBanner();

    @GET("playlistforcurren.php")
    Call<List<PlayList>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<TheLoaiTrongNgay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocyeuthichnhat.php")
    Call<List<BaiHat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachcacplaylist.php")
    Call<List<PlayList>> Getdanhsachcacplaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    @GET("tatcachude.php")
    Call<List<ChuDe>> GetAllChuDe();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> GetTheloaitheochude(@Field("idchude") String idchude);

    @GET("tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> UpdateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<BaiHat>> GetSearchBaihat(@Field("tukhoa") String tukhoa);




}
