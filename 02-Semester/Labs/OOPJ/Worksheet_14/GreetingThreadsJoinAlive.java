class GreetingThread extends Thread {
    private final String message;
    private final int sleepMillis;

    public GreetingThread(String message, int sleepMillis, String threadName) {
        super(threadName);
        this.message = message;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + ": " + message + " (" + i + ")");
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class GreetingThreadsJoinAlive {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new GreetingThread("Good Morning", 1000, "T1");
        Thread t2 = new GreetingThread("Hello", 2000, "T2");
        Thread t3 = new GreetingThread("Welcome", 3000, "T3");

        t1.start();
        t2.start();
        t3.start();

        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            System.out.println("Status -> T1:" + t1.isAlive() + " T2:" + t2.isAlive() + " T3:" + t3.isAlive());
            Thread.sleep(500);
        }

        t1.join();
        t2.join();
        t3.join();

        System.out.println("bye bye see you all");
    }
}
