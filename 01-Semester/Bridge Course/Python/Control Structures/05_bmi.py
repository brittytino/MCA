weight = float(input("Enter the weight : "))
height = float(input("Enter the Height : "))

bmi = weight/(height*height)

if(bmi < 18.5):
    print("Underweight")
elif(bmi >=18.5 and bmi <=24.9):
    print("Healthy")
elif(bmi >=25.0 and bmi <=29.9):
    print("Overweight")
elif(bmi >=30.0):
    print("Obese")
else:
    print("Error")
