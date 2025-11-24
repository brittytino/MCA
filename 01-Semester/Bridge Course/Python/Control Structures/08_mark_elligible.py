maths_mark = int(input("Enter the Maths Mark : "))
physics_mark = int(input("Enter the Physics Mark : "))
chemistry_mark = int(input("Enter the Chemistry Mark : "))

total = (maths_mark + physics_mark + chemistry_mark)
total2 = (maths_mark + physics_mark)

if (total >= 200) and (total2 >= 150) and (maths_mark >= 60) and (physics_mark >= 50) and (chemistry_mark >= 40):
    print("You are Eligible")
else:
    print("You are not Eligible")
