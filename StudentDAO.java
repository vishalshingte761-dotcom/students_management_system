
import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO students(name, department, roll) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getDepartment());
            ps.setInt(3, s.getRoll());
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getString("department") + " | "
                        + rs.getInt("roll")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int roll) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE roll=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roll);
            ps.executeUpdate();
            System.out.println("Student deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
