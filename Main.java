package filestudent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Văn b", "Hà Nội"));
        students.add(new Student(3, "Trần Thị C", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Th D", "Sài Gòn"));
        students.add(new Student(5, "Hoàng Văn E", "Hà Nội"));
        writeDataToFile("student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
