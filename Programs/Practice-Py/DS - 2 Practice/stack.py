stack = []

def push():
    item = input("Enter an element to push: ")
    stack.append(item)

def pop():
    if not stack:
        print("Stack is Empty!")
    else:
        item = stack.pop();
        print(f"Poped element is: {item}")

def peek():
    if not stack:
        print("Stack is Empty!!")
    else:
         print("Peek Element is :" ,{stack[-1]})

def display():
    if not stack:
        print("Stack is Empty!!")
    else:
        print("Stack Elements: ")
        for i in reversed(stack):
            print(i)

def find_min():
    if not stack:
        print("Stack is Empty!!")
    else:
        print("Minimum element is : ",{min(stack)})

def find_max():
    if not stack:
        print("Stack is Empty!!")
    else:
        print("Minimum element is : ",{max(stack)})


while True:
    print("1.Push")
    print("2.POP")
    print("3.Peek")
    print("4.Display")
    print("5.Find Min")
    print("6.Fin Max")
    print("7.Exit")

    choice = input("Enter yput Choice: ")
    if choice == '1':
        push()
    elif choice == '2':
        pop()
    elif choice == '3':
        peek()
    elif choice == '4':
        display()
    elif choice == '5':
        find_min()
    elif choice == '6':
        find_max()
    elif choice == '7':
        print("Exiting!!!")
        break
    else:
        print("Invalid Input")