import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import controller.Controller;
import controller.IController;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.MockTextView;
import model.model.IModel;
import model.model.ModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Controller through a MockTextView.
 */
public class TestMockTextView {

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
  public void testTextView() throws IOException, InterruptedException {
    IView view = new MockTextView( "",20, new StringBuilder());
    IController controller = new Controller(model, view);
    controller.run();
    assertEquals(((MockTextView) view).getLog().toString(), "input setEcho: Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 25.0, Height: 100.0, Color: (255,0,0)\n" +
            "Appears at t=10\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: C\n" +
            "Type: oval\n" +
            "Center: (440.0,370.0), X radius: 120.0, Y radius: 60.0, Color: (0,255,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=80\n" +
            "\n" +
            "Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50\n" +
            "Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: " +
            "100.0 from t=51 to t=70\n" +
            "Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100\n" +
            "Shape C moves from (440.0,70.0) to (440.0,250.0) from t=20 to t=50\n" +
            "Shape C moves from (440.0,250.0) to (440.0,370.0) from t=50 to t=70\n" +
            "Shape C changes color from (0,0,255) to (0,170,85) from t=50 to t=70\n" +
            "Shape C changes color from (0,170,85) to (0,255,0) from t=70 to t=80");
  }
}
