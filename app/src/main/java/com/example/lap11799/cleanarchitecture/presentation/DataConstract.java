package com.example.lap11799.cleanarchitecture.presentation;

import com.example.lap11799.cleanarchitecture.domain.model.Data;

import java.util.List;

public interface DataConstract {
    interface IDataView{
        void showProgressBar();
        void hideProgressBar();
        void showData(List<Data> data);
        void showError(String message);
    }
    interface IDataPresenter{
        void getData();
    }
}