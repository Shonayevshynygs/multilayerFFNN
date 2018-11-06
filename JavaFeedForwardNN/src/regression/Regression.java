package regression;

import static utils.MathUtils.*;

public class Regression {

    public static Line simpleLinearRegression(double[] x, double[] y) //x for variable and y for results
    /**
     * This works only for one to one functions
     */
    {
        //TODO throw exception if y.length != x.length
        double perCoef = pearsonCoef(x,y);
        double sY, sX, a, b;
        sY = standardDeviation(y);
        sX = standardDeviation(x);
        b = perCoef*sY/sX;
        a = mean(y) - (b*mean(x));
        Line line = new Line(a,b); //функция линии
        return line;
    }


    public static void simpleLogisticRegression(double e) //e stands for accuracy
    {

    }


    public static void newtonsMethod()
    {

    }



    //Coefficents

    public static double pearsonCoef(double[] x, double[] y)
    {
        double[] xDif = new double[x.length];
        double[] yDif = new double[y.length];
        double[] xDifSqr = new double[x.length];
        double[] yDifSqr = new double[y.length];
        double[] xyDifMultiplication = new double[x.length];
        double xMean = mean(x);
        double yMean = mean(y);
        for (int i=0; i<x.length; i++)
        {
            xDif[i] = x[i]-xMean;
            yDif[i] = y[i]-yMean;
            xDifSqr[i] = xDif[i]*xDif[i];
            yDifSqr[i] = yDif[i]*yDif[i];
            xyDifMultiplication[i] = xDif[i]*yDif[i];
        }
        double coef = sum(xyDifMultiplication)/(Math.sqrt(sum(xDifSqr)*sum(yDifSqr)));
        return coef;
    }





}
