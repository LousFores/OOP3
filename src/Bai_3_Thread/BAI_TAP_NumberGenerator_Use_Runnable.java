package Bai_3_Thread;

public class BAI_TAP_NumberGenerator_Use_Runnable {
    public static void main(String[] args) {
        NumberGenerator number1 = new NumberGenerator("Number 1");
        NumberGenerator number2 = new NumberGenerator("Number 2");

        Thread thread1 = new Thread(number1);
        Thread thread2 = new Thread(number2);

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}

class NumberGenerator implements Runnable{
    private String name;

    public NumberGenerator(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("HashCode: " + this.hashCode());
        for (int i = 0; i < 10; i++) {
            System.out.println( this.name + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
