
public class InheritancePracticeAnimalDogCat{
    static class Animal {

        protected String name;
        protected int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String describe() {
            return "Name: " + name + " Age: " + age + ",";
        }
    }

    static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        @Override
        public String describe() {
            return super.describe() + " Breed: " + breed;
        }
    }

    static class Cat extends Animal {
        private boolean isIndoor;

        public Cat(String name, int age, boolean isIndoor) {
            super(name, age);
            this.isIndoor = isIndoor;
        }

        @Override
        public String describe() {
            String indoorText = isIndoor ? "Indoor" : "Outdoor";
            return super.describe() + " Type: " + indoorText;
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog("Rocky", 4, "Golden Retriever");
        Cat c = new Cat("Luna", 2, true);

        System.out.println(d.describe());
        System.out.println(c.describe());
    }
}
