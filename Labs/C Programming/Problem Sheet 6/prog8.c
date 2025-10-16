#include <stdio.h>

int main() {
    int arr[] = {12,7,5,12,6,7,9,5,15};
    int n = 9;

    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (arr[i] > arr[j]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

    printf("Sorted Artifacts: ");
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);

    int maxFreq = 0, mostCommon = arr[0], count = 1;
    for (int i = 1; i < n; i++) {
        if (arr[i] == arr[i - 1]) count++;
        else count = 1;
        if (count > maxFreq || (count == maxFreq && arr[i] < mostCommon)) {
            maxFreq = count;
            mostCommon = arr[i];
        }
    }
    printf("\nMost Common Artifact: %d\n", mostCommon);

    int min = arr[0], max = arr[n - 1];
    printf("Missing Values: ");
    for (int i = min; i <= max; i++) {
        int found = 0;
        for (int j = 0; j < n; j++)
            if (arr[j] == i) found = 1;
        if (!found) printf("%d ", i);
    }

    int sum = arr[0];
    for (int i = 1; i < n; i++)
        if (arr[i] != arr[i - 1]) sum += arr[i];
    printf("\nSum of Unique Artifacts: %d\n", sum);
}
