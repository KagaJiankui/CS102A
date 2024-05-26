import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import cs102a.Circle;
import cs102a.Direction;
import cs102a.Location;
import cs102a.RightTriangle;

public class A5OnlineTest {
    private static String gridString(char[][] grids) {
        var sb = new StringBuilder();
        for (char[] line : grids) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test1() {
        var location = new Location(0, 8);
        var circle = new Circle(location, 'V', 2);
        assertEquals(16, circle.area());
        assertEquals("""
                VVVV
                VVVV
                VVVV
                VVVV
                """, gridString(circle.getGrids()));
        assertEquals("Circle: (0,8) area=16 pattern=V", circle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test2() {
        var location = new Location(10, 1);
        var circle = new Circle(location, '4', 4);
        assertEquals(60, circle.area());
        assertEquals("""
                 444444\s
                44444444
                44444444
                44444444
                44444444
                44444444
                44444444
                 444444\s
                """, gridString(circle.getGrids()));
        assertEquals("Circle: (10,1) area=60 pattern=4", circle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test3() {
        var location = new Location(5, 2);
        var circle = new Circle(location, 'Z', 6);
        assertEquals(132, circle.area());
        circle.enlarge();
        assertEquals("""
                   ZZZZZZZZ  \s
                  ZZZZZZZZZZ \s
                 ZZZZZZZZZZZZ\s
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                ZZZZZZZZZZZZZZ
                 ZZZZZZZZZZZZ\s
                  ZZZZZZZZZZ \s
                   ZZZZZZZZ  \s
                """, gridString(circle.getGrids()));
        assertEquals("Circle: (5,2) area=172 pattern=Z", circle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test4() {
        var location = new Location(44, 4);
        var circle = new Circle(location, '&', 9);
        assertEquals(284, circle.area());
        circle.shrink();
        assertEquals("""
                    &&&&&&&&   \s
                  &&&&&&&&&&&& \s
                 &&&&&&&&&&&&&&\s
                 &&&&&&&&&&&&&&\s
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                &&&&&&&&&&&&&&&&
                 &&&&&&&&&&&&&&\s
                 &&&&&&&&&&&&&&\s
                  &&&&&&&&&&&& \s
                    &&&&&&&&   \s
                """, gridString(circle.getGrids()));
        assertEquals("Circle: (44,4) area=224 pattern=&", circle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test5() {
        var location = new Location(10, 15);
        var circle = new Circle(location, '_', 10);
        circle.shrink();
        circle.enlarge();
        circle.shrink();
        circle.shrink();
        circle.enlarge();
        circle.enlarge();
        assertEquals("""
                     __________    \s
                    ____________   \s
                  ________________ \s
                  ________________ \s
                 __________________\s
                ____________________
                ____________________
                ____________________
                ____________________
                ____________________
                ____________________
                ____________________
                ____________________
                ____________________
                ____________________
                 __________________\s
                  ________________ \s
                  ________________ \s
                    ____________   \s
                     __________    \s
                """, gridString(circle.getGrids()));
        assertEquals("Circle: (10,15) area=344 pattern=_", circle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test6() {
        var location = new Location(654, 321);
        var triangle = new RightTriangle(location, 'R', 4, 3, Direction.LEFT_DOWN);
        assertEquals(9, triangle.area());
        assertEquals("""
                RR \s
                RRR\s
                RRRR
                """, gridString(triangle.getGrids()));
        assertEquals("RightTriangle: (654,321) area=9 pattern=R", triangle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test7() {
        var location = new Location(99999, 0);
        var triangle = new RightTriangle(location, '!', 5, 5, Direction.RIGHT_UP);
        assertEquals(15, triangle.area());
        assertEquals("""
                !!!!!
                 !!!!
                  !!!
                   !!
                    !
                """, gridString(triangle.getGrids()));
        assertEquals("RightTriangle: (99999,0) area=15 pattern=!", triangle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test8() {
        var location = new Location(0, 777);
        var triangle = new RightTriangle(location, '=', 7, 7, Direction.RIGHT_DOWN);
        assertEquals(28, triangle.area());
        triangle.enlarge();
        assertEquals("""
                       =
                      ==
                     ===
                    ====
                   =====
                  ======
                 =======
                ========
                """, gridString(triangle.getGrids()));
        assertEquals("RightTriangle: (0,777) area=36 pattern==", triangle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test9() {
        var location = new Location(1000, 1);
        var triangle = new RightTriangle(location, '-', 5, 6, Direction.LEFT_UP);
        assertEquals(20, triangle.area());
        triangle.shrink();
        assertEquals("""
                ----
                ----
                ---\s
                -- \s
                -  \s
                """, gridString(triangle.getGrids()));
        assertEquals("RightTriangle: (1000,1) area=14 pattern=-", triangle.toString());
    }

    @Test
    @Timeout(value = 4000, unit = TimeUnit.MILLISECONDS)
    void test10() {
        var location = new Location(0, 0);
        var triangle = new RightTriangle(location, '\'', 5, 7, Direction.RIGHT_DOWN);
        assertEquals(23, triangle.area());
        triangle.enlarge();
        triangle.enlarge();
        triangle.shrink();
        triangle.shrink();
        triangle.shrink();
        triangle.enlarge();
        triangle.shrink();
        assertEquals("""
                   '
                  ''
                  ''
                 '''
                ''''
                ''''
                """, gridString(triangle.getGrids()));
        assertEquals("RightTriangle: (0,0) area=16 pattern='", triangle.toString());
    }
}
