package Threads;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EvenNumberTask implements Runnable{
    List<Integer>lst;
    EvenNumberTask(List<Integer>lst){
        this.lst=lst;
    }
    public void run(){
        for(int i = 0; i<lst.size();i++){
            int num = lst.get(i);
            if (num % 2 == 0){
                System.out.println("Even: " + num);
            }
        }
    }
}
class OddNumberTask implements Runnable{
    List<Integer>lst;
    OddNumberTask(List<Integer>lst){
        this.lst=lst;
    }
    public void run(){
        for(int i = 0; i<lst.size();i++){
            int num = lst.get(i);
            if (num % 2!= 0){
                System.out.println("Odd: " + num);
            }
        }
    }
}

public class ListOddEven {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        List<Integer> lst = new ArrayList<>();
        System.out.print("How many numbers? ");
        int n = ip.nextInt();

        for(int i = 0; i < n; i++){
            int num = ip.nextInt();
            lst.add(num);
        }
        Thread t1 = new Thread(new EvenNumberTask(lst));
        Thread t2 = new Thread(new OddNumberTask(lst));

        t1.start();
        t2.start();
    }
}
