# Simple str

a = "Hi"

print(a)

# Multiline String

str = """This is a multilne String
This is a multilne String
This is a multilne String"""

print(str)

# String are Arrays

str = "Hello, World!"

print(
    str[1]
)  # get the character at position 1 (the first character has the position 0)

# Looping through a String

for x in "Apple":
    print(x)

# String length "len()" function

a = "Hello, World!"
print(len(a))

# String checking

txt = "My name is Raymark"

print("Raymark" in txt)  # This will return a bool value (True or False)

if "Raymark" in txt:
    print("Your name is Raymark.")
if "Mark" not in txt:
    print("Your name is Raymark, not Mark.")
