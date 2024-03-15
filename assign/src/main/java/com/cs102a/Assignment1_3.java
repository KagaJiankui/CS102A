package com.cs102a;

import java.util.Scanner;

public class Assignment1_3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numTestcases = in.nextInt();
    int[] dataDays0 = new int[6];
    int day1 = 0;
    int day2 = 0;
    for (int j = 0; j < numTestcases; j++) {
      for (int i = 0; i < 6; i++) {
        dataDays0[i] = 0;
        dataDays0[i] = in.nextInt();
      }
      day1 = sum(dataDays0[0], dataDays0[1], dataDays0[2]);
      day2 = sum(dataDays0[3], dataDays0[4], dataDays0[5]);
      System.out.println(day2 - day1);
    }
  }

  public static int sum(int years, int months, int dates) {
    int dayfromYears = 0;
    int dayfromMonths = 0;
    int dayfromDates = dates;
    int leapYears = (years - 1) / 13 + ((years == 0) ? 0 : 1);
    dayfromYears = 916 * years + leapYears;
    boolean flagLeapyears = (years % 13) == 0;
    dayfromMonths = 61 * (months - 1) + ((months > 5) ? 1 : 0) + ((months > 3) ? 1 : 0) * (flagLeapyears ? 1 : 0);
    return dayfromYears + dayfromMonths + dayfromDates;
  }
}
