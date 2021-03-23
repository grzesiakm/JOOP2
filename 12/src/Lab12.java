import java.io.*;
import java.nio.file.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String read;
            String[] strings = {""};

            while(strings.length != 2) {
                System.out.println("Podaj nazwy dwóch plików do odczytania.");
                read = br.readLine();
                strings = read.split(" ");
                if(strings.length != 2)
                    System.out.println("BLAD: Podaj nazwy dokładnie dwóch plików!");
            }

            boolean flag = true;
            String fileName = "";

            while(flag) {
                System.out.println("\nPodaj nazwę pliku do zapisu: ");
                fileName = br.readLine();
                if (Files.exists(Paths.get(fileName))){
                    System.out.println("\nTaki plik już istnieje, czy chcesz go nadpisać? [T/N]:");
                    String ans = br.readLine();
                    if(ans.equals("T")) flag = false;
                    else if(ans.equals("N")) flag = true;
                    else {
                        System.err.println("BLAD: Podaj znak z pytania!");
                        flag = true;
                    }
                }
                else flag = false;
            }

            BufferedReader reader1 = Files.newBufferedReader(Paths.get(strings[0]));
            BufferedReader reader2 = Files.newBufferedReader(Paths.get(strings[1]));
            String line1, line2;
            ArrayList<String> writer = new ArrayList<>();
            ArrayList<String> x = new ArrayList<>();

            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null ) {
                String[] x1 = line1.split(" ");
                String[] x2 = line2.split(" ");

                if(!x1[0].equals(x2[0])) {
                    System.out.println("Współrzędne x nie są identyczne dla obu plików! " + x1[0] + " " + x2[0]);
                }
                else {
                    writer.add(String.valueOf(Double.parseDouble(x1[1]) +  Double.parseDouble(x2[1])));
                    x.add(String.valueOf(Double.parseDouble(x1[0])));

                }
            }

            BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName));
            for(int i = 0; i < writer.size(); i++){
                bw.write(x.get(i) + " " + writer.get(i));
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e) {
            System.err.println("IOException");
            System.exit(1);
        }
    }
}
