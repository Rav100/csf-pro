package ch02.two_stop_test;

public class Service {

    Object object1 = new Object();
    public void methodA(){
        synchronized (object1){ // lock1
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while(isContinueRun){

            }
            System.out.println("methodA end");

        }
    }

    Object object2 = new Object();
    public void methodB(){
        synchronized (object2){ // lock2
            System.out.println("methodB begin");
            System.out.println("methodB end");

        }
    }
}
