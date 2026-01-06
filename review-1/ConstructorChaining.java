class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }

    Animal(String name) {
        System.out.println("Argumented Animal constructor " + name);
    }
}

class Dog extends Animal {
    Dog() {
        this("default");
        System.out.println("Dog no argumented constructor");
    }

    Dog(String name) {
        super("Dog");
        System.out.println("Dog constructor with name: " + name);
    }
}


public class ConstructorChaining {
    public static void main(String[] args) {
        System.out.println("Creating Dog with no arguemented constructor:\n");
        Dog d1 = new Dog();

        System.out.println("\nCreating Dog with agrumented constructor:\n");
        Dog d2 = new Dog("Buddy");
    }
}


