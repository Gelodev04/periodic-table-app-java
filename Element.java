/**
 * Element class demonstrating Encapsulation
 * All fields are private and accessed through public methods
 */
public class Element {
    // Private fields - Encapsulation
    private String symbol;
    private String name;
    private int atomicNumber;
    private double atomicWeight;
    private String group;
    private String period;
    private String category;
    private String[] uses;
    private String description;

    // Constructor
    public Element(String symbol, String name, int atomicNumber, double atomicWeight,
                   String group, String period, String category, String[] uses, String description) {
        this.symbol = symbol;
        this.name = name;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
        this.group = group;
        this.period = period;
        this.category = category;
        this.uses = uses;
        this.description = description;
    }

    // Getters - Encapsulation
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public String getGroup() {
        return group;
    }

    public String getPeriod() {
        return period;
    }

    public String getCategory() {
        return category;
    }

    public String[] getUses() {
        return uses;
    }

    public String getDescription() {
        return description;
    }

    // Setters - Encapsulation
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setAtomicWeight(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUses(String[] uses) {
        this.uses = uses;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-3s %-15s (Z=%d)", symbol, name, atomicNumber);
    }
}

