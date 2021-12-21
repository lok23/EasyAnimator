package model.shape;

import java.util.List;

import model.motion.Motion;

/**
 * This interface represents a Shape object. Shapes are manipulated to create an animation.
 */
public interface Shape {

  /**
   * Getter method for the shape's color in string format.
   * @return Shape's color as a String
   */
  String getColor();

  /**
   * Getter method for the shape's red hue.
   * @return Shape's red hue as an int.
   */
  int getRed();

  /**
   * Getter method for the shape's green hue.
   * @return Shape's green hue as an int.
   */
  int getGreen();

  /**
   * Getter method for the shape's blue hue.
   * @return Shape's blue hue as an int.
   */
  int getBlue();

  /**
   * Adds a Motion for the shape with the given name. Used in creating the GUI view.
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
  void addMotionForShape(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                         int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * Moves this shape. Contains information about where its end X and end Y coordinates will be at,
   * as well as its start time and end time information.
   * @param endPosX X coordinate the shape will move to.
   * @param endPosY Y coordinate the shape will move to.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   */
  void addMove(double endPosX, double endPosY, int startTime, int endTime);

  /**
   * Changes this shape's color. Contains information about what the new red, new green and new
   * blue colors will be, as well as its start time and end time information.
   * @param newRed The red hue value of our new color.
   * @param newGreen The green hue value of our new color.
   * @param newBlue The blue hue value of our new color.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   */
  void addChangeColor(int newRed, int newGreen, int newBlue, int startTime, int endTime);

  /**
   * Changes this shape's dimensions. Contains information about what the new left-to-right
   * dimension and up-to-down dimension will be as well as its start time and end time information.
   * @param leftToRightNewDimension The new length of our left-to-right dimension.
   * @param upToDownNewDimension The new length of our up-to-down dimension.
   * @param startTime Start time of this change.
   * @param endTime End time of this change.
   */
  void addScale(double leftToRightNewDimension, double upToDownNewDimension,
                int startTime, int endTime);

  /**
   * Returns a string containing information relevant to operations that change the shape.
   * @return String representing information relevant to operations that change the shape.
   */
  String getMotionToStrings();

  /**
   * Returns a text description of this object and its properties. Used for the Text view.
   * @return Text description of shape as a String.
   */
  String toString();

  /**
   * Returns a text description of this shape's motions and their properties.
   * Used for the svg view.
   * @return Text description of shape's motions as an svg.
   */
  String toMotionSVG(int ticksPerSecond);

  /**
   * Returns a text description of this shape and its properties. Used for the svg view.
   * @return Text description of shape as an svg.
   */
  String toShapeSVG();

  /**
   * Gets a list of active Motions at a given frame. Used for GUI view.
   * @param frame frame (or tick).
   * @return List of active Motions at a given frame.
   */
  List<Motion> getListOfCurrentMotions(int frame);

  /**
   * Gets the time the shape appears.
   * @return time shape appears.
   */
  int getAppears();

  /**
   * Gets the time the shape disappears.
   * @return time shape disappears.
   */
  int getDisappears();

  /**
   * Returns whether the shape is a Rectangle or not.
   * @return true if shape is of type Rectangle.
   */
  boolean isRectangle();

  /**
   * Returns whether the shape is a ellipse (or Oval) or not.
   * @return true if shape is of type Oval.
   */
  boolean isOval();
}

