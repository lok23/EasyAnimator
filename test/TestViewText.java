import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import controller.Controller;
import controller.IController;
import cs5004.animator.EasyAnimator;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewImplText;
import model.model.IModel;
import model.model.ModelImpl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for ViewImplText and EasyAnimator.
 */
public class TestViewText {

  IModel model;
  IView view;

  @Before
  public void setUpBuilder() throws FileNotFoundException {
    File f = new File("C:\\Users\\denni\\IdeaProjects\\Assignment8Remastered\\" +
            "out\\artifacts\\Assignment8Remastered_jar\\smalldemo.txt");
    FileReader fr = new FileReader(f);
    model = AnimationReader.parseFile(fr, new ModelImpl.Builder());
  }

  @Test
  public void testViewImplSVGWorks() throws IOException {
    IView view = new ViewImplText("output.txt", 20);
    IController controller = new Controller(model, view);
    controller.run();
    File tempFile = new File("C:\\Users\\denni\\IdeaProjects\\Assignment8Remastered\\output.txt");
    assertTrue(tempFile.exists());
    BufferedReader br = new BufferedReader(new FileReader(tempFile));

    String st;
    String collection = "";
    while ((st = br.readLine()) != null) {
      collection += st;
    }
    assertEquals(collection, "Shapes: Name: R" +
            "Type: rectangleMin corner: (200.0,200.0), Width: 25.0, Height: 100.0, Color:" +
            " (255,0,0)Appears at t=10Disappears at t=100Name: CType: ovalCenter: (440.0,370.0)," +
            " X radius: 120.0, Y radius: 60.0, Color: (0,255,0)Appears at t=20Disappears at " +
            "t=80Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50Shape R" +
            " scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 " +
            "to t=70Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100Shape" +
            " C moves from (440.0,70.0) to (440.0,250.0) from t=20 to t=50Shape C moves from " +
            "(440.0,250.0) to (440.0,370.0) from t=50 to t=70Shape C changes color from (0,0,255)" +
            " to (0,170,85) from t=50 to t=70Shape C changes color from (0,170,85) to (0,255,0)" +
            " from t=70 to t=80");

  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailBadTicksPerSecond() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-out", "there.txt", "-view", "svg", "-speed", "0"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsNoIn() throws IOException {
    String[] myArgs = {"-view", "text"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsNoView() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = FileNotFoundException.class)
  public void testViewImplTextFailsInvalidIn() throws IOException {
    String[] myArgs = {"-in", "wee.txt", "-view", "text"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsInvalidView() throws IOException {
    String[] myArgs = {"-view", "IllegalView", "-in", "toh-5.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsMultipleIn() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-in", "toh-5.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsMultipleView() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-view", "text", "-view", "text"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsMultipleOut() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-out", "there.txt", "-view", "text",
      "-out", "output.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsMultipleSpeed() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-speed", "6", "-view", "text", "-speed", "5",
      "-out", "output.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsInvalidCommandLines() throws IOException {
    String[] myArgs = {"33jk3k", "eeet"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplTextFailsDifferentViewAndOutputType() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-view", "text", "-out", "output.svg"};
    EasyAnimator.main(myArgs);
  }
}
