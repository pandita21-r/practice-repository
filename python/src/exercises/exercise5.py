# Exercise 5 Find the hypotenuse of a right triangle

import math

a = float(input("Enter side A: "))
b = float(input("Enter side B: "))

c = math.sqrt(pow(a, 2) + pow(b, 2)) # c = squareroot of a^2 + b^2

print(f"Side C = {c}")