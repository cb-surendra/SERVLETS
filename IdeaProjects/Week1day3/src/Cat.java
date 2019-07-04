public class Cat extends Animal {
    String color;

    public Cat(boolean veg, String eats, int noOfLegs, int age, String color, String color1) {
        super(veg, eats, noOfLegs, age, color);
        this.color = color1;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
