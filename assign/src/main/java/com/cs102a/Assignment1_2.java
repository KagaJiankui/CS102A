package com.cs102a;

import java.util.Scanner;

public class Assignment1_2 {
  public static void main(String[] args) {
    //Convert an integer in decimal into septenary(base7), avoid using library.

    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt();
    sc.nextLine();
    int[] inputNumbers = new int[rows];
    for (int i = 0; i < rows; i++) {
      inputNumbers[i] = Integer.parseInt(sc.nextLine());
    }
    for (int decNumbers : inputNumbers) {
      int index = 0;
      long septNumber = 0;
      while (decNumbers > 0) {
        int rem = decNumbers % 7;
        septNumber += rem * Math.pow(10, index);
        decNumbers /= 7;
        index++;
      }
      System.out.println(septNumber);
    }
  }
}
