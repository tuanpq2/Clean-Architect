package com.example.lap11799.cleanarchitecture.presentation;

import com.example.lap11799.cleanarchitecture.domain.model.Data;
import com.example.lap11799.cleanarchitecture.domain.usecase.LoadAllData;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DataPresenter implements DataConstract.IDataPresenter {

    private DataConstract.IDataView dataView;
    private LoadAllData loadAllData;

    public DataPresenter(DataConstract.IDataView dataView) {
        this.dataView = dataView;
        loadAllData = new LoadAllData();
    }


    @Override
    public void getData() {
        dataView.showProgressBar();

        loadAllData.loadData().subscribe(new Observer<List<Data>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Data> data) {
                dataView.showData(data);
            }

            @Override
            public void onError(Throwable e) {
                dataView.hideProgressBar();
                dataView.showError(e.getMessage());
            }

            @Override
            public void onComplete() {
                dataView.hideProgressBar();
            }
        });
    }
}
