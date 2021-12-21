package model.motion;

/**
 * AbstractMotion contains data common to all Motion objects. It contains a constructor,
 * getStartTime and getEndTime methods, and returns false by default for isMove, isChangeColor,
 * and isScale.
 */
public abstract class AbstractMotion implements Motion {
  int startTime;
  int endTime;

  /**
   * Constructor for AbstractMotion contains startTime and endTime common to all subclasses.
   * @param startTime start time for this Motion.
   * @param endTime end time for this Motion.
   */
  public AbstractMotion(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Getter method for the Motion's start time.
   * @return Motion's start time.
   */
  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Getter method for the Motion's end time.
   * @return Motion's end time.
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Returns whether the Motion's class is Move.
   * @return boolean true if Motion's class is Move.
   */
  @Override
  public boolean isMove() {
    return false;
  }

  /**
   * Returns whether the Motion's class is ChangeColor.
   * @return boolean true if Motion's class is ChangeColor.
   */
  @Override
  public boolean isChangeColor() {
    return false;
  }

  /**
   * Returns whether the Motion's class is Scale.
   * @return boolean true if Motion's class is Scale.
   */
  @Override
  public boolean isScale() {
    return false;
  }
}
