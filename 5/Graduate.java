/**
 * Subclass of Student and Man class.
 */
public class Graduate extends Student {
    private final String title;
    private final int year;

    /**
     * Constructor for Graduate object
     * @param title
     * @param name
     * @param surname
     * @param id
     * @param year This is the year of graduation
     * @param v This is the first out of 3 grades provided by this class
     * @param v1
     * @param v2
     */
    public Graduate(String title, String name, String surname, int id, int year, double v, double v1, double v2) {
        super(name, surname, id, v, v1, v2);
        this.title = title;
        this.year = year;
    }

    /**
     * Getter for graduate's academic title
     * @return string academic title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the year of graduation
     * @return int year
     */
    public int getYear() {
        return year;
    }

    /**
     * Overriden method to print all information about graduate
     * @return string of characters
     */
    @Override
    public String toString() {
        return getTitle() + " " + super.toString() + ", year of graduation: " + getYear();
    }
}
