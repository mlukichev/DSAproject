package src;
public class Vector<T extends Number> {
  T a;
  private double[] data;

  public Vector(T a) {
    this.a = a;
    data = new double[a.getN()];
  }

  public Vector(T a, double[] data) {
    this.a = a;
    this.data = data.clone();
  }

  public double at(int n) {
    return data[n];
  }

  public double[] getData() {
    return data;
  }

  public Vector<T> copy() {
    return new Vector<T>(a);
  }

  private double[] addData(double[] other) {
    double[] sum = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      sum[i] = data[i]+other[i];
    }
    return sum;
  } 

  public Vector<T> add(Vector<T> other) {
    return new Vector<T>(a, addData(other.getData()));
  }

  private double[] addData(double other) {
    double[] sum = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      sum[i] = data[i]+other;
    }
    return sum;
  } 

  public Vector<T> add(double other) {
    return new Vector<T>(a, addData(other));
  }

  private double[] mulData(double other) {
    double[] mul = new double[a.getN()];
    for (int i=0; i<a.getN(); ++i) {
      mul[i] = data[i]*other;
    }
    return mul;
  } 

  public Vector<T> mul(double other) {
    return new Vector<T>(a, mulData(other));
  }
}