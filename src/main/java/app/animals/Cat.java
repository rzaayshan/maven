package app.animals;

public class Cat extends Animal {
    Cat(String name){
        this.name=name;
    }
    @Override
    public String toString() {
        return String.format("I am a cat. My name is %s",name);
    }
}
