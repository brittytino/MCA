#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, x;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
    scanf("%d", &x);

    int i = 0;
    while (i < n) {
        if (arr[i] == x) {
            printf("Found at index %d\n", i);
            return 0;
        }
        i += abs(arr[i] - x);
    }
    printf("Not found\n");
}
