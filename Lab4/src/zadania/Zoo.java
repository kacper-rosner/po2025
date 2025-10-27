package zadania;
import animals.Animal;
import animals.Parrot;
import animals.Snake;
import animals.Dog;


public class Zoo {
        Animal[] animals = new Animal[100];


    void fill(){
        for(int j=0;j<this.animals.length;j++){
            int i=(int)(Math.random()*3);
            switch (i){
                case 0:
                    this.animals[j]=new Snake(1);
                    break;
                case 1:
                    this.animals[j]=new Dog();
                    break;
                default:
                    this.animals[j]=new Parrot();
                    break;

            }
            this.animals[j].makeSound();
        }
    }
    int sum(){
        int nogi=0;
        for(Animal a:animals){
            nogi+=Integer.parseInt(a.getDescription());
            int legs=a.getLegs();
            System.out.println();
        }
        return nogi;
    }
}
