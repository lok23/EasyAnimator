package cs5004.animator.view;

import javax.swing.JLabel;


/**
 * Abstract class for our views. Extends JLabel since ViewImplGUI needs it.
 */
public abstract class AbstractView extends JLabel implements IView {

  String outputName;
  int ticksPerSecond;

  /**
   * AbstractView constructor sets up the constructor for all other Views.
   * @param outputName Determines the output location of this method. Not used in the ViewImplGUI.
   * @param ticksPerSecond Affects speed of the animation. Affects svg and GUI view speeds.
   */
  public AbstractView(String outputName, int ticksPerSecond) {
    this.outputName = outputName;
    this.ticksPerSecond = ticksPerSecond;
  }

  @Override
  public int getTicksPerSecond() {
    return this.ticksPerSecond;
  }
}
