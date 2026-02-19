## Biggest purpose of inheritance - "Write once in the parent, reuse everywhere in the children".

## The base structure of inheritance.
- Superclass = general concept
- Subclass = more specific version
- Subclass uses the keyword extends
  
## Constructor Chaining (super(...))
When a subclass is created, it must call the superclass constructor.

Why?
- It initializes the parent’s fields
- It respects the parent’s rules
- It ensures the object starts life in a correct state
