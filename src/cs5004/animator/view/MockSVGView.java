package cs5004.animator.view;

/**
 * A Mock test class for ViewImplSVG. Contains log, which keeps track of which methods
 * we've called.
 */
public class MockSVGView extends ViewImplSVG {

  private StringBuilder log;

  public MockSVGView(String outputName, int ticksPerSecond, StringBuilder log) {
    super(outputName, ticksPerSecond);
    this.log = log;
  }

  @Override
  public void setEcho(String returned) {
    this.output = returned;
    log.append("input setEcho: " + returned + "\n");
  }

  public StringBuilder getLog() {
    return this.log;
  }
}
