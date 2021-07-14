package com.one.learn.resttemplate.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Resource(name = "defaultThreadPool")
    private ExecutorService executorService;
    @Resource(name = "orderThreadPool")
    private ExecutorService executorServiceOrder;


    public void threadDemo() {

        for (int i = 0; i <10 ; i++) {
            executorService.execute(()->{

                System.out.println("AAAAAAA");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            executorServiceOrder.execute(()->{
                System.out.println("BBBBBBB");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }

}
