# Exercise 4 Calculate the area of a circle

import math

radius = float(input("Enter the radius of a circle: "))

area = math.pi * pow(radius, 2) # area = πr^2

print(f"The are of the circle is: {round(area, 2)}cm²")