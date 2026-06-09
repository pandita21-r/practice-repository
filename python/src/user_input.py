# Function that prompts the user to enter data.
# Return the entered data as a string.

name = input("What is your name?: ")

# Typecast the input function with int so that it'll return int
age = int(input("How old are you?: "))

age += 1

print(f"Hello {name}!")
print("HAPPY BIRTHDAY!")
print(f"You are {age} years old.")