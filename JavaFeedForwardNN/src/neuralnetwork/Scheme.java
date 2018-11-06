package neuralnetwork;

import java.util.Scanner;
import static utils.MatrixWorks.*;

public class Scheme {


    public Layer[] layers;
    public Weights[] weights;
    public double[][] results;
    public int numberOfEntries;
    public static final double speed = 0.5;


    public Scheme(double[][] data, double[][] results, int numberOfHiddenLayers)
    {
        int numberOfLayers = numberOfHiddenLayers+2;
        numberOfEntries = data.length;
        layers = new Layer[numberOfLayers];
        weights = new Weights[numberOfLayers-1];
        layers[0] = new Layer(data); //input
        layers[numberOfLayers-1] = new Layer(results.length, results[0].length); //output layer

        for (int i=1;i<numberOfLayers-1;i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter number of hidden neurons in "+i+" hidden layer");
            int non = sc.nextInt();
            layers[i] = new Layer(numberOfEntries, non);

        }

        for (int i=0;i<numberOfLayers-1;i++)
        {
            //System.out.print(layers[i+1].getNumberOfNeurons()+" ");
            weights[i] = new Weights(layers[i],layers[i+1]);
        }
        initWeightsOfNN();
        this.results = results;

    }

    public void initWeightsOfNN()
    {
        for(int i=0;i<weights.length;i++)
        {
            weights[i].initWeights();
        }
    }

    //Full gradient descent
    public void feedForward()
    {
        for (int i=0;i<layers.length-1;i++)
        {
            if (i==0) {
                layers[i + 1].setData(multiply(layers[i].getData(), weights[i].getWeights())); //assuming that data already normalized
                layers[i+1].activate();
            }
            else
            {
                layers[i+1].setData(multiply(layers[i].getActivatedData(),weights[i].getWeights()));
                layers[i+1].activate();
            }
        }
    }



    public double backProp()
    {
        for (int i=weights.length-1;i>=0;i--)
        {
            if (i==weights.length-1)
            {
                double[][] deltaRes = substract(weights[i].getNextLayer().getActivatedData(),results);
                double[][] sigma = hadamardMultiplication(deltaRes,sigmoidPrime(weights[i].getNextLayer().getData()));
                weights[i].setSigma(sigma);
            }
            else
            {
                double[][] sigma = multiply(weights[i+1].getSigma(),transpose(weights[i+1].getWeights()));
                sigma = hadamardMultiplication(sigma,sigmoidPrime(weights[i].getNextLayer().getData()));
                weights[i].setSigma(sigma);
            }
        }
        updateWeights();
        double mse = computeMSE();
        return mse;

    }
    public double computeMSE()
    {
        double MSE=0;
        for (int i=0;i<results.length;i++)
        {
            for (int j=0;j<results[0].length;j++)
            {
                MSE+=Math.pow(results[i][j]-layers[layers.length-1].getData()[i][j],2);
            }
           MSE/=results[0].length;
        }
        MSE/=numberOfEntries;
        System.out.println(MSE);
        return MSE;
    }

    public void updateWeights()
    {
        for (int i=0;i<weights.length;i++)
        {
            weights[i].updateWeights(speed);
        }
    }


}
