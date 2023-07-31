package Bai_3_Thread;

public class BAI_TAP_TimSoNguyenTo_Use_Thread {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPr = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimized = new OptimizedPrimeFactorization();
        lazyPr.start();
        lazyPr.joinEvent();
        optimized.start();
    }
}

class LazyPrimeFactorization extends Thread{
    @Override
    public void run() {
        System.out.println("LazyPrimeFactorization");
        for (int i = 2; i <= 20; i++) {
            boolean check = true;
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    check = false;
                    break;
                }
            }
            if (check) System.out.println(i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void joinEvent() {
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class OptimizedPrimeFactorization extends Thread {
    @Override
    public void run() {
        System.out.println("OptimizedPrimeFactorization");
        for (int i = 2; i <= 30; i++) {
            boolean check = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if ((i % j) == 0) {
                    check = false;
                    break;
                }
            }
            if (check) System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//class LazyPrimeFactorization implements Runnable {
//    @Override
//    public void run() {
//        int num = 2;
//        while (true) {
//            if (isPrime(num)) {
//                System.out.println("Lazy Prime Factorization: " + num);
//            }
//            num++;
//        }
//    }
//
//    private boolean isPrime(int num) {
//        if (num < 2) return false;
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
//
//class OptimizedPrimeFactorization implements Runnable {
//    @Override
//    public void run() {
//        int num = 2;
//        while (true) {
//            if (isPrime(num)) {
//                System.out.println("Optimized Prime Factorization: " + num);
//            }
//            num++;
//        }
//    }
//
//    private boolean isPrime(int num) {
//        if (num < 2) return false;
//        if (num == 2 || num == 3) return true;
//        if (num % 2 == 0) return false;
//        for (int i = 3; i <= Math.sqrt(num); i += 2) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}