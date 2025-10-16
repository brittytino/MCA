#include <stdio.h>

int main() {
    int n;
    printf("Enter N: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    long long sum_actual = 0, sumSq_actual = 0;
    for (int i = 0; i < n; i++) {
        sum_actual += arr[i];
        sumSq_actual += (long long)arr[i] * arr[i];
    }

    long long sum_expected = (long long)n * (n + 1) / 2;
    long long sumSq_expected = (long long)n * (n + 1) * (2 * n + 1) / 6;

    long long A = sum_actual - sum_expected;
    long long B = sumSq_actual - sumSq_expected;

    long long y_plus_x = B / A;
    long long duplicate = (A + y_plus_x) / 2;
    long long missing = duplicate - A;

    printf("Duplicate = %lld\nMissing = %lld\n", duplicate, missing);
    return 0;
}
