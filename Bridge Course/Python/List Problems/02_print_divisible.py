numbers = list(map(int, input("Enter numbers separated by spaces: ").split()))
n = int(input("Enter divisor: "))

divisible = [x for x in numbers if x % n == 0]
print("Numbers divisible by", n, ":", divisible)
