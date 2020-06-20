package com.example.appnghenhac.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.R;
import com.example.appnghenhac.adapter.SearchBaiHatAdapter;
import com.example.appnghenhac.model.BaiHat;
import com.example.appnghenhac.service.APIService;
import com.example.appnghenhac.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Tim_Kiem extends Fragment {
    Toolbar toolbar;
    RecyclerView recyclerViewSearchbaihat;
    TextView tvKhongcodulieu;
    View view;
    SearchBaiHatAdapter searchBaiHatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        toolbar = view.findViewById(R.id.toolbarsearchbaihat);
        recyclerViewSearchbaihat = view.findViewById(R.id.recyclerviewsearchbaihat);
        tvKhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true); //chức năng --> phải có
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_view,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { //nhập xong đầy đủ
                SearchTuKhoaBaiHat(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) { //text thay đổi là bắt luôn
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void SearchTuKhoaBaiHat(String query){
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callback = dataService.GetSearchBaihat(query);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> mangbaihat = (ArrayList<BaiHat>) response.body();
                if (mangbaihat.size() >0 ){
                    searchBaiHatAdapter = new SearchBaiHatAdapter(getActivity(),mangbaihat);
                    recyclerViewSearchbaihat.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerViewSearchbaihat.setAdapter(searchBaiHatAdapter);
                    tvKhongcodulieu.setVisibility(View.GONE);
                    recyclerViewSearchbaihat.setVisibility(View.VISIBLE);

                }else {
                    recyclerViewSearchbaihat.setVisibility(View.GONE);
                    tvKhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
