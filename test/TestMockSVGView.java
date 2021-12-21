import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import controller.Controller;
import controller.IController;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.MockSVGView;
import model.model.IModel;
import model.model.ModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Controller through a MockSVGView.
 */
public class TestMockSVGView {

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
  public void testSVGView() throws IOException, InterruptedException {
    IView view = new MockSVGView( "",20, new StringBuilder());
    IController controller = new Controller(model, view);
    controller.run();
    assertEquals(((MockSVGView) view).getLog().toString(), "input setEcho: " +
            "<svg width=\"560\" height=\"430\" version=\"1.1\">\n" +
            "\n" +
            "<rect id=\"R\" x=\"200.0\" y=\"200.0\" width=\"50.0\" height=\"10" +
            "0.0\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" " +
            "attributeName=\"x\" from=\"200.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" " +
            "attributeName=\"y\" from=\"200.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "    <animate attributeName=\"width\" begin=\"2550ms\" dur=\"950ms\"" +
            " from=\"50.0\" to=\"25.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\"" +
            " attributeName=\"x\" from=\"300.0\" to=\"200.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"3500ms\" dur=\"1500ms\"" +
            " attributeName=\"y\" from=\"300.0\" to=\"200.0\" fill=\"freeze\" />\n" +
            "    \n" +
            "</rect>\n" +
            "\n" +
            "\n" +
            "<ellipse id=\"C\" cx=\"440.0\" cy=\"70.0\" rx=\"120.0\" ry=\"60.0\" " +
            "fill=\"rgb(0,0,255)\" visibility=\"visible\" >\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"1500ms\"" +
            " attributeName=\"cy\" from=\"70.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"2500ms\" dur=\"1000ms\"" +
            " attributeName=\"cy\" from=\"250.0\" to=\"370.0\" fill=\"freeze\" />\n" +
            "    <animate attributeName=\"fill\" attributeType=\"CSS\" from=\"" +
            "rgb(0,0,255)\" to=\"rgb(0,170,85)\" begin=\"2500ms\" dur=\"1000ms\"" +
            " fill=\"freeze\" />\n" +
            "    <animate attributeName=\"fill\" attributeType=\"CSS\" " +
            "from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" begin=\"3500ms\"" +
            " dur=\"500ms\" fill=\"freeze\" />\n" +
            "    \n" +
            "</ellipse>\n" +
            "\n" +
            "\n" +
            "</svg>\n");
  }
}
