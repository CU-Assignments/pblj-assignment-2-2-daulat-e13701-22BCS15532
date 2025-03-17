import java.io.*;
import java.util.Scanner;

class Employee {
    private String empId;
    private String name;
    private String designation;
    private double salary;

    // Constructor
    public Employee(String empId, String name, String designation, double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    // Method to return formatted employee details
    @Override
    public String toString() {
        return empId + "," + name + "," + designation + "," + salary;
    }

    // Method to display employee details in a readable format
    public static void displayFormatted(String empData) {
        String[] details = empData.split(",");
        System.out.println("Employee ID: " + details[0]);
        System.out.println("Name       : " + details[1]);
        System.out.println("Designation: " + details[2]);
        System.out.println("Salary     : $" + details[3]);
        System.out.println("-----------------------------");
    }
}

public class EmployeeManagementApp {
    private static final String FILE_NAME = "employees.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you! Rajneesh Verma - 23BCS80093");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    // Method to add an employee
    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Employee emp = new Employee(empId, name, designation, salary);

        // Write employee details to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write(emp.toString());
            bufferedWriter.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employee details: " + e.getMessage());
        }
    }

    // Method to display all employees
    private static void displayEmployees() {
        File file = new File(FILE_NAME);

        // Check if file exists
        if (!file.exists() || file.length() == 0) {
            System.out.println("No employee records found.");
            return;
        }

        // Read and display employee details from file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\n--- Employee Details ---");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Employee.displayFormatted(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading employee details: " + e.getMessage());
        }

        
    }
}
