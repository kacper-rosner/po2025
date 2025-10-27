package animals;

public abstract class Animal {
    String name;
    int legs;
    public abstract String getDescription();
    public int getLegs() {
        return legs;
    }

    public Animal() {
    }

    public Animal(int legs, String name) {
        this.legs = legs;
        this.name = name;
    }

    public abstract void makeSound();
}



