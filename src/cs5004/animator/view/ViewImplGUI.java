
package cs5004.animator.view;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JFrame;

/**
 * ViewImplGUI produces the visual view as dictated in the assignment8 spec. This visual view is
 * implemented via the Java swing library. Every select number of milliseconds, a timer increases
 * the current frame by 1. Then, the shapes and motions at the current frame are tweened to get
 * their current location and properties. These are then drawn onto a JLabel object.
 */
public class ViewImplGUI extends AbstractView {

  //private int currentFrame = 1;
  int x;
  int y;
  int width;
  int height;
  List<String> unparsedInfo;
  JScrollPane scrollPane = new JScrollPane();

  public ViewImplGUI(String outputName, int ticksPerSecond) {
    super(outputName, ticksPerSecond);
  }

  @Override
  public void setPreferredSize(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(this.width + this.x,
                  this.height + this.y);
  }

  @Override
  public void doPaint(String shapesData) {
    String str = shapesData;
    List<String> elephantList = Arrays.asList(str.split(","));
    this.unparsedInfo = elephantList;
    repaint();
    //System.out.println(elephantList);
  }

  @Override
  public void paintComponent(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;
    for (int i = 0; i < (this.unparsedInfo.size() / 8); i++) {
      //System.out.println(this.unparsedInfo.size()/8);

      String shapeType = this.unparsedInfo.get(0 + 8 * i);
      int red = Integer.parseInt(this.unparsedInfo.get(1 + 8 * i));
      int green = Integer.parseInt(this.unparsedInfo.get(2 + 8 * i));
      int blue = Integer.parseInt(this.unparsedInfo.get(3 + 8 * i));

      int x = Integer.parseInt(this.unparsedInfo.get(4 + 8 * i));
      int y = Integer.parseInt(this.unparsedInfo.get(5 + 8 * i));
      int width = Integer.parseInt(this.unparsedInfo.get(6 + 8 * i));
      int height = Integer.parseInt(this.unparsedInfo.get(7 + 8 * i));

      if (shapeType.equals("oval")) {
        g2d.setColor(new Color(red, green, blue));
        g2d.fillOval(x, y, width, height);
      } else if (shapeType.equals("rect")) {
        g2d.setColor(new Color(red, green, blue));
        g2d.fillRect(x, y, width, height);
      }
    }
  }

  @Override
  public void render() {
    JFrame window = new JFrame("Visual GUI");
    scrollPane.setViewportView(this);
    window.add(scrollPane);
    window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //int delay = (1000 / ticksPerSecond);

    //Timer t = new Timer(delay, this);
    //t.start();
    window.setVisible(true);
  }

  @Override
   public void setEcho(String returned) throws UnsupportedOperationException {
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

