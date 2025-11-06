MAX = 5
stack = [None] * MAX
top = -1

def push(item):
    global top
    if top == MAX - 1:
        print("Stack Overflow")
    else:
        top +=1
        stack[top] = item
        print(item,"pushed to stack")

def pop():
    global top
    if top == -1:
        print("Stack Underfloe")
    else:
        popped=stack[top]
        stack[top]=None
        top -=1
        print(popped,"popped from stack")

def display():
    if top == -1:
        print("stack is empty")
    else:
        print("Stack elements: ",stack[:top +1])

def peek():
    if top == -1:
        print("Stack is empty")
    else:
        print("Top element: ",stack[top])

push(10)
push(20)

pop()

push(50)
push(60)

pop()
peek()
display()