package model.shape;

import java.util.ArrayList;
import java.util.List;

import model.motion.ChangeColor;
import model.motion.Motion;
import model.motion.MotionForGUI;
import model.motion.Move;
import model.motion.Scale;

/**
 * AbstractShape contains data common to all Shape objects. It contains a getColor, addMove,
 * addChangeColor method.
 */
public abstract class AbstractShape implements Shape {
  List<Motion> listOfMotions;
  int red;
  int green;
  int blue;

  String name;

  double posX;
  double posY;
  double width;
  double height;
  int appears;
  int disappears;

  /**
   * AbstractShape constructor checks if any parameter values are illegal values, and throws IAE if
   * they are. Red, green, blue are integers from 0 to 255. Name is the name of this shape. posX and
   * posY describes a specific point on the shape (like center for oval). Width and height are the
   * width and height of this shape. Appears is the time at which the shape appears, and disappears
   * is the time at which the shape disappears.
   *
   * @param red        Red hue value of this shape.
   * @param green      Green hue value of this shape.
   * @param blue       Blue hue value of this shape.
   * @param name       Name of this shape.
   * @param posX       Position X of this shape.
   * @param posY       Position Y of this shape.
   * @param width      Width of this shape.
   * @param height     Height of this shape.
   * @param appears    Time at which this shape appears.
   * @param disappears Time at which this shape disappears.
   * @throws IllegalArgumentException if red, green, or blue are either less than 0, or greater than
   *                                  255, or if width or height is less than or equal to 0, or if
   *                                  appears time value is greater than disappears time value.
   */
  public AbstractShape(int red, int green, int blue, String name, double posX, double posY,
                       double width, double height, int appears, int disappears)
          throws IllegalArgumentException {
    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Make sure your colors are between 0 and 255.");
    }
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException("Make sure height and width are greater than 0.");
    }
    if (appears < 0) {
      throw new IllegalArgumentException("Make sure appears is 0 or greater.");
    }
    if (appears > disappears) {
      throw new IllegalArgumentException("Make sure disappear time comes after appear time.");
    }
    this.listOfMotions = new ArrayList<Motion>();
    this.red = red;
    this.green = green;
    this.blue = blue;

    this.name = name;

    this.posX = posX;
    this.posY = posY;
    this.width = width;
    this.height = height;
    this.appears = appears;
    this.disappears = disappears;
  }

  /**
   * Adds a Motion for the shape with the given name. Used in creating the GUI view.
   *
   * @param name The name of the Shape object this Motion belongs to.
   * @param t1   starting time.
   * @param x1   starting x coordinate.
   * @param y1   starting y coordinate.
   * @param w1   starting width.
   * @param h1   starting height.
   * @param r1   starting red hue.
   * @param g1   starting green hue.
   * @param b1   starting blue hue.
   * @param t2   ending time.
   * @param x2   ending x coordinate.
   * @param y2   ending y coordinate.
   * @param w2   ending width.
   * @param h2   ending height.
   * @param r2   ending red hue.
   * @param g2   ending green hue.
   * @param b2   ending blue hue.
   */
  @Override
  public void addMotionForShape(String name, int t1, int x1, int y1, int w1, int h1, int r1,
                                int g1, int b1, int t2, int x2, int y2, int w2,
                                int h2, int r2, int g2, int b2) {
    if (t1 > t2) {
      throw new IllegalArgumentException("StartTime can't be greater than  to endTime");
    }

    Motion newMove = new MotionForGUI(name, t1, x1, y1, w1, h1, r1, g1, b1,
                                      t2, x2, y2, w2, h2, r2, g2, b2);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      Motion temp = this.listOfMotions.get(i);
      if (t1 > temp.getStartTime() && t1 < temp.getEndTime()) {
        throw new IllegalArgumentException("Trying to do addMove, but it overlaps with " +
                "another move's times. (1)");
      }
      if (temp.getStartTime() > t1 && temp.getStartTime() < t2) {
        throw new IllegalArgumentException("Trying to do addMove, but it overlaps with " +
                "another move's times. (2)");
      }

    }
    this.listOfMotions.add(newMove);
    this.adjustAppearsDisappears(t1, t2);
  }

  /**
   * Getter method for the shape's color in string format. Hues range from 0 to 255.
   *
   * @return returns the shape's color in (red,green,blue) format.
   */
  @Override
  public String getColor() {
    return "(" + this.red + "," + this.green + "," + this.blue + ")";
  }

  private void adjustAppearsDisappears(int startTime, int endTime) {
    if (this.appears == 0 && this.disappears == 1000000) {
      this.appears = startTime;
      this.disappears = endTime;
    }
    if (this.appears > startTime) {
      this.appears = startTime;
    }
    if (this.disappears < endTime) {
      this.disappears = endTime;
    }
  }

  /**
   * Getter method for the shape's red hue.
   *
   * @return Shape's red hue as an int.
   */
  @Override
  public int getRed() {
    return this.red;
  }

  /**
   * Getter method for the shape's green hue.
   *
   * @return Shape's green hue as an int.
   */
  @Override
  public int getGreen() {
    return this.green;
  }

  /**
   * Getter method for the shape's blue hue.
   *
   * @return Shape's blue hue as an int.
   */
  @Override
  public int getBlue() {
    return this.blue;
  }

  /**
   * Moves this shape. Contains information about where its end X and end Y coordinates will be at,
   * as well as its start time and end time information.
   *
   * @param endPosX   X coordinate the shape will move to.
   * @param endPosY   Y coordinate the shape will move to.
   * @param startTime Start time of this change.
   * @param endTime   End time of this change.
   */
  @Override
  public void addMove(double endPosX, double endPosY, int startTime, int endTime)
          throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }

    Motion newMove = new Move(this.name, this.posX, this.posY, endPosX, endPosY,
            startTime, endTime);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      if (this.listOfMotions.get(i).isMove()) {
        Motion temp = this.listOfMotions.get(i);
        if (startTime >= temp.getStartTime() && startTime < temp.getEndTime()) {
          throw new IllegalArgumentException("Trying to do addMove, but it overlaps with " +
                  "another move's times. (1)");
        }
        if (temp.getStartTime() >= startTime && temp.getStartTime() < endTime) {
          throw new IllegalArgumentException("Trying to do addMove, but it overlaps with " +
                  "another move's times. (2)");
        }
      }
    }
    this.listOfMotions.add(newMove);
    this.posX = endPosX;
    this.posY = endPosY;
    this.adjustAppearsDisappears(startTime, endTime);
  }

  /**
   * Changes this shape's color. Contains information about what the new red, new green and new blue
   * colors will be, as well as its start time and end time information.
   *
   * @param newRed    The red hue value of our new color.
   * @param newGreen  The green hue value of our new color.
   * @param newBlue   The blue hue value of our new color.
   * @param startTime Start time of this change.
   * @param endTime   End time of this change.
   */
  @Override
  public void addChangeColor(int newRed, int newGreen, int newBlue, int startTime, int endTime)
          throws IllegalArgumentException {
    if (newRed > 255 || newRed < 0 || newGreen > 255 || newGreen < 0 ||
            newBlue > 255 || newBlue < 0) {
      throw new IllegalArgumentException("Make sure your colors are between 0 and 255.");
    }
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }

    Motion newColor = new ChangeColor(this.name, this.red, this.green, this.blue, newRed, newGreen,
            newBlue, startTime, endTime);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      if (this.listOfMotions.get(i).isChangeColor()) {
        Motion temp = this.listOfMotions.get(i);
        if (startTime >= temp.getStartTime() && startTime < temp.getEndTime()) {
          throw new IllegalArgumentException("Trying to do addChangeColor, but it overlaps with" +
                  " another move's times. (1)");
        }
        if (temp.getStartTime() >= startTime && temp.getStartTime() < endTime) {
          throw new IllegalArgumentException("Trying to do addChangeColor, but it overlaps with " +
                  "another move's times. (2)");
        }
      }
    }
    this.listOfMotions.add(newColor);

    this.red = newRed;
    this.green = newGreen;
    this.blue = newBlue;
    this.adjustAppearsDisappears(startTime, endTime);
  }

  /**
   * Changes this shape's dimensions. Contains information about what the new left-to-right
   * dimension and up-to-down dimension will be as well as its start time and end time information.
   *
   * @param leftToRightNewDimension The new length of our left-to-right dimension.
   * @param upToDownNewDimension    The new length of our up-to-down dimension.
   * @param startTime               Start time of this change.
   * @param endTime                 End time of this change.
   */
  @Override
  public void addScale(double leftToRightNewDimension, double upToDownNewDimension, int startTime,
                       int endTime) throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }

    Motion newScale = new Scale(this.name, this.width, this.height, leftToRightNewDimension,
            upToDownNewDimension, startTime, endTime);
    for (int i = 0; i < this.listOfMotions.size(); i++) {
      if (this.listOfMotions.get(i).isScale()) {
        Motion temp = this.listOfMotions.get(i);
        if (startTime >= temp.getStartTime() && startTime < temp.getEndTime()) {
          throw new IllegalArgumentException("Trying to do addScale, but it overlaps with " +
                  "another move's times. (1)");
        }
        if (temp.getStartTime() >= startTime && temp.getStartTime() < endTime) {
          throw new IllegalArgumentException("Trying to do addScale, but it overlaps with " +
                  "another move's times. (2)");
        }
      }
    }
    this.listOfMotions.add(newScale);

    this.width = leftToRightNewDimension;
    this.height = upToDownNewDimension;
    this.adjustAppearsDisappears(startTime, endTime);
  }

  /**
   * Gets a list of active Motions at a given frame. Used for GUI view.
   *
   * @param frame frame (or tick).
   * @return List of active Motions at a given frame.
   */
  @Override
  public List<Motion> getListOfCurrentMotions(int frame) {
    List<Motion> returnedList = new ArrayList<Motion>();
    for (Motion motion : this.listOfMotions) {
      if (frame >= motion.getStartTime() && frame <= motion.getEndTime()) {
        //System.out.println(motion.getString(Identifier.RECTANGLE));
        returnedList.add(motion);
      }
    }
    return returnedList;
  }

  /**
   * Gets the time the shape appears.
   *
   * @return time shape appears.
   */
  @Override
  public int getAppears() {
    return this.appears;
  }

  /**
   * Gets the time the shape disappears.
   *
   * @return time shape disappears.
   */
  @Override
  public int getDisappears() {
    return this.disappears;
  }
}
