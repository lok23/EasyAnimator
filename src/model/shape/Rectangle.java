package model.shape;


import model.motion.Motion;

/**
 * Represents a Rectangle shape. Contains AbstractShape's constructor, getColor, addMove, and
 * addChangeColor methods. Rectangle has a print method which describes the Motions associated
 * with this object and a toString method, which describes this object and its properties.
 */
public class Rectangle extends AbstractShape {
  public Rectangle(int red, int green, int blue, String name, double posX, double posY,
                   double width, double height, int appears, int disappears) {
    super(red, green, blue, name, posX, posY, width, height, appears, disappears);
  }

  /**
   * Returns a text description of this shape's animation motions and its properties.
   * @return Text description of shape's animations as a String.
   */
  @Override
  public String getMotionToStrings() {
    String returnString = "";
    for (Motion motion: this.listOfMotions) {
      returnString += motion.getString(Identifier.RECTANGLE);
    }
    return returnString;
  }

  /**
   * Returns a text description of this object and its properties.
   * @return Text description of shape as a String.
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\n" +
            "Type: rectangle\n" +
            "Min corner: (" + this.posX + "," + this.posY + "), Width: " + this.width +
            ", Height: " + this.height + ", Color: " + this.getColor() + "\n" +
            "Appears at t=" + this.appears + "\n" +
            "Disappears at t=" + this.disappears + "\n";
  }

  /**
   * Returns a text description of this shape and its properties. Used for the svg view.
   * @return Text description of shape as an svg.
   */
  @Override
  public String toShapeSVG() {
    String returned = "";
    returned += "<rect id=\"" + this.name + "\" x=\"" + this.posX + "\" y=\"" + this.posY
            + "\" width=\""
            + this.width + "\" height=\"" + this.height + "\" fill=\"rgb" + this.getColor()
            + "\" visibility=\"visible\" >\n    ";
    return returned;
  }

  /**
   * Returns a text description of this shape's motions and their properties.
   * Used for the svg view.
   * @return Text description of shape's motions as an svg.
   */
  @Override
  public String toMotionSVG(int ticksPerSecond) {
    String returned = "";
    for (Motion motion: this.listOfMotions) {
      returned += motion.getSVG(Identifier.RECTANGLE, ticksPerSecond);
    }
    returned += "\n</rect>\n\n";
    return returned;
  }

  /**
   * Returns whether the shape is a Rectangle or not.
   * @return tautologically true.
   */
  @Override
  public boolean isRectangle() {
    return true;
  }

  /**
   * Returns whether the shape is an Oval or not.
   * @return tautologically false.
   */
  @Override
  public boolean isOval() {
    return false;
  }
}
