/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psi;


import java.util.Random;

public class Neuron {

  double[] weights;
  double[] inputs;
  double answer;
  double potential;
  int gitcounter;
  int niegitcounter;
  int error;
  int what;

  public Neuron() {
    what = 0;
    this.potential = 0;
    Random rand = new Random();
    this.weights = new double[9];
    this.inputs = new double[9];
    for (int i = 0; i < 9; i++) {
      this.weights[i] = (rand.nextInt(11) / 1.0);
    }
  }

  public void getPotential() {
    for (int i = 0; i < 9; i++) {
      this.potential += this.weights[i] * this.inputs[i];
    }
  }

  public void sigmoid() {
    this.answer = (1 / (1 + Math.pow(Math.E, (-1 * this.potential))));
  }

  public void Hebb() {
    double n = 0.1;
    for (int i = 0; i < 9; i++) {
      this.weights[i] += n * this.answer * this.inputs[i];
    }
  }

  public void Oji() {
    double n = 0.1;
    for (int i = 0; i < 9; i++) {
      this.weights[i] += n * this.answer * (this.inputs[i] - this.answer * this.weights[i]);
    }
  }

  public void HebbForget() {
    double n = 0.1;
    double g = 0.5;
    for (int i = 0; i < 9; i++) {
      this.weights[i] = this.weights[i] * g + n * this.answer * (this.inputs[i] - this.answer * this.weights[i]);
    }
  }

  public void wtf2(int i) {

    double n = 1;

    niegitcounter = 310 - what;
    what++;
    if (what % 7 != 0) {
      what += 7;
    }
    weights[0] += n * (inputs[1] - this.potential) * inputs[1];
    weights[1] += n * (inputs[2] - this.potential) * inputs[2];
    weights[2] += n * (inputs[3] - this.potential) * inputs[3];
    weights[3] += n * (inputs[4] - this.potential) * inputs[4];
    weights[4] += n * (inputs[5] - this.potential) * inputs[5];
    weights[5] += n * (inputs[1] - this.potential) * inputs[1];

  }
}
