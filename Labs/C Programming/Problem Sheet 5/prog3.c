#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    int A[n][n], B[n][n], C[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &A[i][j]);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            B[i][j] = (A[i][j] + A[j][i]) / 2;
            C[i][j] = (A[i][j] - A[j][i]) / 2;
        }

    printf("Symmetric matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) printf("%d ", B[i][j]);
        printf("\n");
    }

    printf("Skew-symmetric matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) printf("%d ", C[i][j]);
        printf("\n");
    }
}
