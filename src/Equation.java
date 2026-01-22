package src;

import src.math.Vector;
import src.numbers.Number;

public interface Equation<T extends Number, R extends Number> {
  public Vector<R> eval(double t, Vector<T> input);
}