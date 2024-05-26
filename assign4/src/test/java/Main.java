import cs102a.Direction;
import cs102a.Location;
import cs102a.RightTriangle;
import cs102a.ShapeUtils;

public class Main {

  public static void main(String[] args) {
    Location location = new Location(99, 999);
    RightTriangle triangle = new RightTriangle(location, '+', 7, 4, Direction.LEFT_UP);
    System.out.println(ShapeUtils.area(triangle));
    triangle.shrink();
    ShapeUtils.print(triangle);
  }
}
