s = input("Enter a string: ")
new_str = "".join(s[i] for i in range(len(s)) if i % 2 == 0)
print(new_str)
