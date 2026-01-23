package src.math;

import src.numbers.Number;

public class Matrix<T extends Number, R extends Number> {
  double[][] data;

  public Matrix() {
    T a = (T)(new Object());
    R b = (R)(new Object());
    data = new double[a.getN()][b.getN()];
  }

  public Matrix(double[][] data) {
    this.data = data;
  }

  public double at(int r, int c) {
    return data[r][c];
  }

  public void set(int r, int c, double val) {
    data[r][c] = val;
  }

  public Matrix<T, R> add(Matrix<T, R> other) {
    T a = (T)(new Object());
    R b = (R)(new Object());
    double[][] out = new double[a.getN()][b.getN()];
    for (int i=0; i<a.getN(); ++i) {
      for (int j=0; j<b.getN(); ++j) {
        out[i][j] = this.at(i, j) + other.at(i, j);
      }
    }
    return new Matrix<T, R>(out);
  }

  public Matrix<T, R> mul(double other) {
    T a = (T)(new Object());
    R b = (R)(new Object());
    double[][] out = new double[a.getN()][b.getN()];
    for (int i=0; i<a.getN(); ++i) {
      for (int j=0; j<b.getN(); ++j) {
        out[i][j] = data[i][j] * other;
      }
    }
    return new Matrix<T, R>(out);
  }

  public Vector<T> mul(Vector<R> other) {
    T a = (T)(new Object());
    R b = (R)(new Object());
    double[] out = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      for (int j=0; j<b.getN(); ++j) {
        out[i] += data[i][j] * other.at(j);
      }
    }
    return new Vector<T>(out);
  }
}