package neuralnetwork;

import java.util.Random;
import static utils.MatrixWorks.*;

public class Weights {

    private Layer prevLayer;
    private Layer nextLayer;
    private double weights[/*amount of neurons in previous layer*/][/*amount of neurons in next layer*/];
    private double sigma[][];
    private double djdw[][];


    public Weights(Layer prev, Layer next)
    {
        prevLayer = prev;
        nextLayer = next;
        weights = new double[prevLayer.getNumberOfNeurons()][nextLayer.getNumberOfNeurons()];
    }

    public double[][] getSigma() {
        return sigma;
    }

    public Layer getPrevLayer() {
        return prevLayer;
    }

    public void setPrevLayer(Layer prevLayer) {
        this.prevLayer = prevLayer;
    }

    public Layer getNextLayer() {
        return nextLayer;
    }

    public void setNextLayer(Layer nextLayer) {
        this.nextLayer = nextLayer;
    }

    public double[][] getWeights() {
        return weights;
    }

    public void initWeights()
    {
        Random r = new Random();
        for (int i=0;i<weights.length;i++)
        {
            for(int j=0;j<weights[0].length;j++)
            {
                weights[i][j] = 2*r.nextDouble()-1;
            }
        }
    }

    //for last weights
    public void setSigma(double[][] data)
    {
        sigma = data;
        djdw = multiply(transpose(prevLayer.getData()),sigma);
    }

    public void updateWeights(double speed)
    {
        weights = substract(weights,multiply(djdw,speed));
    }


}
