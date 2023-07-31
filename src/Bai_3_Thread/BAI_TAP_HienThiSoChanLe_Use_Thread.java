package Bai_3_Thread;

public class BAI_TAP_HienThiSoChanLe_Use_Thread {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        //oddThread.start();

        evenThread.start();
    }
}

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if ((i%2) == 1) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {

        //[Thực hành] Trải nghiệm vòng đời của Thread
        Thread odd = new Thread(new OddThread());
        odd.start();
        try {
            odd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 10; i++) {
            if ((i % 2) == 0) {
                System.out.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


