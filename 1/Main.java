import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

class Main {
  public static void generate(int n, double r_max) {
    int counter = 0;
    double xx, yy;
    Random rand = new Random();
    try {
      FileWriter file = new FileWriter("circle.dat");
      while(counter < n){
        xx = rand.nextDouble() * r_max;
        yy = rand.nextDouble() * r_max;
        if((xx*xx + yy*yy) <= r_max*r_max){
          counter++;
          System.out.println(counter + ". " + "(" + xx + ", " + yy + ")");
          file.write(xx + " " + yy + "\n");
        }
      }
      file.close();
    }
    catch (IOException ex){
      System.out.println("The file was not created!");
    }
  }


  public static void main(String[] args) {
    System.out.println("Random n points inside circle with centre in (0,0) and set r_max:");
    int n = Integer.parseInt(args[0]);
    double r_max = Double.parseDouble(args[1]);
    generate(n, r_max);
  }
}