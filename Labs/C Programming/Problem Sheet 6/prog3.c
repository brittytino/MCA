#include <stdio.h>

int main() {
    int n = 5, grades[] = {85, 92, 88, 76, 95};
    int max = grades[0];
    float sum = 0;

    for (int i = 0; i < n; i++) {
        if (grades[i] > max) max = grades[i];
        sum += grades[i];
    }

    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (grades[i] > grades[j]) {
                int t = grades[i];
                grades[i] = grades[j];
                grades[j] = t;
            }

    printf("Average Grade: %.2f\n", sum / n);
    printf("Highest Grade: %d\n", max);
    printf("Sorted Grades: ");
    for (int i = 0; i < n; i++) printf("%d ", grades[i]);
}
