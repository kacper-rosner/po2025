package animals;

public class Snake extends Animal{
    public Snake(int legs){
        this.legs=legs;
    }

    public String getDescription() {
        return Integer.toString(this.legs);
    }
    public void makeSound(){
        System.out.println("ssssss");
    }
}
