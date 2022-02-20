package LinkedListObject;

public class Person  {

    // declare variables
    private String name;
    private int age;

    // constructors
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // modify toString method to customize the string representation of the person object
    @Override
    public String toString() {
        return(name + " " + age);
    }
}
