import java.util.Scanner;

public class PeriodicTableApp {
    private PeriodicTable periodicTable;
    private Scanner scanner;
    private ElementDisplay tableDisplay;
    private ElementDisplay searchDisplay;
    private ElementDisplay detailedDisplay;
    private Quiz quiz;

    public PeriodicTableApp() {
        this.periodicTable = new PeriodicTable();
        this.scanner = new Scanner(System.in);
        
        // Polymorphism - different types of displays
        this.tableDisplay = new TableDisplay(periodicTable, scanner);
        this.searchDisplay = new SearchDisplay(periodicTable, scanner);
        this.detailedDisplay = new DetailedDisplay(periodicTable, scanner);
        this.quiz = new Quiz(periodicTable, scanner);
    }

    public void run() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     PERIODIC TABLE LEARNING SYSTEM                      ║");
        System.out.println("║     Learn about Elements, Search, and Take Quizzes!    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            // Polymorphism - calling display() on different ElementDisplay objects
            switch (choice) {
                case 1:
                    tableDisplay.display();
                    break;
                case 2:
                    detailedDisplay.display();
                    break;
                case 3:
                    searchDisplay.display();
                    break;
                case 4:
                    quiz.startQuiz();
                    break;
                case 5:
                    running = false;
                    System.out.println("\nThank you for using Periodic Table Learning System!");
                    System.out.println("Keep learning! 🌟");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
            
            if (running && choice != 5) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("1. View All Elements (Periodic Table)");
        System.out.println("2. View Element Details");
        System.out.println("3. Search Elements");
        System.out.println("4. Take Quiz");
        System.out.println("5. Exit");
        System.out.println("=".repeat(60));
        System.out.print("Enter your choice (1-5): ");
    }

    private int getChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // clear invalid input
            return -1;
        } finally {
            scanner.nextLine(); // consume newline
        }
    }

    public static void main(String[] args) {
        PeriodicTableApp app = new PeriodicTableApp();
        app.run();
    }
}

