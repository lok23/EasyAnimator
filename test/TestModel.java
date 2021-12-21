import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cs5004.animator.util.AnimationReader;
import model.model.IModel;
import model.model.ModelImpl;
import model.shape.Rectangle;
import model.shape.Shape;

import static org.junit.Assert.assertEquals;

/**
 * Test class for ModelImpl.
 */
public class TestModel {

  IModel model;

  /**
   * Tests that our builder builds the model correctly.
   */
  @Before
  public void setUpBuilder() throws FileNotFoundException {
    File f = new File("C:\\Users\\denni\\IdeaProjects\\Assignment8Remastered\\" +
            "out\\artifacts\\Assignment8Remastered_jar\\smalldemo.txt");
    FileReader fr = new FileReader(f);
    model = AnimationReader.parseFile(fr, new ModelImpl.Builder());
  }

  @Test
  public void testGetMapOfInitialShapes() {
    assertEquals(model.getMapOfInitialShapes().toString(), "{R=Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1000000\n" +
            ", C=Name: C\n" +
            "Type: oval\n" +
            "Center: (440.0,70.0), X radius: 120.0, Y radius: 60.0, Color: (0,0,255)\n" +
            "Appears at t=0\n" +
            "Disappears at t=1000000\n" +
            "}");
  }

  @Test
  public void testGetShapesAtCurrectFrameForGUI() {
    assertEquals(model.getShapesAtCurrentFrameForGUI(4).toString(), "[Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            "]");
    assertEquals(model.getShapesAtCurrentFrameForGUI(50).toString(), "[Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            ", Name: C\n" +
            "Type: oval\n" +
            "Center: (440.0,70.0), X radius: 120.0, Y radius: 60.0, Color: (0,0,255)\n" +
            "Appears at t=6\n" +
            "Disappears at t=100\n" +
            "]");
    assertEquals(model.getShapesAtCurrentFrameForGUI(500).toString(), "[]");
  }

  @Test
  public void testGetMapOfShapesForGUI() {
    assertEquals(model.getMapOfShapesForGUI().toString(), "{R=Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (255,0,0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n" +
            ", C=Name: C\n" +
            "Type: oval\n" +
            "Center: (440.0,70.0), X radius: 120.0, Y radius: 60.0, Color: (0,0,255)\n" +
            "Appears at t=6\n" +
            "Disappears at t=100\n" +
            "}");
  }

  @Test
  public void testGetMapOfShapes() {
    assertEquals(model.getMapOfShapes().toString(), "{R=Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 25.0, Height: 100.0, Color: (255,0,0)\n" +
            "Appears at t=10\n" +
            "Disappears at t=100\n" +
            ", C=Name: C\n" +
            "Type: oval\n" +
            "Center: (440.0,370.0), X radius: 120.0, Y radius: 60.0, Color: (0,255,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=80\n" +
            "}");
  }

  @Test
  public void testGetBounds() {
    assertEquals(model.getBoundsWidth(), 360);
    assertEquals(model.getBoundsHeight(), 360);
  }

  /**
   * Tests from assignment 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersRed() {
    Shape rect = new Rectangle(-1,0,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersRed2() {
    Shape rect = new Rectangle(256,0,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersGreen() {
    Shape rect = new Rectangle(0,-1,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersGreen2() {
    Shape rect = new Rectangle(0,256,0, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersBlue() {
    Shape rect = new Rectangle(0,0,-1, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersBlue2() {
    Shape rect = new Rectangle(0,0, 256, "R", 200, 250, 10, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersWidth() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, -1, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersWidth2() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 0, 10, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersHeight() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, -1, 20, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersHeight2() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 0, 20, 50);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersAppears() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 10, -1, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersAppears2() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 10, 51, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMakeShapeBadParametersDisappears() {
    Shape rect = new Rectangle(0,0,0, "R", 200, 250, 10, 10, 20, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAlreadyExists() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addShape("R", rect);
    model.addShape("R", rect);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveShapeNotAddedToModelImpl() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove("R",200, 400, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveStartTimeEndTimeFails() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove("R",200, 400, 50, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsShapeAppears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove("R",200, 400, 10, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsShapeDisappears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove("R",200, 400, 30, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsAddMove() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove("R",200, 400, 30, 40);
    model.addMove("R",200, 400, 25, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMoveContradictsAddMove2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addMove("R",200, 400, 25, 35);
    model.addMove("R",200, 400, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorBadColors() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0, 256,0, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorBadColors2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0, -1,0, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorTimeEndTimeFails() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0, 0,255, 50, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsShapeAppears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0,0,255,10, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsShapeDisappears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0,0,255, 30, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsAddChangeColor() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0,0,255, 30, 40);
    model.addChangeColor("R",0,0,255, 25, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChangeColorContradictsAddChangeColor2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    model.addChangeColor("R",0,0,255, 25, 35);
    model.addChangeColor("R",0,0,255, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleNotAddedToModelImpl() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale("R",20, 40, 30, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleTimeEndTimeFails() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale("R",20, 40, 50, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsShapeAppears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale("R",20, 40, 10, 40);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsShapeDisappears() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale("R",200, 400, 30, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsAddScale() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale("R",20, 40, 30, 40);
    model.addScale("R",20, 40, 25, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddScaleContradictsAddScale2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addScale("R",20, 40, 25, 35);
    model.addScale("R",20, 40, 30, 40);
  }

  @Test
  public void testAddShapeUnMutated() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addShapeUnMutated("R",rect);
    assertEquals(model.getMapOfInitialShapes(), "{R=Name: O\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,250.0), Width: 10.0, Height: 10.0, Color: (255,0,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "}");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeUnMutated2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addShapeUnMutated("R",rect);
    model.addShapeUnMutated("R",rect);
  }

  @Test
  public void testAddShapeForGUI() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addShapesForGUI("R",rect);
    assertEquals(model.getMapOfShapesForGUI(), "{R=Name: O\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,250.0), Width: 10.0, Height: 10.0, Color: (255,0,0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "}");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeForGUI2() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addShapesForGUI("R",rect);
    model.addShapesForGUI("R",rect);
  }

  @Test
  public void testAddMotionForGUI() {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "O", 200, 250, 10, 10, 20, 50);
    model.addShapesForGUI("R",rect);
    model.addMotionForGUI("R", 0,100, 75, 20, 15, 255, 0, 0, 0, 100, 75, 20, 15, 255, 0, 0);
    assertEquals(model.getMapOfShapesForGUI().toString(), "{R=Name: O\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,250.0), Width: 10.0, Height: 10.0, Color: (255,0,0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=50\n" +
            "}");
  }

}
