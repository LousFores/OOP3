package Bai_3_Thread;

import java.util.Scanner;

public class BAI_TAP_HaiThreadDoanSo_Use_Runnable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Người thứ 1 nhập số dự đoán: ");
        int number1 = scanner.nextInt();
        System.out.print("Người thứ 2 nhập số dự đoán: ");
        int number2 = scanner.nextInt();

        GuessANumberRunnable guessNumber1 = new GuessANumberRunnable(number1);
        GuessANumberRunnable guessNumber2 = new GuessANumberRunnable(number2);

        Thread thread1 = new Thread(guessNumber1);
        Thread thread2 = new Thread(guessNumber2);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}

class GuessANumberRunnable implements Runnable {
    private int guessANumber = 0;
    private int count = 0;
    public GuessANumberRunnable(int guessANumber) {
        this.guessANumber = guessANumber;
    }

    @Override
    public void run() {
        int randomNumber = 0;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(Thread.currentThread().getName() + " đoán số " + randomNumber);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (randomNumber != guessANumber);
        System.out.println(Thread.currentThread().getName() + " đã đoán ra số trong " + count + " lần đếm");
    }
}
