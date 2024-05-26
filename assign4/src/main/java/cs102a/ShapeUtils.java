package cs102a;

public class ShapeUtils {

  // 计算被填充格子的数量
  public static int area(Shape shape) {
    char[][] grids = shape.getGrids();
    int count = 0;
    for (char[] grid : grids) {
      for (char elem : grid) {
        if (elem == shape.pattern) {
          count++;
        }
      }
    }
    return count;
  }

  // 打印形状的网格
  public static void print(Shape shape) {
    char[][] grids = shape.getGrids();
    for (char[] grid : grids) {
      for (char elem : grid) {
        System.out.print(elem);
      }
      System.out.println();
    }
  }

  public static String toString(Shape shape) {
    return String.format("%s: (%d,%d) area=%d pattern=%c", shape.getClass().getSimpleName(), shape.location.getX(),
      shape.location.getY(), area(shape), shape.pattern);
  }
}
