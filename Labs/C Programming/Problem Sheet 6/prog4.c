#include <stdio.h>

int main() {
    int arr[] = {120,150,100,175,130,160,140}, n = 7;
    int max = arr[0], min = arr[0];
    float total = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] > max) max = arr[i];
        if (arr[i] < min) min = arr[i];
        total += arr[i];
    }

    printf("Max Attendance: %d\nMin Attendance: %d\nAverage: %.2f\n",
           max, min, total / n);
}
