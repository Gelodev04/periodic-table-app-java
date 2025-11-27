/**
 * Abstract class demonstrating Abstraction and serves as base for Inheritance
 * Different display types will extend this class and implement the abstract methods
 */
public abstract class ElementDisplay {
    protected PeriodicTable periodicTable;

    public ElementDisplay(PeriodicTable periodicTable) {
        this.periodicTable = periodicTable;
    }

    // Abstract method - must be implemented by subclasses (Polymorphism)
    public abstract void display();
    
    // Template method - common functionality
    public void showHeader(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }

    public void showSeparator() {
        System.out.println("-".repeat(60));
    }
}

