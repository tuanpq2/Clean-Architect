package com.example.lap11799.cleanarchitecture.domain.usecase;

import com.example.lap11799.cleanarchitecture.data.repository.Repository;
import com.example.lap11799.cleanarchitecture.domain.model.Data;
import com.example.lap11799.cleanarchitecture.domain.repository.IRepository;

import java.util.List;

import io.reactivex.Observable;

public class LoadAllData {

    IRepository repository;

    public LoadAllData(){
        this.repository = new Repository();
    }

    public Observable<List<Data>> loadData(){
        return repository.loadAllData();
    }
}