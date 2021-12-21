package cs5004.animator.view;

import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;

/**
 * ViewImplPlayBackGUI produces the visual view as dictated in the assignment10 spec. This visual
 * view extends ViewImplGUI as it is very similar to that visual GUI. ViewImplPlayBackGUI builds
 * on top of ViewImplGUI by putting a MenuBar of options that allow us to pause, resume, restart,
 * loop, increase speed etc the animation.
 */
public class ViewImplPlayBackGUI extends ViewImplGUI  {

  JMenuBar menuBar;
  JMenu control;
  JMenu looping;
  JMenu speed;

  JMenuItem start;
  JMenuItem pause;
  JMenuItem resume;
  JMenuItem restart;

  JCheckBoxMenuItem enabled;
  JCheckBoxMenuItem disabled;

  JMenuItem increase;
  JMenuItem decrease;

  public ViewImplPlayBackGUI(String outputName, int ticksPerSecond) {
    super(outputName, ticksPerSecond);
  }

  @Override
  public void render() {
    JFrame window = new JFrame("Visual GUI");
    scrollPane.setViewportView(this);
    window.add(scrollPane);

    menuBar = new JMenuBar();
    window.setJMenuBar(menuBar);

    control = new JMenu("Control");
    menuBar.add(control);
    start = new JMenuItem("Start");
    control.add(start);
    pause = new JMenuItem("Pause");
    control.add(pause);
    resume = new JMenuItem("Resume");
    control.add(resume);
    restart = new JMenuItem("Restart");
    control.add(restart);

    looping = new JMenu("Looping");
    menuBar.add(looping);
    enabled = new JCheckBoxMenuItem("Enabled");
    looping.add(enabled);
    disabled = new JCheckBoxMenuItem("Disabled");
    disabled.setSelected(true);
    looping.add(disabled);

    speed = new JMenu("Speed");
    menuBar.add(speed);
    increase = new JMenuItem("Increase Speed");
    speed.add(increase);
    decrease = new JMenuItem("Decrease Speed");
    speed.add(decrease);

    start.setActionCommand("Start Button");
    pause.setActionCommand("Pause Button");
    resume.setActionCommand("Resume Button");
    restart.setActionCommand("Restart Button");

    enabled.setActionCommand("Enabled Button");
    disabled.setActionCommand("Disabled Button");

    increase.setActionCommand("Increase Button");
    decrease.setActionCommand("Decrease Button");

    window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    window.setVisible(true);
  }

  @Override
  public void setListener(ActionListener listener) {
    start.addActionListener(listener);
    pause.addActionListener(listener);
    resume.addActionListener(listener);
    restart.addActionListener(listener);

    enabled.addActionListener(listener);
    disabled.addActionListener(listener);

    increase.addActionListener(listener);
    decrease.addActionListener(listener);
  }

  @Override
  public boolean getStateEnabled() {
    return enabled.getState();
  }

  @Override
  public boolean getStateDisabled() {
    return disabled.getState();
  }

  @Override
  public void setStateEnabled(boolean bool) {
    enabled.setSelected(bool);
  }

  @Override
  public void setStateDisabled(boolean bool) {
    disabled.setSelected(bool);
  }
}
