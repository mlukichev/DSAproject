package src.solve;

import src.math.Vector;
import src.utils.Equation;
import src.utils.Pair;
import src.numbers.Number;

public class Integrator<T extends Number> {

  private double step;
  private double maxTime;
  private double maxIter; 
  private final Equation<T, T> equation;
  private final Condition<T> condition;

  public Integrator(double step, double maxTime, double maxIter, Equation<T, T> equation, Condition<T> condition) {
    this.step = step;
    this.maxTime = maxTime;
    this.maxIter = maxIter;
    this.equation = equation;
    this.condition = condition;
  }

  private Vector<T> nextState(double t, Vector<T> start) {
    Vector<T> k1 = equation.eval(t, start);
    Vector<T> k2 = equation.eval(t+step/2, start.add(k1.mul(step/2)));
    Vector<T> k3 = equation.eval(t+step/2, start.add(k2.mul(step/2)));
    Vector<T> k4 = equation.eval(t+step, start.add(k3.add(step)));
    return start.add(k1.add(k2.mul(2).add(k3.mul(2).add(k4))).mul(step/6));
  }

  public Vector<T> integrate(Vector<T> start) {
    double t = 0;
    Vector<T> sum = new Vector<T>();
    Vector<T> curr = start;
    sum = sum.add(curr.mul(step));
    double prevG = condition.g(t, curr);
    for (int i=1; i<maxIter && t<maxTime; ++i) {
      t += step;
      curr = nextState(t, curr);
      sum = sum.add(curr.mul(step));
      double g = condition.g(t, curr);
      if (condition.check(t, curr, g > prevG)) {
        break;
      }
      prevG = g;
    }
    return sum;
  }
}
