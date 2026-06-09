# Simple str

a = "Hi"

print(a)

# Multiline String

str = """This is a multiline String
This is a multiline String
This is a multiline String"""

print(str)

# String are Arrays

str = "Hello, World!"

print(str[1])  # get the character at position 1 (the first character has the position 0)

# Looping through a String

for x in "Apple":
    print(x)

# String length "len()" function

a = "Hello, World!"
print(len(a))

# String checking

txt = "My name is Raymark"
# Checks if "Raymark" is present on variable txt.
print("Raymark" in txt)  # This will return a bool value (True or False)

if "Raymark" in txt:
    print("Your name is Raymark.")
if "Mark" not in txt:
    print("Your name is Raymark, not Mark.")

# String slicing

str = "Hello, World!"
print(str[2:5]) # This will get the characters from index 2 - 5 (but the index 5 is not included)
print(str[:5]) # This will get the characters from the start to index 5 (but the index 5 is excluded)
print(str[2:]) # This will get the characters that start from index 2 all the way to the end.

# Negative slicing (STARTS FROM THE END OF THE STRING)

print(str[-5:-2]) # From "o" in "World!" (position -5 but excluded) to "d" in "World!" (position -2 but excluded)

# Uppercase and Lowercase func (variable.upper() and variable.lower())

a = "Hello, World!"

print(a.upper())

b = "World!, Hello"

print(b.lower())

# Remove the Whitespace (stip())

x = " <-Whitespace-> "

print(x.strip()) # returns "<-Whitespace->" the before and after spaces is gone

# Replace String

y = "Hello, World!"
print(y.replace("H", "J")) # This will replace the "H" on "Hello, World!" with "J"

# Split String 
# Split the String into substrings if it finds the intance of the seperator(in this case the seperator is ",").
z = "Hello, World!"
print(z.split(",")) # Returns ['Hello', 'World!'] 