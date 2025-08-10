name = input("Enter Your Name : ")
age = int(input("Enter Your Age : "))
add_name = input( "Enter Nominee Name : ")
add_on_age = int(input("Enter Nominee age : "))
prof = input("Enter your Status (salaried, self-employed,student,retired-pensioner) : ")
income = int(input("Enter Your Annual Income : "))

if (age >=21) and (age <=60):
    if (add_on_age >=18):
        if(prof=="salaried" or prof=="self-employed" or prof=="student" or prof=="retired-pensioner"):
            if(income >= 300000):
                print("Congratulations! You are eligible for a credit card.")
            else:
                print("Sorry, you are not eligible for a credit card due to insufficient income.")
        else:
            print("Sorry, you are not eligible for a credit card due to your profession.")  
    else:
        print("Sorry, you are not eligible for a credit card due to nominee age.")
else:
    print("Sorry, you are not eligible for a credit card due to your age.") 
