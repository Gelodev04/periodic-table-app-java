import java.util.Random;
import java.util.Scanner;

public class Quiz {
    private PeriodicTable periodicTable;
    private Scanner scanner;
    private Random random;
    private int score;
    private int totalQuestions;
    private static final int MAX_QUESTIONS = 30;

    // Interface for different question types (Abstraction)
    public interface Question {
        void displayQuestion();
        boolean checkAnswer(String answer);
        String getCorrectAnswer();
    }

    // Concrete question implementations (Polymorphism)
    private class SymbolQuestion implements Question {
        private Element element;

        public SymbolQuestion(Element element) {
            this.element = element;
        }

        @Override
        public void displayQuestion() {
            System.out.println("\nWhat is the chemical symbol of " + element.getName() + "?");
            System.out.print("Answer: ");
        }

        @Override
        public boolean checkAnswer(String answer) {
            return answer.trim().equalsIgnoreCase(element.getSymbol());
        }

        @Override
        public String getCorrectAnswer() {
            return element.getSymbol();
        }
    }

    private class NameQuestion implements Question {
        private Element element;

        public NameQuestion(Element element) {
            this.element = element;
        }

        @Override
        public void displayQuestion() {
            System.out.println("\nWhat is the name of the element with symbol " + element.getSymbol() + "?");
            System.out.print("Answer: ");
        }

        @Override
        public boolean checkAnswer(String answer) {
            return answer.trim().equalsIgnoreCase(element.getName());
        }

        @Override
        public String getCorrectAnswer() {
            return element.getName();
        }
    }

    private class AtomicNumberQuestion implements Question {
        private Element element;

        public AtomicNumberQuestion(Element element) {
            this.element = element;
        }

        @Override
        public void displayQuestion() {
            System.out.println("\nWhat is the atomic number of " + element.getName() + " (" + element.getSymbol() + ")?");
            System.out.print("Answer: ");
        }

        @Override
        public boolean checkAnswer(String answer) {
            try {
                int answerNum = Integer.parseInt(answer.trim());
                return answerNum == element.getAtomicNumber();
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public String getCorrectAnswer() {
            return String.valueOf(element.getAtomicNumber());
        }
    }

    private class CategoryQuestion implements Question {
        private Element element;

        public CategoryQuestion(Element element) {
            this.element = element;
        }

        @Override
        public void displayQuestion() {
            System.out.println("\nWhat category does " + element.getName() + " (" + element.getSymbol() + ") belong to?");
            System.out.print("Answer: ");
        }

        @Override
        public boolean checkAnswer(String answer) {
            return answer.trim().equalsIgnoreCase(element.getCategory());
        }

        @Override
        public String getCorrectAnswer() {
            return element.getCategory();
        }
    }

    public Quiz(PeriodicTable periodicTable, Scanner scanner) {
        this.periodicTable = periodicTable;
        this.scanner = scanner;
        this.random = new Random();
        this.score = 0;
        this.totalQuestions = 0;
    }

    public void startQuiz() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  PERIODIC TABLE QUIZ");
        System.out.println("=".repeat(60));
        
        // Reset score for new quiz
        score = 0;
        totalQuestions = 0;
        
        System.out.print("How many questions would you like? (Maximum: " + MAX_QUESTIONS + ") ");
        int numQuestions = 0;
        
        try {
            numQuestions = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            // Validate and limit the number of questions
            if (numQuestions < 1) {
                System.out.println("\nInvalid input! Minimum 1 question required. Setting to 1.");
                numQuestions = 1;
            } else if (numQuestions > MAX_QUESTIONS) {
                System.out.println("\nMaximum limit is " + MAX_QUESTIONS + " questions. Setting to " + MAX_QUESTIONS + ".");
                numQuestions = MAX_QUESTIONS;
            }
        } catch (Exception e) {
            System.out.println("\nInvalid input! Defaulting to 10 questions.");
            scanner.nextLine(); // clear invalid input
            numQuestions = 10;
        }

        Element[] allElements = periodicTable.getAllElements();
        
        System.out.println("\nStarting quiz with " + numQuestions + " question(s)...");
        System.out.println("-".repeat(60));

        for (int i = 0; i < numQuestions; i++) {
            Element randomElement = allElements[random.nextInt(allElements.length)];
            Question question = generateRandomQuestion(randomElement);

            question.displayQuestion();
            String userAnswer = scanner.nextLine();

            if (question.checkAnswer(userAnswer)) {
                System.out.println("✓ Correct!");
                score++;
            } else {
                System.out.println("✗ Incorrect! The correct answer is: " + question.getCorrectAnswer());
            }
            totalQuestions++;
        }

        displayResults();
    }

    // Polymorphism - can generate different types of questions
    private Question generateRandomQuestion(Element element) {
        int questionType = random.nextInt(4);
        switch (questionType) {
            case 0:
                return new SymbolQuestion(element);
            case 1:
                return new NameQuestion(element);
            case 2:
                return new AtomicNumberQuestion(element);
            case 3:
                return new CategoryQuestion(element);
            default:
                return new SymbolQuestion(element);
        }
    }

    private void displayResults() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  QUIZ RESULTS");
        System.out.println("=".repeat(60));
        System.out.println("Score: " + score + " / " + totalQuestions);
        double percentage = (score * 100.0) / totalQuestions;
        System.out.printf("Percentage: %.1f%%\n", percentage);
        
        if (percentage >= 80) {
            System.out.println("Excellent! You're a periodic table expert! 🌟");
        } else if (percentage >= 60) {
            System.out.println("Good job! Keep learning! 👍");
        } else {
            System.out.println("Keep practicing! You'll improve! 💪");
        }
        System.out.println("=".repeat(60));
    }
}

