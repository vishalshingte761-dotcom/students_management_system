
public class Student {

    private int id;
    private String name;
    private String department;
    private int roll;

    public Student(String name, String department, int roll) {
        this.name = name;
        this.department = department;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getRoll() {
        return roll;
    }
}
