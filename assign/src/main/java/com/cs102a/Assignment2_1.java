package com.cs102a;

import java.util.Scanner;

public class Assignment2_1 {
  public static double dot1D(Integer[] x, double[] y) {
    try {
      if (x.length != y.length) {
        throw new IllegalArgumentException("x and y must have the same length");
      }
      double result = 0.0;
      for (int i = 0; i < x.length; i++) {
        result += x[i] * y[i];
      }
      return result;
    } catch (Exception e) {
      throw new RuntimeException("Error in multiplication: " + e.getMessage(), e);
    }
  }

  public static Integer[][] readArray(int rows, int cols, Scanner sc) {
    String[] scannedArray;
    Integer[][] result = new Integer[rows][cols];
    int index = 0;
    try {
      while ((sc.hasNextLine()) && (index < rows)) {
        scannedArray = sc.nextLine().split(" ");
        for (int i = 0; (i < cols) && (i < scannedArray.length); i++) {
          result[index][i] = Integer.parseInt(scannedArray[i]);
        }
        index++;
      }
    } catch (Exception e) {
      System.err.println("Exception " + e.hashCode() + ": " + e.getMessage());
    } finally {
      sc.close();
    }
    return result;
  }

  public static double[] maptoDoubleVector(Integer[] input) {
    double[] result = new double[input.length];
    for (int i = 0; i < input.length; i++) {
      switch (input[i]) {
        case 2:
          result[i] = 1;
          break;
        case 1:
          result[i] = -1;
          break;
        case 0:
          result[i] = -0.5;
          break;
        default:
          throw new IllegalArgumentException("Value " + input[i] + " at index " + i + " is not in range [2,1,0]");
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rows = 3;
    int cols = sc.nextInt();
    sc.nextLine();
    Integer[][] scoreArray = readArray(rows, cols, sc);
    double resultQi = dot1D(scoreArray[0], maptoDoubleVector(scoreArray[1]));
    double resultOther = dot1D(scoreArray[0], maptoDoubleVector(scoreArray[2]));
    int cmp = Double.compare(resultQi, resultOther);
    if (cmp > 0) {
      System.out.println("Qi won");
    } else if (cmp < 0) {
      System.out.println("Qi lost");
    } else {
      System.out.println("Qi need another round");
    }
  }
}
