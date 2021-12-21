package model.motion;

import model.shape.Identifier;

/**
 * This interface represents the animation Motion associated with each Shape.
 */
public interface Motion {

  /**
   * Getter method for the Motion's start time.
   * @return Motion's start time.
   */
  int getStartTime();

  /**
   * Getter method for the Motion's end time.
   * @return Motion's end time.
   */
  int getEndTime();

  /**
   * Returns whether the Motion's class is Move.
   * @return boolean true if Motion's class is Move.
   */
  boolean isMove();

  /**
   * Returns whether the Motion's class is ChangeColor.
   * @return boolean true if Motion's class is ChangeColor.
   */
  boolean isChangeColor();

  /**
   * Returns whether the Motion's class is Scale.
   * @return boolean true if Motion's class is Scale.
   */
  boolean isScale();

  /**
   * Returns text description of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @return Text description of the animation motion and its properties as a String.
   */
  String getString(Identifier identifier);

  /**
   * Returns svg formatted representation of the animation motion and its properties.
   * @param identifier enum identifier helps the function return the correct string.
   * @param ticksPerSecond determines time appears, disappears, and duration of motions.
   * @return Svg formatted representation of animation motion and its properties.
   */
  String getSVG(Identifier identifier, int ticksPerSecond);

  /**
   * Determines the tween x coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween x coordinate given frame.
   */
  int tweenX(int currentFrame);

  /**
   * Determines the tween y coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween y coordinate given frame.
   */
  int tweenY(int currentFrame);

  /**
   * Determines the tween width coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween width coordinate given frame.
   */
  int tweenWidth(int currentFrame);

  /**
   * Determines the tween height coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween height coordinate given frame.
   */
  int tweenHeight(int currentFrame);

  /**
   * Determines the tween red coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween red coordinate given frame.
   */
  int tweenRed(int currentFrame);

  /**
   * Determines the tween green coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween green coordinate given frame.
   */
  int tweenGreen(int currentFrame);

  /**
   * Determines the tween blue coordinate given frame.
   * @param currentFrame The given frame.
   * @return tween blue coordinate given frame.
   */
  int tweenBlue(int currentFrame);
}
