/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psi;

public class Layer {

  Neuron[] neurons;
  int noNeurons;

  public Layer(int noNeurons) {
    this.noNeurons = noNeurons;
    this.neurons = new Neuron[6];

    for (int i = 0; i < noNeurons; i++) {
      this.neurons[i] = new Neuron();
    }
  }

}
