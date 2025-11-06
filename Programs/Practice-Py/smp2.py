stack =[]

def push(item):
    stack.append(item)
    print(f"Pushed: {item}")

def pop():
    item = stack.pop()
    print(f"Popped: {item}")

def peek():
    print(f"Top element: {stack[-1]}")

def display():
    print("Stack contents:", stack)

push(10)
push(20)
push(30)
pop()
peek()
display()
