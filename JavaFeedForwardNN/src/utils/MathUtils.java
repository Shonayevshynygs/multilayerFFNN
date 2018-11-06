package utils;

public class MathUtils {
    //utils
    public static double standardDeviation(double[] x)
    {
        double xMean = mean(x);
        double xDifSqr[] = new double[x.length];
        double xSqrSum;
        double stDev;
        for (int i=0;i<x.length;i++)
        {
            xDifSqr[i] = (x[i] - xMean)*(x[i] - xMean);
        }
        xSqrSum = sum(xDifSqr);
        stDev = Math.sqrt(xSqrSum/(x.length-1));
        return stDev;
    }

    public static double mean(double[] x)
    {
        double result=0;
        result = sum(x)/x.length;
        return result;
    }

    public static double sum(double[] x)
    {
        double sum=0;
        for (int i=0;i<x.length;i++)
        {
            sum+=x[i];
        }
        return sum;
    }

    public static double sigmoid(double x)
    {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
    }



    public static double sigmoidPrime(double x)
    {
        double f = sigmoid(x);
        double df = f*(1-f);
        return df;
    }

    public static double tanh(double x)
    {

        double e = Math.E;
        double f;
        f=(2/(1+Math.pow(e,-2*x)))-1;
        return f;
    }

    public static double tanhPrime(double x)
    {
        double f = tanh(x);
        double df = 1-(f*f);
        return df;
    }


}
