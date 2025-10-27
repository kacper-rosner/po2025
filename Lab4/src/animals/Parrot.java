package animals;


    public class Parrot extends Animal{
        public Parrot(){
            this.legs=2;
        }
        public String getDescription() {
            return Integer.toString(this.legs);
        }
        public void makeSound(){
            System.out.println("krakrakra");
        }
    }
