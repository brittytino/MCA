s = input("Enter a string: ")
start = input("Enter starting characters to check: ")

if s.startswith(start):
    print("Yes, it starts with", start)
else:
    print("No, it doesn't start with", start)
