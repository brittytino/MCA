unit = float(input("Enter the Unit Consumed: "))

if unit <= 100:
    fixed_charge = 0
    cost = 0
    total = fixed_charge + cost
elif unit <= 200:
    fixed_charge = 20
    cost = (unit - 100) * 2
    total = fixed_charge + cost
elif unit <= 500:
    fixed_charge = 30
    if unit <= 200:
        cost = (unit - 100) * 2
    else:
        cost = (200 - 100) * 2 + (unit - 200) * 3
    total = fixed_charge + cost
else:
    fixed_charge = 50
    if unit <= 200:
        cost = (unit - 100) * 3.5
    elif unit <= 500:
        cost = (200 - 100) * 3.5 + (unit - 200) * 4.6
    else:
        cost = (200 - 100) * 3.5 + (500 - 200) * 4.6 + (unit - 500) * 6.6
    total = fixed_charge + cost

print("Your Electricity Bill is: Rs.", round(total, 2))
