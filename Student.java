package qlsp.codegym;

public class Student {
    private int id;
    private String name;
    private int age;
    private CClass cClass;
    public Student(int id , String name , int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CClass getcClass() {
        return cClass;
    }

    public void setcClass(CClass cClass) {
        this.cClass = cClass;
    }

    public Student() {}
    public Student(int id, String name, int age, CClass cClass){
        this.id = id;
        this.name = name;
        this.age = age;
        this.cClass = cClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cClass=" + cClass +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }
}
