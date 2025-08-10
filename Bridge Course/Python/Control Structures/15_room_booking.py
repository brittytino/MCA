name = input("Enter Your Name: ")
age = int(input("Enter Your Age: "))
s = input("Are You a Business or Company Person? (Y/N): ")
p = int(input("Enter How Many People Are Going to Stay?: "))
a = int(input("Enter Additional People Count: "))

total_people = p + a

if total_people <= 2:
    rent = 5000
elif total_people == 3:
    rent = 6000
elif total_people == 4:
    rent = 7000
else:
    rent = 7000 + (total_people - 4) * 1000  
if age >= 60:
    rent = rent - (rent * 0.15) 

if s.upper() == "Y":
    rent = rent + (rent * 0.20)  
print(f"\nHello, {name}!")
print(f"Total Rent to Pay: ₹{int(rent)}")
