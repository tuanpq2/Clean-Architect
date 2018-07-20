package com.example.lap11799.cleanarchitecture.data.retrofit;

import com.example.lap11799.cleanarchitecture.data.entity.DataEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/v2/5b5143722e00006d065c1825")
    Call<List<DataEntity>> getAllData();
}
