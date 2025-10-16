#include <stdio.h>

int main() {
    int arr[] = {85, 92, 78, 96, 88, 75}, n = 6, threshold = 80;
    int max = arr[0], count = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] > max) max = arr[i];
        if (arr[i] > threshold) count++;
    }

    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (arr[i] > arr[j]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

    printf("Top Scorer's Score: %d\nPlayers Above %d: %d\nSorted: ",
           max, threshold, count);
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);
}
