// package com.cs102a;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cs102a.Assignment1_1;
import com.cs102a.Scanline;

/**
 * ScanlineTests
 */
public class ScanlineTests {
  private static ByteArrayInputStream testIn;
  private static ByteArrayOutputStream testOut;

  private int row_test = 4;
  private int col_test = 5;

  // testUtils util = new testUtils();

  @BeforeAll
  public static void setUpOutput() {
    testOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(testOut));
  }

  private static void provideInput(String data) {
    testIn = new ByteArrayInputStream(data.getBytes());
    System.setIn(testIn);
  }

  private static String getOutput() {
    return testOut.toString();
  }

  @AfterAll
  public static void restoreSystemInputOutput() {
    System.setIn(System.in);
    System.setOut(System.out);
  }

  @Test
  public void testScanInput() {
    Scanline linescanner = new Scanline();
    // Simulate command line input from a random 2D int array
    String input;
    int[][] expected = testUtils.generateRandom2DArray(row_test, col_test);
    int[][] result;
    input = testUtils.format2DArrayToString(expected);
    provideInput(input);

    // Compare the read array with test samples
    result = linescanner.scanIntArray2D(row_test, col_test);
    assertArrayEquals(expected, result);
    // write a nested for to compare the result with the test samples

    for (int i = 0; i < row_test; i++) {
      for (int j = 0; j < col_test; j++) {
        result[i][j] = Math.abs(expected[i][j] - result[i][j]);
      }
    }
    testUtils.prettyPrint2DArray(result);
    restoreSystemInputOutput();
  }

  // Large batch array test
  @Test
  public void testScanInputLarge() {
    Scanline linescanner = new Scanline();
    row_test = (int) Math.pow(2, 16);
    col_test = 512;
    String input;
    int[][] expected = testUtils.generateRandom2DArray(row_test, col_test);
    int[][] result;
    input = testUtils.format2DArrayToString(expected);
    provideInput(input);

    // Compare the read array with test samples
    result = linescanner.scanIntArray2D(row_test, col_test);
    assertArrayEquals(expected, result);
    restoreSystemInputOutput();
  }

  @Test
  public void testScanInputArrayList() {
    Scanline linescanner = new Scanline();
    // Simulate command line input from a random 2D int array
    String input;
    int[][] expected = testUtils.generateRandom2DArray(row_test, col_test);
    input = testUtils.format2DArrayToString(expected);
    provideInput(input);

    // Compare the read array with test samples
    assertArrayEquals(expected, linescanner.scanIntArray2D(col_test));
    restoreSystemInputOutput();
  }

  @Test
  public void testScanInputArrayLargeList() {
    Scanline linescanner = new Scanline();
    row_test = (int) Math.pow(2, 16);
    col_test = 512;
    String input;
    int[][] expected = testUtils.generateRandom2DArray(row_test, col_test);
    input = testUtils.format2DArrayToString(expected);
    provideInput(input);

    // Compare the read array with test samples
    assertArrayEquals(expected, linescanner.scanIntArray2D(col_test));
    restoreSystemInputOutput();
  }

  @Test
  public void testAssign1Few() {
    row_test = 3;
    col_test = 2;
    String input;
    int[][] testSamples = { { 0, 10 }, { 0, 14 }, { 14, 17 } };
    int[] expected = { 2, 3, 2 };
    input = testUtils.format2DArrayToString(testSamples);
    provideInput(row_test + "\n" + input);
    Assignment1_1.main(null);
    int[] output = new int[row_test];
    String[] outputStrings= getOutput().split("\n");
    for (int i = 0; i < row_test; i++) {
      output[i]=Integer.parseInt(outputStrings[i].strip());
    }
    assertArrayEquals(expected, output);
    restoreSystemInputOutput();
  }
}