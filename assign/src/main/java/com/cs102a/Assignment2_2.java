package com.cs102a;

import java.util.Scanner;

public class Assignment2_2 {
  public static Integer[][] readLists3Rows() {
    Scanner scanner = new Scanner(System.in);
    Integer[] cols=new Integer[3];
    Integer[][] result = new Integer[3][];
    String[] rowString=new String[3];
    for (int i = 0; i < 3; i++) {
      cols[i]=scanner.nextInt();
      scanner.nextLine();
      rowString[i] = scanner.nextLine();
    }
  }
}
