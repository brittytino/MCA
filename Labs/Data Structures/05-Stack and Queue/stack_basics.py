stack =[]

stack.append('1')
stack.append('2')
stack.append('3')

print("Stack:",stack)

pop =stack.pop()
print("Pop:",pop)
print("Stack:",stack)


peek = stack[-1]
print("Peek:",peek)
print("Pop:",pop)
print("Pop:",pop)

emptyahh = not bool(stack)
print("empty: ", emptyahh)

print("Size: ",len(stack))
