package com.example.lap11799.cleanarchitecture.data.entity;

import com.example.lap11799.cleanarchitecture.domain.model.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataMapper {

    public DataMapper() {
    }

    public Data transform(DataEntity dataEntity){
        Data data = null;
        if(dataEntity != null){
            data = new Data(dataEntity.getId(),dataEntity.getTitle(),dataEntity.getDescription());
        }
        return data;
    }

    public List<Data> transform(Collection<DataEntity> dataEntityCollection){
        List<Data> dataList = new ArrayList<>();
        for(DataEntity dataEntity: dataEntityCollection){
            Data data = transform(dataEntity);
            if(data != null){
                dataList.add(data);
            }
        }
        return dataList;
    }
}
