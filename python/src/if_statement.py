
age = int(input("Enter your age: "))

if age >= 100:
    print("You are too old to sing up") # Indent is important!
elif age >= 18:
    print("You are now signed up!") 
elif age < 0:
    print("You haven't been born yet!")
else:
    print("You must be 18+ to sign up")

response = input("Would you like some food? (Y/N): ")

if response == "Y":
    print("Have some food!")
else:
    print("No food for you!")

name = input("Enter your name: ")

if name == "":
    print("You did not type your name!")
else:
    print(f"Hello {name}")

# Boolean 

for_sale = True

if for_sale: # Checks if true
    print("This item is for sale")
else: # If not true this'll print
    print("This item is NOT for sale")