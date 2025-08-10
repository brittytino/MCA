n = int(input("Enter n: "))
numbers = list(map(int, input("Enter the numbers separated by spaces: ").split()))

for i in range(1, n + 1):
    if i not in numbers:
        print("Missing number is:", i)
        break
