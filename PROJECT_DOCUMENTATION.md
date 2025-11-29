# Periodic Table Learning System

## Project Title

**Periodic Table Learning System** - An Interactive Java Console Application

---

## Description/Overview

The Periodic Table Learning System is a comprehensive Java console-based application designed to help users learn about chemical elements through an interactive interface. This educational tool provides multiple ways to explore the periodic table, including viewing all elements in a formatted table, searching for specific elements by various criteria, viewing detailed information about individual elements, and testing knowledge through an interactive quiz system.

**Main Features:**

- **Comprehensive Element Database**: Contains information about all 118 chemical elements with detailed properties including atomic number, weight, group, period, category, uses, and descriptions
- **Multiple Display Modes**: View elements in a paginated table format, search by symbol/name/atomic number/category, or view detailed information about specific elements
- **Interactive Quiz System**: Test knowledge with randomized questions covering element symbols, names, atomic numbers, and categories
- **User-Friendly Interface**: Clean console-based menu system with intuitive navigation

**Problem It Solves:**
This application addresses the challenge of learning and memorizing chemical elements by providing an organized, interactive platform that makes studying the periodic table engaging and efficient. It eliminates the need for physical periodic table charts and textbooks by offering a digital, searchable, and quiz-based learning experience. The system is particularly useful for students, educators, and chemistry enthusiasts who want to reinforce their understanding of element properties and relationships.

---

## OOP Concepts Applied

This project demonstrates all four fundamental Object-Oriented Programming principles through practical implementation:

### 1. Encapsulation

**Definition**: Encapsulation is the bundling of data and methods that operate on that data within a single unit (class), while restricting direct access to some of the object's components.

**Implementation in the Project**:

- **Element Class**: The `Element` class is a prime example of encapsulation. All fields (symbol, name, atomicNumber, atomicWeight, group, period, category, uses, description) are declared as `private`, preventing direct access from outside the class. Access to these fields is controlled through public getter and setter methods:

  ```java
  private String symbol;  // Private field
  public String getSymbol() { return symbol; }  // Public getter
  public void setSymbol(String symbol) { this.symbol = symbol; }  // Public setter
  ```

- **PeriodicTable Class**: The internal array of elements and size counter are encapsulated as private members, with controlled access through public methods like `getAllElements()`, `searchBySymbol()`, etc.

- **Quiz Class**: The score and totalQuestions fields are private, ensuring they can only be modified through the class's own methods, maintaining data integrity.

**Benefits**: This approach protects data from unauthorized access, allows for validation in setters, and provides a clear interface for interacting with objects.

### 2. Inheritance

**Definition**: Inheritance allows a class to inherit properties and methods from another class, promoting code reusability and establishing hierarchical relationships.

**Implementation in the Project**:

- **ElementDisplay Abstract Class**: Serves as the base class (parent) that defines common structure and shared functionality:

  ```java
  public abstract class ElementDisplay {
      protected PeriodicTable periodicTable;
      public abstract void display();
      public void showHeader(String title) { ... }
      public void showSeparator() { ... }
  }
  ```

- **Child Classes**: Three classes extend `ElementDisplay`:

  - `TableDisplay` extends `ElementDisplay` - Displays all elements in a table format
  - `SearchDisplay` extends `ElementDisplay` - Provides search functionality
  - `DetailedDisplay` extends `ElementDisplay` - Shows detailed element information

- **Benefits**: All display classes inherit the `showHeader()` and `showSeparator()` methods, eliminating code duplication. They also share the `periodicTable` reference through the protected field, establishing a consistent structure across all display types.

- **Interface Implementation**: `TableDisplay` also implements the `ElementInfo` interface, demonstrating multiple inheritance through interfaces:
  ```java
  public class TableDisplay extends ElementDisplay implements ElementInfo
  ```

### 3. Polymorphism

**Definition**: Polymorphism allows objects of different types to be treated as objects of a common base type, enabling one interface to represent different underlying forms.

**Implementation in the Project**:

- **Method Overriding (Runtime Polymorphism)**: All three display classes (`TableDisplay`, `SearchDisplay`, `DetailedDisplay`) override the abstract `display()` method from `ElementDisplay`, each providing its own unique implementation:

  ```java
  // In PeriodicTableApp.java
  ElementDisplay tableDisplay = new TableDisplay(...);
  ElementDisplay searchDisplay = new SearchDisplay(...);
  ElementDisplay detailedDisplay = new DetailedDisplay(...);

  // Same method call, different behaviors
  tableDisplay.display();      // Shows table
  searchDisplay.display();     // Shows search interface
  detailedDisplay.display();   // Shows detailed view
  ```

- **Interface-Based Polymorphism in Quiz**: The `Quiz` class uses the `Question` interface to support different question types:

  ```java
  public interface Question {
      void displayQuestion();
      boolean checkAnswer(String answer);
      String getCorrectAnswer();
  }
  ```

  Multiple implementations exist:

  - `SymbolQuestion` - Asks for element symbol
  - `NameQuestion` - Asks for element name
  - `AtomicNumberQuestion` - Asks for atomic number
  - `CategoryQuestion` - Asks for element category

  The `generateRandomQuestion()` method returns a `Question` interface reference, but the actual object can be any of the four implementations, demonstrating polymorphism:

  ```java
  Question question = generateRandomQuestion(element);
  question.displayQuestion();  // Calls the appropriate implementation
  ```

- **Benefits**: This allows the `PeriodicTableApp` to treat all display objects uniformly while each provides specialized behavior, making the code more flexible and maintainable.

### 4. Abstraction

**Definition**: Abstraction hides complex implementation details and shows only the essential features of an object, allowing users to work with high-level concepts rather than low-level details.

**Implementation in the Project**:

- **Abstract Class**: `ElementDisplay` is an abstract class that cannot be instantiated directly. It defines the structure and contract that all display classes must follow:

  ```java
  public abstract class ElementDisplay {
      public abstract void display();  // Must be implemented by subclasses
      // Common methods with implementation
  }
  ```

- **Interface Abstraction**: The `ElementInfo` interface defines a contract without implementation:

  ```java
  public interface ElementInfo {
      void displayInfo(Element element);
      String getInfoSummary(Element element);
  }
  ```

  Classes implementing this interface must provide their own implementation, but the interface abstracts away the specific details.

- **Question Interface**: The `Question` interface in the `Quiz` class abstracts away the different question types. Users of the interface don't need to know whether they're working with a `SymbolQuestion` or `CategoryQuestion` - they just call the interface methods.

- **Benefits**: Abstraction simplifies the code by hiding complexity, making it easier to understand and modify. It also allows for future extensions without breaking existing code.

---

## Program Structure

### Main Classes and Their Roles

1. **PeriodicTableApp.java** (Main Application Class)

   - **Role**: Entry point of the application
   - **Responsibilities**:
     - Initializes all components (PeriodicTable, displays, Quiz)
     - Manages the main menu and user interaction loop
     - Coordinates between different components
     - Demonstrates polymorphism by using `ElementDisplay` references

2. **Element.java** (Data Model)

   - **Role**: Represents a single chemical element
   - **Responsibilities**:
     - Encapsulates element properties (symbol, name, atomic number, etc.)
     - Provides getters and setters for data access
     - Implements `toString()` for string representation

3. **PeriodicTable.java** (Data Management)

   - **Role**: Manages the collection of all elements
   - **Responsibilities**:
     - Stores all 118 elements in an array
     - Provides search functionality (by symbol, name, atomic number, category)
     - Initializes the element database with complete information
     - Returns filtered or complete element lists

4. **ElementDisplay.java** (Abstract Base Class)

   - **Role**: Base class for all display types
   - **Responsibilities**:
     - Defines common structure for display classes
     - Provides shared utility methods (showHeader, showSeparator)
     - Declares abstract `display()` method for subclasses to implement

5. **TableDisplay.java** (Concrete Display Class)

   - **Role**: Displays all elements in a paginated table format
   - **Responsibilities**:
     - Extends `ElementDisplay` and implements `ElementInfo`
     - Implements pagination for large element lists
     - Provides navigation controls (next, previous, go to page)
     - Formats and displays element data in tabular form

6. **SearchDisplay.java** (Concrete Display Class)

   - **Role**: Provides search functionality for elements
   - **Responsibilities**:
     - Extends `ElementDisplay`
     - Implements search interface with multiple criteria
     - Displays search results with full element details
     - Handles user input for search queries

7. **DetailedDisplay.java** (Concrete Display Class)

   - **Role**: Shows detailed information about a specific element
   - **Responsibilities**:
     - Extends `ElementDisplay`
     - Accepts element symbol or atomic number as input
     - Displays comprehensive element information including uses and description
     - Formats detailed element view

8. **Quiz.java** (Quiz System)

   - **Role**: Manages interactive quiz functionality
   - **Responsibilities**:
     - Defines `Question` interface for different question types
     - Implements multiple question types (Symbol, Name, AtomicNumber, Category)
     - Generates random questions from the element database
     - Tracks and displays quiz scores
     - Demonstrates polymorphism through the Question interface

9. **ElementInfo.java** (Interface)
   - **Role**: Defines contract for element information display
   - **Responsibilities**:
     - Specifies methods for displaying element information
     - Provides abstraction for element information operations

### Class Relationships and Structure

```
┌─────────────────────────────────────────────────────────────┐
│                    PeriodicTableApp                          │
│                    (Main Application)                        │
└────────────┬─────────────────────────────────────────────────┘
             │ uses
             ├─────────────────┐
             │                 │
             ▼                 ▼
    ┌─────────────────┐  ┌──────────────┐
    │ PeriodicTable   │  │    Quiz      │
    │ (Data Manager)  │  │ (Quiz System)│
    └────────┬────────┘  └──────┬───────┘
             │                  │
             │ contains         │ uses
             │                  │
             ▼                  │
    ┌─────────────────┐         │
    │    Element      │         │
    │  (Data Model)   │         │
    └─────────────────┘         │
                                │
                                ▼
                    ┌───────────────────────┐
                    │   Question Interface │
                    │  (Abstraction)       │
                    └───────────┬───────────┘
                                │ implements
                ┌───────────────┼───────────────┐
                │               │               │
                ▼               ▼               ▼
        ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
        │SymbolQuestion│ │NameQuestion  │ │AtomicNumber  │
        │              │ │              │ │  Question    │
        └──────────────┘ └──────────────┘ └──────────────┘

┌─────────────────────────────────────────────────────────────┐
│              ElementDisplay (Abstract Class)                 │
│              (Base for all displays)                          │
└───────────────┬──────────────────────────────────────────────┘
                │ extends
    ┌───────────┼───────────┬──────────────┐
    │           │           │              │
    ▼           ▼           ▼              ▼
┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐
│Table     │ │Search    │ │Detailed   │ │(Future   │
│Display   │ │Display   │ │Display    │ │extensions)│
└────┬─────┘ └──────────┘ └──────────┘ └──────────┘
     │
     │ implements
     ▼
┌─────────────────┐
│  ElementInfo    │
│  (Interface)    │
└─────────────────┘
```

### Key Relationships:

1. **Composition**: `PeriodicTableApp` contains instances of `PeriodicTable`, `Quiz`, and multiple `ElementDisplay` objects
2. **Aggregation**: `PeriodicTable` contains an array of `Element` objects
3. **Inheritance**: `TableDisplay`, `SearchDisplay`, and `DetailedDisplay` extend `ElementDisplay`
4. **Interface Implementation**: `TableDisplay` implements `ElementInfo`; Quiz question classes implement `Question` interface
5. **Dependency**: Display classes depend on `PeriodicTable`; `Quiz` depends on `PeriodicTable` and uses `Question` implementations

---

## How to Run the Program

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed
- Command line terminal (Command Prompt, PowerShell, or Git Bash on Windows; Terminal on Mac/Linux)
- All Java source files in the same directory

### Step-by-Step Instructions

#### Method 1: Using Command Line (Recommended)

1. **Open Terminal/Command Prompt**

   - On Windows: Open Command Prompt or PowerShell
   - Navigate to the project directory:
     ```bash
     cd C:\Users\USER\Desktop\oop
     ```

2. **Compile All Java Files**

   ```bash
   javac *.java
   ```

   This command compiles all `.java` files in the current directory and generates corresponding `.class` files.

3. **Run the Application**
   ```bash
   java PeriodicTableApp
   ```
   This executes the main class and starts the application.

#### Method 2: Using an IDE (IntelliJ IDEA, Eclipse, NetBeans)

1. **Open the Project**

   - Open your IDE (IntelliJ IDEA, Eclipse, NetBeans, etc.)
   - Select "Open Project" or "Import Project"
   - Navigate to and select the project folder (`C:\Users\USER\Desktop\oop`)

2. **Compile the Project**

   - Most IDEs auto-compile, or you can manually compile:
     - IntelliJ IDEA: Build → Build Project
     - Eclipse: Project → Build Project
     - NetBeans: Build → Build Project

3. **Run the Application**
   - Locate `PeriodicTableApp.java` in the project explorer
   - Right-click on the file
   - Select "Run" or "Run 'PeriodicTableApp'"
   - Alternatively, use the Run button in the IDE toolbar

### Troubleshooting

- **"javac is not recognized"**: Ensure JDK is installed and added to your system PATH
- **"ClassNotFoundException"**: Make sure you're in the correct directory and all `.class` files are present
- **Compilation Errors**: Check that all Java files are in the same directory and there are no syntax errors

---

## Sample Output

### Main Menu

```
╔══════════════════════════════════════════════════════════╗
║     PERIODIC TABLE LEARNING SYSTEM                      ║
║     Learn about Elements, Search, and Take Quizzes!    ║
╚══════════════════════════════════════════════════════════╝

============================================================
  MAIN MENU
============================================================
1. View All Elements (Periodic Table)
2. View Element Details
3. Search Elements
4. Take Quiz
5. Exit
============================================================
Enter your choice (1-5):
```

### Sample Output 1: Viewing All Elements (Option 1)

```
============================================================
  PERIODIC TABLE - ALL ELEMENTS
============================================================
No.   Sym  Name                 Weight     Category
------------------------------------------------------------
1     H    Hydrogen             1.01       Nonmetal
2     He   Helium               4.00       Noble Gas
3     Li   Lithium              6.94       Alkali Metal
4     Be   Beryllium            9.01       Alkaline Earth Metal
5     B    Boron                10.81      Metalloid
... (more elements)

============================================================
Page 1 of 5 | Showing elements 1-25 of 118
============================================================

Navigation:
  [N] Next page
  [F] First page
  [L] Last page
  [G] Go to specific page
  [Q] Quit (return to menu)

Enter your choice:
```

### Sample Output 2: Viewing Element Details (Option 2)

```
============================================================
  ELEMENT DETAILS
============================================================
Enter element symbol or atomic number: Au

============================================================
  Gold (Au)
============================================================
Atomic Number: 79
Atomic Weight: 196.967 u
Group: 11
Period: 6
Category: Transition Metal

Description:
  Precious metal valued for its beauty and conductivity.

Common Uses:
  • Jewelry
  • Electronics
  • Investment
  • Dentistry
============================================================
```

### Sample Output 3: Searching Elements (Option 3)

```
============================================================
  SEARCH ELEMENTS
============================================================
Search by:
1. Symbol
2. Name
3. Atomic Number
4. Category

Enter your choice: 4
Enter category: Metal

Search Results:
------------------------------------------------------------

Element Details:
  Symbol: Li
  Name: Lithium
  Atomic Number: 3
  Atomic Weight: 6.941
  Group: 1
  Period: 2
  Category: Alkali Metal
  Description: The lightest metal, essential for rechargeable batteries.
  Uses:
    - Batteries
    - Psychiatric medication
    - Alloys
------------------------------------------------------------
... (more results)
```

### Sample Output 4: Taking a Quiz (Option 4)

```
============================================================
  PERIODIC TABLE QUIZ
============================================================
How many questions would you like? (Maximum: 30) 5

Starting quiz with 5 question(s)...
------------------------------------------------------------

What is the chemical symbol of Carbon?
Answer: C
✓ Correct!

What is the name of the element with symbol Fe?
Answer: Iron
✓ Correct!

What is the atomic number of Oxygen (O)?
Answer: 8
✓ Correct!

What category does Helium (He) belong to?
Answer: Noble Gas
✓ Correct!

What is the chemical symbol of Sodium?
Answer: Na
✓ Correct!

============================================================
  QUIZ RESULTS
============================================================
Score: 5 / 5
Percentage: 100.0%
Excellent! You're a periodic table expert! 🌟
============================================================
```

---

## Author and Acknowledgement

### Author

This project was developed as an educational demonstration of Object-Oriented Programming principles in Java.

### Acknowledgements

- **Periodic Table Data**: Element information, properties, and classifications are based on the International Union of Pure and Applied Chemistry (IUPAC) standards and widely accepted scientific data.

- **Educational Resources**: The structure and design principles follow best practices in Object-Oriented Programming as taught in computer science curricula.

- **Java Community**: Built using standard Java libraries and follows Java coding conventions and best practices.

- **Open Source Inspiration**: The project structure and OOP implementation patterns are inspired by educational programming examples and software engineering principles.

### Special Notes

This project serves as a comprehensive example of how Object-Oriented Programming principles can be applied in a real-world application. It demonstrates that OOP is not just theoretical but provides practical benefits in code organization, reusability, and maintainability.

The application can be extended with additional features such as:

- Graphical User Interface (GUI) implementation
- Database integration for element storage
- Advanced quiz modes and statistics
- Element comparison features
- Export functionality for study materials

---

**Version**: 1.0  
**Last Updated**: 2024  
**License**: Educational Use
