package model.model;

import java.util.List;
import java.util.Map;

import model.shape.Shape;

/**
 * This interface represents the model of our MVC and contains operations offered by
 * our model.
 */
public interface IModel {

  /**
   * Adds a Shape object (currently only oval and rectangle) with given name to our model.
   * @param name The name of our shape object.
   * @param shape representing a Shape object.
   */
  void addShape(String name, Shape shape);

  /**
   * Adds a Shape object (currently only oval and rectangle) with given name to our model.
   * Shapes added via this method will not be mutated later down the line (they're immutable).
   * @param name The name of our shape object.
   * @param shape representing a Shape object.
   */
  void addShapeUnMutated(String name, Shape shape);

  /**
   * Adds a Shape object (currently only oval and rectangle) with given name to our model.
   * Shapes added via this method are used for GUI implementation.
   * @param name The name of our shape object.
   * @param shape representing a Shape object.
   */
  void addShapesForGUI(String name, Shape shape);

  /**
   * Getter method for the Map created by addShape(String name, Shape shape).
   * @return Map created by addShape(String name, Shape shape).
   */
  Map<String, Shape> getMapOfShapes();

  /**
   * Getter method for the Map created by addShapeUnMutated(String name, Shape shape).
   * @return Map created by addShapeUnMutated(String name, Shape shape).
   */
  Map<String, Shape> getMapOfInitialShapes();

  /**
   * Getter method for the Map created by addShapesForGUI(String name, Shape shape).
   * @return Map created by addShapesForGUI(String name, Shape shape).
   */
  Map<String, Shape> getMapOfShapesForGUI();

  /**
   * Adds a MotionForGUI to the shapes in the Map created by
   * addShapesForGUI(String name, Shape shape).
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
  void addMotionForGUI(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                       int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * Moves the specified shape from its current position to (endPosX,endPosY) from
   * time t=startTick to t=endTick.
   * @param name name of the shape being moved.
   * @param endPosX X-coordinate that the shape will end at.
   * @param endPosY Y-coordinate that the shape will end at.
   * @param startTime start time that the shape will start moving at.
   * @param endTime end time that the shape will stop moving at.
   */
  void addMove(String name,  double endPosX, double endPosY, int startTime, int endTime);

  /**
   * Changes the specified shape color from its current color to the specified (red,green,blue)
   * color from time t=startTime to t=endTime.
   * @param name name of the shape that is getting its color changed.
   * @param red integer representing intensity of red hue from 0-255.
   * @param green integer representing intensity of green hue from 0-255.
   * @param blue integer representing intensity of blue hue from 0-255.
   * @param startTime start time that the shape will start changing color at.
   * @param endTime end time that the animation will stop changing color at.
   */
  void addChangeColor(String name, int red, int green, int blue, int startTime, int endTime);

  /**
   * Changes the specified shape's left-to-right side (X-radius for oval, width for rectangle)
   * to the specified leftToRightNewDimension and the up-to-down side
   * (Y-radius for oval, height for rectangle) to the specified upToDownNewDimension from time
   * t=startTime to t=endTime.
   * @param name name of the shape that is getting its dimensions scaled.
   * @param leftToRightNewDimension new length of the shape's left-to-right side.
   * @param upToDownNewDimension new length of the shape's up-to-down side.
   * @param startTime start time that the shape will start scaling its dimensions at.
   * @param endTime end time that the animation will stop scaling its dimensions at.
   */
  void addScale(String name, double leftToRightNewDimension, double upToDownNewDimension,
                int startTime, int endTime);

  /**
   * Setter method for the x, y coordinate, width, and height useful for certain views. This data is
   * received from text input.
   * @param x x coordinate of the view.
   * @param y y coordinate of the view.
   * @param width width of the view.
   * @param height height of the view.
   */
  void setBounds(int x, int y, int width, int height);

  /**
   * Getter method for the x-coordinate of the view.
   * @return width for the view.
   */
  int getBoundsX();

  /**
   * Getter method for the y-coordinate of the view.
   * @return height for the view.
   */
  int getBoundsY();

  /**
   * Getter method for the width of the view.
   * @return width for the view.
   */
  int getBoundsWidth();

  /**
   * Getter method for the height of the view.
   * @return height for the view.
   */
  int getBoundsHeight();

  /**
   * Gets a list of all active shapes at a given frame (tick). Used for tweening.
   * @param frame (or tick) that we are at.
   * @return List of shapes at the current frame (tick).
   */
  List<Shape> getShapesAtCurrentFrameForGUI(int frame);

  String getImplText();

  String getImplSVG(int ticksPerSecond);

  String createShapesAtCurrentFrameForGUI(int frame);
}
