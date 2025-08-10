a = int(input("Enter a: "))
b = int(input("Enter b: "))
c = int(input("Enter c: "))

start = min(a, b)
end = max(a, b)

count = 0
for i in range(start, end + 1):
    if i % c == 0:
        count += 1

print("Numbers divisible by", c, "between", a, "and", b, ":", count)
