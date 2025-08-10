string = input("Enter a string: ").lower()
vowels = "aeiou"
v_count = sum(1 for ch in string if ch in vowels)
c_count = sum(1 for ch in string if ch.isalpha() and ch not in vowels)
print("No of vowels:", v_count)
print("No of consonants:", c_count)
