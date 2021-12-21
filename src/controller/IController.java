package controller;

import java.io.IOException;

/**
 * IController is the interface for the controller. It contains one method, which runs the program.
 */
public interface IController {

  /**
   * Takes the model and the view, and creates the text/svg/visual/playback animation.
   * @throws IOException if there is invalid output.
   */
  void run() throws IOException;

}
