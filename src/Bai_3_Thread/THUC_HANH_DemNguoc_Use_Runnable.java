package Bai_3_Thread;

public class THUC_HANH_DemNguoc_Use_Runnable {
    public static void main(String[] args) {
        CountDonwnRunnable cdr = new CountDonwnRunnable();
        Thread thread = new Thread(cdr);
        thread.start();
    }
}

class CountDonwnRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i >= 1 ; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
