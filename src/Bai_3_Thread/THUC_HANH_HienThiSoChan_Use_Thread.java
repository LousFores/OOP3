package Bai_3_Thread;

public class THUC_HANH_HienThiSoChan_Use_Thread {
    public static void main(String[] args) {
        EvenNumbersThread evnt = new EvenNumbersThread();
        evnt.start();
    }
}

class EvenNumbersThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i < 10; i += 2) {
            System.out.println(i);
        }
    }
}
