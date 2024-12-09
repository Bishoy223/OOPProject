package BankManagmentSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {
    
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>(); // List to store multiple clients

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Add New Client");
            System.out.println("2. Display All Clients' Details");
            System.out.println("3. Edit Personal Information for a Client");
            System.out.println("4. Perform Operations on a Client's Account");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add new client
                    System.out.print("Enter first name: ");
                    String firstName = scanner.next();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.next();

                    System.out.print("Enter username: ");
                    String username = scanner.next();

                    System.out.print("Enter ID: ");
                    String ID = scanner.next();

                    System.out.print("Enter telephone number: ");
                    String telephoneNumber = scanner.next();

                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();

                    clients.add(new Client(firstName, lastName, username, ID, telephoneNumber, initialBalance));
                    System.out.println("Client added successfully.");
                    break;

                case 2:
                    // Display all clients
                    if (clients.isEmpty()) {
                        System.out.println("No clients found.");
                    } else {
                        System.out.println("--- Clients' Details ---");
                        for (Client client : clients) {
                            client.displayDetails();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    // Edit personal information for a specific client
                    System.out.print("Enter the ID of the client to edit: ");
                    String editID = scanner.next();
                    Client clientToEdit = findClientByID(clients, editID);

                    if (clientToEdit != null) {
                        System.out.print("Enter new first name: ");
                        String newFirstName = scanner.next();
                        clientToEdit.setFirstName(newFirstName);

                        System.out.print("Enter new last name: ");
                        String newLastName = scanner.next();
                        clientToEdit.setLastName(newLastName);

                        System.out.print("Enter new username: ");
                        String newUsername = scanner.next();
                        clientToEdit.setUsername(newUsername);

                        System.out.print("Enter new telephone number: ");
                        String newTelephoneNumber = scanner.next();
                        clientToEdit.setTelephoneNumber(newTelephoneNumber);

                        System.out.println("Client information updated successfully.");
                    } else {
                        System.out.println("Client with ID " + editID + " not found.");
                    }
                    break;

                case 4:
                    // Perform operations on a specific client's account
                    System.out.print("Enter the ID of the client: ");
                    String clientID = scanner.next();
                    Client targetClient = findClientByID(clients, clientID);

                    if (targetClient != null) {
                        performAccountOperations(scanner, targetClient, clients);
                    } else {
                        System.out.println("Client with ID " + clientID + " not found.");
                    }
                    break;

                case 5:
                    // Exit the application
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Helper method to find a client by ID
    private static Client findClientByID(ArrayList<Client> clients, String ID) {
        for (Client client : clients) {
            if (client.getID().equals(ID)) {
                return client;
            }
        }
        return null;
    }

    // Method to perform account operations for a specific client
    private static void performAccountOperations(Scanner scanner, Client client, ArrayList<Client> clients) {
        while (true) {
            System.out.println("\n--- Account Operations for " + client.getUsername() + " ---");
            System.out.println("1. Display Account Details");
            System.out.println("2. Transfer Money");
            System.out.println("3. Request Credit Card");
            System.out.println("4. Pay with Credit Card");
            System.out.println("5. Disable Credit Card");
            System.out.println("6. Deposit Money");
            System.out.println("7. Show Transaction History");
            System.out.println("8. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    client.displayDetails();
                    break;
    
                case 2:
                    System.out.print("Enter the ID of the client you want to transfer money to: ");
                    String targetClientID = scanner.next();
                    Client targetClient = findClientByID(clients, targetClientID);
    
                    if (targetClient != null) {
                        System.out.print("Enter the amount to transfer: ");
                        double amount = scanner.nextDouble();
                        if (client.getAccountNumber().transfer(amount, targetClient.getAccountNumber())) {
                            System.out.println("Transferred " + amount + " to " + targetClient.getUsername() + " successfully.");
                        } else {
                            System.out.println("Transfer failed. Insufficient balance.");
                        }
                    } else {
                        System.out.println("Client with ID " + targetClientID + " not found.");
                    }
                    break;
    
                case 3:
                    client.getAccountNumber().requestCreditCard();
                    break;
    
                case 4:
                    System.out.print("Enter payment amount: ");
                    double payment = scanner.nextDouble();
                    client.getAccountNumber().payWithCreditCard(payment);
                    break;
    
                case 5:
                    client.getAccountNumber().disableCreditCard();
                    break;
    
                case 6:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    client.getAccountNumber().deposit(deposit);
                    break;
    
                case 7:
                    client.getAccountNumber().displayTransactionHistory();
                    break;
    
                case 8:
                    return;
    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


