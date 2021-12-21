import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import controller.Controller;
import controller.IController;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.MockGUIView;
import model.model.IModel;
import model.model.ModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Testing the Controller through a MockGUIView.
 */
public class TestMockGUIView {

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
  public void testGUIView() throws IOException, InterruptedException {
    IView view = new MockGUIView( "",20, new StringBuilder());
    IController controller = new Controller(model, view);
    controller.run();
    assertEquals(((MockGUIView) view).getLog().toString(), "getTicksPerSecond was called\n" +
            "Input setPreferredSize: 200,70,360,360\n" +
            "render was called\n");
  }
}
