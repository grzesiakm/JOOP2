import java.util.ArrayList;
import java.util.Random;

public class Matrix {
    private final int row;
    private final int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private final double[][] matrix;

    public Matrix(int row, int col, boolean flag) {
        Random r = new Random();
        this.row = row;
        this.col = col;
        this.matrix = new double[row][col];

        if (flag) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = r.nextDouble();
                }
            }
        }
        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0.0;
                }
            }
        }
    }

    public void printCheck() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public double getMatrix(int a, int b) {
        return matrix[a][b];
    }

    public void add(int a, int b, double num) {
        matrix[a][b] += num;
    }


    public static Matrix multiplyEASY(Matrix m1, Matrix m2) {
        Matrix c = new Matrix(m1.row, m2.col, false);
        if (m1.col == m2.row) {
            for (int i = 0; i < m1.row; i++) {
                for (int j = 0; j < m2.col; j++) {
                    for (int k = 0; k < m1.col; k++) {
                        c.add(i, j, m1.getMatrix(i ,k) * m2.getMatrix(k, j));
                    }
                }
            }
        }
        else {
            System.err.println("ERROR: These two matrices cannot be multiplied!");
        }
        return c;
    }

    public static Matrix multiplyParallel(Matrix m1, Matrix m2) throws InterruptedException {
        Matrix c = new Matrix(m1.row, m2.col, false);
        if (m1.col == m2.row) {
            List<Thread> threads = new ArrayList<>(m1.row * m2.col);
            int index = 0;

            for (int i = 0; i < m1.row; i++) {
                for (int j = 0; j < m2.col; j++) {
                    final int Row = i;
                    final int Col = j;
                    Thread thread = new Thread(() -> {
                        for (int k = 0; k < m1.getCol(); k++) {
                            c.add(Row, Col, m1.getMatrix(Row, k) * m2.getMatrix(k, Col));
                        }
                    });
                    threads.add(index, thread);
                    threads.get(index).start();
                    index++;
                }
            }

            for (int i = 0; i < m1.row * m2.col; i++) {
                try {
                    threads.get(i).join();
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.err.println("ERROR: These two matrices cannot be multiplied!");
        }
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Matrix))
            return false;
        Matrix other = (Matrix) o;
        if(this.getRow() != other.getRow() || this.getCol() != other.getCol())
            return false;

        for(int i = 0; i < this.getRow(); i++){
            for(int j = 0; j < this.getRow(); j++) {
                if(getMatrix(i, j) != other.getMatrix(i, j)) {
                    return false;

                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        int len = args.length;

        if (len != 3) {
            System.err.println("ERROR: Give exactly 3 numbers (with space between them)!");
            System.exit(1);
        }

        for (String arg: args) {
            if (!isInt(arg)) {
                System.err.println("ERROR: All args must be integers!");
                System.exit(1);
            }
        }

        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int P = Integer.parseInt(args[2]);

        Matrix A = new Matrix(N, M, true);
        Matrix B = new Matrix(M, P, true);
        Matrix C1 = multiplyEASY(A, B);
        Matrix C2 = multiplyParallel(A, B);

        boolean b = C1.equals(C2);
        if (b) {
            System.out.println("Both methods give the same results.\n");
        }
        else {
            System.out.println("Something is wrong... Results are not the same.\n");
        }

        C1.printCheck();
        System.out.println();
        C2.printCheck();
    }

}
