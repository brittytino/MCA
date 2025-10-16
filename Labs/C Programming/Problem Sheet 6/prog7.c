#include <stdio.h>

int main() {
    int arr[] = {2, 100, 150, 120};
    int n = 4, min = arr[0], maxProfit = 0;

    for (int i = 1; i < n; i++) {
        if (arr[i] < min) min = arr[i];
        else if (arr[i] - min > maxProfit) maxProfit = arr[i] - min;
    }

    printf("Max Profit: %d\n", maxProfit);
}
