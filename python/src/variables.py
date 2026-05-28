# Global Variable (Can be used by everyone, both inside of functions and outside)

globalX = "awesome"

def myfunc():
    print("Python is " + globalX)

myfunc()

# Legal variable examples:

myvar = "Mark"
my_var = "Mark"
_my_var = "Mark"
myVar = "Mark"
MYVAR = "Mark"

# Output multiple variables seperated by comma

x = "I"
y = "Miss"
z = "You"
print(x, y, z) # <- this one!

# Multiple  values to multiple variables on line

x, y, z = "Apple", "Carrot", "Banana"
print(x, y, z)

# Assign same value on multiple variables on line

x = y = z = "Burger"
print(x, y, z)

# Unpacking

cars = ["Volvo", "BMW", "Ford"]
x, y, z = cars
print(x, y, z)
print(y)  # This should print "BMW"

# The type() function - used for printing the type of the variable

var1 = 1

print(type(var1)) # The variable type of variable "var1" should be int!