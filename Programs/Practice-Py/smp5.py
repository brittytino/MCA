class Student:
    def __init__(self,name,age):
        self.name = name
        self.age = age

    def show(self):
        print("Name:",self.name)
        print("Age:",self.age)

s1 = Student("Tino",21)
s1.show()