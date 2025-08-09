ph = int(input("Enter the pH Level : "))
if(ph > 7):
    if (ph < 12):
        print("Alkaline")
    else:
        print("Very Alkaline")
else:
    if (ph == 7):
        print("Neutral")
    else:
        if(ph > 2):
            print("Acidic")
        else:
            print("Very Acidic")
