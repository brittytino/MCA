#include <stdio.h>
#define MAX_SIZE 5

typedef struct {
    int arr[MAX_SIZE];
    int front;
    int rear;
} CircularQueue;

void initQueue(CircularQueue* q) {
    q->front = -1;
    q->rear = -1;
}

int isEmpty(CircularQueue* q) {
    return q->front == -1;
}

int isFull(CircularQueue* q) {
    return ((q->rear + 1) % MAX_SIZE) == q->front;
}

void enqueue(CircularQueue* q, int val) {
    if (isFull(q)) {
        printf("Queue is full\n");
        return;
    }
    if (isEmpty(q)) {
        q->front = 0;
    }
    q->rear = (q->rear + 1) % MAX_SIZE;
    q->arr[q->rear] = val;
    printf("Enqueued %d\n", val);
}

int dequeue(CircularQueue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1;
    }
    int val = q->arr[q->front];
    if (q->front == q->rear) {
        // Queue has only one element, reset to empty
        q->front = -1;
        q->rear = -1;
    } else {
        q->front = (q->front + 1) % MAX_SIZE;
    }
    return val;
}

int front(CircularQueue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1;
    }
    return q->arr[q->front];
}

void display(CircularQueue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return;
    }
    printf("Queue elements: ");
    int i = q->front;
    while (1) {
        printf("%d ", q->arr[i]);
        if (i == q->rear)
            break;
        i = (i + 1) % MAX_SIZE;
    }
    printf("\n");
}

int main() {
    CircularQueue q;
    initQueue(&q);

    enqueue(&q, 10);
    enqueue(&q, 20);
    enqueue(&q, 30);
    enqueue(&q, 40);

    display(&q);

    printf("Dequeued: %d\n", dequeue(&q));
    printf("Dequeued: %d\n", dequeue(&q));

    display(&q);

    enqueue(&q, 50);
    enqueue(&q, 60);

    display(&q);

    enqueue(&q, 70);  // Should show queue is full

    printf("Front element: %d\n", front(&q));

    return 0;
}
