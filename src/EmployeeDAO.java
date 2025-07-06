import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public void addEmployee(Employee e) throws SQLException {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getDepartment());
            stmt.setDouble(3, e.getSalary());
            stmt.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                list.add(e);
            }
        }
        return list;
    }

    public void updateEmployee(Employee e) throws SQLException {
        String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getDepartment());
            stmt.setDouble(3, e.getSalary());
            stmt.setInt(4, e.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
