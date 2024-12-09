package BankManagmentSystem;

public class employee {
        public String name;
        public String address;
        public String position;

        public employee(String name, String address, String position) {
            this.name = name;
            this.address = address;
            this.position = position;
        }

        public void editInfo(String address, String position) {
            if (address != null && !address.isEmpty()) {
                this.address = address;
            }
            if (position != null && !position.isEmpty()) {
                this.position = position;
            }
            System.out.println("Employee information updated.");
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Address: " + address + ", Position: " + position;
        }
    }

