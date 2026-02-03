class Pet{
    private String name;
    private String species;
    private int age;

    public Pet(String name, String species, int age){
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName(){ return name; }
    public String getSpecies(){ return species; }
    public int getAge(){ return age; }

    public String toString(){
        return name + " | " + species + " | " + age;
    }
}

class Dog extends Pet{
    private String toy;

    public Dog(String name, String species, int age, String toy){
        super(name, species, age);
        this.toy = toy;
    }

    public int calculateHumanAge(int age){
        return age*7;
    }

    public void displayDetails(){
        System.out.println(toString() +  " | " + toy + " | " + calculateHumanAge(getAge()));
    }
}

class Bird extends Pet{
    private String wingSpan;

    public Bird(String name, String species, int age, String wingSpan){
        super(name, species, age);
        this.wingSpan = wingSpan;
    }

    public int calculateHumanAge(int age){
        return 4*age;
    }

    public void displayDetails(){
        System.out.println(toString() + " | " + wingSpan + " | " + calculateHumanAge(getAge()));
    }
}


public class PetManager {
    public static void main(String[] args){
        Dog dog = new Dog("Poco", "Poodles", 4, "Stuffed Bone");
        Bird bird = new Bird("Kani", "Sparrow" , 5, "0.4");

        dog.displayDetails();
        bird.displayDetails();
    }
}
