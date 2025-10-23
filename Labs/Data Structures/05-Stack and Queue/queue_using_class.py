class Queue:
    def __init__(self):
        self.queue = []

    def enqueue(self,elem):
        self.queue.append(elem)

    def dequeue(self):
        if self.isEmpty():
            return "Queue is Empty"
        return self.queue.pop(0)

    def peek(self):
        if self.isEmpty():
            return "Queue is Empty"
        return self.queue[0]

    def isEmpty(self):
        return len(self.queue) == 0

myqueue = Queue()

myqueue.enqueue(10)
myqueue.enqueue(20)
myqueue.enqueue(30)
myqueue.enqueue(40)
myqueue.enqueue(50)

print("Queue : ",myqueue.queue)
print("Dequeue : ",myqueue.dequeue())
print("After Dequeue Queue is : ",myqueue.queue)


print("Peek : ",myqueue.peek())

