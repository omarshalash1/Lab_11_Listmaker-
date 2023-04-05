import java.util.ArrayList;
import java.util.Scanner;

public class main {

    private static ArrayList<String> itemList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String userInput = SafeInput.getRegExString(scanner, "Enter your choice: ", "[AaDdPpQq]");

            switch (userInput.toLowerCase()) {
                case "a":
                    addItem(scanner);
                    break;
                case "d":
                    deleteItem(scanner);
                    break;
                case "p":
                    printList();
                    break;
                case "q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (y/n) ")) {
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem(Scanner scanner) {
        String newItem = SafeInput.getString(scanner, "Enter the item to add: ");
        itemList.add(newItem);
        System.out.println("Item added successfully.");
    }

    private static void deleteItem(Scanner scanner) {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }

        printNumberedList();
        int itemIndex = SafeInput.getRangedInt(scanner, "Enter the item number to delete: ", 1, itemList.size()) - 1;
        itemList.remove(itemIndex);
        System.out.println("Item deleted successfully.");
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current list:");
            printNumberedList();
        }
    }

    private static void printNumberedList() {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }
}
