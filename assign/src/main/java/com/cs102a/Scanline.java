package com.cs102a;

import java.util.Scanner;

public class Scanline {
  public int[][] scanInt(int rows, int cols) {
    Scanner sc = new Scanner(System.in);
    String scannedString;
    int[][] result = new int[rows][cols];
    int index = 0;
    try {
      while ((sc.hasNextLine()) && (index < rows)) {
        scannedString = sc.nextLine();
        for (int i = 0; (i < cols) && (i < scannedString.length()); i++) {
          result[index][i] = Character.getNumericValue(scannedString.charAt(i));
        }
        index++;
      }
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      sc.close();
    }
    return result;
  }
}
