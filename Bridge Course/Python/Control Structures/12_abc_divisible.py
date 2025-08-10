a = 3
b = 30
c = 3

count = 0

for i in range(a, b + 1):
    if i % c == 0:
        count += 1
print(f"There are {count} numbers between {a} and {b} divisible by {c}.")
