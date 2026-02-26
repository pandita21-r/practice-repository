
public class PolymorphismPracticeAnimalSounds {
    static class Animal {
        String name;

        public void setName(String name) {
            if (name == null || name.isBlank()) {
                System.out.println("Name cannot be blank.");
            }
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void makeSound() {
            System.out.println("(generic animal sound)");
        }
    }

    static class Dog extends Animal {
        String name;

        public Dog(String name) {
            super.setName(name);
            this.name = name;
        }

        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        String name;

        public Cat(String name) {
            super.setName(name);
            this.name = name;
        }

        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        Animal[] animal = new Animal[3];

        animal[0] = new Dog("Chuck");
        animal[1] = new Cat("Jamal");
        for (Animal a : animal) {
            System.out.print(a.name + " says: ");
            a.makeSound();
        }
    }
}
