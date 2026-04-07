package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class NegativeTask implements Runnable{
    List<Integer>lst;

    NegativeTask(List<Integer>lst){
        this.lst=lst;
    }
    public void run(){
        for(int i =0; i<lst.size();i++){
            int num = lst.get(i);
            if(num < 0){
                System.out.println("Negative: "+ num);
            }
        }
    }
}
class PositiveEvenTask implements Runnable{
    List<Integer>lst;

    PositiveEvenTask(List<Integer>lst){
        this.lst=lst;
    }
    public void run(){
        for(int i =0; i<lst.size();i++){
            int num = lst.get(i);
            if(num > 0 && num % 2 == 0){
                System.out.println("Positive Even: " + num);
            }
        }

    }
}

class PositiveOddTask implements Runnable{
    List<Integer>lst;

    PositiveOddTask(List<Integer>lst){
        this.lst=lst;
    }
    public void run(){
        for(int i =0;i<lst.size();i++){
            int num = lst.get(i);
            if(num > 0 && num % 2 !=0 ){
                System.out.println("Positive Odd: "+ num);
            }
        }

    }
}


public class RandomNegEveOdd {
    public static void main(String[] args) {
        List<Integer>lst = new ArrayList<>();
        Random rand = new Random();
        for (int i =0;i<10;i++){
            int num = rand.nextInt(101) - 50;
            lst.add(num);
        }

        Thread t1 = new Thread(new NegativeTask(lst));
        Thread t2 = new Thread(new PositiveEvenTask(lst));
        Thread t3 = new Thread(new PositiveOddTask(lst));

        t1.start();
        t2.start();
        t3.start();

        try{
            Thread.sleep(50);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
