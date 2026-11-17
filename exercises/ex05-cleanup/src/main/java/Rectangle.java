/** A rectangle with a width and a height. */
public class Rectangle {

  private double width;
  private double height;

  /**
   * Creates a rectangle with the given dimensions.
   *
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Returns the area of this rectangle.
   *
   * @return the area
   */
  public double area() {
    return width * height;
  }

  /**
   * Scales both dimensions by the given factor.
   *
   * @param factor the scaling factor
   */
  public void scale(double factor) {
    width *= factor;
    height *= factor;
  }

  /**
   * Reports whether this rectangle has a larger area than another.
   *
   * @param other the rectangle to compare against
   * @return true if this rectangle has a strictly larger area
   */
  public boolean isLargerThan(Rectangle other) {
    return area() > other.area();
  }
}
