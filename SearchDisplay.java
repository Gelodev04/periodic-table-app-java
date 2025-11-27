import java.util.Scanner;

/**
 * Class demonstrating Inheritance - extends ElementDisplay
 * Allows searching for elements by various criteria
 * Demonstrates Polymorphism through method overriding
 */
public class SearchDisplay extends ElementDisplay {
    private Scanner scanner;

    public SearchDisplay(PeriodicTable periodicTable, Scanner scanner) {
        super(periodicTable);
        this.scanner = scanner;
    }

    @Override
    public void display() {
        showHeader("SEARCH ELEMENTS");
        
        System.out.println("Search by:");
        System.out.println("1. Symbol");
        System.out.println("2. Name");
        System.out.println("3. Atomic Number");
        System.out.println("4. Category");
        System.out.print("\nEnter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Element[] results = null;
        
        switch (choice) {
            case 1:
                System.out.print("Enter symbol: ");
                String symbol = scanner.nextLine().trim();
                results = periodicTable.searchBySymbol(symbol);
                break;
            case 2:
                System.out.print("Enter name (partial match): ");
                String name = scanner.nextLine().trim();
                results = periodicTable.searchByName(name);
                break;
            case 3:
                System.out.print("Enter atomic number: ");
                int num = scanner.nextInt();
                results = periodicTable.searchByAtomicNumber(num);
                break;
            case 4:
                System.out.print("Enter category: ");
                String category = scanner.nextLine().trim();
                results = periodicTable.searchByCategory(category);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        if (results != null && results.length > 0) {
            System.out.println("\nSearch Results:");
            showSeparator();
            for (Element element : results) {
                displayElementDetails(element);
            }
        } else {
            System.out.println("\nNo elements found!");
        }
    }
    
    private void displayElementDetails(Element element) {
        System.out.println("\nElement Details:");
        System.out.println("  Symbol: " + element.getSymbol());
        System.out.println("  Name: " + element.getName());
        System.out.println("  Atomic Number: " + element.getAtomicNumber());
        System.out.println("  Atomic Weight: " + element.getAtomicWeight());
        System.out.println("  Group: " + element.getGroup());
        System.out.println("  Period: " + element.getPeriod());
        System.out.println("  Category: " + element.getCategory());
        System.out.println("  Description: " + element.getDescription());
        
        String[] uses = element.getUses();
        if (uses != null && uses.length > 0) {
            System.out.println("  Uses:");
            for (String use : uses) {
                System.out.println("    - " + use);
            }
        }
        showSeparator();
    }
}

