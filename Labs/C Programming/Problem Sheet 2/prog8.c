#include <stdio.h>
int main() {
    int n, i, sum = 0;

    printf("Enter a number: ");
    scanf("%d", &n);

    printf("Factors of %d (excluding itself): ", n);
    for (i = 1; i <= n / 2; i++) {
        if (n % i == 0) {
            printf("%d ", i);
            sum += i;
        }
    }

    printf("\nSum of factors = %d\n", sum);

    if (sum == n) {
        printf("%d is a Perfect Number \n", n);
    } else {
        printf("%d is NOT a Perfect Number \n", n);
    }

    return 0;
}
