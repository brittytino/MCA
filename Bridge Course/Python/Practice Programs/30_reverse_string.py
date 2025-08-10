a = "this is pretty"

result = ''.join(word[::-1] for word in a.split())
print(result)