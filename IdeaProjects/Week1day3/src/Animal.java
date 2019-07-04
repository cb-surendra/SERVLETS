public class Animal {
    private boolean veg;
    private String eats;
    private int noOfLegs;
    private int age;
    private String color;

    public void sound(){

    }
    public Animal(boolean veg, String eats, int noOfLegs, int age, String color) {
        this.veg = veg;
        this.eats = eats;
        this.noOfLegs = noOfLegs;
        this.age = age;
        this.color = color;
    }

    public boolean isVeg(){
        return veg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public String getEats() {
        return eats;
    }

    public void setEats(String eats) {
        this.eats = eats;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
