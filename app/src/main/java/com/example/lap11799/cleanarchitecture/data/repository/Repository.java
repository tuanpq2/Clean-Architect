package com.example.lap11799.cleanarchitecture.data.repository;

import com.example.lap11799.cleanarchitecture.data.entity.DataEntity;
import com.example.lap11799.cleanarchitecture.data.entity.DataMapper;
import com.example.lap11799.cleanarchitecture.data.retrofit.GetDataService;
import com.example.lap11799.cleanarchitecture.data.retrofit.RetrofitInstance;
import com.example.lap11799.cleanarchitecture.domain.model.Data;
import com.example.lap11799.cleanarchitecture.domain.repository.IRepository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    private DataMapper dataMapper;
    public Repository(){
        this.dataMapper = new DataMapper();
    }

    @Override
    public Observable<List<Data>> loadAllData() {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<DataEntity>> call = service.getAllData();
        return Observable.create(emitter -> {
            call.enqueue(new Callback<List<DataEntity>>() {
                @Override
                public void onResponse(Call<List<DataEntity>> call, final Response<List<DataEntity>> response) {
                    emitter.onNext(dataMapper.transform(response.body()));
                    emitter.onComplete();
                }

                @Override
                public void onFailure(Call<List<DataEntity>> call, Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }
}
