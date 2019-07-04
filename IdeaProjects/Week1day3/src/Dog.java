public class Dog extends Animal {
    String name;
    String breed;

    public String getName() {
        return name;
    }

    public Dog(boolean veg, String eats, int noOfLegs, int age, String color, String name, String breed) {
        super(veg, eats, noOfLegs, age, color);
        this.name = name;
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
