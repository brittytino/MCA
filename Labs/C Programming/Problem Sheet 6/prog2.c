#include <stdio.h>

int main() {
    int arr[] = {1,5,7,5,10,15,5};
    int n = 7, x = 5, count = 0;
    printf("Days with Gift Type %d: ", x);
    for (int i = 0; i < n; i++)
        if (arr[i] == x) {
            printf("%d ", arr[i]);
            count++;
        }
    printf("\nOccurrences: %d\n", count);
}
