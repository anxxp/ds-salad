package Matrix;
/**
 * Rotate a 2D- square matrix 90 degree clock-wise
 *
 * @author Anoop
 */
public class MatrixRotation {

  public static void main(String args[]) {
    int SIZE = 5;
    int[][] matrix = new int[SIZE][SIZE];
    int count = 0;
    for (int i = 0; i < SIZE; i++) {

      for (int j = 0; j < SIZE; j++) {
        matrix[i][j] = count;
        count++;
      }
    }

    System.out.println("---------------INPUT MATRIX ---------");
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print((matrix[i][j] < 10) ? matrix[i][j] + "  " : matrix[i][j] + " ");
      }
      System.out.println("");
    }

    /*ROTATION LOGIC START*/

    int level = 0;
    int start = 0;
    int end = SIZE - 1;
    while (level < SIZE / 2) {

      for (int offset = 0; offset < end - start; offset++) {
        swap(matrix, start, start + offset, start + offset, end);
        swap(matrix, start, start + offset, end, end - offset);
        swap(matrix, start, start + offset, end - offset, start);
      }
      level++;
      start++;
      end--;
    }

    // ROTATION LOGIC END

    System.out.println("---------------OUTPUT MATRIX ---------");
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print((matrix[i][j] < 10) ? matrix[i][j] + "  " : matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }

  public static void swap(int[][] matrix, int fRow, int fCol, int sRow, int sCol) {

    // System.out.println("( "+fRow+","+fCol+" )"+" --> "+"( "+sRow+","+sCol+" )");
    int temp = matrix[fRow][fCol];
    matrix[fRow][fCol] = matrix[sRow][sCol];
    matrix[sRow][sCol] = temp;
  }
}
