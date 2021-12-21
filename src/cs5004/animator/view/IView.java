package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This interface represents the View of our MVC and contains operations offered by
 * our view.
 */
public interface IView {

  /**
   * The only method in the view interface renders the view according to its specific
   * class implementation.
   * @throws IOException if we can't produce the output file.
   */
  void render() throws IOException;

  void setEcho(String returned);

  int getTicksPerSecond();

  void setPreferredSize(int x, int y, int width, int height);

  void doPaint(String shapesData);

  void setListener(ActionListener listener);

  boolean getStateEnabled();

  boolean getStateDisabled();

  void setStateEnabled(boolean bool);

  void setStateDisabled(boolean bool);
}
