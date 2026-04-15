import java.util.Scanner;

public class CounterSynchronizationDemo {

    static class Counter {
        int count;

        void inc() {
            count = count + 1;
        }

        int getCount() {
            return count;
        }
    }

    static class ThreadSafeCounter {
        private int count;

        synchronized void inc() {
            count = count + 1;
        }

        synchronized int getCount() {
            return count;
        }
    }

    static class UnsyncWorker extends Thread {
        private final Counter counter;
        private final int increments;

        UnsyncWorker(Counter counter, int increments) {
            this.counter = counter;
            this.increments = increments;
        }

        @Override
        public void run() {
            for (int i = 0; i < increments; i++) {
                counter.inc();
            }
        }
    }

    static class SyncWorker extends Thread {
        private final ThreadSafeCounter counter;
        private final int increments;

        SyncWorker(ThreadSafeCounter counter, int increments) {
            this.counter = counter;
            this.increments = increments;
        }

        @Override
        public void run() {
            for (int i = 0; i < increments; i++) {
                counter.inc();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int numThreads = scanner.nextInt();
        System.out.print("Enter increments per thread: ");
        int increments = scanner.nextInt();

        int expected = numThreads * increments;

        Counter counter = new Counter();
        Thread[] unsyncThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            unsyncThreads[i] = new UnsyncWorker(counter, increments);
            unsyncThreads[i].start();
        }
        for (Thread t : unsyncThreads) {
            t.join();
        }

        ThreadSafeCounter safeCounter = new ThreadSafeCounter();
        Thread[] syncThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            syncThreads[i] = new SyncWorker(safeCounter, increments);
            syncThreads[i].start();
        }
        for (Thread t : syncThreads) {
            t.join();
        }

        System.out.println("Expected count: " + expected);
        System.out.println("Unsynchronized counter value: " + counter.getCount());
        System.out.println("Synchronized counter value: " + safeCounter.getCount());
    }
}
