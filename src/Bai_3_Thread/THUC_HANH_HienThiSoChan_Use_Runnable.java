package Bai_3_Thread;

public class THUC_HANH_HienThiSoChan_Use_Runnable {
    public static void main(String[] args) {
        EvenNumbersThread evenRunnable = new EvenNumbersThread();
        Thread thread = new Thread(evenRunnable);
        thread.start();
    }
}

class EvenNumbersRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
