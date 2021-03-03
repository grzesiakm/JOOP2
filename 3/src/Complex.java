import static java.lang.Math.abs;

public class Complex {
    private double re, im = 0.0;

    public Complex() {}
    Complex(double Re) { re = Re; }
    Complex (double Re, Double Im) {
        re = Re;
        im = Im;
    }

    private static String str(double r, double i){
        if (i < 0){
            return r + " - " + abs(i) + "i";
        }
        else{
            return r + " + " + i + "i";
        }
    }

    public double getRe() { return re; }
    public double getIm() { return im; }

    private static final String I = 1.0+"i";
    private static final double ZERO = 0.0;
    private static final double ONE = 1.0;

    private static String add(Complex c1, Complex c2){
        double re = c1.getRe() + c2.getRe();
        double im = c1.getIm() + c2.getIm();
        return str(re, im);
    }

    private static String subtract(Complex c1, Complex c2){
        double re = c1.getRe() - c2.getRe();
        double im = c1.getIm() - c2.getIm();
        return str(re, im);
    }

    private static String multiply(Complex c1, Complex c2){
        double re = c1.getRe()*c2.getRe() - c1.getIm()*c2.getIm();
        double im = c1.getIm()*c2.getRe() + c1.getRe()*c2.getIm();
        return str(re, im);
    }

    private static String multiply(Complex c1, double num){
        double re = c1.getRe()*num;
        double im = c1.getIm()*num;
        return str(re, im);
    }

    private static String divide(Complex c1, Complex c2){
        double re = (c1.getRe() * c2.getRe() + c1.getIm() * c2.getIm()) / (c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm());
        double im = (c1.getIm() * c2.getRe() - c1.getRe() * c2.getIm()) / (c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm());
        return str(re, im);
    }

    private double mod(){
        return Math.sqrt(getRe()*getRe() + getIm()*getIm());
    }

    private static String sqrt(double num){
        if(num > 0){
            return String.valueOf(Math.sqrt(num));
        }
        else{
            return Math.sqrt(abs(num)) + "i";
        }
    }

    private Boolean equals(Complex c){
        return re == c.getRe() && im == c.getIm();
    }

    @Override
    public String toString() {
        String r = String.valueOf(re);
        String i = String.valueOf(abs(im));
        if (im < 0){
            return r + " - " + i + "i";
        }
        else if (im == 0){
            return r;
        }
        else if (re == 0){
            return i + "i";
        }
        else{
            return r + " + " + i + "i";
        }
    }

    private void conjugate(){ im = -im; }

    private void opposite() {
        re = -re;
        conjugate();
    }

    public static void test() {
        // Wykorzystanie konstruktorów:
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0, 5.1)); // 5.1i
        System.out.println();

        // Stałe typu Complex:
        System.out.println(Complex.I); // 1.0i
        System.out.println(Complex.ZERO); // 0.0
        System.out.println(Complex.ONE); // 1.0
        System.out.println();

        // Wykorzystanie metod zwracających wynik obliczeń:
        System.out.println("Re(c1) = " + c1.getRe()); // Re(c1) = 2.5
        System.out.println("Im(c1) = " + c1.getIm()); // Im(c1) = 13.1
        System.out.println("c1 + c2 = " + Complex.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i
        System.out.println("c1 - c2 = " + Complex.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i
        System.out.println("c1 * c2 = " + Complex.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i
        System.out.println("c1 * 15.1 = " + Complex.multiply(c1, 15.1)); // c1 * 15.1 = 37.75 + 197.81i
        System.out.println("c1 / c2 = " + Complex.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 - 1.4932931836846426i
        System.out.println("|c1| = " + c1.mod()); // |c1| = 13.336416310238668
        System.out.println("sqrt(243.36) = " + Complex.sqrt(243.36)); // sqrt(243.36) = 15.6
        System.out.println("sqrt(-243.36) = " + Complex.sqrt(-243.36)); // sqrt(-243.36) = 15.6i
        Complex c3 = new Complex(2.5, 13.1);
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equals(c3)); // true
        // Poniższe wywołanie - dla chętnych :)
        System.out.println(c1.equals("test ze zlym obiektem")); // false
        System.out.println();

        // Metoda zamieniająca liczbę na jej sprzężenie:
        c1.conjugate();
        System.out.println("c1* = " + c1); // c1* = 2.5 - 13.1i

        // Metoda zamieniająca liczbę na przeciwną:
        c1.opposite();
        System.out.println("-c1 = " + c1); // -c1 = -2.5 + 13.1i
    }

    public static void main(String[] args) { test(); }

}