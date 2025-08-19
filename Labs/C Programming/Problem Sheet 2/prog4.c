#include <stdio.h>

int main() {
    int day, month, year, century, yearInCentury;
    int result, remainder;
    char *days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    printf("Enter date (DD MM YYYY): ");
    scanf("%d %d %d", &day, &month, &year);

    century = year / 100;
    yearInCentury = year % 100;

    result = (century / 4) - (2 * century) - 1;
    result += (5 * yearInCentury) / 4;
    result += (26 * (month + 1)) / 10;
    result += day;

    remainder = result % 7;
    if (remainder < 0) {
        remainder += 7;
    }

    printf("The day is: %s\n", days[remainder]);

    return 0;
}
