package BankManagmentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        SystemManager system = new SystemManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Employee");
                System.out.println("2. Edit Employee Information");
                System.out.println("3. Display Employees");
                System.out.println("4. Create Client");
                System.out.println("5. Edit Client");
                System.out.println("6. Search Client");
                System.out.println("7. Delete Client");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: // Add Employee
                        System.out.print("Enter Employee Name: ");
                        String empName = scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String empAddress = scanner.nextLine();
                        System.out.print("Enter Position: ");
                        String empPosition = scanner.nextLine();
                        system.addEmployee(empName, empAddress, empPosition);
                        break;

                    case 2: // Edit Employee Information
                        System.out.print("Enter Employee Name: ");
                        String editEmpName = scanner.nextLine();
                        System.out.print("Enter New Address (leave blank to skip): ");
                        String newAddress = scanner.nextLine();
                        System.out.print("Enter New Position (leave blank to skip): ");
                        String newPosition = scanner.nextLine();
                        system.editEmployee(editEmpName, newAddress, newPosition);
                        break;

                    case 3: // Display Employees
                        system.displayEmployees();
                        break;

                    case 4: // Create Client
                        System.out.print("Enter Account Number: ");
                        int accountNumber = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Name: ");
                        String clientName = scanner.nextLine();
                        System.out.print("Enter Contact Info: ");
                        String contactInfo = scanner.nextLine();
                        system.createClient(accountNumber, clientName, contactInfo);
                        break;

                    case 5: // Edit Client
                        System.out.print("Enter Account Number: ");
                        accountNumber = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter New Name (leave blank to skip): ");
                        clientName = scanner.nextLine();
                        System.out.print("Enter New Contact Info (leave blank to skip): ");
                        contactInfo = scanner.nextLine();
                        system.editClient(accountNumber, clientName, contactInfo);
                        break;

                    case 6: // Search Client
                        System.out.print("Enter Name or Account Number: ");
                        String query = scanner.nextLine();
                        system.searchClient(query);
                        break;

                    case 7: // Delete Client
                        System.out.print("Enter Account Number: ");
                        accountNumber = Integer.parseInt(scanner.nextLine());
                        system.deleteClient(accountNumber);
                        break;

                    case 8: // Exit
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
