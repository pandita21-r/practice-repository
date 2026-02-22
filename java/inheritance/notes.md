# Notes – Raymark 
Last Update: 2026-02-22

# Biggest purpose of inheritance - "Write once in the parent, reuse everywhere in the children".

## The base structure of inheritance.
- Superclass = general concept
- Subclass = more specific version
- Subclass uses the keyword extends

## The Liskov Substitution Principle (LSP):

###Objects of a superclass should be replaceable with objects of its subclasses without breaking the application or changing the expected behavior.
  
## Constructor Chaining (super(...))
### What is super? (Simple Definition - “Talk to my parent class.”)

super is a keyword in Java that refers to the superclass.

It lets the subclass access:
- The parent constructor
- The parent’s methods
- The parent’s variables (if not private)
  
### Using super.field to Access Parent Fields

Avoid this unless necessary because:
- Subclasses should not depend on parent internals too tightly
- Best practice: use methods, not raw super.field

### When a subclass is created, it must call the superclass constructor.

Why?
- It initializes the parent’s fields
- It respects the parent’s rules
- It ensures the object starts life in a correct state

## What super Does NOT Do
super does not create a new object
 
It refers to the existing superclass part of the object.

 It is not like this
- this = current class
- super = parent class

It cannot be used anywhere in the constructor
- super(...) must be the first statement.
 
### You cannot call two super(...) constructors!
### Only one call is allowed!

## Method Overriding (@Override)
A subclass can replace a method from its parent.

Why?
- Subclass wants different behavior
- Same method name, different implementation
- Decided at runtime

## Specialization (Adding More Features)
A subclass adds its own fields or methods.

- Parent is general.
- Child is more specific.

## Code Reuse
The superclass provides common fields and methods:

- name
- age
- describe() base behavior

Subclasses reuse them instantly — no copy-paste.

## The “IS-A” Relationship
A core rule of inheritance:

- Dog is an Animal
- Cat is an Animal
- Car is a Vehicle

### If this sentence doesn’t make sense, then inheritance is wrong!
- This is part of inheritance design rules.

# Keywords!
### super:
When you create an object of a subclass, you must initialize the superclass first.

### protected:
protected allows access in
- the same class
- subclasses (even in other packages)
- same package classes

But NOT the whole world (unlike public).

It is more open than private, but safer than public.

### @Override:
A subclass replaces a method from the parent
- The method name is the same
- The parameters are the same
- The return type is compatible
- The behavior is different (more specific)
 
It does not change behavior by itself.

it is a safety check.

### extends:
Used to create a subclass from a superclass.

It means:

“This class inherits from another class.”
“This class is a more specific version of the superclass.”

Why We Use extends
- Because it makes code reusable and organized.
- Without extends, you would have to repeat the same fields in every class.

