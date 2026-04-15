class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> Child thread step " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class MyThreadConstructorStart {
    public static void main(String[] args) {
        MyThread child = new MyThread("Child-1");

        for (int i = 1; i <= 5; i++) {
            System.out.println("main -> Main thread step " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        try {
            child.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
