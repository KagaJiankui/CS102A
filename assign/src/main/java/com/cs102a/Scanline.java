package com.cs102a;

import java.util.ArrayList;
import java.util.Scanner;

public class Scanline {
  public Scanner sc=new Scanner(System.in);
  /**
   * Scans the input for a 2D array of integers.
   *
   * @param  rows  the number of rows in the 2D array
   * @param  cols  the number of columns in the 2D array
   * @return       a 2D array of integers scanned from the input
   */
  public int[][] scanIntArray2D(int rows, int cols) {
    // Scanner sc = new Scanner(System.in);
    String[] scannedArray;
    int[][] result = new int[rows][cols];
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

  /**
   * Scans the input for integer values and stores them in a 2D array.
   *
   * @param  cols  the number of columns for the resulting 2D array
   * @return       a 2D array containing the scanned integer values
   */
  public int[][] scanIntArray2D(int cols) {
    Scanner sc = new Scanner(System.in);
    ArrayList<int[]> resultList = new ArrayList<>();
    try {
      while (sc.hasNextLine()) {
        String[] scannedArray = sc.nextLine().split(" ");
        int[] line = new int[scannedArray.length];
        for (int i = 0; (i < cols) && (i < scannedArray.length); i++) {
          line[i] = Integer.parseInt(scannedArray[i]);
        }
        resultList.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
      String simpleTrace = String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
      System.err.println(simpleTrace);
    } finally {
      sc.close();
    }
    return resultList.toArray(new int[0][]);
  }

}
