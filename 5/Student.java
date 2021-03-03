/**
 * Subclass of Man class.
 */
public class Student extends Man {
    private final int id;
    private final double v, v1, v2;

    /**
     * Constructor for Student object
     * @param name
     * @param surname
     * @param id
     * @param v This is the first out of 3 grades provided by this class
     * @param v1
     * @param v2
     */
    public Student(String name, String surname, int id, double v, double v1, double v2) {
        super(name, surname);
        this.id = id;
        this.v = v;
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * Getter for student's id number
     * @return int id number
     */
    public int getId() {
        return id;
    }

    /**
     * Getters for Student's grades
     * @return double value - grade
     */
    public double getV() {
        return v;
    }

    public double getV1() {
        return v1;
    }

    public double getV2() {
        return v2;
    }

    /**
     * Overriden method from abstract class
     * @return the average grades score for student
     */
    public double average() {
        return (getV() + getV1() + getV2())/3.0;
    }

    /**
     * Overriden method to print all information about student
     * @return string of characters
     */
    @Override
    public String toString() {
        return super.toString() + ", id number: " + getId() + ", grades: [" + getV() + ", " + getV1() + ", " + getV2() + "]";
    }

    /**
     Implementation of abstract method that returns student with better average grades score
     * @param ob This is object of abstract class
     * @return The object that fulfills the condition of comparison method
     */
    @Override
    public Man compare(Man ob) {
        if (!(ob instanceof Student)) {
            return null;
        }
        if (this.average() > ob.average()) {
            return this;
        }
        else {
            return ob;
        }
    }
}
