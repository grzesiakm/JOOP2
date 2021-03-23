import java.util.Random;
import java.util.Scanner;

public class Board {
    private char[][] board;

    public Board(int x, int y, double P) {
        board = new char[x][y];
        Random generator = new Random();
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                double p = generator.nextDouble();
                if (p < P)
                    board[i][j] = 'X';
                else
                    board[i][j] = ' ';
            }
        }
        for (int k = 0; k < y; k++){
            board[x-1][k] = 'X';
        }
        board[x-1][y-1] = ' ';
        board[0][0] = 'o';
    }

    public void printBoard(char[][] board, int x, int y){
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void step(Direction dir, int i0, int j0, CheckStep check, int x, int y) {
        if (check.test(board, i0, j0, dir)) {
            board[i0][j0] = ' ';
            board[i0 + dir.getX()][j0 + dir.getY()] = 'o';
            if (board[x-1][y-1] == 'o'){
                System.out.println("GRATULACJE, WYGRALES!");
                System.exit(0);
            }
        }
        else {
            System.out.println("NIE UDALO SIE WYKONAC TAKIEGO RUCHU.");
        }
    }

    CheckStep check = (char[][] board, int i0, int j0, Direction dir) -> board[i0 + dir.getX()][j0 + dir.getY()] == ' ';


    public static void main(String[] args) {
//        int nx = Integer.parseInt(args[0]);
//        int ny = Integer.parseInt(args[1]);
//        double P = Double.parseDouble(args[2]);
        int nx = 6;
        int ny = 5;
        double P = 0.4;
        int i0 = 0;
        int j0 = 0;
        Board myGame = new Board(nx, ny, P);
        System.out.println("Dostepne opcje:");
        System.out.println(Option.RESET.toString());
        System.out.println(Option.LEFT.toString());
        System.out.println(Option.RIGHT.toString());
        System.out.println(Option.UP.toString());
        System.out.println(Option.DOWN.toString());
        System.out.println(Option.EXIT.toString() + "\n");
        myGame.printBoard(myGame.board, nx, ny);
        System.out.println("\n");


        Scanner sc = new Scanner(System.in);
        char z = sc.next().charAt(0);
        while (z != 'q'){
            System.out.println("Wybierz opcje: " + z + "\n");
            switch (z){
                case 'h':
                    myGame.step(Direction.LEFT, i0, j0, myGame.check, nx, ny);
                    myGame.printBoard(myGame.board, nx, ny);
                    i0 += Direction.LEFT.getX();
                    j0 += Direction.LEFT.getY();
                    break;
                case 'l':
                    myGame.step(Direction.RIGHT, i0, j0, myGame.check, nx, ny);
                    myGame.printBoard(myGame.board, nx, ny);
                    i0 += Direction.RIGHT.getX();
                    j0 += Direction.RIGHT.getY();
                    break;
                case 'j':
                    myGame.step(Direction.UP, i0, j0, myGame.check, nx, ny);
                    myGame.printBoard(myGame.board, nx, ny);
                    i0 += Direction.UP.getX();
                    j0 += Direction.UP.getY();
                    break;
                case 'k':
                    myGame.step(Direction.DOWN, i0, j0, myGame.check, nx, ny);
                    myGame.printBoard(myGame.board, nx, ny);
                    i0 += Direction.DOWN.getX();
                    j0 += Direction.DOWN.getY();
                    break;
                case '0':
                    myGame = new Board(nx, ny, P);
                    myGame.printBoard(myGame.board, nx, ny);
                    i0 = 0;
                    j0 = 0;
                    break;
            }
            z = sc.next().charAt(0);
        }
        sc.close();
    }
}
