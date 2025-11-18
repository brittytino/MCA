#include <stdio.h>
#include <string.h>

int main() {

    // Step 1: Words in spiral order (1 to 9)
    char words[9][20] = {
        "Twinkle,", "twinkle", "little",
        "star,", "how", "I",
        "wonder", "what", "you"
    };

    // Step 2: Create empty 3x3 matrix of strings
    char mat[3][3][20];

    // Step 3: Fill matrix in SPIRAL manually (naive method)

    int k = 0;  // index for words[]

    // Top row (left → right)
    strcpy(mat[0][0], words[k++]);
    strcpy(mat[0][1], words[k++]);
    strcpy(mat[0][2], words[k++]);

    // Right column (top → bottom)
    strcpy(mat[1][2], words[k++]);
    strcpy(mat[2][2], words[k++]);

    // Bottom row (right → left)
    strcpy(mat[2][1], words[k++]);
    strcpy(mat[2][0], words[k++]);

    // Left column (bottom → top)
    strcpy(mat[1][0], words[k++]);

    // Center element
    strcpy(mat[1][1], words[k++]);

    // Step 4: Print the matrix normally
    printf("Spiral Matrix:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%-10s ", mat[i][j]);
        }
        printf("\n");
    }

    return 0;
}
