import static java.lang.Math.abs;

public class Equation2 {
    private static void calculate(double a, double b, double c){
        double delta = b*b - 4*a*c;
        if (delta < 0){
            double xR = -b / 2*a;
            double xI = Math.sqrt(abs(delta)) / 2*a;
            System.out.println("x1 = " + xR + " + " + xI + "i,  x2 = " + xR + " - " + xI + "i");
        }
        else if(delta == 0){
            double x = -b / 2*a;
            System.out.println("x = " + x);
        }
        else{
            double x1 = (-b + Math.sqrt(delta))/2*a;
            double x2 = (-b - Math.sqrt(delta))/2*a;
            System.out.println("x1 = " + x1 + ",  x2 = " + x2);
        }
    }

    public static void main(String[] args) {
        calculate(Double.valueOf(args[0]), Double.valueOf(args[1]), Double.valueOf(args[2]));
    }

}