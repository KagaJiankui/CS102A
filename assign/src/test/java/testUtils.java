import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class testUtils {

/**
   * Generates a random 2D array of integers with the specified number of rows and
   * columns.
   *
   * @param rows the number of rows in the 2D array
   * @param cols the number of columns in the 2D array
   * @return the randomly generated 2D array
   */
  public static int[][] generateRandom2DArray(int rows, int cols) {
    int[][] result = new int[rows][cols];
    Random random = new Random();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = random.nextInt(65536);
      }
    }
    return result;
  }

  /**
   * Writes the given 2D array of integers to a file with a filename based on the
   * current datetime.
   *
   * @param array the 2D array of integers to be written to the file
   * @return void
   */
  public static void writeTestSamplesToFile(int[][] array) {
    LocalDateTime datetime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    String filename = "test_samples_" + datetime.format(formatter) + ".txt";
    try {
      FileWriter fileWriter = new FileWriter(filename);
      PrintWriter printWriter = new PrintWriter(fileWriter);
      for (int[] row : array) {
        for (int num : row) {
          printWriter.print(num + " ");
        }
        printWriter.println();
      }
      printWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Reads test samples from a file and returns them as a 2D array of integers.
   *
   * @param filename the name of the file to read the test samples from
   * @return a 2D array of integers representing the test samples
   */
  public static int[][] readTestSamplesFromFile(String filename) {
    List<int[]> rows = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(" ");
        int[] row = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        rows.add(row);
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rows.toArray(new int[0][]);
  }

  /**
   * Formats a 2D array to a string.
   *
   * @param array the 2D array to be formatted
   * @return the formatted string
   */
  public static String format2DArrayToString(int[][] array) {
    StringBuilder result = new StringBuilder();
    for (int[] row : array) {
      for (int i = 0; i < row.length; i++) {
        result.append(row[i]);
        if (i < row.length - 1) {
          result.append(" ");
        }
      }
      result.append("\n");
    }
    return result.toString();
  }

  /**
   * Prints a 2D array with color-coded elements to the console.
   *
   * @param array the 2D array to be pretty printed
   * @return void
   */
  public static void prettyPrint2DArray(int[][] array) {
    StringBuilder sb = new StringBuilder();
    for (int[] row : array) {
      for (int num : row) {
        String color = num == 0 ? "\u001B[32m" : "\u001B[31m";
        sb.append(color);
        sb.append(String.format("%4d", num));
        sb.append("\u001B[0m");
      }
      sb.append("\n");
    }
    System.out.print(sb.toString());
  }

}
