public class CurrentThreadInfo {
    public static void main(String[] args) {
        Thread current = Thread.currentThread();

        System.out.println("Current Thread ID: " + current.getId());
        System.out.println("Current Thread Name: " + current.getName());
        System.out.println("Current Thread Priority: " + current.getPriority());
    }
}
