numbers = list(map(int, input("Enter numbers separated by spaces: ").split()))

even = [x for x in numbers if x % 2 == 0]
odd = [x for x in numbers if x % 2 != 0]

print("Even numbers:", even)
print("Odd numbers:", odd)
