queue=[]

def enqueue():    
    item = input("Enter the element to be Enqueue: ") 
    queue.append(item)
    print(f"The Element {item} Enqueued")


def dequeue():
    if not queue:
        print("Queue is empty! No one to remove.")
    else:
        item = queue.pop(0)
        print(f"The Element {item} Dequeued")


def display():
    if not queue:
        print("Queue is Empty")
    else:
        print(f"The Queue is")
        for i in queue:
            print(i, end=" <- ")
        print()


def front():
    if not queue:
        print("Queue is Empty")
    else:
        print(f"The First person is {queue[0]}")


def rear():
    if not queue:
        print("Queue is Empty")
    else:
        print(f"The last person is {queue[-1]}")



while True:
    print("1.Enqueue")
    print("2.Dequeue")
    print("3.Display")
    print("4.Front")
    print("5.Rear")
    print("6.Exit")

    choice = input("Enter your input Choice: ")
    if choice == '1':
        enqueue()
    elif choice == '2':
        dequeue()
    elif choice == '3':
        display()
    elif choice == '4':
        front()
    elif choice == '5':
        rear()
    elif choice == '6':
        print("Exiting!!!")
        break
    else:
        print("Invalid Input")