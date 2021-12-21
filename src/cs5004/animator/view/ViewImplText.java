package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * ViewImplText produces the text view as dictated in the assignment8 spec. First, it states the
 * shapes to be created. Next it states when the shapes are to be instantiated. Then it states all
 * the motions that the shapes undergo. Shapes are described doing only do one verb at a time:
 * they can only change color, move, and scale in one sentence. If shapes do several actions at a
 * given time, then it requires several sentences to describe it.
 */
public class ViewImplText extends AbstractView {

  String output;

  public ViewImplText(String outputName, int ticksPerSecond) {
    super(outputName, ticksPerSecond);
  }

  @Override
  public void render() throws IOException {

    if (outputName.equals("")) {
      System.out.println(this.output);
    }
    else {
      Writer writer = new FileWriter(outputName);

      writer.write(this.output);
      writer.close();
    }
  }

  @Override
  public void setEcho(String returned) {
    this.output = returned;
  }

  @Override
  public void setPreferredSize(int x, int y, int width, int height)
          throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public void doPaint(String shapesData) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public void setListener(ActionListener listener) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public boolean getStateEnabled() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public boolean getStateDisabled() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public void setStateEnabled(boolean bool) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public void setStateDisabled(boolean bool) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This operation is not supported");
  }
}
