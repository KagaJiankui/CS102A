package com.cs102a;

import java.util.Scanner;

public class Assignment1_1 {
  public static void main(String[] args) {
    Scanline scanLine = new Scanline();
    int count = 0;
    boolean isDivisibleBy7 = false;
    boolean contains7 = false;
    int rows = scanLine.sc.nextInt();
    scanLine.sc.nextLine();
    int[][] range = scanLine.scanIntArray2D(rows, 2);
    for (int i = 0; i < rows; i++) {
      for (int j = range[i][0]; j <= range[i][1]; j++) {
        isDivisibleBy7 = j % 7 == 0;
        contains7 = containsDigitSeven(j);
        if (isDivisibleBy7 || contains7) {
          count++;
        }
      }
      System.out.println(count);
      count = 0;
    }
  }

  private static boolean containsDigitSeven(int number) {
    while (number > 0) {
      if (number % 10 == 7) {
        return true;
      }
      number /= 10;
    }
    return false;
  }

}
