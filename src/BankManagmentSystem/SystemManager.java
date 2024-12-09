package BankManagmentSystem;

import java.util.ArrayList;
import java.util.List;
public class SystemManager {
    public List<Client> clients = new ArrayList<>();
    public List<employee> employees = new ArrayList<>();

    public void addEmployee(String name, String address, String position) {
        employees.add(new employee(name, address, position));
        System.out.println("Employee added.");
    }

    public void editEmployee(String name, String newAddress, String newPosition) {
        for (employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                employee.editInfo(newAddress, newPosition);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            for (employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void createClient(int accountNumber, String name, String contactInfo) {
        for (Client client : clients) {
            if (client.getAccountNumber() == accountNumber) {
                System.out.println("Client with this account number already exists.");
                return;
            }
        }
        clients.add(new Client(accountNumber, name, contactInfo));
        System.out.println("Client account created.");
    }

    public void editClient(int accountNumber, String name, String contactInfo) {
        for (Client client : clients) {
            if (client.getAccountNumber() == accountNumber) {
                client.editInfo(name, contactInfo);
                return;
            }
        }
        System.out.println("Client not found.");
    }

    public void searchClient(String query) {
        boolean found = false;
        for (Client client : clients) {
            if (client.getName().toLowerCase().contains(query.toLowerCase()) ||
                    String.valueOf(client.getAccountNumber()).equals(query)) {
                System.out.println(client);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No clients found.");
        }
    }

    public void deleteClient(int accountNumber) {
        for (Client client : clients) {
            if (client.getAccountNumber() == accountNumber) {
                clients.remove(client);
                System.out.println("Client account deleted.");
                return;
            }
        }
        System.out.println("Client not found.");
    }
}
