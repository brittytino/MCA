class NameThread extends Thread {
    private final String displayName;

    public NameThread(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Thread class] " + displayName + " - step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class NameRunnable implements Runnable {
    private final String displayName;

    public NameRunnable(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[Runnable] " + displayName + " - step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new NameThread("Student-A");
        Thread t2 = new Thread(new NameRunnable("Student-B"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
