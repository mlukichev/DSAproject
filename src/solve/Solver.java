package src.solve;

import src.math.Matrix;
import src.math.Vector;
import src.numbers.Number;
import src.utils.Equation;
import src.utils.Pair;

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

  public Pair<Vector<T>, Vector<T>> solve() {
    
  }

}