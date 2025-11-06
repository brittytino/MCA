queue = []

def enqueue(item):
    queue.append(item)
    print(f"added {item} to the queue")

def dequeue():
    popped = queue.pop()
    print(f"dequeued the {popped}")

def peek():
    peeked = queue[-1]
    print(f"Top element: {peeked}")

def display():
    print("Queue:",queue)


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