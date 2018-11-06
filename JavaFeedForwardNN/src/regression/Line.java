package regression;

public class Line {
    double a; //free
    double b; //slope

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getResult(double x)
    {
        double y;
        y=a+b*x;
        return y;
    }
}
