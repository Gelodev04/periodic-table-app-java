import java.util.Scanner;

public class DetailedDisplay extends ElementDisplay {
    private Scanner scanner;

    public DetailedDisplay(PeriodicTable periodicTable, Scanner scanner) {
        super(periodicTable);
        this.scanner = scanner;
    }

    @Override
    public void display() {
        showHeader("ELEMENT DETAILS");
        
        System.out.print("Enter element symbol or atomic number: ");
        String input = scanner.nextLine().trim();
        
        Element element = null;
        
        // Try to find by symbol first
        Element[] bySymbol = periodicTable.searchBySymbol(input);
        if (bySymbol != null && bySymbol.length > 0) {
            element = bySymbol[0];
        } else {
            // Try to find by atomic number
            try {
                int atomicNumber = Integer.parseInt(input);
                Element[] byNumber = periodicTable.searchByAtomicNumber(atomicNumber);
                if (byNumber != null && byNumber.length > 0) {
                    element = byNumber[0];
                }
            } catch (NumberFormatException e) {
                // Not a number, continue
            }
        }
        
        if (element != null) {
            displayFullDetails(element);
        } else {
            System.out.println("\nElement not found!");
        }
    }
    
    private void displayFullDetails(Element element) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + element.getName() + " (" + element.getSymbol() + ")");
        System.out.println("=".repeat(60));
        
        System.out.println("Atomic Number: " + element.getAtomicNumber());
        System.out.println("Atomic Weight: " + element.getAtomicWeight() + " u");
        System.out.println("Group: " + element.getGroup());
        System.out.println("Period: " + element.getPeriod());
        System.out.println("Category: " + element.getCategory());
        
        System.out.println("\nDescription:");
        System.out.println("  " + element.getDescription());
        
        String[] uses = element.getUses();
        if (uses != null && uses.length > 0) {
            System.out.println("\nCommon Uses:");
            for (String use : uses) {
                System.out.println("  • " + use);
            }
        }
        
        System.out.println("=".repeat(60));
    }
}

