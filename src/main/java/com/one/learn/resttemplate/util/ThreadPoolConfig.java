package com.one.learn.resttemplate.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean("defaultThreadPool")
    public ExecutorService defaultThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
        return threadPoolExecutor;
    }

    @Bean("orderThreadPool")
    public ExecutorService orderThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
        return threadPoolExecutor;
    }
}
