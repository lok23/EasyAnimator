package model.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.motion.Motion;
import model.shape.Oval;
import model.shape.Rectangle;
import model.shape.Shape;
import cs5004.animator.util.AnimationBuilder;

/**
 * ModelImpl implements IModel and contains a builder inside of it to help with its instantiation.
 * The given code inside of the builder does all the parsing of the input text.
 */
public class ModelImpl implements IModel {
  //Contains just the name and the shapes
  Map<String, Shape> mapOfInitialShapes;

  //Contains name, shapes, and inside of shapes contains list of motions of changeColor, move, scale
  Map<String, Shape> mapOfShapes;

  //Contains name, shapes and inside of shapes contains list of motions of type MotionForGUI.
  Map<String, Shape> mapOfShapesForGUI;
  int x;
  int y;
  int width;
  int height;

  /**
   * Lazy instantiation of our three Maps.
   */
  public ModelImpl() {
    this.mapOfShapes = new LinkedHashMap<String, Shape>();
    this.mapOfInitialShapes = new LinkedHashMap<String, Shape>();
    this.mapOfShapesForGUI = new LinkedHashMap<String, Shape>();
  }

  /**
   * Builder implements the Interface AnimationBuilder given to us by the professors.
   */
  public static final class Builder implements AnimationBuilder<IModel> {
    IModel model = new ModelImpl();
    Map<String, String> mapOfUnInstantiatedShapes = new HashMap<String, String>();

    @Override
    public IModel build() {
      return model;
    }

    @Override
    public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
      model.setBounds(x, y, width, height);
      return this;
    }

    @Override
    public AnimationBuilder<IModel> declareShape(String name, String type)
            throws IllegalArgumentException {
      if (mapOfUnInstantiatedShapes.containsKey(name)) {
        throw new IllegalArgumentException("We already declared a Shape with that name");
      } else {
        mapOfUnInstantiatedShapes.put(name, type);
        return this;
      }
    }

    @Override
    public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                                              int r1, int g1, int b1, int t2, int x2, int y2,
                                              int w2, int h2, int r2, int g2, int b2)
                                              throws IllegalArgumentException {
      if (!mapOfUnInstantiatedShapes.containsKey(name)) {
        throw new IllegalArgumentException("We didn't declare a Shape with that name");
      } else {
        String type = mapOfUnInstantiatedShapes.get(name);

        if (type.equalsIgnoreCase("Rectangle")) {
          //If the model's mapOfShapes doesn't contain our key,
          // create our key-value and add it to our hashMap.
          if (!model.getMapOfShapes().containsKey(name)) {
            //Appears and Disappears is changed to appropriate
            // values once motions are added.
            Shape rect = new Rectangle(r1, g1, b1, name, x1, y1, w1, h1, 0, 1000000);
            model.addShape(name, rect);
            Shape rect2 = new Rectangle(r1, g1, b1, name, x1, y1, w1, h1, 0, 1000000);
            model.addShapeUnMutated(name, rect2);
            Shape rect3 = new Rectangle(r1, g1, b1, name, x1, y1, w1, h1, 0, 1000000);
            model.addShapesForGUI(name, rect3);
          }

          model.addMotionForGUI(name, t1, x1, y1, w1, h1, r1, g1, b1,
                                t2, x2, y2, w2, h2, r2, g2, b2);
          //Determine if we need to add move, add changecolor, add scale.
          //addMove
          if (x1 != x2 || y1 != y2) {
            model.addMove(name, x2, y2, t1, t2);
          }
          //addChangeColor
          if (r1 != r2 || g1 != g2 || b1 != b2) {
            model.addChangeColor(name, r2, g2, b2, t1, t2);
          }
          //addScale
          if (w1 != w2 || h1 != h2) {
            model.addScale(name, w2, h2, t1, t2);
          }

        }

        if (type.equalsIgnoreCase("Ellipse")) {
          if (!model.getMapOfShapes().containsKey(name)) {
            //Appears and Disappears is changed to appropriate values once motions are added.
            Shape oval = new Oval(r1, g1, b1, name, x1, y1, w1, h1, 0, 1000000);
            model.addShape(name, oval);
            Shape oval2 = new Oval(r1, g1, b1, name, x1, y1, w1, h1, 0, 1000000);
            model.addShapeUnMutated(name, oval2);
            Shape oval3 = new Oval(r1, g1, b1, name, x1, y1, w1, h1, 0, 1000000);
            model.addShapesForGUI(name, oval3);
          }

          model.addMotionForGUI(name, t1, x1, y1, w1, h1, r1, g1, b1,
                                t2, x2, y2, w2, h2, r2, g2, b2);
          //Determine if we need to add move, add changecolor, add scale.
          //addMove
          if (x1 != x2 || y1 != y2) {
            model.addMove(name, x2, y2, t1, t2);
          }
          //addChangeColor
          if (r1 != r2 || g1 != g2 || b1 != b2) {
            model.addChangeColor(name, r2, g2, b2, t1, t2);
          }
          //addScale
          if (w1 != w2 || h1 != h2) {
            model.addScale(name, w2, h2, t1, t2);
          }
        }

      }
      return this;
    }
  }

  /**
   * Adds a Shape object (currently only oval and rectangle) with given name to the mapOfShapes
   * in our model.
   * @param name The name of our shape object.
   * @param shape representing a Shape object.
   */
  @Override
  public void addShape(String name, Shape shape) throws IllegalArgumentException {
    if (this.mapOfShapes.containsKey(name)) {
      throw new IllegalArgumentException("This shape has already been added to the model.");
    }
    else {
      this.mapOfShapes.put(name, shape);
    }
  }

  /**
   * Adds a Shape object (currently only oval and rectangle) with given name to the
   * mapOfInitialShapes in our model.
   * Shapes added via this method will not be mutated later down the line (they're immutable).
   * @param name The name of our shape object.
   * @param shape representing a Shape object.
   */
  @Override
  public void addShapeUnMutated(String name, Shape shape) throws IllegalArgumentException {
    if (this.mapOfInitialShapes.containsKey(name)) {
      throw new IllegalArgumentException("This shape has already been added to the model.");
    }
    else {
      this.mapOfInitialShapes.put(name, shape);
    }
  }

  /**
   * Adds a Shape object (currently only oval and rectangle) with given name to the
   * mapOfShapesForGUI in our model.
   * Shapes added via this method are used for GUI implementation.
   * @param name The name of our shape object.
   * @param shape representing a Shape object.
   */
  @Override
  public void addShapesForGUI(String name, Shape shape) throws IllegalArgumentException {
    if (this.mapOfShapesForGUI.containsKey(name)) {
      throw new IllegalArgumentException("This shape has already been added to the model.");
    }
    else {
      this.mapOfShapesForGUI.put(name, shape);
    }
  }


  /**
   * Getter method for the Map created by addShape(String name, Shape shape).
   * @return Map created by addShape(String name, Shape shape).
   */
  @Override
  public Map<String, Shape> getMapOfShapes() {
    return this.mapOfShapes;
  }

  /**
   * Getter method for the Map created by addShapeUnMutated(String name, Shape shape).
   * @return Map created by addShapeUnMutated(String name, Shape shape).
   */
  @Override
  public Map<String, Shape> getMapOfInitialShapes() {
    return this.mapOfInitialShapes;
  }

  /**
   * Getter method for the Map created by addShapesForGUI(String name, Shape shape).
   * @return Map created by addShapesForGUI(String name, Shape shape).
   */
  @Override
  public Map<String, Shape> getMapOfShapesForGUI() {
    return this.mapOfShapesForGUI;
  }

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
  @Override
  public void addMotionForGUI(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                              int b1, int t2, int x2, int y2, int w2, int h2,
                              int r2, int g2, int b2) throws IllegalArgumentException {
    if (!this.mapOfShapesForGUI.containsKey(name)) {
      throw new IllegalArgumentException("That shape hasn't been added to our ModelImpl.");
    }
    else {
      Shape shape = this.mapOfShapesForGUI.get(name);
      shape.addMotionForShape(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
    }
  }

  /**
   * Moves the specified shape from its current position to (endPosX,endPosY) from
   * time t=startTick to t=endTick.
   * @param name name of the shape being moved.
   * @param endPosX X-coordinate that the shape will end at.
   * @param endPosY Y-coordinate that the shape will end at.
   * @param startTime start time that the shape will start moving at.
   * @param endTime end time that the shape will stop moving at.
   */
  @Override
  public void addMove(String name, double endPosX, double endPosY, int startTime, int endTime)
                      throws IllegalArgumentException {
    if (!this.mapOfShapes.containsKey(name)) {
      throw new IllegalArgumentException("That shape hasn't been added to our ModelImpl.");
    }
    else {
      Shape shape = this.mapOfShapes.get(name);
      shape.addMove(endPosX, endPosY, startTime, endTime);
    }
  }

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
  @Override
  public void addChangeColor(String name, int red, int green, int blue, int startTime, int endTime)
                            throws IllegalArgumentException {
    if (!this.mapOfShapes.containsKey(name)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      Shape shape = this.mapOfShapes.get(name);
      shape.addChangeColor(red, green, blue, startTime, endTime);
    }
  }

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
  @Override
  public void addScale(String name, double leftToRightNewDimension, double upToDownNewDimension,
                       int startTime, int endTime) throws IllegalArgumentException {
    if (!this.mapOfShapes.containsKey(name)) {
      throw new IllegalArgumentException("That shape hasn't been created yet.");
    }
    else {
      Shape shape = this.mapOfShapes.get(name);
      shape.addScale(leftToRightNewDimension, upToDownNewDimension, startTime, endTime);
    }
  }

  /**
   * Setter method for the x, y coordinate, width, and height useful for certain views. This data is
   * received from text input.
   * @param x x coordinate of the view.
   * @param y y coordinate of the view.
   * @param width width of the view.
   * @param height height of the view.
   */
  @Override
  public void setBounds(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @Override
  public int getBoundsX() {
    return this.x;
  }

  @Override
  public int getBoundsY() {
    return this.y;
  }

  /**
   * Getter method for the width of the view.
   * @return width for the view.
   */
  @Override
  public int getBoundsWidth() {
    return this.width;
  }

  /**
   * Getter method for the height of the view.
   * @return height for the view.
   */
  @Override
  public int getBoundsHeight() {
    return this.height;
  }

  /**
   * Gets a list of all active shapes at a given frame (tick). Used for tweening.
   * @param frame (or tick) that we are at.
   * @return List of shapes at the current frame (tick).
   */
  @Override
  public List<Shape> getShapesAtCurrentFrameForGUI(int frame) {
    List<Shape> returnedList = new ArrayList<Shape>();
    for (Shape shape: this.getMapOfShapesForGUI().values()) {
      if (frame >= shape.getAppears() && frame <= shape.getDisappears()) {
        returnedList.add(shape);
      }
    }
    return returnedList;
  }

  @Override
  public String getImplText() {
    String returned = "";
    returned += "Shapes: \n";
    for (Shape shape: this.getMapOfShapes().values()) {
      returned += shape.toString() + "\n";
    }
    for (Shape shape: this.getMapOfShapes().values()) {
      returned += shape.getMotionToStrings();
    }
    return returned;
  }

  @Override
  public String getImplSVG(int ticksPerSecond) {
    String returned = "";
    int width = this.width;
    int x = this.x;
    int height = this.height;
    int y = this.y;

    int sumWidth = width + x;
    int sumHeight = height + y;

    returned += "<svg width=\"" + sumWidth + "\" height=\"" +
            sumHeight + "\" version=\"1.1\">\n\n";
    for (Map.Entry<String, Shape> entry : this.getMapOfInitialShapes().entrySet()) {
      returned += entry.getValue().toShapeSVG();
      String key = entry.getKey();
      Shape shape = this.getMapOfShapes().get(key);
      returned += shape.toMotionSVG(ticksPerSecond) + "\n";
    }
    returned += "</svg>";
    return returned;
  }

  @Override
  public String createShapesAtCurrentFrameForGUI(int currentFrame) {
    String returned = "";
    for (Shape shape: this.getShapesAtCurrentFrameForGUI(currentFrame)) {
      //System.out.println(shape);
      if (shape.isOval()) {
        for (Motion motion : shape.getListOfCurrentMotions(currentFrame)) {
          int red = motion.tweenRed(currentFrame);
          int green = motion.tweenGreen(currentFrame);
          int blue = motion.tweenBlue(currentFrame);

          int x = motion.tweenX(currentFrame);
          int y = motion.tweenY(currentFrame);
          int width = motion.tweenWidth(currentFrame);
          int height = motion.tweenHeight(currentFrame);

          returned += "oval" + "," + red + "," + green + "," + blue + "," + x + "," + y +
                  "," + width + "," + height + ",";
          //g2d.setColor(new Color(red, green, blue));
          //g2d.fillOval(x, y, width, height);

        }
      }
      else if (shape.isRectangle()) {
        for (Motion motion : shape.getListOfCurrentMotions(currentFrame)) {
          int red = motion.tweenRed(currentFrame);
          int green = motion.tweenGreen(currentFrame);
          int blue = motion.tweenBlue(currentFrame);

          int x = motion.tweenX(currentFrame);
          int y = motion.tweenY(currentFrame);
          int width = motion.tweenWidth(currentFrame);
          int height = motion.tweenHeight(currentFrame);

          returned += "rect" + "," + red + "," + green + "," + blue + "," + x + "," + y + ","
                  + width + "," + height + ",";

          //g2d.setColor(new Color(red, green, blue));
          //g2d.fillRect(x, y, width, height);
          //System.out.println(currentFrame);
          //System.out.println(width);
          //System.out.println(motion.getString(Identifier.RECTANGLE));
        }
      }
    }
    return returned;
  }
}
