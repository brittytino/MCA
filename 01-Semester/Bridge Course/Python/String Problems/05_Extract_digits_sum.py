s = input("Enter a string: ")
digits = [int(ch) for ch in s if ch.isdigit()]

print("The original string is:", s)
if digits:
    print("The digits are:", ",".join(map(str, digits)))
    print("The sum of the digits are:", sum(digits))
else:
    print("The string does not contain any digit.")
