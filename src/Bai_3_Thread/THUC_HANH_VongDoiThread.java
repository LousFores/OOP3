package Bai_3_Thread;

public class THUC_HANH_VongDoiThread {
}

class MyThread extends Thread {
    @Override
    public void run() {
//        System.out.println("Thread start");
//        DemoSynchronized.commnResource();

//        System.out.println("MyRunnable Start");
//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("MyRunnable End");
//        }

        System.out.println("MyThread Start");
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        try {
            myRunnableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread End");
    }

    public static void main(String[] args) {
        //MyThread myThread = new MyThread();
        //myThread.start(); //2 trạng thái con, đó là, Ready to Run – Chờ đợi cấp phát tài nguyên, và Running
        //System.out.println(myThread.getState()); //Để có thể xem được trạng thái của một Thread

//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//
//        myThread1.start();
//        myThread2.start();
//
//        System.out.println(myThread1.getName() + ": " + myThread1.getState());
//        System.out.println(myThread2.getName() + ": " + myThread2.getState());

//        WAITING
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(20000);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
                System.out.println("MyRunnable Start");
        for (int i = 0; i < 100 ; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyRunnable End");
        }
    }
}

//BLOCKED - Chỉ một Thread được ưu tiên sử dụng đến tài nguyên dùng chung, các Thread còn lại  bị khoá và phải đợi cho Thread ưu tiên kia sử dụng xong tài nguyên rồi mới được chạy.
class DemoSynchronized {
    public static synchronized void  commnResource() {
        for (int i = 0; i < 100000; i++) {

        }
    }
}
