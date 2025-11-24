p1 = float(input("Enter the Product 1 Price : "))
p2 = float(input("Enter the Product 2 Price : "))

total = (p1 + p2)
dis1 = (total*(5/100))
dis3 = (total-dis1)
dis2 = (total*(8/100))
dis4 = (total-dis2)
if (total >2000) and (total <5000):
    print("Total Bill : ",dis3)
elif (total >5000):
    print("Total Bill : ",dis4)
else:
    print("No discount , Your Total Bill is : ",total)
