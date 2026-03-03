package WorkSheet_4;

import java.util.Scanner;

public class ScoreMin {
    static int findMin(int[] arr,int n){
        int min = arr[0];
        for(int i =0; i < arr.length ; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;

    }
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter no of Atheletes: ");
        int n = ip.nextInt();
        System.out.println("Enter the Score's: ");
        int []arr= new int[n];
        for (int i =0;i <n;i++){
            arr[i]=ip.nextInt();
        }
        int fast = findMin(arr,n);
        System.out.print("Fastest:" + fast);

        ip.close();
    }
}
