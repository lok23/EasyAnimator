package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.Timer;

import cs5004.animator.view.IView;
import cs5004.animator.view.ViewImplGUI;
import cs5004.animator.view.ViewImplPlayBackGUI;
import cs5004.animator.view.ViewImplSVG;
import cs5004.animator.view.ViewImplText;
import model.model.IModel;

/**
 * The controller mediates interactions between the model and the view, ensuring neither has
 * direct assess to the other. This controller is also responsible for handling the actionListener,
 * which may occur as a result of someone clicking on a menubar item (if using the playback view)
 * or if enough time has passed (if using playback or visual view).
 */
public class Controller implements IController, ActionListener {

  private IModel model;
  private IView view;
  private int currentFrame;
  private Timer t;
  private int ticksPerSecond;

  /**
   * Controller has access to model and view, and mediates interactions between them.
   * Controller has access to the currentFrame, which is used for playback and visual view.
   * It gets information about how many ticks are in a second from the view, which it then uses
   * to calculate the delay in the Timer (used for playback or visual view).
   * @param m model of MVC, performs all the calculations.
   * @param v view of MVC, sets up the user facing product.
   */
  public Controller(IModel m, IView v) {
    model = m;
    view = v;
    currentFrame = 1;
    ticksPerSecond = view.getTicksPerSecond();
  }

  @Override
  public void run() throws IOException {
    if (view instanceof ViewImplText) {
      String returned =  model.getImplText();
      view.setEcho(returned);
    }
    if (view instanceof ViewImplSVG) {
      String returned = model.getImplSVG(view.getTicksPerSecond());
      view.setEcho(returned);
    }
    if (view instanceof ViewImplGUI) {
      int x = model.getBoundsX();
      int y = model.getBoundsY();
      int width = model.getBoundsWidth();
      int height = model.getBoundsHeight();
      view.setPreferredSize(x, y, width, height);

      //int ticksPerSecond = view.getTicksPerSecond();
      int delay = (1000 / ticksPerSecond);

      t = new Timer(delay, this);
      t.setActionCommand("Timer");
      t.start();
    }
    view.render();
    if (view instanceof ViewImplPlayBackGUI) {
      view.setListener(this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getActionCommand().equals("Start Button")) {
      if (currentFrame <= 1) {
        t.start();
      }
      else {
        currentFrame = 1;
      }
    }
    if (actionEvent.getActionCommand().equals("Pause Button")) {
      t.stop();
    }
    if (actionEvent.getActionCommand().equals("Resume Button")) {
      t.start();
    }
    if (actionEvent.getActionCommand().equals("Restart Button")) {
      currentFrame = 0;
    }

    if (actionEvent.getActionCommand().equals("Enabled Button")) {
      //System.out.println(view.getStateEnabled());
      if (!view.getStateEnabled()) {
        view.setStateEnabled(true);
      }
      if (view.getStateEnabled()) {
        view.setStateEnabled(true);
        view.setStateDisabled(false);
      }
    }
    if (actionEvent.getActionCommand().equals("Disabled Button")) {
      //System.out.println(view.getStateDisabled());
      if (!view.getStateDisabled()) {
        view.setStateDisabled(true);
      }
      if (view.getStateDisabled()) {
        view.setStateEnabled(false);
        view.setStateDisabled(true);
      }
    }

    if (actionEvent.getActionCommand().equals("Increase Button")) {
      ticksPerSecond += 5;
      int delay = (1000 / ticksPerSecond);
      t.setDelay(delay);
    }
    if (actionEvent.getActionCommand().equals("Decrease Button")) {
      ticksPerSecond -= 5;
      if (ticksPerSecond < 1) {
        ticksPerSecond = 1;
      }
      int delay = (1000 / ticksPerSecond);
      t.setDelay(delay);
    }

    else {
      currentFrame += 1;
      String shapesData = model.createShapesAtCurrentFrameForGUI(currentFrame);
      //If enabled is enabled (haha joke), we will reset the currentFrame to 1 if
      //the animation is over.
      if (view instanceof ViewImplPlayBackGUI && view.getStateEnabled()) {
        if (shapesData.equals("")) {
          currentFrame = 1;
        }
      }
      view.doPaint(shapesData);
      //System.out.println(shapesData);
    }
  }

}
