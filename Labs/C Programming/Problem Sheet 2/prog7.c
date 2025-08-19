#include <stdio.h>
int main() {
    int matchsticks = 21, user, computer;

    printf("Welcome to the Matchstick Game!\n \n Rules: \n 1. There are 21 matchsticks.\n 2. You can pick 1, 2, 3, or 4 matchsticks.\n 3. Whoever is forced to pick the last matchstick loses.\n\n");
    while (matchsticks > 1) {
        printf("Matchsticks left: %d\n", matchsticks);
        printf("Pick 1, 2, 3, or 4 matchsticks: ");
        scanf("%d", &user);

        if (user < 1 || user > 4) {
            printf("Invalid choice! Pick between 1 and 4.\n");
            continue;
        }

        matchsticks -= user;

        if (matchsticks == 1) {
            printf("Only 1 matchstick left. You are forced to pick it next!\n");
            printf("Computer wins! \n");
            break;
        }

        computer = 5 - user;
        printf("Computer picks %d matchstick(s).\n", computer);
        matchsticks -= computer;

        if (matchsticks == 1) {
            printf("Only 1 matchstick left. You are forced to pick it next!\n");
            printf("Computer wins!\n");
            break;
        }
    }

    return 0;
}
