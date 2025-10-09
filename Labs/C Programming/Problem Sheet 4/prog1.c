#include <stdio.h>

int main() {
    int n, i;
    printf("Enter the size of the array (N): ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements (1 to %d with one duplicate and one missing):\n", n);
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int sum = 0, sumSq = 0;

    for (i = 0; i < n; i++) {
        sum += arr[i];
        sumSq += arr[i] * arr[i];
    }

    int expectedSum = n * (n + 1) / 2;
    int expectedSqSum = n * (n + 1) * (2 * n + 1) / 6;

    int diff = sum - expectedSum;               
    int diffSq = sumSq - expectedSqSum;         

    int sumDupMiss = diffSq / diff;            

    int duplicate = (diff + sumDupMiss) / 2;
    printf("The duplicated number is: %d\n", duplicate);

    return 0;
}
