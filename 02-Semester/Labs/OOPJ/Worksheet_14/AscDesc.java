package Threads;

import java.util.*;

class AscendingTask implements Runnable{
    List<Integer>asclst;
    AscendingTask(List<Integer>asclst){
        this.asclst=asclst;
    }
    public void run(){
        Collections.sort(asclst);
        System.out.println("Ascending: " + asclst);
    }
}
class DescendingTask implements Runnable{
    List<Integer>desclst;
    DescendingTask(List<Integer>desclst){
        this.desclst=desclst;
    }
    public void run(){
        Collections.sort(desclst, Collections.reverseOrder());
        System.out.println("Descending: " + desclst);

    }
}
public class AscDesc {
    public static void main(String[] args) {
        List<Integer>asclst = new ArrayList<>();
        List<Integer>desclst = new ArrayList<>();

        Scanner ip = new Scanner(System.in);
        System.out.println("Enter Numbers: ");
        int n = ip.nextInt();

        for(int i =0;i<n;i++){
            int num = ip.nextInt();
            asclst.add(num);
            desclst.add(num);
        }
        System.out.println("Original: " + asclst);
        Thread t1 = new Thread(new AscendingTask(asclst));
        Thread t2 = new Thread(new DescendingTask(desclst));

        t1.start();
        t2.start();

    }
}
