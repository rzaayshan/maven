package app.animals;

public class Dog extends Animal {
    Dog(String name){
        this.name=name;
    }
    public String toString(){
        return String.format("I am a dog. My name is %s",name);
    }
}
