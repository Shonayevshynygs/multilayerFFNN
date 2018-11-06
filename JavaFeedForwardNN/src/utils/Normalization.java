package utils;

public class Normalization {

    public static double[] defaultNormalization(double[] input)
    {
        double[] output = new double[input.length];
        double max = -Double.MAX_VALUE;
        for (int i=0;i<input.length;i++)
        {
            if (input[i]>max) max = input[i];
        }
        for (int i=0;i<input.length;i++)
        {
            output[i] = input[i]/max;
        }
        return output;
    }

    public static double[] minMaxNormalization (double[] input)
    {
        double[] output = new double[input.length];
        double max = -Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        for (int i=0;i<input.length;i++)
        {
            if (input[i]>max) max = input[i];
            if (input[i]<min) min = input[i];
        }
        for (int i=0;i<input.length;i++)
        {
            output[i] = (input[i] - min)/(max-min); //can be zero
        }
        return output;
    }

    public static double[][] minMaxNormalization (double[][] input)
    {
        double[][] output = new double[input.length][input[0].length];
        double[] max = new double[input[0].length];
        for (int i=0;i<max.length;i++)
        {
            max[i]=-Double.MAX_VALUE;
        }
        for (int j=0;j<input[0].length;j++)
        {
            for (int i=0;i<input.length;i++)
            {
                if (input[i][j]>max[j]) max[j]=input[i][j];
            }
        }
        for (int i=0;i<input.length;i++)
        {
            for (int j=0;j<input[0].length;j++)
            {
                output[i][j]=input[i][j]/max[j];
            }
        }

        return output;
    }

    public static double[] zScoreNormalization(double[] input)
    {
        double[] output = new double[input.length];
        double mean=0;
        double stDevaiation;
        for (int i = 0 ; i<input.length; i++)
        {
            mean+=input[i]/input.length;
        }

        double sqrSum=0;
        for (int i = 0 ; i<input.length; i++)
        {
            sqrSum+=(input[i]-mean)*(input[i]-mean);
        }

        stDevaiation = sqrSum/input.length;

        for (int i = 0 ; i<input.length; i++)
        {
            output[i]=(input[i] - mean)/stDevaiation;
        }
        return output;
    }
}
