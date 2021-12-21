
package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * ViewImplSVG produces the text view as dictated in the assignment8 spec. This text view is
 * compliant with the popular SVG file format. Since SVG is an XML-based format, it is a purely
 * text representation. SVG states the width and height of the view in brackets. Then, it states
 * the shapes. Descriptions of the shape's motions are nested within the shape tags.
 */
public class ViewImplSVG extends AbstractView {

  String output;

  public ViewImplSVG(String outputName, int ticksPerSecond) {
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
