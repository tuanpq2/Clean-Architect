package com.example.lap11799.cleanarchitecture.data.executor;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JobExecutor implements Executor {

    private ThreadPoolExecutor threadPoolExecutor;
    private final int corePoolSize = 3;
    private final int maxPoolSize = 5;
    private final int keepAliveTime = 10;

    @Inject
    public JobExecutor(){
        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize
                ,maxPoolSize
                ,keepAliveTime,
                TimeUnit.SECONDS
                ,new LinkedBlockingQueue<Runnable>());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        this.threadPoolExecutor.execute(command);
    }
}
