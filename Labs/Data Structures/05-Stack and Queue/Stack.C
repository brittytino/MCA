#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

#define MAX_SIZE 1000

typedef struct {
    int stack[MAX_SIZE];
    int minStack[MAX_SIZE];
    int topIndex;
    int minTopIndex;
} MinStack;

void MinStackInit(MinStack* obj) {
    obj->topIndex = -1;
    obj->minTopIndex = -1;
}

void push(MinStack* obj, int val) {
    if (obj->topIndex == MAX_SIZE - 1) {
        printf("Stack Overflow\n");
        return;
    }
    obj->stack[++obj->topIndex] = val;

    if (obj->minTopIndex == -1 || val <= obj->minStack[obj->minTopIndex]) {
        obj->minStack[++obj->minTopIndex] = val;
    }
}

void pop(MinStack* obj) {
    if (obj->topIndex == -1) {
        printf("Stack Underflow\n");
        return;
    }
    int popped = obj->stack[obj->topIndex--];
    if (popped == obj->minStack[obj->minTopIndex]) {
        obj->minTopIndex--;
    }
}

int top(MinStack* obj) {
    if (obj->topIndex == -1) {
        printf("Stack is empty\n");
        return INT_MIN;
    }
    return obj->stack[obj->topIndex];
}

int getMin(MinStack* obj) {
    if (obj->minTopIndex == -1) {
        printf("Stack is empty\n");
        return INT_MIN;
    }
    return obj->minStack[obj->minTopIndex];
}

int main() {
    MinStack s;
    MinStackInit(&s);

    char command[20];
    int val;

    printf("Commands:\n");
    printf(" push <value>\n pop\n top\n min\n exit\n");

    while (1) {
        printf("> ");
        // Read the first word (command)
        if (scanf("%19s", command) != 1) break;

        if (strcmp(command, "push") == 0) {
            if (scanf("%d", &val) != 1) {
                printf("Invalid input for push\n");
                // Clear input buffer
                while (getchar() != '\n');
                continue;
            }
            push(&s, val);
        }
        else if (strcmp(command, "pop") == 0) {
            pop(&s);
        }
        else if (strcmp(command, "top") == 0) {
            int t = top(&s);
            if (t != INT_MIN) printf("Top element: %d\n", t);
        }
        else if (strcmp(command, "min") == 0) {
            int m = getMin(&s);
            if (m != INT_MIN) printf("Minimum element: %d\n", m);
        }
        else if (strcmp(command, "exit") == 0) {
            break;
        }
        else {
            printf("Unknown command: %s\n", command);
            // Clear rest of the line
            while (getchar() != '\n');
        }
    }

    printf("Exiting...\n");
    return 0;
}
