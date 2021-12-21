package cs5004.animator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;
import controller.IController;
import cs5004.animator.util.AnimationReader;
import model.model.IModel;
import model.model.ModelImpl;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;


/**
 * EasyAnimator accepts command-line arguments through IntelliJ. It's main() method will be the
 * entry point for your program. The command-line arguments are of the form -in
 * "name-of-animation-file" -view "type-of-view" -out "where-output-show-go" -speed
 * "integer-ticks-per-second". -in and -view are required; -out and -speed are optional.
 */
public class EasyAnimator {

  private static void checkForInvalidViewAndOut(String outputType, String viewName) {
    JFrame frame = new JFrame();
    if (outputType.equals("txt")) {
      if (!viewName.equals("text")) {
        JOptionPane.showMessageDialog(frame,
                "View and output type need to be the same.");
        throw new IllegalArgumentException("View and output type need to be the same.");
      }
    }
    if (outputType.equals("svg")) {
      if (!viewName.equals("svg")) {
        JOptionPane.showMessageDialog(frame,
                "View and output type need to be the same.");
        throw new IllegalArgumentException("View and output type need to be the same.");
      }
    }
  }

  /**
   * Main method of our program. Reads in string arguments, then produces the desired view.
   * @param args String array arguments containing data we want parsed.
   * @throws IllegalArgumentException If arguments are not valid as specified in spec.
   * @throws IOException If cannot find file to read from.
   */
  public static void main(String[] args) throws IllegalArgumentException, IOException {

    IModel model = null;
    IView view = null;
    IController controller;
    boolean passedIn = false;
    boolean passedView = false;
    boolean passedOut = false;
    boolean passedSpeed = false;
    String viewName = "";
    String outputName = "";
    int ticksPerSecond = 1;
    JFrame frame = new JFrame();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        if (passedIn) {
          JOptionPane.showMessageDialog(frame,
                  "Can't use two -in as the command line argument.");
          throw new IllegalArgumentException("Can't use two -in as the command line argument.");
        }
        String txtName = args[i + 1];
        File f = new File(txtName); // this file doesnt exist yet
        FileReader fr = new FileReader(f);
        model = AnimationReader.parseFile(fr, new ModelImpl.Builder());
        i++;
        passedIn = true;
      } else if (args[i].equalsIgnoreCase("-view")) {
        if (passedView) {
          JOptionPane.showMessageDialog(frame,
                  "Can't use two -view as the command line argument.");
          throw new IllegalArgumentException("Can't use two -view as the command line argument.");
        }
        viewName = args[i + 1];
        //view.render(model);
        i++;
        passedView = true;
      } else if (args[i].equalsIgnoreCase("-out")) {
        if (passedOut) {
          JOptionPane.showMessageDialog(frame,
                  "Can't use two -out as the command line argument.");
          throw new IllegalArgumentException("Can't use two -out as the command line argument.");
        }
        outputName = args[i + 1];
        i++;
        passedOut = true;
      } else if (args[i].equalsIgnoreCase("-speed")) {
        if (passedSpeed) {
          JOptionPane.showMessageDialog(frame,
                  "Can't use two -speed as the command line argument.");
          throw new IllegalArgumentException("Can't use two -speed as the command line argument.");
        }
        ticksPerSecond = Integer.parseInt(args[i + 1]);
        if (ticksPerSecond <= 0) {
          JOptionPane.showMessageDialog(frame,
                  "Ticks per second needs to be positive.");
          throw new IllegalArgumentException("Ticks per second needs to be positive.");
        }
        i++;
        passedSpeed = true;
      } else {
        JOptionPane.showMessageDialog(frame,
                "That's not valid command line arguments!");
        throw new IllegalArgumentException("That's not valid command line arguments!");
      }
    }

    ViewFactory vf = new ViewFactory();
    view = vf.getInstance(viewName, outputName, ticksPerSecond);

    //Need an input and a view to create stuff. Other two (out and speed) are optional.
    if (passedIn && passedView) {
      if (!outputName.equals("")) {
        String outputType = outputName.substring(outputName.length() - 3);
        //Checking whether output is same as view. (for example, output.txt has text view type).
        checkForInvalidViewAndOut(outputType, viewName);
      }
      controller = new Controller(model, view);
      controller.run();
    } else {
      JOptionPane.showMessageDialog(frame,
              "Need valid -in and -view.");
      throw new IllegalArgumentException("Need valid -in and -view");
    }

  }
}
