package cs5004.animator.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ViewFactory is a factory class that helps us instantiate the correct View object.
 */
public class ViewFactory {

  JFrame frame = new JFrame();
  //JOptionPane.showMessageDialog(frame,"Eggs are not supposed to be green.");

  /**
   * Takes a string input and returns a View object corresponding to the input.
   * @param viewName Name of the View type.
   * @return View object corresponding to the input.
   * @throws IllegalArgumentException If the viewName does not correspond to any View object.
   */
  public IView getInstance(String viewName, String outputName, int ticksPerSecond)
          throws IllegalArgumentException {
    IView view;
    if (viewName.equalsIgnoreCase("text")) {
      view = new ViewImplText(outputName, ticksPerSecond);
    }
    else if (viewName.equalsIgnoreCase("visual")) {
      view = new ViewImplGUI(outputName, ticksPerSecond);
    }
    else if (viewName.equalsIgnoreCase("svg")) {
      view = new ViewImplSVG(outputName, ticksPerSecond);
    }
    else if (viewName.equalsIgnoreCase("playback")) {
      view = new ViewImplPlayBackGUI(outputName, ticksPerSecond);
    }
    else {
      JOptionPane.showMessageDialog(frame,"That's not a valid view!!!");
      throw new IllegalArgumentException("That's not a valid view!!!");
    }
    return view;
  }
}
