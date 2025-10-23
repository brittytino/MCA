class Stack:
    def __init__(self):
        self.stack=[]

    def push(self, elem):
        self.stack.append(elem)

    def pop(self):
        if self.isEmpty():
            return "Stack is empty"
        return self.stack.pop()

    def peek(self):
        if self.isEmpty():
            return "Stack is empty"
        return self.stack[-1]

    def isEmpty(self):
        return len(self.stack) == 0

mystack = Stack()
mystack.push(10)
mystack.push(20)
mystack.push(30)
print("stack: ", mystack.stack)

print("Pop: ", mystack.pop())
print("After Pop: ", mystack.stack)

print("Peek: ", mystack.peek())

