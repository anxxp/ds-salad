package Matrix;
/**
 * Print the elements of a 2D array in spiral pattern
 *
 * @author Anoop
 */
public class MatrixSpiralPrint {
  public static void main(String agrs[]) {
    int ROW = 3;
    int COL = 5;
    int[][] matrix = new int[ROW][COL];
    int count = 0;
    for (int i = 0; i < ROW; i++) {

      for (int j = 0; j < COL; j++) {
        matrix[i][j] = count;
        count++;
      }
    }

    System.out.println("---------------INPUT MATRIX ---------");
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        System.out.print((matrix[i][j] < 10) ? matrix[i][j] + "  " : matrix[i][j] + " ");
      }
      System.out.println("");
    }

    int rowMin = 0, rowMax = ROW - 1, colMin = 0, colMax = COL - 1;
    int i;
    while (rowMax >= rowMin && colMax >= colMin) {
      for (i = colMin; i <= colMax; i++) {
        System.out.print(matrix[rowMin][i] + " ");
      }
      rowMin++;

      for (i = rowMin; i <= rowMax; i++) {
        System.out.print(matrix[i][colMax] + " ");
      }
      colMax--;

      if (rowMax >= rowMin) {
        for (i = colMax; i >= colMin; i--) {
          System.out.print(matrix[rowMax][i] + " ");
        }
        rowMax--;
      }
      if (colMax >= colMin) {
        for (i = rowMax; i >= rowMin; i--) {
          System.out.print(matrix[i][colMin] + " ");
        }
        colMin++;
      }
    }
  }
}
