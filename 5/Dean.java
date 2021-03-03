/**
 * Subclass of Man class.
 */
public class Dean extends Man {
    private final String title;
    private final int yearFrom, yearTo;

    /**
     * Constructor for Dean object
     * @param title
     * @param name
     * @param surname
     * @param yearFrom This is a year of the beginning of the dean's cadence
     * @param yearTo This is a year of the end of the dean's cadence
     */
    public Dean(String title, String name, String surname, int yearFrom, int yearTo) {
        super(name, surname);
        this.title = title;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    /**
     * Getter for dean's academic title
     * @return String title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the year of the beginning dean's cadence
     * @return int yearFrom
     */
    public int getYearFrom() {
        return yearFrom;
    }

    /**
     * Getter for the year of the enf of dean's cadence
     * @return int yearTo
     */
    public int getYearTo() {
        return yearTo;
    }

    /**
     * Overriden method to print all information about dean
     * @return string of characters
     */
    @Override
    public String toString() {
        return getTitle() + " " + super.toString() + ", Dean of the Faculty from " + getYearFrom() + " to " + getYearTo() + ".";
    }

    /**
     * Implementation of abstract method that returns newer dean
     * @param ob This is object of abstract class
     * @return The object that fulfills the condition of comparison method
     */
    @Override
    public Man compare(Man ob) {
        if (!(ob instanceof Dean)) {
            return null;
        }
        if (this.getYearTo() > ((Dean)ob).getYearTo()) {
            return this;
        }
        else {
            return ob;
        }
    }

    /**
     * Overriden method from abstract class
     * @return the average grades score which is not applicable for dean
     */
    @Override
    public double average() {
        System.out.print(" [Average not applicable] ");
        return super.average();
    }
}
