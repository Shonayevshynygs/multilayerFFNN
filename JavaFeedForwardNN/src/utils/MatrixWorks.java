package utils;

import java.util.Random;
import static utils.MathUtils.*;


public class MatrixWorks {

    //boolean methods
    public static boolean isRectangularShape(double a[][])
    {
        for (int i=1;i<a.length;i++)
        {
            if (a[i].length!=a[i-1].length) return false; //if found out that at least one of
            //rows are not equal to each other
        }
        /* maybe throw the exception if array is not matrix??? */
        return true;
    }

    public static boolean isEqualShape(double a[][], double b[][]) //lazy check
    {
        //this method only checks equality of number of rows and amount of columns in first row
        //use the method only if you assured that arguments are fully checked
        if (a.length == b.length && a[0].length == b[0].length) return true;
        else return false;
    }

    public static boolean isEqualShapeFull(double a[][], double b[][]) //full check
    {
        //this method for absolute check of every row and number of column in each row
        if (a.length!=b.length || !isRectangularShape(a) || !isRectangularShape(b)) return false;

        /* maybe throw the exception if arrays are not matrices??? */

        for (int i=0; i<a.length;i++)
        {
            if (a[i].length!=b[i].length) return false;
        }
        return true;
    }

    public static boolean isEqual(double a[][], double b[][])
    {

        //fully checking
        if (!isEqualShapeFull(a, b)) return false;
        //if (!isEqualShape(a, b)) return false;  /* this for lazy check */

        //if matrixes came through first check method starts to check the each cell of matrixes
        //for equality

        for (int i=0;i<a.length;i++)
        {
            for (int j=0;j<a[i].length;j++)
            {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }


    public static boolean isMultiplyable(double a[][], double b[][])
    {
        if (!isRectangularShape(a)
                || !isRectangularShape(b)
                    || a[0].length!=b.length) return false;
        return true;
    }


    //matrix works inc
    public static double[][] multiply(double a[][], double b) //multiplying on one number
    {
        if (!isRectangularShape(a)) throw new IllegalArgumentException("given array is not matrix shaped");
        //make custom exceptions
        double c[][] = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++)
        {
            for (int j=0;j<a[i].length;j++)
            {
                c[i][j] = a[i][j]*b;
            }
        }
        return c;
    }

    public static double[][] multiply (double a[][], double borsh[][])  //борщ ето б
    {
        if (!isMultiplyable(a,borsh)) throw new IllegalArgumentException("given matrices cannot be multiplied");

        //make custom exception
        // a[X;y] * b[y;Z] = c [X;Z]
        int aRows = a.length;
        int aCols = a[0].length; //because we already checked
        int bCols = borsh[0].length; //because we already checked
        double c[][] = new double[aRows][bCols];
        for (int i=0;i<aRows;i++)
        {
            for (int j=0; j<bCols;j++)
            {
                c[i][j] = 0;
                for (int k = 0; k < aCols; k++)
                    c[i][j] += a[i][k] * borsh[k][j];

            }
        }
        return c;
    }

    public static double[][] transpose(double a[][])
    {
        if(!isRectangularShape(a)) throw new IllegalArgumentException("given array is not matrix shaped");

        double[][] borsh = new double[a[0].length][a.length];
        for (int i=0;i<a[0].length;i++)
        {
            for (int j=0;j<a.length;j++)
            {
                borsh[i][j] = a[j][i];
            }
        }
        return borsh;
    }


    public static double[][] hadamardMultiplication(double a[][], double b[][])
    {
        if (!isEqualShape(a,b)) throw new IllegalArgumentException("matrices are not equally shaped");

        double[][] c = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++)
        {
            for (int j=0; j<a[0].length;j++)
            {
                c[i][j]=a[i][j]*b[i][j];
            }
        }
        return c;
    }

    public static double[][] sum(double a[][], double b[][])
    {
        if (!isEqualShape(a,b)) throw new IllegalArgumentException("matrices are not equally shaped");

        double[][] c = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++)
        {
            for (int j=0; j<a[0].length;j++)
            {
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }

    public static double[][] substract(double a[][], double b[][])
    {
        if (!isEqualShape(a,b)) throw new IllegalArgumentException("matrices are not equally shaped");

        double[][] c = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++)
        {
            for (int j=0; j<a[0].length;j++)
            {
                c[i][j]=a[i][j]-b[i][j];
            }
        }
        return c;
    }


    public static double[][] sigmoidPrime(double[][] a)
    {
        double[][] c = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++)
        {
            for (int j=0; j<a[0].length;j++)
            {
               c[i][j] = MathUtils.sigmoidPrime(a[i][j]); //kosyak
            }
        }
        return c;
    }
    //debug
    public static void show(double[][] data)
    {
        for (int i=0;i<data.length;i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void showSizes(double[][] data)
    {
        System.out.println("The i="+data.length+" The j="+data[0].length);
    }
    public static void rand(double[][] data)
    {
        Random r = new Random();
        for (int i=0;i<data.length;i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j]=r.nextDouble();
            }
        }
    }



}
