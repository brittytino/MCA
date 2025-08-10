radius = float(input("Enter radius : "))

x = int(input("Enter x coordinate : "))
y = int(input("Enter y coordinate : "))

if(x < radius and x > -radius) and (y < radius and y > -radius):
    print("It hit the DART!")
else:
    print("It NOT hit the dart")