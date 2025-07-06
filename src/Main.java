import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n1. Add Employee\n2. View All\n3. Update\n4. Delete\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee());
                }
                case 2 -> dao.getAllEmployees().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    dao.updateEmployee(new Employee());
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                }
                case 5 -> System.exit(0);
            }
        }
    }
}
