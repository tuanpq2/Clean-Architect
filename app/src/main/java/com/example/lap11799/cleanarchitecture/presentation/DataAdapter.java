package com.example.lap11799.cleanarchitecture.presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lap11799.cleanarchitecture.R;

import com.example.lap11799.cleanarchitecture.domain.model.Data;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>  {
    private List<Data> dataList;
    private Context context;

    public DataAdapter(Context context,List<Data> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.description.setText(dataList.get(position).getDescription());
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView title;
        TextView description;

        DataViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            title = mView.findViewById(R.id.title);
            description = mView.findViewById(R.id.description);
        }
    }
}