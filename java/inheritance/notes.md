# Biggest purpose of inheritance - "Write once in the parent, reuse everywhere in the children".

## The base structure of inheritance.
- Superclass = general concept
- Subclass = more specific version
- Subclass uses the keyword extends
  
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
Many beginners misunderstand this, so Sensei clarifies:
 -super does not create a new object
 
It refers to the existing superclass part of the object.

 It is not like this
- this = current class
- super = parent class

It cannot be used anywhere in the constructor
- super(...) must be the first statement.
 
### You cannot call two super(...) constructors
### Only one call is allowed.

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

### If this sentence doesn’t make sense, then inheritance is wrong.
- This is part of inheritance design rules.
