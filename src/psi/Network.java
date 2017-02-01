/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psi;


public class Network {

  private int noLayers;
  private Layer[] layers;
  public static int forwardCounter = 0;

  public Network(int noLayers, int noNeurons) {
    this.noLayers = noLayers;
    this.layers = new Layer[this.noLayers];
    for (int i = 0; i < noLayers - 1; i++) {
      this.layers[i] = new Layer(noNeurons);
    }
    this.layers[this.noLayers] = new Layer(16);
  }

  public void feedForward() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        this.layers[Network.forwardCounter + 1].neurons[i] = this.layers[Network.forwardCounter].neurons[j];
      }
    }
  }


  public void BackProp() {
    for (int i = 8; i >= 0; i--) {
      for (int j = 8; j >=0; j--) {
        this.layers[Network.forwardCounter + 1].neurons[i].error += this.layers[Network.forwardCounter].neurons[j].error;
      }
    }
  }




}
