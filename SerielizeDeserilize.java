
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {

    int id;
    String name;

    public Student(int _id, String _name) {
        this.id = _id;
        this.name = _name;
    }

}

public class SerielizeDeserilize{

    public static void main(String[] args) {
        Student s1 = new Student(1, "Arpit");
        
        FileOutputStream fout;
        ObjectOutputStream ob;

        // Serizalation an object
        try {
            fout = new FileOutputStream(".\\sample.txt");
            ob = new ObjectOutputStream(fout);
            ob.writeObject(s1);
            ob.flush();
            fout.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        System.out.println("Successfully write the object in file...");

        // desearlization of an object
        ObjectInputStream ob1;
        try {
            ob1 = new ObjectInputStream(new FileInputStream(".\\sample.txt"));

            Student s2 = (Student) ob1.readObject();
            
            System.out.println(s2.id + "  " + s2.name);
            ob1.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        System.out.print("Completed By - \nName : Rajneesh Verma.\nUid : 23BCS80093\nSection : Epam_801/A.");

    }

}
