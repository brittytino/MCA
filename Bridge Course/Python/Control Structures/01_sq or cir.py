shape = input("Enter the area of square : ")
if (shape =="s"):
    a= int(input("Enter the area of square : "))
    sq=a**2
    print("The area of square : ",sq)
elif(shape =="c"):
    b= int(input("Enter the radius of circle : "))
    cr=3.14*(b**2)
    print("The area of circle is : ",cr)
else:
    print("error")
