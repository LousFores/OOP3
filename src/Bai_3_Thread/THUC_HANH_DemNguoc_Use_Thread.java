package Bai_3_Thread;

public class THUC_HANH_DemNguoc_Use_Thread {
    public static void main(String[] args) {
        CountdownThread countdownThread = new CountdownThread();
         countdownThread.run();
    }
}

class CountdownThread extends Thread {
    @Override
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}