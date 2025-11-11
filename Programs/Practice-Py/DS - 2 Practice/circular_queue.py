size = int(input("Enter the size of the circular queue: "))
queue = [None] * size
front = -1
rear =-1

def enqueue():
    global front,rear
    item = input("Enter element to Enqueue: ")
    if(rear +1) % size == front:
        print("Queue is full cannot enqueue")
        return
    if front == -1:
        front = 0

    rear = (rear + 1) % size
    queue[rear] = item
    print(f"{item} added to the queue")

def dequeue():
    global front, rear
    if front == -1:
        print("Queue is empty! Cannot dequeue.")
        return

    item = queue[front]
    # If only one element left
    if front == rear:
        front = rear = -1
    else:
        front = (front + 1) % size

    print(f"{item} removed from the queue.")


def display():
    if front == -1:
        print("Queue is empty!")
        return

    print("Circular Queue elements are:", end=" ")
    i = front
    while True:
        print(queue[i], end=" ")
        if i == rear:
            break
        i = (i + 1) % size
    print()

def front_element():
    if front == -1:
        print("Queue is empty!")
    else:
        print(f"Front element: {queue[front]}")

def rear_element():
    if rear == -1:
        print("Queue is empty!")
    else:
        print(f"Rear element: {queue[rear]}")

while True:
    print("\n=== Circular Queue Menu ===")
    print("1. Enqueue")
    print("2. Dequeue")
    print("3. Display")
    print("4. Front Element")
    print("5. Rear Element")
    print("6. Exit")

    choice = input("Enter your choice (1-6): ")

    if choice == '1':
        enqueue()
    elif choice == '2':
        dequeue()
    elif choice == '3':
        display()
    elif choice == '4':
        front_element()
    elif choice == '5':
        rear_element()
    elif choice == '6':
        print("Exiting Circular Queue Program...")
        break
    else:
        print("Invalid choice! Please enter 1-6.")

