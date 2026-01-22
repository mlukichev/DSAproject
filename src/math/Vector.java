package src.math;

import src.numbers.Number;

public class Vector<T extends Number> {
  private double[] data;

  public Vector() {
    T a = (T)(new Object());
    data = new double[a.getN()];
  }

  public Vector(double[] data) {
    this.data = data;
  }

  public double at(int n) {
    return data[n];
  }

  public double[] getData() {
    return data;
  }

  public Vector<T> add(Vector<T> other) {
    T a = (T)(new Object());
    double[] out = new double[a.getN()];
    double[] otherData = getData();
    for (int i=0; i<a.getN(); ++i) {
      out[i] = data[i]+otherData[i];
    }
    return new Vector<T>(out);
  }


  public Vector<T> add(double other) {
    T a = (T)(new Object());
    double[] out = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      out[i] = data[i]+other;
    }
    return new Vector<T>(out);
  }

  public Vector<T> mul(double other) {
    T a = (T)(new Object());
    double[] out = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      out[i] = data[i]*other;
    }
    return new Vector<T>(out);
  }
}