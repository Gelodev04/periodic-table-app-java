# Periodic Table Learning System

A Java console-based learning application about the periodic table that demonstrates Object-Oriented Programming (OOP) principles.

## Features

- 📋 **View All Elements**: Display all elements in the periodic table in a formatted table
- 🔍 **Search Elements**: Search for elements by symbol, name, atomic number, or category
- 📖 **Element Details**: View detailed information about each element including uses and descriptions
- 🎯 **Interactive Quiz**: Test your knowledge with randomized questions about elements
- 💡 **OOP Principles**: Demonstrates Encapsulation, Inheritance, Polymorphism, and Abstraction

## OOP Principles Demonstrated

### 1. **Encapsulation**

- The `Element` class uses private fields with public getters and setters
- Data is protected and can only be accessed through controlled methods
- Example: `element.getSymbol()`, `element.setSymbol()`

### 2. **Inheritance**

- `TableDisplay`, `SearchDisplay`, and `DetailedDisplay` extend the abstract `ElementDisplay` class
- All display classes inherit common functionality from the parent class
- Promotes code reusability and hierarchical relationships

### 3. **Polymorphism**

- Different display classes override the `display()` method with their own implementations
- The `Quiz` class uses the `Question` interface to support different question types
- Same interface, different implementations - runtime polymorphism

### 4. **Abstraction**

- `ElementDisplay` is an abstract class that defines the structure
- `ElementInfo` interface defines contracts for element information
- `Question` interface in `Quiz` provides abstraction for different question types
- Hides complex implementation details from the user

## Project Structure

```
PeriodicTableApp/
├── Element.java              # Element class (Encapsulation)
├── ElementInfo.java          # Interface (Abstraction)
├── ElementDisplay.java       # Abstract class (Abstraction/Inheritance)
├── TableDisplay.java         # Extends ElementDisplay (Inheritance)
├── SearchDisplay.java        # Extends ElementDisplay (Inheritance)
├── DetailedDisplay.java      # Extends ElementDisplay (Inheritance)
├── Quiz.java                 # Quiz with polymorphism
├── PeriodicTable.java        # Data structure for elements
└── PeriodicTableApp.java     # Main application class
```

## How to Compile and Run

### Using Command Line (Windows):

1. **Compile all Java files:**

   ```bash
   javac *.java
   ```

2. **Run the application:**
   ```bash
   java PeriodicTableApp
   ```

### Using an IDE:

1. Open the project folder in your IDE (IntelliJ IDEA, Eclipse, NetBeans, etc.)
2. Compile the project
3. Run `PeriodicTableApp.java` as the main class

## Usage Guide

When you run the application, you'll see a menu with the following options:

1. **View All Elements**: Displays all elements in a formatted table
2. **View Element Details**: Enter a symbol or atomic number to see detailed information
3. **Search Elements**: Search by symbol, name, atomic number, or category
4. **Take Quiz**: Test your knowledge with randomized questions
5. **About**: Learn about the OOP principles demonstrated in this application
6. **Exit**: Close the application

## Example Usage

### Searching for an Element:

- Choose option 3 from the menu
- Select search criteria (symbol, name, atomic number, or category)
- Enter your search term
- View the results with all element details and uses

### Taking a Quiz:

- Choose option 4 from the menu
- Enter the number of questions you want
- Answer questions about symbols, names, atomic numbers, or categories
- View your score and percentage at the end

## Element Information

Each element includes:

- Chemical symbol and name
- Atomic number and atomic weight
- Group and period
- Category (Metal, Nonmetal, etc.)
- Common uses and applications
- Description

## Notes

- The application includes 30+ common elements with their properties
- You can easily extend the `PeriodicTable.initializeElements()` method to add more elements
- All OOP principles are clearly demonstrated and documented in the code
- The quiz generates random questions from different question types

## Requirements

- Java JDK 8 or higher
- Command line or IDE to compile and run Java files

Enjoy learning about the periodic table! 🌟
