package qlsp.codegym;

public class CClass {
    private int id;
    private String className;

    public CClass(int id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public String toString() {
        return "CClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                '}';
    }
}
