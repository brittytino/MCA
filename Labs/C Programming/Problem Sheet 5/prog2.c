#include <stdio.h>

int main() {
    int n;
    printf("Enter number of questions: ");
    scanf("%d", &n);
    int key[n];
    printf("Enter key: ");
    for (int i = 0; i < n; i++) scanf("%d", &key[i]);

    char choice = 'y';
    while (choice == 'y' || choice == 'Y') {
        int correct = 0, ans;
        printf("Enter answers: ");
        for (int i = 0; i < n; i++) {
            scanf("%d", &ans);
            if (ans == key[i]) correct++;
        }
        printf("Score: %d/%d (%.2f%%)\n", correct, n, (correct * 100.0 / n));
        printf("Grade another quiz? (y/n): ");
        scanf(" %c", &choice);
    }
}
