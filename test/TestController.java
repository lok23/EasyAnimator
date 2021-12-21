import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import controller.IController;
import controller.MockController;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewImplGUI;
import cs5004.animator.view.ViewImplText;
import model.model.IModel;
import model.model.ModelImpl;

import static org.junit.Assert.assertEquals;


/**
 * Test class for Controller.
 */
public class TestController {

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
  public void testRun() throws IOException, InterruptedException {
    IView view = new ViewImplText( "",20);
    IController controller = new MockController(model, view);
    controller.run();
    assertEquals(((MockController) controller).getLog().toString(), "go was triggered");
  }

  @Test
  public void testActionListener() throws IOException, InterruptedException {
    String source = "source";
    int id = 44;
    String command = "hi";
    ActionEvent ae = new ActionEvent(source, 44, "hi");
    IView view = new ViewImplGUI( "",20);
    IController controller = new MockController(model, view);
    ((MockController) controller).actionPerformed(ae);
    assertEquals(((MockController) controller).getLog().toString(), "input " +
            "actionPerformed: java.awt.event.ActionEvent[unknown type,cmd=hi,when=0,modifiers=] " +
            "on source\n");
  }
}
