import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int i; // Counter
    private final Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                // Wait until i is divisible by 3 but not by 5
                while (i <= n && (i % 3 != 0 || i % 5 == 0)) {
                    lock.wait();
                }
                if (i <= n && i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                }
                lock.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                // Wait until i is divisible by 5 but not by 3
                while (i <= n && (i % 5 != 0 || i % 3 == 0)) {
                    lock.wait();
                }
                if (i <= n && i % 5 == 0 && i % 3 != 0) {
                    printBuzz.run();
                    i++;
                }
                lock.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                // Wait until i is divisible by both 3 and 5
                while (i <= n && (i % 3 != 0 || i % 5 != 0)) {
                    lock.wait();
                }
                if (i <= n && i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                }
                lock.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (i <= n) {
                // Wait until i is not divisible by 3 or 5
                while (i <= n && (i % 3 == 0 || i % 5 == 0)) {
                    lock.wait();
                }
                if (i <= n && i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                }
                lock.notifyAll();
            }
        }
    }
}
