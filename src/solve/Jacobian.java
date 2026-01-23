package src.solve;

import src.utils.Equation;

import java.util.ArrayList;

import src.math.Matrix;
import src.math.Vector;
import src.numbers.Number;

public class Jacobian<T extends Number, R extends Number> {

  private ArrayList<Vector<T>> splitVectorByComponent(Vector<T> vec) {
    T a = (T)(new Object());
    ArrayList<Vector<T>> vectors = new ArrayList<Vector<T>>();
    vectors.ensureCapacity(a.getN());
    double[] data = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      data[i] = vec.at(i);
      vectors.add(new Vector<T>(data));
      data[i] = 0;
    }
    return vectors;
  }

  public Matrix<R, T> getJacobian(Vector<T> start, Integrator<T> integrator, Equation<T, R> lossEquation, Vector<T> steps) {
    T a = (T)(new Object());
    R b = (R)(new Object());

    Matrix<R, T> jacobian = new Matrix<R, T>();

    ArrayList<Vector<T>> vectors = splitVectorByComponent(steps);

    for (int i=0; i<a.getN(); ++i) {
      Vector<R> loss = lossEquation.eval(0, integrator.integrate(start).add(integrator.integrate(start.add(vectors.get(i)))).mul(1/steps.at(i)));
      for (int j=0; j<b.getN(); ++j) {
        jacobian.set(j, i, loss.at(j));
      }
    }

    return jacobian;
  }
}
