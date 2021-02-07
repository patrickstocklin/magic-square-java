public class MagicSquare {

    static int[][] eg = new int[][] {
            new int[] {4,3,8},
            new int[] {9,5,1},
            new int[] {2,7,6}
    };

    static int[][] eg2 = new int[][] {
            new int[] {2,16,13,3},
            new int[] {11,5,8,10},
            new int[] {7,9,12,6},
            new int[] {14,4,1,15}
    };

    public static int calculateM(int[][] square) {
        int n = square.length;
        return n * ( (n*n) + 1) / 2;
    }

    public static boolean validateMagicSquare(int[][] square) {
        int n = square.length;
        int m = calculateM(square);
        for (int i = 0; i < n; i++) {
            if (!validateRow(square, m, i)) return false;
        }
        for (int j = 0; j < n; j++) {
            if (!validateCol(square, m, j)) return false;
        }
        if (!validateDiags(square, m)) return false;

        return true;
    }

    public static boolean validateRow(int[][] square, int m, int row) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[row][i];
        }
        return (sum == m);
    }

    public static boolean validateCol(int[][] square, int m, int col) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][col];
        }
        return (sum == m);
    }

    public static boolean validateDiags(int[][] square, int m) {
        int sumOne = 0;
        for (int i = 0; i < square.length; i++) {
            sumOne += square[i][i];
        }
        int sumTwo = 0;
        for (int j = 0; j < square.length; j++) {
            sumTwo += square[square.length - 1 - j][j];
        }
        return sumOne == m && sumTwo == m;
    }

    public static void main(String[] args) {
        System.out.println("Hello Magic Squares");
        System.out.println(calculateM(eg)); //15
        System.out.println(validateMagicSquare(eg)); //true
        System.out.println(validateMagicSquare(eg2)); //true
    }
}
