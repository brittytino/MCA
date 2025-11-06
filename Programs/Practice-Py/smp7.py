class Queue:
    def __init__(self):
        self.queue = []

    def enqueue(self,item):
        self.queue.append(item)
        print(item,"enqueued into queue")
    
    def dequeue(self):
        if not self.queue:
            print("Queue is Empty")
        else:
            print(self.queue.pop(0),"dequeued from Queue")

    def display(self):
        print("Queue: ",self.queue)
        

q = Queue()

q.enqueue(10)
q.enqueue(20)
q.enqueue(30)

q.dequeue()

q.display()