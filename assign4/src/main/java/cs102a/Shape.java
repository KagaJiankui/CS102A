package cs102a;

public abstract class Shape {

  // 网格字段
  protected char[][] grids;
  // 模式字段
  protected char pattern;
  // 位置字段
  protected Location location;

  // 两参数构造器
  public Shape(Location location, char pattern) {
    this.location = location;
    this.pattern = pattern;
  }

  // 返回网格引用
  public char[][] getGrids() {
    return grids;
  }

  // 抽象方法
  public abstract void fillGrids();

  public abstract void enlarge();

  public abstract void shrink();

  @Override
  public String toString() {
    return ShapeUtils.toString(this);
  }

  public int area() {
    return ShapeUtils.area(this);
  }
}
