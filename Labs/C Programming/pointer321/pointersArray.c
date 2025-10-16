#include<stdio.h>

int main(){


    int arr[5]={1,2,3,4,5};
    int *ptr = arr;
    for(int i =0; i<5;i++)
    {
        printf("%d\n",*(ptr +i));
    }



    // int arr[5]={1,2,3,4,5};
    // // printf("%d",arr);
    // // for(int i =0;i<5;i++){
    // //     printf("%d\n",arr[i]);
    // // }

    // int a;
    // // printf("%zu\n",sizeof(arr));
    // printf("%p\n",&arr[0]);
}