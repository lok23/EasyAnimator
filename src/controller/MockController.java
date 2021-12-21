package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

import cs5004.animator.view.IView;
import model.model.IModel;

/**
 * A Mock test class for Controller. Contains log, which keeps track of which methods we've called.
 */
public class MockController implements IController, ActionListener {

  StringBuilder log;

  private int ticksPerSecond;

  /**
   * Mock implementation of controller.
   * @param m model of MVC, performs all the calculations.
   * @param v view of MVC, sets up the user facing product.
   */
  public MockController(IModel m, IView v) {
    this.log = new StringBuilder();
    IView view = v;
    int currentFrame = 1;
    ticksPerSecond = view.getTicksPerSecond();
  }

  @Override
  public void run() throws IOException {
    log.append("go was triggered");
    int delay = (1000 / ticksPerSecond);

    Timer t = new Timer(delay, this);
    t.setActionCommand("Timer");
    t.start();
  }

  /**
   * Returns the log, which tracks which methods have been called.
   * @return StringBuilder log, which tracks which methods have been called.
   */
  public StringBuilder getLog() {
    return this.log;
  }

  /**
   * Appends to the log whenever actionPerformed is called.
   * @param actionEvent the thing triggering actionPerformed.
   */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    log.append("input actionPerformed: " + actionEvent + "\n");
  }
}
