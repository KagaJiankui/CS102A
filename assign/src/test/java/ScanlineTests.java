import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * ScanlineTests
 */
public class ScanlineTests {
  private ByteArrayInputStream testIn;
  private ByteArrayOutputStream testOut;

  @BeforeAll
  public void setUpOutput() {
    testOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(testOut));
  }

  private void provideInput(String data) {
    testIn = new ByteArrayInputStream(data.getBytes());
    System.setIn(testIn);
  }

  private String getOutput() {
    return testOut.toString();
  }

  @AfterAll
  public void restoreSystemInputOutput() {
    System.setIn(System.in);
    System.setOut(System.out);
  }

  @Test
  public void testScanInput() {

  }
}