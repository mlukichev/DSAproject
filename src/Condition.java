package src;

import src.math.Vector;
import src.numbers.Number;

public abstract class Condition<T extends Number> {
  public abstract double g(Vector<T> val);
  public abstract boolean check(Vector<T> a, Vector<T> b);
}