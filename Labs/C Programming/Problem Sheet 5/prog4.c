#include <stdio.h>

int main() {
    int n, m, k;
    scanf("%d%d%d", &n, &m, &k);
    int count = 0, result = 0;

    for (int p = k; p >= 1; p--) {
        if (n % p == 0 && m % p == 0) {
            count++;
            if (count == 3) {
                result = p;
                break;
            }
        }
    }

    printf("Result = %d\n", result);
    return 0;
}
