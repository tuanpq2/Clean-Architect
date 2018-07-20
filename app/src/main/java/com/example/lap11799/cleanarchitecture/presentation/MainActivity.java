package com.example.lap11799.cleanarchitecture.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lap11799.cleanarchitecture.R;
import com.example.lap11799.cleanarchitecture.domain.model.Data;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataConstract.IDataView{
    RecyclerView recyclerView;
    ProgressBar progressBar;
    private DataAdapter adapter;
    DataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        hideProgressBar();
        presenter = new DataPresenter(this);
        presenter.getData();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showData(List<Data> data) {
        adapter = new DataAdapter(this,data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
