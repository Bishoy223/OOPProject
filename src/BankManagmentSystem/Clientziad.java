package BankManagmentSystem;

public class Client {
        public int accountNumber;
        public String name;
        public String contactInfo;
        public Client(int accountNumber, String name, String contactInfo) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.contactInfo = contactInfo;
        }

        public void editInfo(String name, String contactInfo) {
            if (name != null && !name.isEmpty()) {
                this.name = name;
            }
            if (contactInfo != null && !contactInfo.isEmpty()) {
                this.contactInfo = contactInfo;
            }
            System.out.println("Client information updated.");
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public String getName() {
            return name;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        @Override
        public String toString() {
            return "Account Number: " + accountNumber + ", Name: " + name + ", Contact Info: " + contactInfo;
        }
    }

