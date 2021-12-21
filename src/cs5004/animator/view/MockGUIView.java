
package cs5004.animator.view;

import java.awt.event.ActionListener;

/**
 * A Mock test class for ViewImplGUI. Contains log, which keeps track of which methods we've called.
 */
public class MockGUIView extends ViewImplGUI {

  private StringBuilder log;

  /**
   * Same constructor as ViewImplGUI, but contains a log that tracks the methods called.
   * @param outputName the name that this view will output to. Optional, System.out by default.
   * @param ticksPerSecond How many ticks are in a second. Optional, 1 by default.
   * @param log keeps track of what methods were called.
   */
  public MockGUIView(String outputName, int ticksPerSecond, StringBuilder log) {
    super(outputName, ticksPerSecond);
    this.log = log;
  }

  @Override
  public void render() {
    log.append("render was called" + "\n");
  }

  @Override
  public void setEcho(String returned) {
    log.append("Input setEcho: " + returned + "\n");
  }

  @Override
  public int getTicksPerSecond() {
    log.append("getTicksPerSecond was called" + "\n");
    return 20;
  }

  @Override
  public void setPreferredSize(int x, int y, int width, int height) {
    log.append("Input setPreferredSize: " + x + "," + y + "," + width + "," + height + "\n");
  }

  @Override
  public void doPaint(String shapesData) {
    log.append("Input doPaint: " + shapesData + "\n");
  }

  @Override
  public void setListener(ActionListener listener) {
    log.append("Input setListener: " + listener + "\n");
  }

  @Override
  public boolean getStateEnabled() {
    log.append("getStateEnabled was called" + "\n");
    return true;
  }

  @Override
  public boolean getStateDisabled() {
    log.append("Input getStateDisabled:" + "\n");
    return true;
  }

  @Override
  public void setStateEnabled(boolean bool) {
    log.append("Input setStateEnabled: " + bool + "\n");
  }

  @Override
  public void setStateDisabled(boolean bool) {
    log.append("Input setStateDisabled: " + bool + "\n");
  }

  public StringBuilder getLog() {
    return this.log;
  }

}
