#include <stdio.h>

int main() {
    int n, k;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
    scanf("%d", &k);

    int sum = 0;
    for (int i = 0; i < k; i++) sum += arr[i];
    int maxSum = sum, start = 0;

    for (int i = k; i < n; i++) {
        sum += arr[i] - arr[i - k];
        if (sum > maxSum) {
            maxSum = sum;
            start = i - k + 1;
        }
    }

    printf("Max avg subarray starts at index %d\n", start);
    printf("Max average = %.2f\n", (float)maxSum / k);
    return 0;
}
