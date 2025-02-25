package com.chaseshu.biz;

import com.chaseshu.lock.ZookeeperImproveLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class OrderService implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private OrderNumFactory onf = new OrderNumFactory();

    private final static int count = 100;
    private final static CountDownLatch cdi = new CountDownLatch(count);

//    private final Lock lock = new ReentrantLock();
    private final Lock lock = new ZookeeperImproveLock();//分布式锁 distributed lock

    @Override
    public void run() {

        try {
            cdi.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        createOrderNum();
    }

    public void createOrderNum(){

        lock.lock();
        try{
            String orderNum = onf.createOrderNum();
            logger.info(Thread.currentThread().getName() +  "--->创建订单号：【"+ orderNum +"】");
        }catch (Exception ex){

        }finally {
            lock.unlock();
        }


    }



    public static void main(String [] args){


        for(int i = 0; i < count; i++){
            new Thread(new OrderService()).start();
            cdi.countDown();
        }
    }

}
