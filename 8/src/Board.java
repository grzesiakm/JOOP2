import java.util.Random;
import java.util.Scanner;

public class Board {
    private char[][] board;

    public Board(int x, double P) {
        board = new char[x][x];
        Random generator = new Random();
        for (int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                double p = generator.nextDouble();
                if (p < P)
                    board[i][j] = 'X';
                else
                    board[i][j] = ' ';
            }
        }
        for (int k = 0; k < x; k++){
            board[x-1][k] = 'X';
        }
        board[0][0] = 'o';
    }

    public void printBoard(char[][] board, int x) {
        for (int i = 0; i < x; i++){
            for(int j = 0; j < x; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void move(char[][] board, char direction, int i0, int j0, int nx) throws WallException, OptionNotRecognizedException {
        switch(direction){
            case 'a':
                int y = j0 - 1;
                if (y >= nx || y < 0){
                    throw new WallException("BLAD: Wyjscie poza plansze!");
                }
                else {
                    board[i0][j0] = ' ';
                    board[i0][y] = 'o';
                    break;
                }

            case 'd':
                y = j0 + 1;
                if (y >= nx || y < 0){
                    throw new WallException("BLAD: Wyjscie poza plansze!");
                }
                else {
                    board[i0][j0] = ' ';
                    board[i0][y] = 'o';
                    break;
                }
            case 'w':
                int x = i0 - 1;
                if (x >= nx || x < 0){
                    throw new WallException("BLAD: Wyjscie poza plansze!");
                }
                else{
                    board[i0][j0] = ' ';
                    board[x][j0] = 'o';
                    break;
                }
            case 's':
                x = i0 + 1;
                if (x >= nx || x < 0){
                    throw new WallException("BLAD: Wyjscie poza plansze!");
                }
                else {
                    board[i0][j0] = ' ';
                    board[x][j0] = 'o';
                    break;
                }
            default:
                throw new OptionNotRecognizedException("BLAD: Niepoprawna opcja ruchu!");
        }
    }

    public void printOptions(){
        System.out.println("Dostepne opcje:");
        System.out.println("'a' ⇒ gracz porusza się na planszy w lewo");
        System.out.println("'d' ⇒ gracz porusza się na planszy w prawo");
        System.out.println("'w' ⇒ gracz porusza się na planszy w górę");
        System.out.println("'s' ⇒ gracz porusza się na planszy w dół");
        System.out.println("'q' ⇒ zakończenie gry");
        System.out.println("\n");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nx;
        do {
            System.out.println("Podaj liczbe calkowita wieksza od 1: ");
            while (!sc.hasNextInt()){
                System.err.println("BLAD: Podaj liczbe calkowita!");
                System.out.println("Podaj liczbe calkowita wieksza od 1: ");
                sc.next();
            }
            nx = sc.nextInt();
            if(nx <= 1) System.err.println("BLAD: Zbyt mala wartosc nx: " + nx + "!");
        } while (nx <= 1);
        double P = 0.3;
        int i0 = 0;
        int j0 = 0;
        Board myGame = new Board(nx, P);
        myGame.printOptions();
        myGame.printBoard(myGame.board, nx);
        System.out.println("\n");
        char z = sc.next().charAt(0);

        while (z != 'q'){
            System.out.println("Wybierz opcje: " + z + "\n");
            try {
                myGame.move(myGame.board, z, i0, j0, nx);
            }
            catch (OptionNotRecognizedException | WallException e){
                System.err.println(e);
                myGame.printOptions();
            }
            myGame.printBoard(myGame.board, nx);
            z = sc.next().charAt(0);
        }
        sc.close();
        System.out.println("WYJSCIE Z GRY . . .");
    }
}
