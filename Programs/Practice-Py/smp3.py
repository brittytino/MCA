MAX = 5
queue = [None] * MAX
front = -1
rear = -1

#Enqueue 

def enqueue(item):
    global front,rear
    if rear == MAX -1:
        print("Queue is overflowed",item)
    else:
        if front == -1:
            front = 0
        rear +=1
        queue[rear] = item
        print(item,"added to queue")

#dequeue

def dequeue():
    global front,rear
    if front == -1:
        print("Queue is underflowd") 
    else:
        removed = queue[front]
        queue[front] = None
        front +=1
        print(removed,"removed from queue")


def peek():
    if front == -1:
        print("Queue is empty")
    else:
        print("Front element:",queue[front])

def display():
    if front == -1:
        print("Queu is empty")
    else:
        print("Queue elements:",queue[front:rear +1])


enqueue(10)
enqueue(20)
enqueue(30)

display()

dequeue()

display()

enqueue(40)
enqueue(50)

peek()

display()