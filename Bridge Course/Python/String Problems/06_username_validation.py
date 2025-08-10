username = input("Enter the user name: ")
password = input("Enter the password: ")

if not username.isalpha():
    print("Username must contain only alphabets.")
elif len(password) != 7 or not password[0].isupper():
    print("Password length must be strictly 7 and it should start with uppercase letter.")
else:
    print("The user login created successfully")
