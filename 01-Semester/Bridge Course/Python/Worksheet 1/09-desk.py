a = int(input("No of studnets in A : "))
b = int(input("No of studnets in B : "))
c = int(input("No of studnets in C : "))

total_students = a + b + c

needed_desk = round(total_students / 2)

print("Total needed desk -> ", needed_desk)