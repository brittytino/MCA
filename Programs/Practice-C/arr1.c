#include <stdio.h>  // This is like inviting friends (printf and scanf) to play.

int main() {
    int times;  // A box to hold your number.
    printf("How many times to say Hello? ");  // Ask you!
    scanf("%d", &times);  // Wait for your answer, put in box.

    // For loop: Counts like 1,2,3...
    printf("For loop says:\n");
    for (int i = 1; i <= times; i++) {  // Start i=1, while i <= your number, add 1 each time.
        printf("Hello! ");  // Say Hello each lap.
    }
    printf("\n\n");  // New lines for space.

    // While loop: Checks first.
    printf("While loop says:\n");
    int j = 1;  // Start counter at 1.
    while (j <= times) {  // While j is small enough...
        printf("Hello! ");
        j++;  // Add 1 to j (like growing).
    }
    printf("\n\n");

    // Do-while: Does first, checks later.
    printf("Do-while loop says:\n");
    int k = 1;
    do {
        printf("Hello! ");
        k++;
    } while (k <= times);  // Check after.

    return 0;  // End the story happily.
}