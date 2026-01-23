package src.solve;

import src.math.Vector;
import src.numbers.Number;

public abstract class Condition<T extends Number> {
  double previousVal;

  public abstract double g(double t, Vector<T> val);
  public abstract boolean check(double t, Vector<T> val, boolean increasing);

  
}