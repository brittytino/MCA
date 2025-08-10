n = int(input("Enter the number to divide by: "))

for i in range(700, 901):
    if i % n == 0:
        print(i, end=" ")
