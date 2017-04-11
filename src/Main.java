import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();

    public static void main(String[] args) throws Exception {
        while (true) {
            displayItems();

            System.out.println("Please select from the following options:");

            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Change quantity");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                inventory.add(createItem());

            } else if (option.equals("2")) {
                System.out.println("Enter the number of the item you would like to delete");
                int itemNum = Integer.parseInt(scanner.nextLine());
                inventory.remove(itemNum - 1);
            } else if (option.equals("3")) {
                updateItem();
            }
        }

    }

    static InventoryItem createItem() throws Exception {

        System.out.println("Please enter category");
        System.out.println("1. Bean");
        System.out.println("2. Beef");
        System.out.println("3. Onion");
        System.out.println("4. Pepper");
        System.out.println("5. Tomato");
        Scanner scanner2 = new Scanner(System.in);
        String category = scanner2.nextLine();

        System.out.println("Please enter the name");
        String name = scanner2.nextLine();

        System.out.println("Please enter the quantity");
        int qty = Integer.parseInt(scanner2.nextLine());

        InventoryItem item;
        switch (category) {
            case "1":

                item = new Bean(name, qty);
                break;
            case "2":
                item = new Beef(name, qty);
                break;
            case "3":
                item = new Onion(name, qty);
                break;
            case "4":
                item = new Pepper(name, qty);
            case "5":
                item = new Tomato(name, qty);
                break;
            default:
                throw new Exception("invalid option!");
        }
        return item;
    }

    static public void updateItem() throws Exception {
        System.out.println("Select the item number you want to change");
        int itemNum = Integer.parseInt(scanner.nextLine());
        inventory.remove(itemNum - 1);

        InventoryItem creation = createItem();
        inventory.add(itemNum - 1, creation);
    }

    public static void displayItems() {
        int i = 1;
        for (InventoryItem foodItem : inventory) {
            System.out.printf("%d %s %s %d\n", i, foodItem.category, foodItem.name, foodItem.amount);
            i++;
        }
    }

}

