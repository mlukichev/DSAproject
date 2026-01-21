package src;
public interface Equation<T extends Number, R extends Number> {
  public Vector<R> eval(double t, Vector<T> input);
}