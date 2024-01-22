package qlsp.codegym;

import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
    static Scanner scanner = new Scanner(System.in);
    static CClass c11 = new CClass(1, "C11");
    static CClass c12 = new CClass(2, "C12");

    static Student s1 = new Student(1, "Cong", 20, c11);
    static Student s2 = new Student(2, "Huy", 28, c11);
    static Student s3 = new Student(3, "Quang", 28, c12);

    static Student[] students = {s1, s2, s3};

    public static void main(String[] args) {
        while (true) {
            System.out.println("Chon ky tu minh muon thuc hien:");
            System.out.println("1. Hien thi hoc sinh:");
            System.out.println("2. Them hoc sinh");
            System.out.println("3. Sua thong tin");
            System.out.println("4. Xoa hoc sinh");
            System.out.println("5. Tim kiem hoc sinh");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showStudents(students);
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    inputDeleteStudent();
                    break;
                // Thêm các trường hợp xử lý cho menu còn lại (c5) nếu cần
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }

    public static void showStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
    public static Student findStudentById(Student [] students, int id){
        for (Student existingStudent : students) {
            if (existingStudent.getId() == id) {
                return existingStudent;
            }
        }
        return null;
    }
    public static Student [] insertStudent(Student [] students, Student student){
        Student[] studentsNew = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            studentsNew[i] = students[i];
        }
        studentsNew[students.length] = student;
        return studentsNew;
    }


    public static Student inputCreateStudent(){
        System.out.println("Nhap id:");
        int id = Integer.parseInt(scanner.nextLine());

        Student student = new Student();
        student.setId(id);
        inputBasicInfo(student, "nhap ten can sua", "nhap age can sua");
        return student;
    }
    private static void inputEditStudent(Student student) {
        inputBasicInfo(student, "nhap ten can sua", "nhap age can sua");
    }


    private static void inputBasicInfo(Student student, String nameStr, String ageStr) {
        System.out.println(nameStr);
        String name = scanner.nextLine();
        System.out.println(ageStr);
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhap id lop hoc:");
        int classId = Integer.parseInt(scanner.nextLine());
        CClass cClass = null;
        if(classId == 1){
            cClass = c11;
        }else{
            cClass = c12;
        }

        student.setAge(age);
        student.setName(name);
        student.setcClass(cClass);
    }
    public static void addStudent() {
        String nameStr = "Nhap ten moi";
        String ageStr = "Nhap age moi";
        inputBasicInfo(null, nameStr, ageStr);
        Student student = inputCreateStudent();
        Student studentExists = findStudentById(students, student.getId());

        if (studentExists !=null ) {
            System.out.println("Hoc sinh da ton tai trong danh sach.");
        } else {
            students = insertStudent(students, student);
            System.out.println("Da them hoc sinh moi:");
            showStudents(students);
        }
    }

    public static void editStudent() {
        String nameStr = "Nhap ten can sua";
        String ageStr = "Nhap age can sua";
        inputBasicInfo(null, nameStr, ageStr);
        System.out.println("Nhap id hoc sinh can sua:");
        int idToEdit = Integer.parseInt(scanner.nextLine());

        Student student = findStudentById(students, idToEdit);
        if (student != null) {
            inputEditStudent(student);
        }else{
            System.out.println("ID khong ton tai");
        }


        System.out.println("Khong tim thay hoc sinh co id: " + idToEdit);
    }



    public static void inputDeleteStudent() {
        System.out.println("Nhap id hoc sinh can xoa:");
        int idToDelete = Integer.parseInt(scanner.nextLine());
        Student student = findStudentById(students, idToDelete);

        if (student != null) {
            students = deleteInfoStudent(student);
        }else{
            System.out.println("ID khong ton tai");
        }

        showStudents(students);
    }
    public static Student [] deleteInfoStudent(Student student){
        int indexDeleted = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == student.getId()) {
                indexDeleted = i;
                break;
            }
        }
        // [2,5,1,7,8]
        // [2,5,7,8,8] => [2,5,7,8]
        for(int i = indexDeleted; i< students.length-1;i++){
            students[i] = students[i+1];
        }
        return Arrays.copyOf(students, students.length - 1);
    }
}

