public class Solver<T extends Number> {
  private final Equation<T, T> equation;
  private final double maxTime;
  private final double step;
  private final Condition<T> check;

  public Solver(Equation<T, T> equation, double maxTime, double step, Condition<T> check) {
    this.equation = equation;
    this.maxTime = maxTime;
    this.step = step;
    this.check = check;
  }

  private Vector<T> nextState(double t, Vector<T> start) {
    Vector<T> k1 = equation.eval(t, start);
    Vector<T> k2 = equation.eval(t+step/2, start.add(k1.mul(step/2)));
    Vector<T> k3 = equation.eval(t+step/2, start.add(k2.mul(step/2)));
    Vector<T> k4 = equation.eval(t+step, k3.add(step));
    return start.add(k1.add(k2.mul(2).add(k3.mul(2).add(k4))).mul(step/6));
  }

  private Vector<T> integrate(Vector<T> start) {
    double t = 0;
    Vector<T> sum = start;
    Vector<T> prev = start;
    Vector<T> curr = start;
    sum = sum.add(curr.mul(step));
    while (t <= maxTime) {
      prev = curr;
      curr = nextState(t, curr);
      sum = sum.add(curr.mul(step));
      if (check.check(curr, prev)) {
        break;
      }
      t += step;
    }
    return sum;
  }

  public Pair<Vector<T>, Vector<T>> solve() {

  }

}