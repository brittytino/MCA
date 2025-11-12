#include <stdio.h>

int main() {
    char arr[3][3][50];  // 3x3 matrix of strings
    int i, j;

    printf("Enter 9 words (to form a 3x3 matrix):\n");

    // Input words
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            scanf("%49s", arr[i][j]);
        }
    }

    // Display 3x3 matrix
    printf("\n--- 3x3 String Matrix ---\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++) {
            printf("%-10s ", arr[i][j]);  // formatted spacing
        }
        printf("\n");
    }

    // Spiral order print
    printf("\n--- Spiral Order ---\n");
    int top = 0, bottom = 2, left = 0, right = 2;

    while (top <= bottom && left <= right) {
        // left to right
        for (i = left; i <= right; i++)
            printf("%s ", arr[top][i]);
        top++;

        // top to bottom
        for (i = top; i <= bottom; i++)
            printf("%s ", arr[i][right]);
        right--;

        // right to left
        if (top <= bottom) {
            for (i = right; i >= left; i--)
                printf("%s ", arr[bottom][i]);
            bottom--;
        }

        // bottom to top
        if (left <= right) {
            for (i = bottom; i >= top; i--)
                printf("%s ", arr[i][left]);
            left++;
        }
    }

    printf("\n");
    return 0;
}
