/**
 * Abstarct class Man that represents a person.
 */

abstract class Man {
    private final String name;
    private final String surname;

    /**
     * Constructor for the abstract object
     * @param name
     * @param surname
     */
    public Man(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Getter for person's surname
     * @return string surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Getter for person's name
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * Overriden method to print the common part for all objects
     * @return string of characters
     */
    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }

    /**
     * Abstract class to be implemented depending on the instance of object
     * @param ob This is object of abstract class
     * @return The object that fulfills the condition of comparison method
     */
    abstract public Man compare(Man ob);

    /**
     * Polymorphic method that calculates the average grades score
     * @return double value - score
     */
    public double average() {
        return 0.0;
    }
}
