import java.util.Scanner;

public class TableDisplay extends ElementDisplay implements ElementInfo {
    private Scanner scanner;
    private static final int ELEMENTS_PER_PAGE = 25;

    public TableDisplay(PeriodicTable periodicTable, Scanner scanner) {
        super(periodicTable);
        this.scanner = scanner;
    }

    @Override
    public void display() {
        Element[] elements = periodicTable.getAllElements();
        
        // Sort elements by atomic number to ensure proper order
        java.util.Arrays.sort(elements, (e1, e2) -> 
            Integer.compare(e1.getAtomicNumber(), e2.getAtomicNumber()));
        
        int totalElements = elements.length;
        int totalPages = (int) Math.ceil((double) totalElements / ELEMENTS_PER_PAGE);
        int currentPage = 1;
        
        boolean viewing = true;
        
        while (viewing) {
            showHeader("PERIODIC TABLE - ALL ELEMENTS");
            
            System.out.printf("%-5s %-4s %-20s %-10s %-15s%n", 
                             "No.", "Sym", "Name", "Weight", "Category");
            showSeparator();
            
            int startIndex = (currentPage - 1) * ELEMENTS_PER_PAGE;
            int endIndex = Math.min(startIndex + ELEMENTS_PER_PAGE, totalElements);
            
            for (int i = startIndex; i < endIndex; i++) {
                Element element = elements[i];
                System.out.printf("%-5d %-4s %-20s %-10.2f %-15s%n",
                                element.getAtomicNumber(),
                                element.getSymbol(),
                                element.getName(),
                                element.getAtomicWeight(),
                                element.getCategory());
            }
            
            System.out.println("\n" + "=".repeat(60));
            System.out.printf("Page %d of %d | Showing elements %d-%d of %d%n", 
                            currentPage, totalPages, startIndex + 1, endIndex, totalElements);
            System.out.println("=".repeat(60));
            
            if (totalPages > 1) {
                System.out.println("\nNavigation:");
                if (currentPage > 1) {
                    System.out.println("  [P] Previous page");
                }
                if (currentPage < totalPages) {
                    System.out.println("  [N] Next page");
                }
                System.out.println("  [F] First page");
                System.out.println("  [L] Last page");
                System.out.println("  [G] Go to specific page");
                System.out.println("  [Q] Quit (return to menu)");
                System.out.print("\nEnter your choice: ");
                
                String choice = scanner.nextLine().trim().toUpperCase();
                
                switch (choice) {
                    case "P":
                    case "PREVIOUS":
                        if (currentPage > 1) {
                            currentPage--;
                        } else {
                            System.out.println("\nAlready on first page!");
                            System.out.print("Press Enter to continue...");
                            scanner.nextLine();
                        }
                        break;
                    case "N":
                    case "NEXT":
                        if (currentPage < totalPages) {
                            currentPage++;
                        } else {
                            System.out.println("\nAlready on last page!");
                            System.out.print("Press Enter to continue...");
                            scanner.nextLine();
                        }
                        break;
                    case "F":
                    case "FIRST":
                        currentPage = 1;
                        break;
                    case "L":
                    case "LAST":
                        currentPage = totalPages;
                        break;
                    case "G":
                    case "GO":
                        System.out.print("Enter page number (1-" + totalPages + "): ");
                        try {
                            int pageNum = Integer.parseInt(scanner.nextLine().trim());
                            if (pageNum >= 1 && pageNum <= totalPages) {
                                currentPage = pageNum;
                            } else {
                                System.out.println("\nInvalid page number! Please enter between 1 and " + totalPages);
                                System.out.print("Press Enter to continue...");
                                scanner.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid input! Please enter a number.");
                            System.out.print("Press Enter to continue...");
                            scanner.nextLine();
                        }
                        break;
                    case "Q":
                    case "QUIT":
                        viewing = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please try again.");
                        System.out.print("Press Enter to continue...");
                        scanner.nextLine();
                }
            } else {
                System.out.println("\n[Q] Quit (return to menu)");
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine().trim().toUpperCase();
                if (choice.equals("Q") || choice.equals("QUIT")) {
                    viewing = false;
                }
            }
        }
    }

    @Override
    public void displayInfo(Element element) {
        System.out.println(element.toString());
    }

    @Override
    public String getInfoSummary(Element element) {
        return element.getSymbol() + " - " + element.getName();
    }
}

