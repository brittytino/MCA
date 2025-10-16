#include <stdio.h>

typedef struct {
    int arr[MAX_SIZE];
    int top;
} Stack;

void initStack(Stack* s) {
    s->top = -1;
}

int isEmpty(Stack* s) {
    return s->top == -1;
}

void pushStack(Stack* s, int val) {
    s->arr[++s->top] = val;
}

int popStack(Stack* s) {
    if (isEmpty(s)) {
        printf("Stack empty\n");
        return -1;
    }
    return s->arr[s->top--];
}

int peekStack(Stack* s) {
    if (isEmpty(s)) {
        printf("Stack empty\n");
        return -1;
    }
    return s->arr[s->top];
}

typedef struct {
    Stack s1, s2;
} QueueUsingStacks;

void initQueue(QueueUsingStacks* q) {
    initStack(&q->s1);
    initStack(&q->s2);
}

void enqueue(QueueUsingStacks* q, int val) {
    pushStack(&q->s1, val);
}

int dequeue(QueueUsingStacks* q) {
    if (isEmpty(&q->s2)) {
        while (!isEmpty(&q->s1)) {
            pushStack(&q->s2, popStack(&q->s1));
        }
    }
    if (isEmpty(&q->s2)) {
        printf("Queue is empty\n");
        return -1;
    }
    return popStack(&q->s2);
}

int front(QueueUsingStacks* q) {
    if (isEmpty(&q->s2)) {
        while (!isEmpty(&q->s1)) {
            pushStack(&q->s2, popStack(&q->s1));
        }
    }
    if (isEmpty(&q->s2)) {
        printf("Queue is empty\n");
        return -1;
    }
    return peekStack(&q->s2);
}
