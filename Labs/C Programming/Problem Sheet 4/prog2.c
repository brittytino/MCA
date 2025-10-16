#include <stdio.h>

int main() {
    int m, n;
    printf("Enter rows and cols: ");
    scanf("%d%d", &m, &n);
    int a[m][n];

    printf("Enter matrix:\n");
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    printf("To-and-fro row-major order:\n");
    for (int i = 0; i < m; i++) {
        if (i % 2 == 0)
            for (int j = 0; j < n; j++) printf("%d ", a[i][j]);
        else
            for (int j = n - 1; j >= 0; j--) printf("%d ", a[i][j]);
    }
    return 0;
}

#include <stdio.h>

int main() {
    int n;
    printf("Enter size: ");
    scanf("%d", &n);
    int a[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    printf("Diagonal-major order:\n");
    for (int d = 0; d < 2 * n - 1; d++) {
        int row = d < n ? 0 : d - n + 1;
        int col = d < n ? d : n - 1;
        while (row < n && col >= 0)
            printf("%d ", a[row++][col--]);
    }
    return 0;
}


#include <stdio.h>

int main() {
    int m, n;
    scanf("%d%d", &m, &n);
    int a[m][n];
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    int top = 0, bottom = m - 1, left = 0, right = n - 1;
    printf("Spiral order:\n");
    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) printf("%d ", a[top][i]);
        top++;
        for (int i = top; i <= bottom; i++) printf("%d ", a[i][right]);
        right--;
        if (top <= bottom)
            for (int i = right; i >= left; i--) printf("%d ", a[bottom][i]);
        bottom--;
        if (left <= right)
            for (int i = bottom; i >= top; i--) printf("%d ", a[i][left]);
        left++;
    }
    return 0;
}
