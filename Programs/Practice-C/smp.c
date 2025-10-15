#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;  // Global head pointer

void insertAtBegin() {
    struct node *newnode;
    newnode = (struct node *) malloc(sizeof(struct node));  // allocate memory

    printf("Enter data: ");
    scanf("%d", &newnode->data);

    newnode->next = NULL; // new node’s next initially null

    if (head == NULL) {
        head = newnode;
    } else {
        newnode->next = head;  // link newnode to old head
        head = newnode;        // make newnode the new head
    }

    printf("Node inserted at beginning!\n");
}

void display() {
    struct node *temp = head;
    printf("Linked List: ");
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

int main() {
    insertAtBegin();
    insertAtBegin();
    insertAtBegin();

    display();
    return 0;
}
