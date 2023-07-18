package Bai_3_Thread;

import java.util.Scanner;

public class BAI_TAP_HaiThreadDoanSo_Use_Thread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Người 1 nhập vào 1 số muốn đoán: ");
        int number1 = scanner.nextInt();
        System.out.print("Người 2 nhập vào 1 số muốn đoán: ");
        int number2 = scanner.nextInt();

        GuessANumberThread guessNumber1 = new GuessANumberThread(number1);
        GuessANumberThread guessNumber2 = new GuessANumberThread(number2);

        guessNumber1.setName("Thread 1");
        guessNumber2.setName("Thread 2");

        guessNumber1.start();
        guessNumber2.start();
    }
}

class GuessANumberThread extends Thread {
    private int guessNumber = 0;
    private int count = 0;

    public GuessANumberThread(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    @Override
    public void run() {
        int randomNumber = 0;
        do {
           randomNumber = (int) (Math.random() * 100 + 1);
           count++;
           System.out.println(getName() + " đoán số " + randomNumber);
           try {
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        } while (randomNumber != guessNumber);
        System.out.println(getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đếm");
    }
}
