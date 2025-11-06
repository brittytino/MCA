class Stack:
    def __init__(self):
        self.stack = []

    def push(self,item):
        self.stack.append(item)
        print(item,"pushed into stack")

    def pop(self):
        if not self.stack:
            print("Stack is empty")
        else:
            print(self.stack.pop(),"popped from stack")        
        
    def display(self):
        print("Stack: ",self.stack)


s = Stack()
s.push(10)
s.push(20)
s.push(30)

s.pop()

s.display()