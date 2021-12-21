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
import cs5004.animator.view.ViewImplSVG;
import model.model.IModel;
import model.model.ModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for View Interface and EasyAnimator.
 */
public class TestViewSVG {
  IModel model;
  IView view;

  @Before
  public void setUpBuilder() throws IOException {
    File f = new File("C:\\Users\\denni\\IdeaProjects\\Assignment8Remastered\\" +
            "out\\artifacts\\Assignment8Remastered_jar\\smalldemo.txt");
    FileReader fr = new FileReader(f);
    model = AnimationReader.parseFile(fr, new ModelImpl.Builder());
  }

  @Test
  public void testViewImplSVGWorks() throws IOException {
    IView view = new ViewImplSVG("output.svg", 20);
    IController controller = new Controller(model, view);
    controller.run();
    File tempFile = new File("C:\\Users\\denni\\IdeaProjects\\Assignment8Remastered\\output.svg");
    assertTrue(tempFile.exists());
    BufferedReader br = new BufferedReader(new FileReader(tempFile));

    String st;
    String collection = "";
    while ((st = br.readLine()) != null) {
      collection += st;
    }
    assertEquals(collection, "<svg width=\"560\" height=\"430\" version=\"1.1\">" +
            "<rect id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"100.0\"" +
            " fill=\"rgb(255,0,0)\" visibility=\"visible\" >  " +
            "  <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" " +
            "attributeName=\"x\" from=\"200.0\" to=\"300.0\" fill=\"freeze\" />   " +
            " <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" attributeName=\"y\"" +
            " from=\"200.0\" to=\"300.0\" fill=\"freeze\" />    <animate attributeName=\"width\"" +
            " begin=\"2550ms\" dur=\"950ms\" from=\"50.0\" to=\"25.0\" fill=\"freeze\" />  " +
            "  <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\" attributeName=\"x\"" +
            " from=\"300.0\" to=\"200.0\" fill=\"freeze\" />   " +
            " <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\" attributeName=\"y\"" +
            " from=\"300.0\" to=\"200.0\" fill=\"freeze\" />  " +
            "  </rect><ellipse id=\"C\" cx=\"440.0\" cy=\"70.0\" rx=\"120.0\" ry=\"60.0\"" +
            " fill=\"rgb(0,0,255)\" visibility=\"visible\" > " +
            "   <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"1500ms\" " +
            "attributeName=\"cy\" from=\"70.0\" to=\"250.0\" fill=\"freeze\" />  " +
            "  <animate attributeType=\"xml\" begin=\"2500ms\" dur=\"1000ms\"" +
            " attributeName=\"cy\" from=\"250.0\" to=\"370.0\" fill=\"freeze\" />  " +
            "  <animate attributeName=\"fill\" attributeType=\"CSS\" from=\"rgb(0,0,255)\" " +
            "to=\"rgb(0,170,85)\" begin=\"2500ms\" dur=\"1000ms\" fill=\"freeze\" />  " +
            "  <animate attributeName=\"fill\" attributeType=\"CSS\" from=\"rgb(0,170,85)\"" +
            " to=\"rgb(0,255,0)\" begin=\"3500ms\" dur=\"500ms\" fill=\"freeze\" />   " +
            " </ellipse></svg>");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailBadTicksPerSecond() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-out", "there.svg", "-view", "svg", "-speed", "0"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsNoIn() throws IOException {
    String[] myArgs = {"-view", "svg"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsNoView() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = FileNotFoundException.class)
  public void testViewImplSVGFailsInvalidIn() throws IOException {
    String[] myArgs = {"-in", "wee.txt", "-view", "svg"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsInvalidView() throws IOException {
    String[] myArgs = {"-view", "IllegalVIEW", "-in", "toh-5.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsMultipleIn() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-in", "toh-5.txt"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsMultipleView() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-view", "svg", "-view", "svg"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsMultipleOut() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-out", "there.svg", "-view", "svg",
      "-out", "output.svg"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsMultipleSpeed() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-speed", "6", "-view", "svg", "-speed", "5",
      "-out", "output.svg"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsInvalidCommandLines() throws IOException {
    String[] myArgs = {"33jk3k", "eeet"};
    EasyAnimator.main(myArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testViewImplSVGFailsDifferentViewAndOutputType() throws IOException {
    String[] myArgs = {"-in", "toh-5.txt", "-view", "svg", "-out", "output.txt"};
    EasyAnimator.main(myArgs);
  }
}

