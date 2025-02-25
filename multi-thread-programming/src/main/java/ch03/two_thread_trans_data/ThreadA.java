package ch03.two_thread_trans_data;

import java.util.concurrent.locks.Lock;

public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try{
            synchronized (lock){
                for(int i = 0;i < 10; i++){
                    MyList.add();

                    if(MyList.size() == 5){
                        lock.notify();
                        System.out.println("已发出通知！");
                    }
                    System.out.println(Thread.currentThread().getName() +
                            " 添加了"+(i+1)+"个元素");
                    Thread.sleep(1000);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
