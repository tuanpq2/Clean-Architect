package com.example.lap11799.cleanarchitecture.domain.repository;

import com.example.lap11799.cleanarchitecture.domain.model.Data;

import java.util.List;

import io.reactivex.Observable;

public interface IRepository {
    Observable<List<Data>> loadAllData();
}
