# Exercise 3 Calculate the circumference of a circle

import math

radius = float(input('Enter the radius of a circle: '))

circumference = 2 * math.pi * radius # circumference = 2πr

# "round(circumference, 2)" is for rounding the circumference to a given decimal place which is the number 2
print(f'The circumference is: {round(circumference, 2)}cm')