import java.util.Arrays;
import java.lang.reflect.*;

public class Lab09 {
    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    }


    public static void main(String[] args) {
        System.out.println("Oczekiwane dzialanie podaj w cudzyslowie przy wywolaniu programu.\n");
        int number = args.length;
        System.out.println(args[0]);
        for (String arg: args) {
            if (arg.equals(" ")) {
                number--;
            }
        }
        if (number == 0){
            System.err.println("Nie podano nic do obliczenia!");
        }
        else {
            String[] splitted = splitArgs(args[0]);
            try {
                Class<?> mathClass = Class.forName("java.lang.Math");
                try {
                    if (splitted.length > 3 || splitted.length == 1) {
                        throw new Exception();
                    }
                }
                catch(Exception e) {
                    System.err.println("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby.");
                    System.exit(0);
                }

                var argsType = new Class[splitted.length - 1];
                for (int i = 0; i < splitted.length - 1; i++) {
                    argsType[i] = double.class;
                }

                double[] argsValue = new double[splitted.length - 1];
                try {
                    for (int i = 0; i < splitted.length - 1; i++) {
                        argsValue[i] = Double.parseDouble(splitted[i + 1]);
                    }
                }
                catch(NumberFormatException e) {
                    System.err.println("Argumenty funkcji musza byc liczbami!");
                    System.exit(0);
                }

                Method m = null;
                try {
                    m = mathClass.getMethod(splitted[0], argsType);
                }
                catch(NoSuchMethodException e) {
                    System.err.println("Nie ma takiej metody!");
                    System.exit(0);
                }

                if (m.getParameterCount() == 1) {
                    System.out.println("Wynik: " + m.invoke(m, argsValue[0]));
                }
                else if (m.getParameterCount() == 2) {
                    System.out.println("Wynik: " + m.invoke(m, argsValue[0], argsValue[1]));
                }
                else if (m.getParameterCount() == 3) {
                    System.out.println("Wynik: " + m.invoke(m, argsValue[0], argsValue[1], argsValue[2]));
                }
                else {
                    System.err.println("Nie można obliczyc wyniku!");
                    System.exit(0);
                }
            }
            catch(Exception e) {
                System.err.println("Nie ma takiej klasy!");
                System.exit(0);
            }
        }
    }
}
