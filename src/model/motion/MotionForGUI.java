package model.motion;

import model.shape.Identifier;

/**
 * MotionForGUI represents a Motion specialized for the GUI view. MotionForGUI can be viewed as a
 * combination class of ChangeColor, Move, and Scale as MotionForGUI can change all three properties
 * of the shape by itself.
 */
public class MotionForGUI extends AbstractMotion {
  String name;
  int t1;
  int x1;
  int y1;
  int w1;
  int h1;
  int r1;
  int g1;
  int b1;
  int t2;
  int x2;
  int y2;
  int w2;
  int h2;
  int r2;
  int g2;
  int b2;

  /**
   * Constructor for MotionForGUI sets the instance variables equal to the parameters.
   * @param name The name of the Shape object this Motion belongs to.
   * @param t1 starting time.
   * @param x1 starting x coordinate.
   * @param y1 starting y coordinate.
   * @param w1 starting width.
   * @param h1 starting height.
   * @param r1 starting red hue.
   * @param g1 starting green hue.
   * @param b1 starting blue hue.
   * @param t2 ending time.
   * @param x2 ending x coordinate.
   * @param y2 ending y coordinate.
   * @param w2 ending width.
   * @param h2 ending height.
   * @param r2 ending red hue.
   * @param g2 ending green hue.
   * @param b2 ending blue hue.
   */
  public MotionForGUI(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                      int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    super(t1, t2);
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  /**
   * This class does not support this operation.
   * @param identifier enum identifier helps the function return the correct string.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public String getString(Identifier identifier) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * This class does not support this operation.
   * @param identifier enum identifier helps the function return the correct string.
   * @param ticksPerSecond determines time appears, disappears, and duration of motions.
   * @return shouldn't return anything.
   * @throws UnsupportedOperationException if this method is called.
   */
  @Override
  public String getSVG(Identifier identifier, int ticksPerSecond)
          throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  /**
   * Determines the tween x coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween x coordinate given frame.
   */
  @Override
  public int tweenX(int currentFrame) {
    return (int)(this.x1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.x2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

  /**
   * Determines the tween y coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween y coordinate given frame.
   */
  @Override
  public int tweenY(int currentFrame) {
    return (int)(this.y1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.y2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

  /**
   * Determines the tween width coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween width coordinate given frame.
   */
  @Override
  public int tweenWidth(int currentFrame) {
    return (int)(this.w1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.w2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

  /**
   * Determines the tween height coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween height coordinate given frame.
   */
  @Override
  public int tweenHeight(int currentFrame) {
    return (int)(this.h1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.h2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

  /**
   * Determines the tween red coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween red coordinate given frame.
   */
  @Override
  public int tweenRed(int currentFrame) {
    return (int)(this.r1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.r2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

  /**
   * Determines the tween green coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween green coordinate given frame.
   */
  @Override
  public int tweenGreen(int currentFrame) {
    return (int)(this.g1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.g2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

  /**
   * Determines the tween blue coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween blue coordinate given frame.
   */
  @Override
  public int tweenBlue(int currentFrame) {
    return (int)(this.b1 *
            (Double.valueOf(this.t2 - currentFrame) / Double.valueOf(this.t2 - this.t1)) +
            this.b2 *
            (Double.valueOf(currentFrame - this.t1) / Double.valueOf(this.t2 - this.t1)));
  }

}
