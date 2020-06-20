package com.example.appnghenhac.service;

public class APIService {
    private static String base_url = "https://monocarpellary-tag.000webhostapp.com/Server/";

    public static  DataService getService(){

        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
