package neuralnetwork;

import static utils.MathUtils.*;

public class Layer {

  private double[][] data;
  private double[][] activatedData;
  private int numberOfEntries;
  private int numberOfNeurons;

  public Layer(int noe, int non)
  {
      numberOfEntries = noe;
      numberOfNeurons = non;
      data = new double[noe][non];
      activatedData = new double[noe][non];
  }

  public Layer(double data[][])
  {
      this.data = data;

      numberOfEntries=data.length;
      numberOfNeurons=data[0].length;
  }

    public double[][] getActivatedData() {
        return activatedData;
    }

    public void setActivatedData(double[][] activatedData) {
        this.activatedData = activatedData;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public int getNumberOfNeurons() {
        return numberOfNeurons;
    }

    public void setNumberOfNeurons(int numberOfNeurons) {
        this.numberOfNeurons = numberOfNeurons;
    }

    public void activate()
    {
        for (int i=0;i<numberOfEntries;i++)
        {
            for (int j=0;j<numberOfNeurons;j++)
            {
                activatedData[i][j] = sigmoid(data[i][j]);
            }
        }
    }
}
