package com.valentine.stickers.imagesliderbanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://ankush2016.github.io/";

    @GET("sticker_banner_ads.json")
    Call<List<MyBanner>> getMyBaners();
}
