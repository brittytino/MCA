package WorkSheet_4;

import java.util.Scanner;

public class CountEven {
    static int evenCount(int[] arr, int n){
        int count = 0;
        for(int i =0;i< arr.length ;i++){
            if(arr[i]% 2 == 0){
                count ++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter no of Tokens: ");
        int n = ip.nextInt();
        System.out.println("Enter the Each Token No: ");
        int []arr= new int[n];
        for (int i =0;i <n;i++){
            arr[i]=ip.nextInt();
        }
        int even_count = evenCount(arr,n);
        System.out.print("Even Count:" + even_count);

        ip.close();
    }
}
