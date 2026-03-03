package WorkSheet_4;

import java.util.Scanner;

public class AverageScore {
    static int calcSum(int [] arr,int n){
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    static int calcAverage(int sum,int n){
        return sum/n;
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter no of Students: ");
        int n = ip.nextInt();
        System.out.println("Enter the Mark's: ");
        int []arr= new int[n];
        for (int i =0;i <n;i++){
            arr[i]=ip.nextInt();
        }
        int sum = calcSum(arr,n);
        System.out.print("Sum:" + sum);
        int average = calcAverage(sum,n);
        System.out.print("Average:" + average);
        ip.close();
    }
}
