package assignment25;
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        MyThread obj1 = new MyThread();
        MyThread obj2 = new MyThread();

        obj1.start();
        obj2.start();
    }
}