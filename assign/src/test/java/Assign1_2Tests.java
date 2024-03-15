// package com.cs102a;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.*;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cs102a.Assignment1_1;
import com.cs102a.Assignment1_2;
import com.cs102a.Scanline;

/**
 * ScanlineTests
 */
public class Assign1_2Tests {
  private static ByteArrayInputStream testIn;
  private static ByteArrayOutputStream testOut;

  private static int row_test = 4;
  private static int col_test = 5;

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
  public static void testSeptConversion() {
    StringBuilder result = new StringBuilder();
    Random random = new Random();
    int[] testSamples = new int[row_test];
    int[] expected = new int[row_test];
    for (int i : testSamples) {
      i = random.nextInt(65536);
      result.append(i).append("\n");
    }
    for (int j = 0; j < row_test; j++) {
      expected[j] = Integer.parseInt(Integer.toString(testSamples[j], 7));
    }
    setUpOutput();
    provideInput(result.toString());
    Assignment1_2.main(null);
    String[] outputStrings = getOutput().split("\n");
    int[] output = new int[row_test];
    for (int i = 0; i < row_test; i++) {
      output[i] = Integer.parseInt(outputStrings[i].strip());
    }
    assertArrayEquals(testSamples, output);
    restoreSystemInputOutput();
  }

}