import sys

full_name = sys.argv[1]

email= full_name.lower().replace(" ", ".")+"@divineinfotech.org"


print("Full Name: ",full_name)
print("Email: ",email)
