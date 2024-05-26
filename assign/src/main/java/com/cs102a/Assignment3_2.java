package com.cs102a;

import java.util.Scanner;

public class Assignment3_2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] scanned = scanner.nextLine().split(" ");
    scanner.close();
    String integeString = scanned[0];
    int segSize = Integer.parseInt(scanned[1]);
    int[] result = stringSegmentize(integeString, segSize);
    System.out.println(arraySum(result));
  }

  private static String reverseString(String str) {
    if (str == null) {
      return null;
    }
    char[] chars = str.toCharArray();
    int n = chars.length - 1;
    for (int i = 0; i < chars.length / 2; i++) {
      char temp = chars[i];
      chars[i] = chars[n - i];
      chars[n - i] = temp;
    }
    return new String(chars);
  }

  private static int[] stringSegmentize(String str, int seglen) {
    int l = str.length();
    int n;
    int[] result;
    String subString;
    if (l % seglen > 0) {
      n = l / seglen + 1;
      result = new int[n];
      for (int i = 0; i < n - 1; i++) {
        subString = str.substring(i * seglen, (i + 1) * seglen);
        result[i] = Integer.parseInt(reverseString(subString));
      }
      subString = str.substring((n - 1) * seglen);
      result[n - 1] = Integer.parseInt(reverseString(subString));
    } else {
      n = l / seglen;
      result = new int[n];
      for (int i = 0; i < n; i++) {
        subString = str.substring(i * seglen, (i + 1) * seglen);
        result[i] = Integer.parseInt(reverseString(subString));
      }
    }
    return result;
  }

  private static long arraySum(int[] arr) {
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }
}