students = int(input("Enter number of students : "))
apples = int(input("Enter number of apples : "))

equal_dis = apples // students
remainings = apples % students

print("Distributed for each -> ", equal_dis)
print("Remaing apples -> ", remainings)