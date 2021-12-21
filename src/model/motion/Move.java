package model.motion;

import model.shape.Identifier;

/**
 * Represents a Move Motion. Move returns true for isMove method, and has a
 * print method which describes this Motion.
 */
public class Move extends AbstractMotion {
  private String name;
  private double startX;
  private double startY;
  private double endPosX;
  private double endPosY;

  /**
   * Constructor sets the object's reference variables equal to input parameters.
   * @param name Name of this shape.
   * @param startX start X coordinate
   * @param startY start Y coordinate
   * @param endPosX end X coordinate
   * @param endPosY end Y coordinate
   * @param startTime start time for this Motion.
   * @param endTime end time for this Motion.
   */
  public Move(String name, double startX, double startY, double endPosX, double endPosY,
              int startTime, int endTime) {
    super(startTime, endTime);
    this.name = name;
    this.startX = startX;
    this.startY = startY;
    this.endPosX = endPosX;
    this.endPosY = endPosY;
  }

  /**
   * Returns whether this object is Move class. Tautologically true.
   * @return always returns true.
   */
  @Override
  public boolean isMove() {
    return true;
  }

  /**
   * Returns text description of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @return Text description of the animation motion and its properties as a String.
   */
  @Override
  public String getString(Identifier identifier) {
    return "Shape " + this.name + " moves from (" + this.startX + "," +
            this.startY + ") to (" + this.endPosX + "," + this.endPosY + ") from t="
            + this.startTime + " to t=" + this.endTime + "\n";
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
    if (identifier.equals(Identifier.RECTANGLE)) {
      if (startX != endPosX) {
        returned += "<animate attributeType=\"xml\" begin=\"" + realStartTime + "ms\" dur=\""
                + realEndTime + "ms\" attributeName=\"x\" from=\"" + this.startX + "\" to=\""
                + this.endPosX + "\" fill=\"freeze\" />\n    ";
      }
      if (startY != endPosY) {
        returned += "<animate attributeType=\"xml\" begin=\"" + realStartTime + "ms\" dur=\""
                + realEndTime + "ms\" attributeName=\"y\" from=\"" + this.startY + "\" to=\""
                + this.endPosY + "\" fill=\"freeze\" />\n    ";
      }
    }
    if (identifier.equals(Identifier.OVAL)) {
      if (startX != endPosX) {
        returned += "<animate attributeType=\"xml\" begin=\"" + realStartTime + "ms\" dur=\""
                + realEndTime + "ms\" attributeName=\"cx\" from=\"" + this.startX + "\" to=\""
                + this.endPosX + "\" fill=\"freeze\" />\n    ";
      }
      if (startY != endPosY) {
        returned += "<animate attributeType=\"xml\" begin=\"" + realStartTime + "ms\" dur=\""
                + realEndTime + "ms\" attributeName=\"cy\" from=\"" + this.startY + "\" to=\""
                + this.endPosY + "\" fill=\"freeze\" />\n    ";
      }
    }
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
  public int tweenWidth(int currentFrame)throws UnsupportedOperationException {
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