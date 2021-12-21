package model.motion;

import model.shape.Identifier;

/**
 * Represents a ChangeColor Motion. ChangeColor returns true for isChangeColor method, and has a
 * print method which describes this Motion.
 */
public class ChangeColor extends AbstractMotion {
  private String name;
  private int startRed;
  private int startGreen;
  private int startBlue;

  private int red;
  private int green;
  private int blue;

  /**
   * Constructor sets the object's reference variables equal to input parameters.
   * @param name Name of this shape.
   * @param startRed Start red hue value of this shape.
   * @param startGreen Start green hue value of this shape.
   * @param startBlue Start blue hue value of this shape.
   * @param red End red hue value of this shape.
   * @param green End green hue value of this shape.
   * @param blue End blue hue value of this shape.
   * @param startTime start time for this Motion.
   * @param endTime end time for this Motion.
   */
  public ChangeColor(String name, int startRed, int startGreen, int startBlue, int red, int green,
                     int blue, int startTime, int endTime) {
    super(startTime, endTime);
    this.name = name;
    this.startRed = startRed;
    this.startGreen = startGreen;
    this.startBlue = startBlue;
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Returns whether this object is ChangeColor class. Tautologically true.
   * @return always returns true.
   */
  @Override
  public boolean isChangeColor() {
    return true;
  }

  /**
   * Returns text description of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @return Text description of the animation motion and its properties as a String.
   */
  @Override
  public String getString(Identifier identifier) {
    return "Shape " + this.name + " changes color from " + "(" + this.startRed + ","
            + this.startGreen + "," + this.startBlue + ")" +
            " to (" + red + "," + green + "," + blue  + ") from t="
            + startTime + " to t=" + endTime + "\n";
  }

  /**
   * Returns svg formatted representation of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @param ticksPerSecond determines time appears, disappears, and duration of motions.
   * @return Svg formatted representation of animation motion and its properties.
   */
  @Override
  public String getSVG(Identifier identifier, int ticksPerSecond) {
    String returned = "";
    int realStartTime = 1000 * this.getStartTime() / ticksPerSecond;
    int realEndTime = 1000 * (this.getEndTime() - this.getStartTime()) / ticksPerSecond;
    returned += "<animate attributeName=\"fill\" attributeType=\"CSS\" from=\"rgb("
            + this.startRed + "," + this.startGreen + "," + this.startBlue + ")\" to=\"rgb("
            + this.red + "," + this.green + "," + this.blue + ")\" begin=\"" + realStartTime
            + "ms\" dur=\"" + realEndTime + "ms\" fill=\"freeze\" />\n    ";
    return returned;
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenX(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenY(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenWidth(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenHeight(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenRed(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenGreen(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param currentFrame The given frame.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public int tweenBlue(int currentFrame) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }
}