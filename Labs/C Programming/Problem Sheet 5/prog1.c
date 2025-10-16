
#include <stdio.h>

int main() {
    int n;
    printf("Enter number of salespeople: ");
    scanf("%d", &n);
    float sales[n], total = 0, max, min;
    int maxId = 1, minId = 1;

    for (int i = 0; i < n; i++) {
        printf("Enter sale of person %d: ", i + 1);
        scanf("%f", &sales[i]);
        total += sales[i];
        if (i == 0) max = min = sales[i];
        if (sales[i] > max) { max = sales[i]; maxId = i + 1; }
        if (sales[i] < min) { min = sales[i]; minId = i + 1; }
    }

    float avg = total / n;
    printf("\nTotal = %.2f\nAverage = %.2f\n", total, avg);
    printf("Highest: %d (%.2f)\nLowest: %d (%.2f)\n", maxId, max, minId, min);

    float val;
    printf("Enter threshold: ");
    scanf("%f", &val);
    int count = 0;
    for (int i = 0; i < n; i++)
        if (sales[i] > val) {
            printf("Person %d -> %.2f\n", i + 1, sales[i]);
            count++;
        }
    printf("Total exceeded: %d\n", count);
}
