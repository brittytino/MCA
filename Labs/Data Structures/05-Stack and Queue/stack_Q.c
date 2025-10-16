#include <stdio.h>

typedef struct {
    int arr[MAX_SIZE];
    int front, rear;
} Queue;

// Initialize queue
void initQueue(Queue* q) {
    q->front = 0;
    q->rear = -1;
}

// Check if queue empty
int isEmpty(Queue* q) {
    return q->rear < q->front;
}

// Enqueue
void enqueue(Queue* q, int val) {
    q->arr[++q->rear] = val;
}

// Dequeue
int dequeue(Queue* q) {
    return q->arr[q->front++];
}

// Stack using two queues
typedef struct {
    Queue q1, q2;
} StackUsingQueues;

void initStack(StackUsingQueues* s) {
    initQueue(&s->q1);
    initQueue(&s->q2);
}

void push(StackUsingQueues* s, int val) {
    // Enqueue to empty queue
    if (isEmpty(&s->q1))
        enqueue(&s->q1, val);
    else
        enqueue(&s->q2, val);

    // Move all elements from non-empty queue to the other
    if (!isEmpty(&s->q1)) {
        while (!isEmpty(&s->q2)) {
            enqueue(&s->q1, dequeue(&s->q2));
        }
    } else {
        while (!isEmpty(&s->q1)) {
            enqueue(&s->q2, dequeue(&s->q1));
        }
    }
}

int pop(StackUsingQueues* s) {
    // Pop is dequeue from the non-empty queue
    if (!isEmpty(&s->q1))
        return dequeue(&s->q1);
    else if (!isEmpty(&s->q2))
        return dequeue(&s->q2);
    else {
        printf("Stack is empty\n");
        return -1;
    }
}

int top(StackUsingQueues* s) {
    if (!isEmpty(&s->q1'))
        return s->q1.arr[s->q1.front];
    else if (!isEmpty(&s->q2))
        return s->q2.arr[s->q2.front];
    else {
        printf("Stack is empty\n");
        return -1;
    }
}
