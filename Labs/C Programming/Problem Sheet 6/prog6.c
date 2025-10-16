#include <stdio.h>

int main() {
    int n = 4;
    int arr[] = {4, 7, 2, 90};
    int temp[4];
    for (int i = 0; i < n; i++) temp[i] = arr[i];

    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (temp[i] > temp[j]) {
                int t = temp[i];
                temp[i] = temp[j];
                temp[j] = t;
            }

    for (int i = 0; i < n; i++) {
        int rank = 1;
        for (int j = 0; j < n; j++)
            if (temp[j] < arr[i]) rank++;
        printf("%d ", rank);
    }
}
