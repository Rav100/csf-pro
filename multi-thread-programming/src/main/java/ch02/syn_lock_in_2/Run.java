package ch02.syn_lock_in_2;

public class Run {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
