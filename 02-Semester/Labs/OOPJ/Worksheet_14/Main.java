package Threads;

import java.util.*;

class SharedArray {
    int[] arr;

    SharedArray(int[] arr) {
        this.arr = arr;
    }
}

// Thread 1: Calculate Sum
class SumThread implements Runnable {
    SharedArray shared;

    SumThread(SharedArray shared) {
        this.shared = shared;
    }

    public void run() {
        int sum = 0;
        for (int num : shared.arr) {
            sum += num;
        }
        System.out.println(Thread.currentThread().getName() + " (Sum): " + sum);
    }
}

// Thread 2: Find Maximum
class MaxThread implements Runnable {
    SharedArray shared;

    MaxThread(SharedArray shared) {
        this.shared = shared;
    }

    public void run() {
        int max = shared.arr[0];
        for (int num : shared.arr) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println(Thread.currentThread().getName() + " (Max): " + max);
    }
}

// Thread 3: Count Even Numbers
class EvenCountThread implements Runnable {
    SharedArray shared;

    EvenCountThread(SharedArray shared) {
        this.shared = shared;
    }

    public void run() {
        int count = 0;
        for (int num : shared.arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " (Even Count): " + count);
    }
}

// Thread 4: Reverse Array
class ReverseThread implements Runnable {
    SharedArray shared;

    ReverseThread(SharedArray shared) {
        this.shared = shared;
    }

    public void run() {
        System.out.print(Thread.currentThread().getName() + " (Reversed Array): ");
        for (int i = shared.arr.length - 1; i >= 0; i--) {
            System.out.print(shared.arr[i] + " ");
        }
        System.out.println();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SharedArray shared = new SharedArray(arr);

        // Create threads
        Thread t1 = new Thread(new SumThread(shared), "Thread-1");
        Thread t2 = new Thread(new MaxThread(shared), "Thread-2");
        Thread t3 = new Thread(new EvenCountThread(shared), "Thread-3");
        Thread t4 = new Thread(new ReverseThread(shared), "Thread-4");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        sc.close();
    }
}