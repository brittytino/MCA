#include <stdio.h>

int main() {
    int n1 = 4, n2 = 3, n3 = 3;
    int s1[] = {101, 102, 103, 101};
    int s2[] = {103, 104, 105};
    int s3[] = {106, 107, 102};

    int merged[50], size = 0;

    for (int i = 0; i < n1; i++) merged[size++] = s1[i];
    for (int i = 0; i < n2; i++) merged[size++] = s2[i];
    for (int i = 0; i < n3; i++) merged[size++] = s3[i];

    int unique[50], u = 0;
    for (int i = 0; i < size; i++) {
        int exists = 0;
        for (int j = 0; j < u; j++)
            if (merged[i] == unique[j]) exists = 1;
        if (!exists) unique[u++] = merged[i];
    }

    for (int i = 0; i < u - 1; i++)
        for (int j = i + 1; j < u; j++)
            if (unique[i] > unique[j]) {
                int t = unique[i];
                unique[i] = unique[j];
                unique[j] = t;
            }

    printf("Consolidated IDs: ");
    for (int i = 0; i < u; i++) printf("%d ", unique[i]);
}
